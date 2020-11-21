package com.jeesite.modules.ia.entity;

import com.jeesite.common.entity.DataEntity;

public class IaPBase
        extends DataEntity<IaPBase>
{
    private String pid;
    private String pname;
    private String fpath;
    private String disc;

    public String getPid()
    {
        return this.pid;
    }

    public void setPid(String pid)
    {
        this.pid = pid;
    }

    public String getPname()
    {
        return this.pname;
    }

    public void setPname(String pname)
    {
        this.pname = pname;
    }

    public String getFpath()
    {
        return this.fpath;
    }

    public void setFpath(String fpath)
    {
        this.fpath = fpath;
    }

    public String getDisc()
    {
        return this.disc;
    }

    public void setDisc(String disc)
    {
        this.disc = disc;
    }
}
