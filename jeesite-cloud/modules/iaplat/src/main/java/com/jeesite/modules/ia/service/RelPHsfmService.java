package com.jeesite.modules.ia.service;

import com.jeesite.common.service.CrudService;
import com.jeesite.common.service.ServiceResp;
import com.jeesite.modules.ia.dao.RelPHsfmDao;
import com.jeesite.modules.ia.entity.RelPHsfm;
import java.util.Collections;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly=true)
public class RelPHsfmService
        extends CrudService<RelPHsfmDao, RelPHsfm>
{
    public ServiceResp batchSave(List<RelPHsfm> list, String id)
    {
        list.removeAll(Collections.singleton(null));

        ServiceResp serviceResp = new ServiceResp();
        try
        {
            for (RelPHsfm entity : list)
            {
                entity.setFmcd(id);
                ((RelPHsfmDao)this.dao).insert(entity);
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
