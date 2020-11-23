package com.jeesite.modules.ia.service;

import com.google.common.collect.Lists;
import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.ia.dao.IaCBridgeDao;
import com.jeesite.modules.ia.entity.IAMVsurface;
import com.jeesite.modules.ia.entity.IaCBridge;
import com.jeesite.modules.ia.entity.RelPBridge;
import com.jeesite.modules.ia.entity.RelPV;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly=true)
public class IaCBridgeService extends CrudService<IaCBridgeDao, IaCBridge>{

    /**
     * 分页 带子表查询
     * @param entity
     * @return
     */
    public Page<IaCBridge> findPage(IaCBridge entity) {
        Page<IaCBridge> page = entity.getPage();
        List<IaCBridge> list = this.dao.findList(entity);
        page.setList(list);
        //主表与子表关联ID数据
        List<RelPBridge> relPBridgeList = Lists.newArrayList();
        for(IaCBridge vo : list){
            RelPBridge rel = new RelPBridge();
            rel.setBrcd(vo.getBrcd());
            relPBridgeList.add(rel);
        }
        //子表查询
        IaCBridge sub = new IaCBridge();
        sub.setRelPBridgeList(relPBridgeList);
        List<IaCBridge> subList = this.dao.findSubList(sub);
        page.setList(subList);
        return page;
    }

}
