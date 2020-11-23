package com.jeesite.modules.ia.web;

import com.jeesite.common.service.ServiceResp;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.ia.entity.IACPrevad;
import com.jeesite.modules.ia.service.IACPrevadService;
import io.swagger.annotations.Api;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import com.jeesite.common.entity.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping({"${adminPath}/iaplat/iacp"})
@Api(value="防治区基本情况调查成果", tags={"防治区基本情况调查成果接口"})
public class IACPrevadController extends BaseController{

    @Autowired
    private IACPrevadService iacPrevadService;

    @RequestMapping({"list"})
    @ResponseBody
    public String list(@RequestBody IACPrevad iacPrevad, HttpServletRequest request, HttpServletResponse response)
    {
        iacPrevad.setPage(new Page(iacPrevad.getPageNo().intValue(), iacPrevad.getPageSize().intValue()));
        Page<IACPrevad> page = this.iacPrevadService.findPage(iacPrevad);
        return renderResult("1", text("查询数据成功！", new String[0]), page);
    }

    @RequestMapping({"save"})
    @ResponseBody
    public String save(@RequestBody IACPrevad iacPrevad)
    {
        ServiceResp serviceResp = new ServiceResp();
        IACPrevad entity = (IACPrevad)this.iacPrevadService.get(iacPrevad);
        if (null != entity)
        {
            serviceResp.setCode("0");
            serviceResp.setMsg("行政区划代码记录已存在");
        }
        else
        {
            serviceResp = this.iacPrevadService.save(iacPrevad);
        }
        return renderResult(serviceResp.getCode(), text(serviceResp.getMsg(), new String[0]));
    }

    @RequestMapping({"update"})
    @ResponseBody
    public String update(@RequestBody IACPrevad iacPrevad)
    {
        ServiceResp serviceResp = this.iacPrevadService.update(iacPrevad);
        return renderResult(serviceResp.getCode(), text(serviceResp.getMsg(), new String[0]));
    }

    @RequestMapping({"delete"})
    @ResponseBody
    public String delete(@RequestBody IACPrevad iacPrevad)
    {
        ServiceResp serviceResp = this.iacPrevadService.delete(iacPrevad);
        return renderResult(serviceResp.getCode(), text(serviceResp.getMsg(), new String[0]));
    }
}
