package com.jeesite.modules.ia.entity;

import com.jeesite.common.entity.DataEntity;

public class RelPDam
        extends DataEntity<RelPDam>
{
    private String damcd;
    private String pid;

    public String getDamcd()
    {
        return this.damcd;
    }

    public void setDamcd(String damcd)
    {
        this.damcd = damcd;
    }

    public String getPid()
    {
        return this.pid;
    }

    public void setPid(String pid)
    {
        this.pid = pid;
    }
}
