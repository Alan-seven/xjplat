package com.jeesite.modules.ia.web;

import com.jeesite.common.service.ServiceResp;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.ia.entity.IACAdinfo;
import com.jeesite.modules.ia.service.IACAdinfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping({"${adminPath}/iaplat/adinfo"})
@Api(value="行政区划", tags={"行政区划接口"})
public class IACAdinfoController
        extends BaseController
{
    @Autowired
    private IACAdinfoService iacAdinfoService;

    @ResponseBody
    @RequestMapping({"list"})
    @ApiOperation(value="获取行政区划信息", notes="获取行政区划信息", httpMethod="POST")
    public String list(@RequestBody IACAdinfo iacAdinfo, HttpServletResponse response)
    {
        List<IACAdinfo> list = this.iacAdinfoService.findList(iacAdinfo);

        return renderResult("1", text("查询数据成功！", new String[0]), list);
    }

    @ResponseBody
    @RequestMapping({"save"})
    public String save(@RequestBody IACAdinfo iacAdinfo)
    {
        ServiceResp serviceResp = new ServiceResp();
        IACAdinfo entity = (IACAdinfo)this.iacAdinfoService.get(iacAdinfo);
        if (null != entity)
        {
            serviceResp.setCode("0");
            serviceResp.setMsg("行政区划代码记录已存在");
        }
        else
        {
            serviceResp = this.iacAdinfoService.save(iacAdinfo);
        }
        return renderResult(serviceResp.getCode(), text(serviceResp.getMsg(), new String[0]));
    }

    @ResponseBody
    @RequestMapping({"update"})
    public String update(@RequestBody IACAdinfo iacAdinfo)
    {
        ServiceResp serviceResp = this.iacAdinfoService.update(iacAdinfo);
        return renderResult(serviceResp.getCode(), text(serviceResp.getMsg(), new String[0]));
    }

    @ResponseBody
    @RequestMapping({"delete"})
    public String delete(@RequestBody IACAdinfo iacAdinfo)
    {
        ServiceResp serviceResp = this.iacAdinfoService.delete(iacAdinfo);
        return renderResult(serviceResp.getCode(), text(serviceResp.getMsg(), new String[0]));
    }
}
