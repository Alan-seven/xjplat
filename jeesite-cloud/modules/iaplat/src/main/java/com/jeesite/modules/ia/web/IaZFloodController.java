package com.jeesite.modules.ia.web;

import com.jeesite.common.idgen.IdGen;
import com.jeesite.common.service.ServiceResp;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.ia.entity.IaZFlood;
import com.jeesite.modules.ia.entity.RelPFlood;
import com.jeesite.modules.ia.service.IaZFloodService;
import com.jeesite.modules.ia.service.RelPFloodService;
import io.swagger.annotations.Api;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.jeesite.common.entity.Page;

@Controller
@RequestMapping({"${adminPath}/iaplat/zflood"})
@Api(value="泥石流信息", tags={"泥石流接口"})
public class IaZFloodController extends BaseController{

    @Autowired
    private IaZFloodService iaZFloodService;
    @Autowired
    private RelPFloodService relPFloodService;

    @ResponseBody
    @RequestMapping({"list"})
    public String list(@RequestBody IaZFlood iaZFlood, HttpServletResponse response)
    {
        iaZFlood.setPage(new Page(iaZFlood.getPageNo().intValue(), iaZFlood.getPageSize().intValue()));
        Page<IaZFlood> page = this.iaZFloodService.findPage(iaZFlood);
        return renderResult("1", text("查询数据成功！", new String[0]), page);
    }

    @ResponseBody
    @RequestMapping({"save"})
    public String save(@RequestBody IaZFlood iaZFlood)
    {
        ServiceResp serviceResp = new ServiceResp();
        iaZFlood.setFcd(IdGen.uuid());

        RelPFlood relpFlood = new RelPFlood();
        relpFlood.setFcd(iaZFlood.getFcd());

        serviceResp = this.relPFloodService.delete(relpFlood);

        serviceResp = this.relPFloodService.batchSave(iaZFlood.getRelPFloodList(), iaZFlood.getFcd());
        serviceResp = this.iaZFloodService.save(iaZFlood);
        return renderResult(serviceResp.getCode(), text(serviceResp.getMsg(), new String[0]));
    }

    @ResponseBody
    @RequestMapping({"update"})
    public String update(@RequestBody IaZFlood iaZFlood)
    {
        RelPFlood relpFlood = new RelPFlood();
        relpFlood.setFcd(iaZFlood.getFcd());

        ServiceResp serviceResp = this.relPFloodService.delete(relpFlood);

        serviceResp = this.relPFloodService.batchSave(iaZFlood.getRelPFloodList(), iaZFlood.getFcd());
        serviceResp = this.iaZFloodService.update(iaZFlood);
        return renderResult(serviceResp.getCode(), text(serviceResp.getMsg(), new String[0]));
    }

    @ResponseBody
    @RequestMapping({"delete"})
    public String delete(@RequestBody IaZFlood iaZFlood)
    {
        ServiceResp serviceResp = this.iaZFloodService.delete(iaZFlood);
        return renderResult(serviceResp.getCode(), text(serviceResp.getMsg(), new String[0]));
    }
}
