package com.jeesite.modules.ia.web;

import com.google.common.collect.Lists;
import com.jeesite.common.mapper.JsonMapper;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.ia.entity.Dict;
import com.jeesite.modules.sys.entity.DictData;
import com.jeesite.modules.sys.service.DictDataService;
import io.swagger.annotations.Api;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping({"${adminPath}/iaplat/dict/"})
@Api(value="字典匹配", tags={"字典匹配接口"})
public class DictJsonController
        extends BaseController
{
    @Autowired
    private DictDataService dictDataService;

    @ResponseBody
    @RequestMapping({"get"})
    public void getJsonContent(HttpServletRequest request, HttpServletResponse response)
    {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/javascript;charset=utf-8");
        List<DictData> dictDataList = this.dictDataService.findList(new DictData());
        List<Dict> dictList = Lists.newArrayList();
        for (DictData entity : dictDataList)
        {
            Dict dict = new Dict();
            dict.setDictValue(entity.getDictValue());
            dict.setDictType(entity.getDictType());
            dict.setDictLabel(entity.getDictLabel());
            dictList.add(dict);
        }
        String dictJson = JsonMapper.toJson(dictList);
        try
        {
            response.getWriter().write(dictJson);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
