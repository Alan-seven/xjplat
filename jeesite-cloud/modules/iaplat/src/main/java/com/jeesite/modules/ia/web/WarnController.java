package com.jeesite.modules.ia.web;

import com.google.common.collect.Maps;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.ia.entity.IACAdinfo;
import com.jeesite.modules.ia.entity.IAMVsurface;
import com.jeesite.modules.ia.service.IACAdinfoService;
import com.jeesite.modules.ia.service.IAMVsurfaceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @description: 辅助预警
 * @author: seven
 * @date: 2020/11/23 19:44
 */
@Controller
@RequestMapping({"${adminPath}/iaplat/warn"})
@Api(value="辅助预警", tags={"辅助预警接口接口"})
public class WarnController extends BaseController {

    @Autowired
    private IACAdinfoService iacAdinfoService;

    @Autowired
    private IAMVsurfaceService iamVsurfaceService;

    /**
     * 根据行政区划名称 ，查询行政区划信息，关系图片，纵断面信息
     * @param iacAdinfo
     * @return
     */
    @ResponseBody
    @RequestMapping({"findByAdnm"})
    @ApiOperation(value="根据行政区划名称查询", notes="根据行政区划名称，获取行政区划信息，纵断面信息", httpMethod="POST")
    public String findByAdnm(@RequestBody IACAdinfo iacAdinfo){
        Map<String,Object> maps = Maps.newHashMap();
        List<IACAdinfo> adinfoList = iacAdinfoService.findSubList(iacAdinfo);
        IACAdinfo adinfo = adinfoList.size()>0?adinfoList.get(0):null;
        maps.put("adinfo",adinfo);

        IAMVsurface surface = new IAMVsurface();
        if(null != adinfo){
            surface.setAdcd(adinfo.getAdcd());
            List<IAMVsurface> surList = iamVsurfaceService.findSubList(surface);
            maps.put("surList",surList);
        }
        return renderResult("1", text("查询数据成功！"), maps);
    }


}
