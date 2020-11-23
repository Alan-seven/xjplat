package com.jeesite.modules.ia.entity;

import com.jeesite.common.entity.DataEntity;
import java.util.Date;

public class IaCSrstInfo extends DataEntity<IaCSrstInfo>{
    private String srstcd;
    private String address;
    private String wscd;
    private String adcd;
    private String bdate;
    private String mrain;
    private String light;
    private String wvalue;
    private String prain;
    private Float lgtd;
    private Float lttd;
    private String signer;
    private String audid;
    private String status;
    private String comments;
    private Date moditime;

    public String getSrstcd()
    {
        return this.srstcd;
    }

    public void setSrstcd(String srstcd)
    {
        this.srstcd = srstcd;
    }

    public String getAddress()
    {
        return this.address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getWscd()
    {
        return this.wscd;
    }

    public void setWscd(String wscd)
    {
        this.wscd = wscd;
    }

    public String getAdcd()
    {
        return this.adcd;
    }

    public void setAdcd(String adcd)
    {
        this.adcd = adcd;
    }

    public String getBdate()
    {
        return this.bdate;
    }

    public void setBdate(String bdate)
    {
        this.bdate = bdate;
    }

    public String getMrain()
    {
        return this.mrain;
    }

    public void setMrain(String mrain)
    {
        this.mrain = mrain;
    }

    public String getLight()
    {
        return this.light;
    }

    public void setLight(String light)
    {
        this.light = light;
    }

    public String getWvalue()
    {
        return this.wvalue;
    }

    public void setWvalue(String wvalue)
    {
        this.wvalue = wvalue;
    }

    public String getPrain()
    {
        return this.prain;
    }

    public void setPrain(String prain)
    {
        this.prain = prain;
    }

    public Float getLgtd()
    {
        return this.lgtd;
    }

    public void setLgtd(Float lgtd)
    {
        this.lgtd = lgtd;
    }

    public Float getLttd()
    {
        return this.lttd;
    }

    public void setLttd(Float lttd)
    {
        this.lttd = lttd;
    }

    public String getSigner()
    {
        return this.signer;
    }

    public void setSigner(String signer)
    {
        this.signer = signer;
    }

    public String getAudid()
    {
        return this.audid;
    }

    public void setAudid(String audid)
    {
        this.audid = audid;
    }

    public String getStatus()
    {
        return this.status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getComments()
    {
        return this.comments;
    }

    public void setComments(String comments)
    {
        this.comments = comments;
    }

    public Date getModitime()
    {
        return this.moditime;
    }

    public void setModitime(Date moditime)
    {
        this.moditime = moditime;
    }
}
