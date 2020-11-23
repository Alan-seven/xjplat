package com.jeesite.modules.ia.service;

import com.google.common.collect.Lists;
import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.ia.dao.IaMHsfmParentDao;
import com.jeesite.modules.ia.entity.IaMHsfmParent;
import com.jeesite.modules.ia.entity.RelPDam;
import com.jeesite.modules.ia.entity.RelPHsfm;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly=true)
public class IaMHsfmParentService extends CrudService<IaMHsfmParentDao, IaMHsfmParent>{

    /**
     * 分页 带子表查询
     * @param entity
     * @return
     */
    public Page<IaMHsfmParent> findPage(IaMHsfmParent entity) {
        Page<IaMHsfmParent> page = entity.getPage();
        List<IaMHsfmParent> list = this.dao.findList(entity);
        page.setList(list);
        //主表与子表关联ID数据
        List<RelPHsfm> relPDams = Lists.newArrayList();
        for(IaMHsfmParent vo : list){
            RelPHsfm rel = new RelPHsfm();
            rel.setFmcd(vo.getFmcd());
            relPDams.add(rel);
        }
        //子表查询
        IaMHsfmParent sub = new IaMHsfmParent();
        sub.setRelphList(relPDams);
        List<IaMHsfmParent> subList = this.dao.findSubList(sub);
        page.setList(subList);
        return page;
    }


}
