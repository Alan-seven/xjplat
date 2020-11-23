package com.jeesite.modules.ia.service;

import com.google.common.collect.Lists;
import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.ia.dao.IaCCulvertDao;
import com.jeesite.modules.ia.entity.IaCBridge;
import com.jeesite.modules.ia.entity.IaCCulvert;
import com.jeesite.modules.ia.entity.RelPBridge;
import com.jeesite.modules.ia.entity.RelPCulv;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly=true)
public class IaCCulvertService extends CrudService<IaCCulvertDao, IaCCulvert>{

    /**
     * 分页 带子表查询
     * @param entity
     * @return
     */
    public Page<IaCCulvert> findPage(IaCCulvert entity) {
        Page<IaCCulvert> page = entity.getPage();
        List<IaCCulvert> list = this.dao.findList(entity);
        page.setList(list);
        //主表与子表关联ID数据
        List<RelPCulv> relPCulv = Lists.newArrayList();
        for(IaCCulvert vo : list){
            RelPCulv rel = new RelPCulv();
            rel.setCulcd(vo.getCulcd());
            relPCulv.add(rel);
        }
        //子表查询
        IaCCulvert sub = new IaCCulvert();
        sub.setRelPCulvList(relPCulv);
        List<IaCCulvert> subList = this.dao.findSubList(sub);
        page.setList(subList);
        return page;
    }

}
