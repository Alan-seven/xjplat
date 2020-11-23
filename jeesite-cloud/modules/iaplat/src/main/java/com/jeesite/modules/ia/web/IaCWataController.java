package com.jeesite.modules.ia.web;

import com.jeesite.common.service.ServiceResp;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.ia.entity.IaCWata;
import com.jeesite.modules.ia.service.IaCWataService;
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
@RequestMapping({"${adminPath}/iaplat/cwata"})
@Api(value="小流域基础信息", tags={"小流域基础信息接口"})
public class IaCWataController extends BaseController{

    @Autowired
    private IaCWataService iaCWataService;

    @RequestMapping({"list"})
    @ResponseBody
    public String list(@RequestBody IaCWata iaCWata, HttpServletRequest request, HttpServletResponse response)
    {
        iaCWata.setPage(new Page(iaCWata.getPageNo().intValue(), iaCWata.getPageSize().intValue()));
        Page<IaCWata> page = this.iaCWataService.findPage(iaCWata);
        return renderResult("1", text("查询数据成功！", new String[0]), page);
    }

    @RequestMapping({"save"})
    @ResponseBody
    public String save(@RequestBody IaCWata iaCWata)
    {
        ServiceResp serviceResp = new ServiceResp();
        IaCWata entity = (IaCWata)this.iaCWataService.get(iaCWata);
        if (null != entity)
        {
            serviceResp.setCode("0");
            serviceResp.setMsg("小流域代码记录已存在");
        }
        else
        {
            serviceResp = this.iaCWataService.save(iaCWata);
        }
        return renderResult(serviceResp.getCode(), text(serviceResp.getMsg(), new String[0]));
    }

    @RequestMapping({"update"})
    @ResponseBody
    public String update(@RequestBody IaCWata iaCWata)
    {
        ServiceResp serviceResp = this.iaCWataService.update(iaCWata);
        return renderResult(serviceResp.getCode(), text(serviceResp.getMsg(), new String[0]));
    }

    @RequestMapping({"delete"})
    @ResponseBody
    public String delete(@RequestBody IaCWata iaCWata)
    {
        ServiceResp serviceResp = this.iaCWataService.delete(iaCWata);
        return renderResult(serviceResp.getCode(), text(serviceResp.getMsg(), new String[0]));
    }
}
