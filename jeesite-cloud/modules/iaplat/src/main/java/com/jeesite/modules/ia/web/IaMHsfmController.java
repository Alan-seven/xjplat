package com.jeesite.modules.ia.web;

import com.jeesite.common.idgen.IdGen;
import com.jeesite.common.service.ServiceResp;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.ia.entity.IaMHsfm;
import com.jeesite.modules.ia.service.IaMHsfmService;
import io.swagger.annotations.Api;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping({"${adminPath}/iaplat/hsfm"})
@Api(value="历史洪痕信息", tags={"历史洪痕接口"})
public class IaMHsfmController
        extends BaseController
{
    @Autowired
    private IaMHsfmService iaMHsfmService;

    @RequestMapping({"list"})
    @ResponseBody
    public String list(@RequestBody IaMHsfm iaMHsfm, HttpServletRequest request, HttpServletResponse response)
    {
        List<IaMHsfm> list = this.iaMHsfmService.findList(iaMHsfm);
        return renderResult("1", text("查询数据成功！", new String[0]), list);
    }

    @RequestMapping({"save"})
    @ResponseBody
    public String save(@RequestBody IaMHsfm iaMHsfm)
    {
        iaMHsfm.setId(IdGen.uuid());
        ServiceResp serviceResp = this.iaMHsfmService.save(iaMHsfm);
        return renderResult(serviceResp.getCode(), text(serviceResp.getMsg(), new String[0]));
    }

    @RequestMapping({"update"})
    @ResponseBody
    public String update(@RequestBody IaMHsfm iaMHsfm)
    {
        ServiceResp serviceResp = this.iaMHsfmService.update(iaMHsfm);
        return renderResult(serviceResp.getCode(), text(serviceResp.getMsg(), new String[0]));
    }

    @RequestMapping({"delete"})
    @ResponseBody
    public String delete(@RequestBody IaMHsfm iaMHsfm)
    {
        ServiceResp serviceResp = this.iaMHsfmService.delete(iaMHsfm);
        return renderResult(serviceResp.getCode(), text(serviceResp.getMsg(), new String[0]));
    }
}
