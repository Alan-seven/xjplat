package com.jeesite.modules.ia.service;

import com.jeesite.common.service.CrudService;
import com.jeesite.common.service.ServiceResp;
import com.jeesite.modules.ia.dao.RelPFloodDao;
import com.jeesite.modules.ia.entity.RelPFlood;
import java.util.Collections;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly=true)
public class RelPFloodService
        extends CrudService<RelPFloodDao, RelPFlood>
{
    public ServiceResp batchSave(List<RelPFlood> list, String id)
    {
        list.removeAll(Collections.singleton(null));

        ServiceResp serviceResp = new ServiceResp();
        try
        {
            for (RelPFlood entity : list)
            {
                entity.setFcd(id);
                ((RelPFloodDao)this.dao).insert(entity);
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
}
