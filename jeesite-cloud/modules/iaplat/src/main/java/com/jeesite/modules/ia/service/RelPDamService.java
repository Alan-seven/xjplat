package com.jeesite.modules.ia.service;

import com.jeesite.common.service.CrudService;
import com.jeesite.common.service.ServiceResp;
import com.jeesite.modules.ia.dao.RelPDamDao;
import com.jeesite.modules.ia.entity.RelPDam;
import java.util.Collections;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly=true)
public class RelPDamService extends CrudService<RelPDamDao, RelPDam>{
    public ServiceResp batchSave(List<RelPDam> list, String id)
    {
        list.removeAll(Collections.singleton(null));

        ServiceResp serviceResp = new ServiceResp();
        try
        {
            for (RelPDam entity : list)
            {
                entity.setDamcd(id);
                ((RelPDamDao)this.dao).insert(entity);
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
