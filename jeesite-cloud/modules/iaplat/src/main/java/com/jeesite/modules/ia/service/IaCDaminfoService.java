package com.jeesite.modules.ia.service;

import com.google.common.collect.Lists;
import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.ia.dao.IaCDaminfoDao;
import com.jeesite.modules.ia.entity.IaCCulvert;
import com.jeesite.modules.ia.entity.IaCDaminfo;
import com.jeesite.modules.ia.entity.RelPCulv;
import com.jeesite.modules.ia.entity.RelPDam;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly=true)
public class IaCDaminfoService extends CrudService<IaCDaminfoDao, IaCDaminfo>{

    /**
     * 分页 带子表查询
     * @param entity
     * @return
     */
    public Page<IaCDaminfo> findPage(IaCDaminfo entity) {
        Page<IaCDaminfo> page = entity.getPage();
        List<IaCDaminfo> list = this.dao.findList(entity);
        page.setList(list);
        //主表与子表关联ID数据
        List<RelPDam> relPDams = Lists.newArrayList();
        for(IaCDaminfo vo : list){
            RelPDam rel= new RelPDam();
            rel.setDamcd(vo.getDamcd());
            relPDams.add(rel);
        }
        //子表查询
        IaCDaminfo sub = new IaCDaminfo();
        sub.setRelPDamList(relPDams);
        List<IaCDaminfo> subList = this.dao.findSubList(sub);
        page.setList(subList);
        return page;
    }
}
