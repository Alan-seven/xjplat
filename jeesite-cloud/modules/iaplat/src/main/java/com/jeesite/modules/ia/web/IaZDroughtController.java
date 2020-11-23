package com.jeesite.modules.ia.web;

import com.jeesite.common.idgen.IdGen;
import com.jeesite.common.service.ServiceResp;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.ia.entity.IaZDrought;
import com.jeesite.modules.ia.entity.RelPDrought;
import com.jeesite.modules.ia.service.IaZDroughtService;
import com.jeesite.modules.ia.service.RelPDroughtService;
import io.swagger.annotations.Api;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.jeesite.common.entity.Page;

@Controller
@RequestMapping({"${adminPath}/iaplat/zdrought"})
@Api(value="干旱信息", tags={"干旱接口"})
public class IaZDroughtController
        extends BaseController
{
    @Autowired
    private IaZDroughtService iaZDroughtService;
    @Autowired
    private RelPDroughtService relPDroughtService;

    @ResponseBody
    @RequestMapping({"list"})
    public String list(@RequestBody IaZDrought iaZDrought, HttpServletResponse response)
    {
        iaZDrought.setPage(new Page(iaZDrought.getPageNo().intValue(), iaZDrought.getPageSize().intValue()));
        Page<IaZDrought> page = this.iaZDroughtService.findPage(iaZDrought);
        return renderResult("1", text("查询数据成功！", new String[0]), page);
    }

    @ResponseBody
    @RequestMapping({"save"})
    public String save(@RequestBody IaZDrought iaZDrought)
    {
        ServiceResp serviceResp = new ServiceResp();
        iaZDrought.setDcd(IdGen.uuid());

        RelPDrought relPDrought = new RelPDrought();
        relPDrought.setDcd(iaZDrought.getDcd());

        serviceResp = this.relPDroughtService.delete(relPDrought);

        serviceResp = this.relPDroughtService.batchSave(iaZDrought.getRelPDroughtList(), iaZDrought.getDcd());
        serviceResp = this.iaZDroughtService.save(iaZDrought);

        return renderResult(serviceResp.getCode(), text(serviceResp.getMsg(), new String[0]));
    }

    @ResponseBody
    @RequestMapping({"update"})
    public String update(@RequestBody IaZDrought iaZDrought)
    {
        RelPDrought relPDrought = new RelPDrought();
        relPDrought.setDcd(iaZDrought.getDcd());

        ServiceResp serviceResp = this.relPDroughtService.delete(relPDrought);

        serviceResp = this.relPDroughtService.batchSave(iaZDrought.getRelPDroughtList(), iaZDrought.getDcd());
        serviceResp = this.iaZDroughtService.update(iaZDrought);
        return renderResult(serviceResp.getCode(), text(serviceResp.getMsg(), new String[0]));
    }

    @ResponseBody
    @RequestMapping({"delete"})
    public String delete(@RequestBody IaZDrought iaZDrought)
    {
        ServiceResp serviceResp = this.iaZDroughtService.delete(iaZDrought);
        return renderResult(serviceResp.getCode(), text(serviceResp.getMsg(), new String[0]));
    }
}
