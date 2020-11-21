package com.jeesite.modules.ia.entity;

import com.jeesite.common.entity.DataEntity;

public class RelPHsfm
        extends DataEntity<RelPHsfm>
{
    private String pid;
    private String fmcd;

    public String getPid()
    {
        return this.pid;
    }

    public void setPid(String pid)
    {
        this.pid = pid;
    }

    public String getFmcd()
    {
        return this.fmcd;
    }

    public void setFmcd(String fmcd)
    {
        this.fmcd = fmcd;
    }
}
