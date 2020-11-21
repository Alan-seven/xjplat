package com.jeesite.modules.ia.web;

import com.jeesite.common.entity.Page;
import com.jeesite.common.idgen.IdGen;
import com.jeesite.common.service.ServiceResp;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.ia.entity.IaCCulvert;
import com.jeesite.modules.ia.entity.RelPCulv;
import com.jeesite.modules.ia.service.IaCCulvertService;
import com.jeesite.modules.ia.service.RelPCulvService;
import io.swagger.annotations.Api;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping({"${adminPath}/iaplat/cul"})
@Api(value="路涵基础", tags={"路涵基础接口"})
public class IaCCulvertController
        extends BaseController
{
    @Autowired
    private IaCCulvertService iaCCulvertService;
    @Autowired
    private RelPCulvService relPCulvService;

    @RequestMapping({"list"})
    @ResponseBody
    public String list(@RequestBody IaCCulvert iaCCulvert, HttpServletRequest request, HttpServletResponse response)
    {
        iaCCulvert.setPage(new Page(iaCCulvert.getPageNo().intValue(), iaCCulvert.getPageSize().intValue()));
        Page<IaCCulvert> page = this.iaCCulvertService.findPage(iaCCulvert);
        return renderResult("1", text("查询数据成功！", new String[0]), page);
    }

    @RequestMapping({"save"})
    @ResponseBody
    public String save(@RequestBody IaCCulvert iaCCulvert)
    {
        iaCCulvert.setCulcd(IdGen.uuid());

        RelPCulv relpc = new RelPCulv();
        relpc.setCulcd(iaCCulvert.getCulcd());

        ServiceResp serviceResp = this.relPCulvService.delete(relpc);

        serviceResp = this.relPCulvService.batchSave(iaCCulvert.getRelPCulvList(), iaCCulvert.getCulcd());
        serviceResp = this.iaCCulvertService.save(iaCCulvert);
        return renderResult(serviceResp.getCode(), text(serviceResp.getMsg(), new String[0]));
    }

    @RequestMapping({"update"})
    @ResponseBody
    public String update(@RequestBody IaCCulvert iaCCulvert)
    {
        RelPCulv relpc = new RelPCulv();
        relpc.setCulcd(iaCCulvert.getCulcd());

        ServiceResp serviceResp = this.relPCulvService.delete(relpc);

        serviceResp = this.relPCulvService.batchSave(iaCCulvert.getRelPCulvList(), iaCCulvert.getCulcd());
        serviceResp = this.iaCCulvertService.update(iaCCulvert);
        return renderResult(serviceResp.getCode(), text(serviceResp.getMsg(), new String[0]));
    }

    @RequestMapping({"delete"})
    @ResponseBody
    public String delete(@RequestBody IaCCulvert iaCCulvert)
    {
        ServiceResp serviceResp = this.iaCCulvertService.delete(iaCCulvert);
        return renderResult(serviceResp.getCode(), text(serviceResp.getMsg(), new String[0]));
    }
}
