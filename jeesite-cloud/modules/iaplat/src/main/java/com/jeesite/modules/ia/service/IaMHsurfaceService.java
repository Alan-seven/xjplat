package com.jeesite.modules.ia.service;

import com.google.common.collect.Lists;
import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.ia.dao.IaMHsurfaceDao;
import com.jeesite.modules.ia.entity.IACPrevad;
import com.jeesite.modules.ia.entity.IaMHsurface;
import com.jeesite.modules.ia.entity.RelPH;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly=true)
public class IaMHsurfaceService extends CrudService<IaMHsurfaceDao, IaMHsurface>{
    /**
     * 分页 带子表查询
     * @param entity
     * @return
     */
    public Page<IaMHsurface> findPage(IaMHsurface entity) {
        Page<IaMHsurface> page = entity.getPage();
        List<IaMHsurface> list = this.dao.findList(entity);
        page.setList(list);
        //主表与子表关联ID数据
        List<RelPH> relphList = Lists.newArrayList();
        for(IaMHsurface vo : list){
            RelPH rel = new RelPH();
            rel.setHecd(vo.getHecd());
            relphList.add(rel);
        }
        //子表查询
        IaMHsurface sub = new IaMHsurface();
        sub.setRelphList(relphList);
        List<IaMHsurface> subList = this.dao.findSubList(sub);
        page.setList(subList);
        return page;
    }
}
