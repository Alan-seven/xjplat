package com.jeesite.modules.ia.web;

import com.jeesite.common.idgen.IdGen;
import com.jeesite.common.service.ServiceResp;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.ia.entity.IaMVspoint;
import com.jeesite.modules.ia.service.IaMVspointService;
import io.swagger.annotations.Api;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping({"${adminPath}/iaplat/vsp"})
@Api(value="沟道纵断面测量点", tags={"沟道纵断面测量点接口"})
public class IaMVspointController
        extends BaseController
{
    @Autowired
    private IaMVspointService iaMVspointService;

    @RequestMapping({"list"})
    @ResponseBody
    public String list(@RequestBody IaMVspoint iaMVspoint, HttpServletResponse response)
    {
        List<IaMVspoint> list = this.iaMVspointService.findList(iaMVspoint);
        return renderResult("1", text("查询数据成功！", new String[0]), list);
    }

    @RequestMapping({"save"})
    @ResponseBody
    public String save(@RequestBody IaMVspoint iaMVspoint)
    {
        iaMVspoint.setId(IdGen.uuid());
        ServiceResp serviceResp = this.iaMVspointService.save(iaMVspoint);
        return renderResult(serviceResp.getCode(), text(serviceResp.getMsg(), new String[0]));
    }

    @RequestMapping({"update"})
    @ResponseBody
    public String update(@RequestBody IaMVspoint iaMVspoint)
    {
        ServiceResp serviceResp = this.iaMVspointService.update(iaMVspoint);
        return renderResult(serviceResp.getCode(), text(serviceResp.getMsg(), new String[0]));
    }

    @RequestMapping({"delete"})
    @ResponseBody
    public String delete(@RequestBody IaMVspoint iaMVspoint)
    {
        ServiceResp serviceResp = this.iaMVspointService.delete(iaMVspoint);
        return renderResult(serviceResp.getCode(), text(serviceResp.getMsg(), new String[0]));
    }
}
