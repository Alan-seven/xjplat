package com.jeesite.modules.ia.service;

import com.google.common.collect.Lists;
import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.ia.dao.IACAdinfoDao;
import com.jeesite.modules.ia.entity.IACAdinfo;
import com.jeesite.modules.ia.entity.IAMVsurface;
import com.jeesite.modules.ia.entity.RelPV;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly=true)
public class IACAdinfoService  extends CrudService<IACAdinfoDao, IACAdinfo>{

    /**
     * 根据行政区划名称查询村落对应的图片
     * @param entity
     * @return
     */
    public List<IACAdinfo> findSubList(IACAdinfo entity){
        return this.dao.findSubList(entity);
    }

    /**
     * 分页 带子表查询
     * @param entity
     * @return
     */
    public Page<IACAdinfo> findPage(IACAdinfo entity) {
        Page<IACAdinfo> page = entity.getPage();
        List<IACAdinfo> list = this.dao.findList(entity);
        page.setList(list);
        //主表与子表关联ID数据
        List<RelPV> relphList = Lists.newArrayList();
        for(IACAdinfo vo : list){
            RelPV rel = new RelPV();
            rel.setVecd(vo.getAdcd());
            relphList.add(rel);
        }
        //子表查询
        IACAdinfo sub = new IACAdinfo();
        sub.setRelpList(relphList);
        List<IACAdinfo> subList = this.dao.findSubList(sub);
        page.setList(subList);
        return page;
    }

}
