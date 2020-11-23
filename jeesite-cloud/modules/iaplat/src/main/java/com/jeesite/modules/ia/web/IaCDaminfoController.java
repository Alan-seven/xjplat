package com.jeesite.modules.ia.web;

import com.jeesite.common.idgen.IdGen;
import com.jeesite.common.service.ServiceResp;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.ia.entity.IaCDaminfo;
import com.jeesite.modules.ia.entity.RelPDam;
import com.jeesite.modules.ia.service.IaCDaminfoService;
import com.jeesite.modules.ia.service.RelPDamService;
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
@RequestMapping({"${adminPath}/iaplat/dami"})
@Api(value="塘坝基础", tags={"塘坝基础接口"})
public class IaCDaminfoController
        extends BaseController
{
    @Autowired
    private IaCDaminfoService iaCDaminfoService;
    @Autowired
    private RelPDamService relPDamService;

    @RequestMapping({"list"})
    @ResponseBody
    public String list(@RequestBody IaCDaminfo iaCDaminfo, HttpServletRequest request, HttpServletResponse response)
    {
        iaCDaminfo.setPage(new Page(iaCDaminfo.getPageNo().intValue(), iaCDaminfo.getPageSize().intValue()));
        Page<IaCDaminfo> page = this.iaCDaminfoService.findPage(iaCDaminfo);
        return renderResult("1", text("查询数据成功！", new String[0]), page);
    }

    @RequestMapping({"save"})
    @ResponseBody
    public String save(@RequestBody IaCDaminfo iaCDaminfo)
    {
        iaCDaminfo.setDamcd(IdGen.uuid());

        RelPDam relpd = new RelPDam();
        relpd.setDamcd(iaCDaminfo.getDamcd());

        ServiceResp serviceResp = this.relPDamService.delete(relpd);

        serviceResp = this.relPDamService.batchSave(iaCDaminfo.getRelPDamList(), iaCDaminfo.getDamcd());
        serviceResp = this.iaCDaminfoService.save(iaCDaminfo);
        return renderResult(serviceResp.getCode(), text(serviceResp.getMsg(), new String[0]));
    }

    @RequestMapping({"update"})
    @ResponseBody
    public String update(@RequestBody IaCDaminfo iaCDaminfo)
    {
        RelPDam relpd = new RelPDam();
        relpd.setDamcd(iaCDaminfo.getDamcd());

        ServiceResp serviceResp = this.relPDamService.delete(relpd);

        serviceResp = this.relPDamService.batchSave(iaCDaminfo.getRelPDamList(), iaCDaminfo.getDamcd());
        serviceResp = this.iaCDaminfoService.update(iaCDaminfo);
        return renderResult(serviceResp.getCode(), text(serviceResp.getMsg(), new String[0]));
    }

    @RequestMapping({"delete"})
    @ResponseBody
    public String delete(@RequestBody IaCDaminfo iaCDaminfo)
    {
        ServiceResp serviceResp = this.iaCDaminfoService.delete(iaCDaminfo);
        return renderResult(serviceResp.getCode(), text(serviceResp.getMsg(), new String[0]));
    }
}
