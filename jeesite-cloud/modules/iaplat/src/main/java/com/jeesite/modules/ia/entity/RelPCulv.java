package com.jeesite.modules.ia.entity;

import com.jeesite.common.entity.DataEntity;

public class RelPCulv extends DataEntity<RelPCulv>{
    private String culcd;
    private String pid;

    public String getCulcd()
    {
        return this.culcd;
    }

    public void setCulcd(String culcd)
    {
        this.culcd = culcd;
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
