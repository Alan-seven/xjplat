package com.jeesite.modules.ia.service;

import com.google.common.collect.Lists;
import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.ia.dao.IaZFloodDao;
import com.jeesite.modules.ia.entity.IaZDrought;
import com.jeesite.modules.ia.entity.IaZFlood;
import com.jeesite.modules.ia.entity.RelPDrought;
import com.jeesite.modules.ia.entity.RelPFlood;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly=true)
public class IaZFloodService extends CrudService<IaZFloodDao, IaZFlood>{

    /**
     * 分页 带子表查询
     * @param entity
     * @return
     */
    public Page<IaZFlood> findPage(IaZFlood entity) {
        Page<IaZFlood> page = entity.getPage();
        List<IaZFlood> list = this.dao.findList(entity);
        page.setList(list);
        //主表与子表关联ID数据
        List<RelPFlood> relList = Lists.newArrayList();
        for(IaZFlood vo : list){
            RelPFlood rel = new RelPFlood();
            rel.setFcd(vo.getFcd());
            relList.add(rel);
        }
        //子表查询
        IaZFlood sub = new IaZFlood();
        sub.setRelPFloodList(relList);
        List<IaZFlood> subList = this.dao.findSubList(sub);
        page.setList(subList);
        return page;
    }
}
