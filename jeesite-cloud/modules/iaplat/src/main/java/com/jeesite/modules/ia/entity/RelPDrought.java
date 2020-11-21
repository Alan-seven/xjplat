package com.jeesite.modules.ia.entity;

import com.jeesite.common.entity.DataEntity;

public class RelPDrought
        extends DataEntity<RelPDrought>
{
    private String dcd;
    private String pid;

    public String getDcd()
    {
        return this.dcd;
    }

    public void setDcd(String dcd)
    {
        this.dcd = dcd;
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
