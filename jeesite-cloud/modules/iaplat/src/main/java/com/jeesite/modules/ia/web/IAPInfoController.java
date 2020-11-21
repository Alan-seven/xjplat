package com.jeesite.modules.ia.web;

import com.jeesite.common.idgen.IdGen;
import com.jeesite.common.io.PropertiesUtils;
import com.jeesite.common.lang.DateUtils;
import com.jeesite.common.service.ServiceResp;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.ia.entity.IAPInfo;
import com.jeesite.modules.ia.service.IAPInfoService;
import com.jeesite.modules.util.FileDownload;
import com.jeesite.modules.util.FileUpload;
import io.swagger.annotations.Api;
import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
@RequestMapping({"${adminPath}/iaplat/pinfo"})
@Api(value="断面类图片", tags={"断面类图片接口"})
public class IAPInfoController
        extends BaseController
{
    @Autowired
    private IAPInfoService iapInfoService;

    @ResponseBody
    @RequestMapping({"uploadFile"})
    public String uploadFile(HttpServletRequest request, HttpServletResponse response)
    {
        IAPInfo info = new IAPInfo();
        try
        {
            MultipartHttpServletRequest mreq = (MultipartHttpServletRequest)request;
            Iterator<String> fileNames = mreq.getFileNames();
            MultipartFile file = null;
            String fileName = null;
            String type = request.getParameter("type");
            while (fileNames.hasNext())
            {
                fileName = (String)fileNames.next();
                file = mreq.getFile(fileName);

                String name = file.getOriginalFilename();

                String extension = name.substring(name.lastIndexOf(".") + 1);
                String ym = DateUtils.getYear() + DateUtils.getMonth();
                String url = PropertiesUtils.getInstance().getProperty("uploadFile") + "/" + ym + "/";
                String fileNameId = IdGen.uuid();

                String fname = FileUpload.fileUp(file, url, fileNameId);

                info.setFpath(url + fname);
                info.setPid(IdGen.uuid());
                info.setPname(name);
                info.setDisc(extension);
                this.iapInfoService.save(info);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return renderResult("0", text("文件上传失败", new String[0]));
        }
        return renderResult("1", text("文件上传成功", new String[0]), info);
    }

    @ResponseBody
    @RequestMapping({"fileDownload"})
    public void fileDownload(HttpServletRequest request, HttpServletResponse response)
    {
        try
        {
            String pid = request.getParameter("pid");
            IAPInfo iapInfo = new IAPInfo();
            iapInfo.setPid(pid);
            if (StringUtils.isNotBlank(iapInfo.getPid()))
            {
                iapInfo = (IAPInfo)this.iapInfoService.get(iapInfo.getPid());
                String filePath = iapInfo.getFpath();
                String fileName = iapInfo.getPname();
                FileDownload.fileDownload(response, filePath, fileName);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @ResponseBody
    @RequestMapping({"delete"})
    public String delete(@RequestBody IAPInfo iapInfo)
    {
        ServiceResp serviceResp = this.iapInfoService.delete(iapInfo);
        return renderResult(serviceResp.getCode(), text(serviceResp.getMsg(), new String[0]));
    }
}
