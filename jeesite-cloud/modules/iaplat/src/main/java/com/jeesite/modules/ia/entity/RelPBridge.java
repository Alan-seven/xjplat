package com.jeesite.modules.ia.entity;

import com.jeesite.common.entity.DataEntity;

public class RelPBridge extends DataEntity<RelPBridge>{
    private String brcd;
    private String pid;

    public String getBrcd()
    {
        return this.brcd;
    }

    public void setBrcd(String brcd)
    {
        this.brcd = brcd;
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
