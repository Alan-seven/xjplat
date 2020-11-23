package com.jeesite.modules.ia.web;

import com.google.common.collect.Lists;
import com.jeesite.common.idgen.IdGen;
import com.jeesite.common.io.PropertiesUtils;
import com.jeesite.common.lang.DateUtils;
import com.jeesite.common.service.ServiceResp;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.ia.entity.IAMVsurface;
import com.jeesite.modules.ia.entity.IAPInfo;
import com.jeesite.modules.ia.entity.IaMHsfm;
import com.jeesite.modules.ia.entity.IaMHsfmParent;
import com.jeesite.modules.ia.entity.IaMHspoint;
import com.jeesite.modules.ia.entity.IaMHsurface;
import com.jeesite.modules.ia.entity.IaMVspoint;
import com.jeesite.modules.ia.entity.RelPH;
import com.jeesite.modules.ia.entity.RelPHsfm;
import com.jeesite.modules.ia.entity.RelPV;
import com.jeesite.modules.ia.service.IAMVsurfaceService;
import com.jeesite.modules.ia.service.IAPInfoService;
import com.jeesite.modules.ia.service.IaMHsfmParentService;
import com.jeesite.modules.ia.service.IaMHsfmService;
import com.jeesite.modules.ia.service.IaMHspointService;
import com.jeesite.modules.ia.service.IaMHsurfaceService;
import com.jeesite.modules.ia.service.IaMVspointService;
import com.jeesite.modules.ia.service.RelPHService;
import com.jeesite.modules.ia.service.RelPHsfmService;
import com.jeesite.modules.ia.service.RelPVService;
import com.jeesite.modules.util.FileHUtil;
import com.jeesite.modules.util.FileHsFmUtil;
import com.jeesite.modules.util.FileUpload;
import com.jeesite.modules.util.FileVUtil;
import io.swagger.annotations.Api;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import org.apache.http.entity.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping({"${adminPath}/iaplat/uploadData/"})
@Api(value="上传数据", tags={"上传数据接口"})
public class UploadDataController
        extends BaseController
{
    @Autowired
    private IaMHsurfaceService iaMHsurfaceService;
    @Autowired
    private IaMHspointService iaMHspointService;
    @Autowired
    private IAPInfoService iapInfoService;
    @Autowired
    private RelPHService relPHService;
    @Autowired
    private IAMVsurfaceService iamVsurfaceService;
    @Autowired
    private IaMVspointService iaMVspointService;
    @Autowired
    private RelPVService relPVService;
    @Autowired
    private IaMHsfmParentService iaMHsfmParentService;
    @Autowired
    private IaMHsfmService iaMHsfmService;
    @Autowired
    private RelPHsfmService relPHsfmService;

    @ResponseBody
    @RequestMapping({"upload"})
    public void uploadData()
    {
        String path = "E:\\颐信\\X-项目\\新疆山洪灾害\\650109米东区\\横纵断面表";
        File file = new File(path);
        fileList(file);
    }

    public void fileList(File file)
    {
        List<String> picList = Lists.newArrayList();
        File[] files = file.listFiles();
        if (files != null) {
            for (File f : files) {
                if (!f.isDirectory())
                {
                    String fpath = f.getPath();

                    String fname = f.getName();

                    String suffix = fname.substring(fname.lastIndexOf(".") + 1);
                    if ((suffix.startsWith("xls")) || (suffix.startsWith("xlxs")))
                    {
                        String type = findHVFile(f);
                        if ("H".equals(type)) {
                            ServiceResp localServiceResp = saveHm(fpath, f, suffix);
                        }
                        if ("V".equals(type)) {
                            ServiceResp localServiceResp = saveVm(fpath, f, suffix);
                        }
                        if ("L".equals(type)) {
                            ServiceResp localServiceResp = saveLm(fpath, f, suffix);
                        }
                    }
                }
                else
                {
                    fileList(f);
                }
            }
        }
    }

    public ServiceResp saveHm(String fpath, File f, String suffix)
    {
        IaMHsurface iaMHsurface = FileHUtil.parseHsurface(fpath);
        ServiceResp resp = this.iaMHsurfaceService.save(iaMHsurface);
        List<IaMHspoint> hsplist = FileHUtil.parseHPoint(fpath, iaMHsurface.getHecd());
        for (IaMHspoint entity : hsplist)
        {
            resp = this.iaMHspointService.save(entity);
        }
        IaMHspoint entity;
        File[] sameDirFiles = f.getParentFile().listFiles();
        for (File sameDirFile : sameDirFiles)
        {
            String sameFileName = sameDirFile.getName();
            suffix = sameFileName.substring(sameFileName.lastIndexOf(".") + 1);
            if ((suffix.startsWith("JPG")) || (suffix.startsWith("jpg")))
            {
                String fileNameId = savePicture(sameDirFile, suffix);

                RelPH relPH = new RelPH();
                relPH.setPid(fileNameId);
                relPH.setHecd(iaMHsurface.getHecd());
                resp = this.relPHService.save(relPH);
            }
        }
        return resp;
    }

    public ServiceResp saveVm(String fpath, File f, String suffix)
    {
        IAMVsurface iaMVsurface = FileVUtil.parseVsurface(fpath);

        ServiceResp resp = this.iamVsurfaceService.save(iaMVsurface);

        List<IaMVspoint> vsplist = FileVUtil.parseVPoint(fpath, iaMVsurface.getVecd());
        for (IaMVspoint entity : vsplist)
        {
            resp = this.iaMVspointService.save(entity);
        }
        IaMVspoint entity;
        File[] sameDirFiles = f.getParentFile().listFiles();
        for (File sameDirFile : sameDirFiles)
        {
            String sameFileName = sameDirFile.getName();
            suffix = sameFileName.substring(sameFileName.lastIndexOf(".") + 1);
            if ((suffix.startsWith("JPG")) || (suffix.startsWith("jpg")))
            {
                String fileNameId = savePicture(sameDirFile, suffix);

                RelPV relPV = new RelPV();
                relPV.setPid(fileNameId);
                relPV.setVecd(iaMVsurface.getVecd());
                resp = this.relPVService.save(relPV);
            }
        }
        return resp;
    }

    public ServiceResp saveLm(String fpath, File f, String suffix)
    {
        IaMHsfmParent iaMHsfmParent = FileHsFmUtil.parseHsFmParent(fpath);

        ServiceResp resp = this.iaMHsfmParentService.save(iaMHsfmParent);

        List<IaMHsfm> hsfmlist = FileHsFmUtil.parseHsFm(fpath, iaMHsfmParent.getFmcd());
        for (IaMHsfm entity : hsfmlist)
        {
            resp = this.iaMHsfmService.save(entity);
        }
        IaMHsfm entity;
        File[] sameDirFiles = f.getParentFile().listFiles();
        for (File sameDirFile : sameDirFiles)
        {
            String sameFileName = sameDirFile.getName();
            suffix = sameFileName.substring(sameFileName.lastIndexOf(".") + 1);
            if ((suffix.startsWith("JPG")) || (suffix.startsWith("jpg")))
            {
                String fileNameId = savePicture(sameDirFile, suffix);

                RelPHsfm relPHsfm = new RelPHsfm();
                relPHsfm.setPid(fileNameId);
                relPHsfm.setFmcd(iaMHsfmParent.getFmcd());
                resp = this.relPHsfmService.save(relPHsfm);
            }
        }
        return resp;
    }

    public String findHVFile(File f)
    {
        String type = "";
        String fparentDir = f.getParent();
        String[] fileName = fparentDir.split("/");
        String parentName = fileName[(fileName.length - 1)];
        if (fparentDir.contains("横断面")) {
            type = "H";
        } else if (fparentDir.contains("纵断面")) {
            type = "V";
        } else if (fparentDir.contains("历史痕迹")) {
            type = "L";
        }
        return type;
    }

    public String savePicture(File file, String suffix)
    {
        String fileNameId = IdGen.uuid();
        FileInputStream inputStream = null;
        try {
            String ym = DateUtils.getYear() + DateUtils.getMonth();
            String url = PropertiesUtils.getInstance().getProperty("uploadFile") + "/" + ym + "/";
            inputStream = new FileInputStream(file);
            MultipartFile multipartFile = new MockMultipartFile(file.getName(), file.getName(), ContentType.APPLICATION_OCTET_STREAM.toString(), inputStream);

            String fname = FileUpload.fileUp(multipartFile, url, fileNameId);


            IAPInfo info = new IAPInfo();
            info.setPid(fileNameId);
            info.setFpath(url + fname);
            info.setDisc(suffix);
            this.iapInfoService.save(info);
            return fileNameId;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileNameId;
    }
}
