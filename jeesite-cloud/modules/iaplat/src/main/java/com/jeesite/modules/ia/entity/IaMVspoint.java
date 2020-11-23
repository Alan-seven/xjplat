package com.jeesite.modules.ia.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jeesite.common.entity.DataEntity;
import java.util.Date;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public class IaMVspoint extends DataEntity<IaMVspoint>{
    private String vecd;
    private String pname;
    private Float cdistance;
    private Float channel;
    private Float ele;
    private Float lgtd;
    private Float lttd;
    private String cltype;
    private String audid;
    private String remark;
    private Date moditime;

    @Length(min=0, max=32, message="纵断面代码长度必须介于 0和 32 之间")
    public String getVecd()
    {
        return this.vecd;
    }

    public void setVecd(String vecd)
    {
        this.vecd = vecd;
    }

    @Length(min=0, max=50, message="测量点名称长度必须介于 0和 50 之间")
    @NotNull(message="测量点名称不可为空")
    public String getPname()
    {
        return this.pname;
    }

    public void setPname(String pname)
    {
        this.pname = pname;
    }

    public Float getCdistance()
    {
        return this.cdistance;
    }

    public void setCdistance(Float cdistance)
    {
        this.cdistance = cdistance;
    }

    public Float getChannel()
    {
        return this.channel;
    }

    public void setChannel(Float channel)
    {
        this.channel = channel;
    }

    public Float getEle()
    {
        return this.ele;
    }

    public void setEle(Float ele)
    {
        this.ele = ele;
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

    public String getCltype()
    {
        return this.cltype;
    }

    public void setCltype(String cltype)
    {
        this.cltype = cltype;
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
}
