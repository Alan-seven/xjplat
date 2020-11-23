package com.jeesite.modules.ia.service;

import com.google.common.collect.Lists;
import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.ia.dao.IAMVsurfaceDao;
import com.jeesite.modules.ia.entity.IAMVsurface;
import com.jeesite.modules.ia.entity.IaMHsurface;
import com.jeesite.modules.ia.entity.RelPH;
import com.jeesite.modules.ia.entity.RelPV;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly=true)
public class IAMVsurfaceService extends CrudService<IAMVsurfaceDao, IAMVsurface>{
    /**
     * 分页 带子表查询
     * @param entity
     * @return
     */
    public Page<IAMVsurface> findPage(IAMVsurface entity) {
        Page<IAMVsurface> page = entity.getPage();
        List<IAMVsurface> list = this.dao.findList(entity);
        page.setList(list);
        //主表与子表关联ID数据
        List<RelPV> relphList = Lists.newArrayList();
        for(IAMVsurface vo : list){
            RelPV rel = new RelPV();
            rel.setVecd(vo.getVecd());
            relphList.add(rel);
        }
        //子表查询
        IAMVsurface sub = new IAMVsurface();
        sub.setRelpList(relphList);
        List<IAMVsurface> subList = this.dao.findSubList(sub);
        page.setList(subList);
        return page;
    }
}
