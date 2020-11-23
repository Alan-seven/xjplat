package com.jeesite.modules.ia.web;

import com.jeesite.common.idgen.IdGen;
import com.jeesite.common.service.ServiceResp;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.ia.entity.IaMHsurface;
import com.jeesite.modules.ia.entity.RelPH;
import com.jeesite.modules.ia.service.IaMHsurfaceService;
import com.jeesite.modules.ia.service.RelPHService;
import io.swagger.annotations.Api;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.jeesite.common.entity.Page;

@Controller
@RequestMapping({"${adminPath}/iaplat/mh"})
@Api(value="沟道横断面成果", tags={"沟道横断面成果接口"})
public class IaMHsurfaceController extends BaseController{

    @Autowired
    private IaMHsurfaceService iaMHsurfaceService;
    @Autowired
    private RelPHService relPhService;

    @ResponseBody
    @RequestMapping({"list"})
    public String list(@RequestBody IaMHsurface iamHsurface, HttpServletRequest request, HttpServletResponse response)
    {
        iamHsurface.setPage(new Page(iamHsurface.getPageNo().intValue(), iamHsurface.getPageSize().intValue()));
        Page<IaMHsurface> page = this.iaMHsurfaceService.findPage(iamHsurface);
        return renderResult("1", text("查询数据成功！", new String[0]), page);
    }

    @ResponseBody
    @RequestMapping({"save"})
    public String save(@RequestBody IaMHsurface iamHsurface)
    {
        ServiceResp serviceResp = new ServiceResp();
        iamHsurface.setHecd(IdGen.uuid());

        RelPH relph = new RelPH();
        relph.setHecd(iamHsurface.getVecd());

        serviceResp = this.relPhService.delete(relph);

        serviceResp = this.relPhService.batchSave(iamHsurface.getRelphList(), iamHsurface.getHecd());
        serviceResp = this.iaMHsurfaceService.save(iamHsurface);
        return renderResult(serviceResp.getCode(), text(serviceResp.getMsg(), new String[0]));
    }

    @ResponseBody
    @RequestMapping({"update"})
    public String update(@RequestBody IaMHsurface iamHsurface)
    {
        RelPH relph = new RelPH();
        relph.setHecd(iamHsurface.getVecd());

        ServiceResp serviceResp = this.relPhService.delete(relph);

        serviceResp = this.relPhService.batchSave(iamHsurface.getRelphList(), iamHsurface.getHecd());
        serviceResp = this.iaMHsurfaceService.update(iamHsurface);
        return renderResult(serviceResp.getCode(), text(serviceResp.getMsg(), new String[0]));
    }

    @ResponseBody
    @RequestMapping({"delete"})
    public String delete(@RequestBody IaMHsurface iamHsurface)
    {
        ServiceResp serviceResp = this.iaMHsurfaceService.delete(iamHsurface);
        return renderResult(serviceResp.getCode(), text(serviceResp.getMsg(), new String[0]));
    }
}
