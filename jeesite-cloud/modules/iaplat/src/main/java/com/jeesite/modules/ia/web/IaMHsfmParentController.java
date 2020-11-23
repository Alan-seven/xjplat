package com.jeesite.modules.ia.web;

import com.jeesite.common.idgen.IdGen;
import com.jeesite.common.service.ServiceResp;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.ia.entity.IaMHsfmParent;
import com.jeesite.modules.ia.entity.RelPHsfm;
import com.jeesite.modules.ia.service.IaMHsfmParentService;
import com.jeesite.modules.ia.service.RelPHsfmService;
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
@RequestMapping({"${adminPath}/iaplat/hsfmpar"})
@Api(value="历史洪痕表头信息", tags={"历史洪痕表头接口"})
public class IaMHsfmParentController
        extends BaseController
{
    @Autowired
    private IaMHsfmParentService iaMHsfmParentService;
    @Autowired
    private RelPHsfmService relPHsfmService;

    @RequestMapping({"list"})
    @ResponseBody
    public String list(@RequestBody IaMHsfmParent iaMHsfmParent, HttpServletRequest request, HttpServletResponse response)
    {
        iaMHsfmParent.setPage(new Page(iaMHsfmParent.getPageNo().intValue(), iaMHsfmParent.getPageSize().intValue()));
        Page<IaMHsfmParent> page = this.iaMHsfmParentService.findPage(iaMHsfmParent);
        return renderResult("1", text("查询数据成功！", new String[0]), page);
    }

    @RequestMapping({"save"})
    @ResponseBody
    public String save(@RequestBody IaMHsfmParent iaMHsfmParent)
    {
        iaMHsfmParent.setFmcd(IdGen.uuid());

        RelPHsfm relph = new RelPHsfm();
        relph.setFmcd(iaMHsfmParent.getFmcd());

        ServiceResp serviceResp = this.relPHsfmService.delete(relph);

        serviceResp = this.relPHsfmService.batchSave(iaMHsfmParent.getRelphList(), iaMHsfmParent.getFmcd());

        serviceResp = this.iaMHsfmParentService.save(iaMHsfmParent);
        return renderResult(serviceResp.getCode(), text(serviceResp.getMsg(), new String[0]));
    }

    @RequestMapping({"update"})
    @ResponseBody
    public String update(@RequestBody IaMHsfmParent iaMHsfmParent)
    {
        RelPHsfm relph = new RelPHsfm();
        relph.setFmcd(iaMHsfmParent.getFmcd());

        ServiceResp serviceResp = this.relPHsfmService.delete(relph);

        serviceResp = this.relPHsfmService.batchSave(iaMHsfmParent.getRelphList(), iaMHsfmParent.getFmcd());
        serviceResp = this.iaMHsfmParentService.update(iaMHsfmParent);
        return renderResult(serviceResp.getCode(), text(serviceResp.getMsg(), new String[0]));
    }

    @RequestMapping({"delete"})
    @ResponseBody
    public String delete(@RequestBody IaMHsfmParent iaMHsfmParent)
    {
        ServiceResp serviceResp = this.iaMHsfmParentService.delete(iaMHsfmParent);
        return renderResult(serviceResp.getCode(), text(serviceResp.getMsg(), new String[0]));
    }
}
