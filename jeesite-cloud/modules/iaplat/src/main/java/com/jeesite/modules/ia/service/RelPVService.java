package com.jeesite.modules.ia.service;

import com.jeesite.common.service.CrudService;
import com.jeesite.common.service.ServiceResp;
import com.jeesite.modules.ia.dao.RelPVDao;
import com.jeesite.modules.ia.entity.RelPV;
import java.util.Collections;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly=true)
public class RelPVService extends CrudService<RelPVDao, RelPV>{

    public ServiceResp batchSave(List<RelPV> list, String id)
    {
        list.removeAll(Collections.singleton(null));

        ServiceResp serviceResp = new ServiceResp();
        try
        {
            for (RelPV entity : list)
            {
                entity.setVecd(id);
                ((RelPVDao)this.dao).insert(entity);
            }
            serviceResp.setCode("1");
            serviceResp.setMsg("操作成功");
        }
        catch (Exception e)
        {
            serviceResp.setCode("0");
            serviceResp.setMsg("操作失败");
        }
        return serviceResp;
    }

    public ServiceResp removeAll(RelPV entity)
    {
        ServiceResp serviceResp = new ServiceResp();
        try{
            this.dao.delete(entity);
            serviceResp.setCode("1");
            serviceResp.setMsg("操作成功");
        }catch (Exception e){
            serviceResp.setCode("0");
            serviceResp.setMsg("操作失败");
        }
        return serviceResp;
    }
}
