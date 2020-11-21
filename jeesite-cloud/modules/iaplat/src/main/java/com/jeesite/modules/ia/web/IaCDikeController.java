package com.jeesite.modules.ia.web;

import com.jeesite.common.entity.Page;
import com.jeesite.common.idgen.IdGen;
import com.jeesite.common.service.ServiceResp;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.ia.entity.IaCDike;
import com.jeesite.modules.ia.service.IaCDikeService;
import io.swagger.annotations.Api;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping({"${adminPath}/iaplat/dike"})
@Api(value="堤防基础", tags={"堤防基础接口"})
public class IaCDikeController
        extends BaseController
{
    @Autowired
    private IaCDikeService iaCDikeService;

    @RequestMapping({"list"})
    @ResponseBody
    public String list(@RequestBody IaCDike iaCDike, HttpServletRequest request, HttpServletResponse response)
    {
        iaCDike.setPage(new Page(iaCDike.getPageNo().intValue(), iaCDike.getPageSize().intValue()));
        Page<IaCDike> page = this.iaCDikeService.findPage(iaCDike);
        return renderResult("1", text("查询数据成功！", new String[0]), page);
    }

    @RequestMapping({"save"})
    @ResponseBody
    public String save(@RequestBody IaCDike iaCDike)
    {
        iaCDike.setDikecd(IdGen.uuid());
        ServiceResp serviceResp = this.iaCDikeService.save(iaCDike);
        return renderResult(serviceResp.getCode(), text(serviceResp.getMsg(), new String[0]));
    }

    @RequestMapping({"update"})
    @ResponseBody
    public String update(@RequestBody IaCDike iaCDike)
    {
        ServiceResp serviceResp = this.iaCDikeService.update(iaCDike);
        return renderResult(serviceResp.getCode(), text(serviceResp.getMsg(), new String[0]));
    }

    @RequestMapping({"delete"})
    @ResponseBody
    public String delete(@RequestBody IaCDike iaCDike)
    {
        ServiceResp serviceResp = this.iaCDikeService.delete(iaCDike);
        return renderResult(serviceResp.getCode(), text(serviceResp.getMsg(), new String[0]));
    }
}
