package com.jeesite.modules.ia.web;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.ServiceResp;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.ia.entity.Wata;
import com.jeesite.modules.ia.service.WataService;
import io.swagger.annotations.Api;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping({"${adminPath}/iaplat/wata"})
@Api(value="小流域基本信息（空间）", tags={"小流域基本信息（空间）接口"})
public class WataController
        extends BaseController
{
    @Autowired
    private WataService wataService;

    @RequestMapping({"list"})
    @ResponseBody
    public String list(@RequestBody Wata wata, HttpServletRequest request, HttpServletResponse response)
    {
        wata.setPage(new Page(wata.getPageNo().intValue(), wata.getPageSize().intValue()));
        Page<Wata> page = this.wataService.findPage(wata);
        return renderResult("1", text("查询数据成功！", new String[0]), page);
    }

    @RequestMapping({"save"})
    @ResponseBody
    public String save(@RequestBody Wata wata)
    {
        ServiceResp serviceResp = new ServiceResp();
        Wata entity = (Wata)this.wataService.get(wata);
        if (null != entity)
        {
            serviceResp.setCode("0");
            serviceResp.setMsg("桥梁代码记录已存在");
        }
        else
        {
            serviceResp = this.wataService.save(wata);
        }
        return renderResult(serviceResp.getCode(), text(serviceResp.getMsg(), new String[0]));
    }

    @RequestMapping({"update"})
    @ResponseBody
    public String update(@RequestBody Wata wata)
    {
        ServiceResp serviceResp = this.wataService.update(wata);
        return renderResult(serviceResp.getCode(), text(serviceResp.getMsg(), new String[0]));
    }

    @RequestMapping({"delete"})
    @ResponseBody
    public String delete(@RequestBody Wata wata)
    {
        ServiceResp serviceResp = this.wataService.delete(wata);
        return renderResult(serviceResp.getCode(), text(serviceResp.getMsg(), new String[0]));
    }
}
