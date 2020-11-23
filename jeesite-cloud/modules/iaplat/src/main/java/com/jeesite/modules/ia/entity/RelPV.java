package com.jeesite.modules.ia.entity;

import com.jeesite.common.entity.DataEntity;

public class RelPV extends DataEntity<RelPV>{
    private String pid;
    private String vecd;

    public String getPid()
    {
        return this.pid;
    }

    public void setPid(String pid)
    {
        this.pid = pid;
    }

    public String getVecd()
    {
        return this.vecd;
    }

    public void setVecd(String vecd)
    {
        this.vecd = vecd;
    }
}
