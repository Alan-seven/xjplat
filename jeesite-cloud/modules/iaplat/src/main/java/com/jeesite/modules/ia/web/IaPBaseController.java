package com.jeesite.modules.ia.web;

import com.jeesite.common.idgen.IdGen;
import com.jeesite.common.io.PropertiesUtils;
import com.jeesite.common.lang.DateUtils;
import com.jeesite.common.service.ServiceResp;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.ia.entity.IaPBase;
import com.jeesite.modules.ia.service.IaPBaseService;
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
@RequestMapping({"${adminPath}/iaplat/pbase"})
@Api(value="基础工程类图片", tags={"基础工程类图片接口"})
public class IaPBaseController extends BaseController{

    @Autowired
    private IaPBaseService iapBaseService;

    @ResponseBody
    @RequestMapping({"uploadFile"})
    public String uploadFile(HttpServletRequest request, HttpServletResponse response)
    {
        IaPBase Base = new IaPBase();
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

                Base.setFpath(url + fname);
                Base.setPid(IdGen.uuid());
                Base.setPname(name);
                Base.setDisc(extension);
                this.iapBaseService.save(Base);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return renderResult("0", text("文件上传失败", new String[0]));
        }
        return renderResult("1", text("文件上传成功", new String[0]), Base);
    }

    @ResponseBody
    @RequestMapping({"fileDownload"})
    public void fileDownload(HttpServletRequest request, HttpServletResponse response)
    {
        try
        {
            String pid = request.getParameter("pid");
            IaPBase iapBase = new IaPBase();
            iapBase.setPid(pid);
            if (StringUtils.isNotBlank(iapBase.getPid()))
            {
                iapBase = (IaPBase)this.iapBaseService.get(iapBase.getPid());
                String filePath = iapBase.getFpath();
                String fileName = iapBase.getPname();
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
    public String delete(@RequestBody IaPBase iapBase)
    {
        ServiceResp serviceResp = this.iapBaseService.delete(iapBase);
        return renderResult(serviceResp.getCode(), text(serviceResp.getMsg(), new String[0]));
    }
}
