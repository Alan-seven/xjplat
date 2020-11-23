package com.jeesite.modules.ia.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.common.collect.Lists;
import com.jeesite.common.entity.DataEntity;
import java.util.Date;
import java.util.List;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public class IAMVsurface extends DataEntity<IAMVsurface>{
    private String vecd;
    private String adcd;
    private String channel;
    private String address;
    private String isctown;
    private Float cele;
    private Float clgtd;
    private Float clttd;
    private String eletype;
    private String method;
    private String signer;
    private String audid;
    private String status;
    private String remark;
    private Date moditime;
    private String adnm;
    private List<RelPV> relpList = Lists.newArrayList();
    private List<IAPInfo> pinfoList = Lists.newArrayList();

    @Length(min=0, max=32, message="纵断面代码长度必须介于 0和 32 之间")
    public String getVecd()
    {
        return this.vecd;
    }

    public void setVecd(String vecd)
    {
        this.vecd = vecd;
    }

    @Length(min=0, max=15, message="行政区划代码长度必须介于 0和 15 之间")
    @NotNull(message="行政区划代码不可为空")
    public String getAdcd()
    {
        return this.adcd;
    }

    public void setAdcd(String adcd)
    {
        this.adcd = adcd;
    }

    @Length(min=0, max=50, message="沟道长度必须介于 0和 50 之间")
    public String getChannel()
    {
        return this.channel;
    }

    public void setChannel(String channel)
    {
        this.channel = channel;
    }

    @Length(min=0, max=100, message="位置长度必须介于 0和 100 之间")
    public String getAddress()
    {
        return this.address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    @Length(min=0, max=1, message="是否跨县长度必须介于 0和 1 之间")
    public String getIsctown()
    {
        return this.isctown;
    }

    public void setIsctown(String isctown)
    {
        this.isctown = isctown;
    }

    public Float getCele()
    {
        return this.cele;
    }

    public void setCele(Float cele)
    {
        this.cele = cele;
    }

    public Float getClgtd()
    {
        return this.clgtd;
    }

    public void setClgtd(Float clgtd)
    {
        this.clgtd = clgtd;
    }

    public Float getClttd()
    {
        return this.clttd;
    }

    public void setClttd(Float clttd)
    {
        this.clttd = clttd;
    }

    public String getEletype()
    {
        return this.eletype;
    }

    public void setEletype(String eletype)
    {
        this.eletype = eletype;
    }

    public String getMethod()
    {
        return this.method;
    }

    public void setMethod(String method)
    {
        this.method = method;
    }

    @Length(min=0, max=10, message="填写人姓名长度必须介于 0和 10 之间")
    public String getSigner()
    {
        return this.signer;
    }

    public void setSigner(String signer)
    {
        this.signer = signer;
    }

    @Length(min=0, max=20, message="审核批次号长度必须介于 0和 20 之间")
    public String getAudid()
    {
        return this.audid;
    }

    public void setAudid(String audid)
    {
        this.audid = audid;
    }

    @Length(min=0, max=1, message="审核状态长度必须介于 0和 1 之间")
    public String getStatus()
    {
        return this.status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    @Length(min=0, max=200, message="备注长度必须介于 0和 200 之间")
    public String getRemark()
    {
        return this.remark;
    }

    public void setRemark(String remark)
    {
        this.remark = remark;
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    public Date getModitime()
    {
        return this.moditime;
    }

    public void setModitime(Date moditime)
    {
        this.moditime = moditime;
    }

    public List<RelPV> getRelpList()
    {
        return this.relpList;
    }

    public void setRelpList(List<RelPV> relpList)
    {
        this.relpList = relpList;
    }

    public List<IAPInfo> getPinfoList()
    {
        return this.pinfoList;
    }

    public void setPinfoList(List<IAPInfo> pinfoList)
    {
        this.pinfoList = pinfoList;
    }

    public String getAdnm()
    {
        return this.adnm;
    }

    public void setAdnm(String adnm)
    {
        this.adnm = adnm;
    }
}
