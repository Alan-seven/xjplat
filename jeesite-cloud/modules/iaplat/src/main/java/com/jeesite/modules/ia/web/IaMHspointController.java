package com.jeesite.modules.ia.web;

import com.jeesite.common.idgen.IdGen;
import com.jeesite.common.service.ServiceResp;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.ia.entity.IaMHspoint;
import com.jeesite.modules.ia.service.IaMHspointService;
import io.swagger.annotations.Api;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping({"${adminPath}/iaplat/mhs"})
@Api(value="横断面测量点", tags={"横断面测量点接口"})
public class IaMHspointController extends BaseController{

    @Autowired
    private IaMHspointService iaMHspointService;

    @RequestMapping({"list"})
    @ResponseBody
    @ApiOperation(value = "沟道横断面数据", notes = "沟道横断面数据不分页", httpMethod = "POST")
    public String list(@RequestBody IaMHspoint iaMHspoint, HttpServletResponse response)
    {
        List<IaMHspoint> list = this.iaMHspointService.findList(iaMHspoint);
        return renderResult("1", text("查询数据成功！", new String[0]), list);
    }

    @RequestMapping({"save"})
    @ResponseBody
    public String save(@RequestBody IaMHspoint iaMHspoint)
    {
        iaMHspoint.setId(IdGen.uuid());
        ServiceResp serviceResp = this.iaMHspointService.save(iaMHspoint);
        return renderResult(serviceResp.getCode(), text(serviceResp.getMsg(), new String[0]));
    }

    @RequestMapping({"update"})
    @ResponseBody
    public String update(@RequestBody IaMHspoint iaMHspoint)
    {
        ServiceResp serviceResp = this.iaMHspointService.update(iaMHspoint);
        return renderResult(serviceResp.getCode(), text(serviceResp.getMsg(), new String[0]));
    }

    @RequestMapping({"delete"})
    @ResponseBody
    public String delete(@RequestBody IaMHspoint iaMHspoint)
    {
        ServiceResp serviceResp = this.iaMHspointService.delete(iaMHspoint);
        return renderResult(serviceResp.getCode(), text(serviceResp.getMsg(), new String[0]));
    }
}
