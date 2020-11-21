package com.jeesite.modules.ia.web;

import com.jeesite.common.entity.Page;
import com.jeesite.common.idgen.IdGen;
import com.jeesite.common.service.ServiceResp;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.ia.entity.IaCRs;
import com.jeesite.modules.ia.service.IaCRsService;
import io.swagger.annotations.Api;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping({"${adminPath}/iaplat/icrs"})
@Api(value="水库", tags={"水库接口"})
public class IaCRsController
        extends BaseController
{
    @Autowired
    private IaCRsService iaCRsService;

    @RequestMapping({"list"})
    @ResponseBody
    public String list(@RequestBody IaCRs iaCRs, HttpServletRequest request, HttpServletResponse response)
    {
        iaCRs.setPage(new Page(iaCRs.getPageNo().intValue(), iaCRs.getPageSize().intValue()));
        Page<IaCRs> page = this.iaCRsService.findPage(iaCRs);
        return renderResult("1", text("查询数据成功！", new String[0]), page);
    }

    @RequestMapping({"save"})
    @ResponseBody
    public String save(@RequestBody IaCRs iaCRs)
    {
        iaCRs.setRscd(IdGen.uuid());
        ServiceResp serviceResp = this.iaCRsService.save(iaCRs);
        return renderResult(serviceResp.getCode(), text(serviceResp.getMsg(), new String[0]));
    }

    @RequestMapping({"update"})
    @ResponseBody
    public String update(@RequestBody IaCRs iaCRs)
    {
        ServiceResp serviceResp = this.iaCRsService.update(iaCRs);
        return renderResult(serviceResp.getCode(), text(serviceResp.getMsg(), new String[0]));
    }

    @RequestMapping({"delete"})
    @ResponseBody
    public String delete(@RequestBody IaCRs iaCRs)
    {
        ServiceResp serviceResp = this.iaCRsService.delete(iaCRs);
        return renderResult(serviceResp.getCode(), text(serviceResp.getMsg(), new String[0]));
    }
}
