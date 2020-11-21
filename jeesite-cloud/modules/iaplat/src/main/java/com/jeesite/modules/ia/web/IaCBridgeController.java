package com.jeesite.modules.ia.web;

import com.jeesite.common.entity.Page;
import com.jeesite.common.idgen.IdGen;
import com.jeesite.common.service.ServiceResp;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.ia.entity.IaCBridge;
import com.jeesite.modules.ia.entity.RelPBridge;
import com.jeesite.modules.ia.service.IaCBridgeService;
import com.jeesite.modules.ia.service.RelPBridgeService;
import io.swagger.annotations.Api;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping({"${adminPath}/iaplat/brid"})
@Api(value="桥梁基础", tags={"桥梁基础接口"})
public class IaCBridgeController
        extends BaseController
{
    @Autowired
    private IaCBridgeService iaCBridgeService;
    @Autowired
    private RelPBridgeService relPBridgeService;

    @RequestMapping({"list"})
    @ResponseBody
    public String list(@RequestBody IaCBridge iaCBridge, HttpServletRequest request, HttpServletResponse response)
    {
        iaCBridge.setPage(new Page(iaCBridge.getPageNo().intValue(), iaCBridge.getPageSize().intValue()));
        Page<IaCBridge> page = this.iaCBridgeService.findPage(iaCBridge);
        return renderResult("1", text("查询数据成功！", new String[0]), page);
    }

    @RequestMapping({"save"})
    @ResponseBody
    public String save(@RequestBody IaCBridge iaCBridge)
    {
        iaCBridge.setBrcd(IdGen.uuid());

        RelPBridge relpb = new RelPBridge();
        relpb.setBrcd(iaCBridge.getBrcd());

        ServiceResp serviceResp = this.relPBridgeService.delete(relpb);

        serviceResp = this.relPBridgeService.batchSave(iaCBridge.getRelPBridgeList(), iaCBridge.getBrcd());
        serviceResp = this.iaCBridgeService.save(iaCBridge);
        return renderResult(serviceResp.getCode(), text(serviceResp.getMsg(), new String[0]));
    }

    @RequestMapping({"update"})
    @ResponseBody
    public String update(@RequestBody IaCBridge iaCBridge)
    {
        RelPBridge relpb = new RelPBridge();
        relpb.setBrcd(iaCBridge.getBrcd());

        ServiceResp serviceResp = this.relPBridgeService.delete(relpb);

        serviceResp = this.relPBridgeService.batchSave(iaCBridge.getRelPBridgeList(), iaCBridge.getBrcd());
        serviceResp = this.iaCBridgeService.update(iaCBridge);
        return renderResult(serviceResp.getCode(), text(serviceResp.getMsg(), new String[0]));
    }

    @RequestMapping({"delete"})
    @ResponseBody
    public String delete(@RequestBody IaCBridge iaCBridge)
    {
        ServiceResp serviceResp = this.iaCBridgeService.delete(iaCBridge);
        return renderResult(serviceResp.getCode(), text(serviceResp.getMsg(), new String[0]));
    }
}
