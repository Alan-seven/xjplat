package com.jeesite.modules.ia.service;

import com.google.common.collect.Lists;
import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.ia.dao.IaZDroughtDao;
import com.jeesite.modules.ia.entity.IAMVsurface;
import com.jeesite.modules.ia.entity.IaZDrought;
import com.jeesite.modules.ia.entity.RelPDrought;
import com.jeesite.modules.ia.entity.RelPV;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly=true)
public class IaZDroughtService extends CrudService<IaZDroughtDao, IaZDrought>{

    /**
     * 分页 带子表查询
     * @param entity
     * @return
     */
    public Page<IaZDrought> findPage(IaZDrought entity) {
        Page<IaZDrought> page = entity.getPage();
        List<IaZDrought> list = this.dao.findList(entity);
        page.setList(list);
        //主表与子表关联ID数据
        List<RelPDrought> relList = Lists.newArrayList();
        for(IaZDrought vo : list){
            RelPDrought rel = new RelPDrought();
            rel.setDcd(vo.getDcd());
            relList.add(rel);
        }
        //子表查询
        IaZDrought sub = new IaZDrought();
        sub.setRelPDroughtList(relList);
        List<IaZDrought> subList = this.dao.findSubList(sub);
        page.setList(subList);
        return page;
    }

}
