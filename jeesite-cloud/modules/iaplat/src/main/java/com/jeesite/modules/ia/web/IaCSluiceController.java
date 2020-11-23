package com.jeesite.modules.ia.web;

import com.jeesite.common.idgen.IdGen;
import com.jeesite.common.service.ServiceResp;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.ia.entity.IaCSluice;
import com.jeesite.modules.ia.service.IaCSluiceService;
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
@RequestMapping({"${adminPath}/iaplat/sluice"})
@Api(value="水闸", tags={"水闸接口"})
public class IaCSluiceController
        extends BaseController
{
    @Autowired
    private IaCSluiceService iaCSluiceService;

    @RequestMapping({"list"})
    @ResponseBody
    public String list(@RequestBody IaCSluice iaCSluice, HttpServletRequest request, HttpServletResponse response)
    {
        iaCSluice.setPage(new Page(iaCSluice.getPageNo().intValue(), iaCSluice.getPageSize().intValue()));
        Page<IaCSluice> page = this.iaCSluiceService.findPage(iaCSluice);
        return renderResult("1", text("查询数据成功！", new String[0]), page);
    }

    @RequestMapping({"save"})
    @ResponseBody
    public String save(@RequestBody IaCSluice iaCSluice)
    {
        iaCSluice.setSpcd(IdGen.uuid());
        ServiceResp serviceResp = this.iaCSluiceService.save(iaCSluice);
        return renderResult(serviceResp.getCode(), text(serviceResp.getMsg(), new String[0]));
    }

    @RequestMapping({"update"})
    @ResponseBody
    public String update(@RequestBody IaCSluice iaCSluice)
    {
        ServiceResp serviceResp = this.iaCSluiceService.update(iaCSluice);
        return renderResult(serviceResp.getCode(), text(serviceResp.getMsg(), new String[0]));
    }

    @RequestMapping({"delete"})
    @ResponseBody
    public String delete(@RequestBody IaCSluice iaCSluice)
    {
        ServiceResp serviceResp = this.iaCSluiceService.delete(iaCSluice);
        return renderResult(serviceResp.getCode(), text(serviceResp.getMsg(), new String[0]));
    }
}
