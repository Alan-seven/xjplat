package com.jeesite.common.service;

import com.jeesite.common.constraints.ValidateUtils;
import com.jeesite.common.constraints.Violation;
import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mapper.JsonMapper;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import com.jeesite.common.entity.Page;



@Transactional(readOnly = true)
public abstract class CrudService<D extends CrudDao<T>, T extends DataEntity<?>> extends QueryService<D, T>
{
    @Transactional(readOnly = false)
    public List<T> findList(T entity){
        return this.dao.findList(entity);
    }

    @Transactional(readOnly = false)
    public ServiceResp insert(T entity) {
        ServiceResp serviceResp = new ServiceResp();
        List<Violation> violations = ValidateUtils.validate(entity);
        if (violations.size() > 0) {
            serviceResp.setCode("2");
            serviceResp.setMsg(JsonMapper.toJson(violations));
        } else {
            try {
                ((CrudDao)this.dao).insert(entity);
                serviceResp.setCode("1");
                serviceResp.setMsg("操作成功");
            } catch (Exception e) {
                serviceResp.setCode("0");
                serviceResp.setMsg("操作失败");
            }
        }
        return serviceResp;
    }



    @Transactional(readOnly = false)
    public ServiceResp save(T entity) {
        ServiceResp serviceResp = new ServiceResp();
        List<Violation> violations = ValidateUtils.validate(entity);
        if (violations.size() > 0) {
            serviceResp.setCode("2");
            serviceResp.setMsg(JsonMapper.toJson(violations));
        } else {
            try {
                ((CrudDao)this.dao).insert(entity);
                serviceResp.setCode("1");
                serviceResp.setMsg("操作成功");
            } catch (Exception e) {
                e.printStackTrace();
                serviceResp.setCode("0");
                serviceResp.setMsg("操作失败");
            }
        }
        return serviceResp;
    }



    @Transactional(readOnly = false)
    public ServiceResp update(T entity) {
        ServiceResp serviceResp = new ServiceResp();
        List<Violation> violations = ValidateUtils.validate(entity);
        if (violations.size() > 0) {
            serviceResp.setCode("2");
            serviceResp.setMsg(JsonMapper.toJson(violations));
        } else {
            try {
                ((CrudDao)this.dao).update(entity);
                serviceResp.setCode("1");
                serviceResp.setMsg("操作成功");
            } catch (Exception e) {
                e.printStackTrace();
                serviceResp.setCode("0");
                serviceResp.setMsg("操作失败");
            }
        }
        return serviceResp;
    }


    public void updateStatus(T entity) { ((CrudDao)this.dao).updateStatus(entity); }



    protected void preSave(T entity) {}



    @Transactional(readOnly = false)
    public ServiceResp delete(T entity) {
        ServiceResp serviceResp = new ServiceResp();
        List<Violation> violations = ValidateUtils.validate(entity);
        if (violations.size() > 0) {
            serviceResp.setCode("2");
            serviceResp.setMsg(JsonMapper.toJson(violations));
        } else {
            try {
                ((CrudDao)this.dao).delete(entity);
                serviceResp.setCode("1");
                serviceResp.setMsg("操作成功");
            } catch (Exception e) {
                e.printStackTrace();
                serviceResp.setCode("0");
                serviceResp.setMsg("操作失败");
            }
        }
        return serviceResp;
    }

}
