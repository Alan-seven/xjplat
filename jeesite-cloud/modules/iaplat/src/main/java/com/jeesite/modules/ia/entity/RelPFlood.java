package com.jeesite.modules.ia.entity;

import com.jeesite.common.entity.DataEntity;

public class RelPFlood
        extends DataEntity<RelPFlood>
{
    private String pid;
    private String fcd;

    public String getPid()
    {
        return this.pid;
    }

    public void setPid(String pid)
    {
        this.pid = pid;
    }

    public String getFcd()
    {
        return this.fcd;
    }

    public void setFcd(String fcd)
    {
        this.fcd = fcd;
    }
}
