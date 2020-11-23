package com.jeesite.modules.ia.web;

import com.jeesite.common.idgen.IdGen;
import com.jeesite.common.service.ServiceResp;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.ia.entity.IAMVsurface;
import com.jeesite.modules.ia.entity.RelPV;
import com.jeesite.modules.ia.service.IAMVsurfaceService;
import com.jeesite.modules.ia.service.RelPVService;
import io.swagger.annotations.Api;

import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.jeesite.common.entity.Page;

@Controller
@RequestMapping({"${adminPath}/iaplat/vsur"})
@Api(value="沟道纵断面成果", tags={"沟道纵断面成果接口"})
public class IAMVsurfaceController
        extends BaseController
{
    @Autowired
    private IAMVsurfaceService iamVsurfaceService;
    @Autowired
    private RelPVService relPVService;

    @ResponseBody
    @RequestMapping({"list"})
    public String list(@RequestBody IAMVsurface iamVsurface, HttpServletResponse response)
    {
        iamVsurface.setPage(new Page(iamVsurface.getPageNo().intValue(), iamVsurface.getPageSize().intValue()));
        Page<IAMVsurface> page = this.iamVsurfaceService.findPage(iamVsurface);
        return renderResult("1", text("查询数据成功！", new String[0]), page);
    }

    @ResponseBody
    @RequestMapping({"save"})
    public String save(@RequestBody IAMVsurface iamVsurface)
    {
        ServiceResp serviceResp = new ServiceResp();
        iamVsurface.setVecd(IdGen.uuid());

        RelPV relpv = new RelPV();
        relpv.setVecd(iamVsurface.getVecd());

        serviceResp = this.relPVService.removeAll(relpv);

        serviceResp = this.relPVService.batchSave(iamVsurface.getRelpList(), iamVsurface.getVecd());
        serviceResp = this.iamVsurfaceService.save(iamVsurface);
        return renderResult(serviceResp.getCode(), text(serviceResp.getMsg(), new String[0]));
    }

    @ResponseBody
    @RequestMapping({"update"})
    public String update(@RequestBody IAMVsurface iamVsurface)
    {
        RelPV relpv = new RelPV();
        relpv.setVecd(iamVsurface.getVecd());

        ServiceResp serviceResp = this.relPVService.removeAll(relpv);

        serviceResp = this.relPVService.batchSave(iamVsurface.getRelpList(), iamVsurface.getVecd());
        serviceResp = this.iamVsurfaceService.update(iamVsurface);
        return renderResult(serviceResp.getCode(), text(serviceResp.getMsg(), new String[0]));
    }

    @ResponseBody
    @RequestMapping({"delete"})
    public String delete(@RequestBody IAMVsurface iamVsurface)
    {
        ServiceResp serviceResp = this.iamVsurfaceService.delete(iamVsurface);
        return renderResult(serviceResp.getCode(), text(serviceResp.getMsg(), new String[0]));
    }
}
