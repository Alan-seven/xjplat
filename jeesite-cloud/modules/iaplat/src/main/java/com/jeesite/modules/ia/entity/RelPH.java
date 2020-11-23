package com.jeesite.modules.ia.entity;

import com.jeesite.common.entity.DataEntity;

public class RelPH extends DataEntity<RelPH>{
    private String pid;
    private String hecd;

    public String getPid()
    {
        return this.pid;
    }

    public void setPid(String pid)
    {
        this.pid = pid;
    }

    public String getHecd()
    {
        return this.hecd;
    }

    public void setHecd(String hecd)
    {
        this.hecd = hecd;
    }
}
