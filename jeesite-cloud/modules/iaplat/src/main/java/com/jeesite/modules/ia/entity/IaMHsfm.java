package com.jeesite.modules.ia.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jeesite.common.entity.DataEntity;
import java.util.Date;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public class IaMHsfm
        extends DataEntity<IaMHsfm>
{
    private String fmcd;
    private Float lgtd;
    private Float lttd;
    private Float ele;
    private String floodm;
    private String signer;
    private String audid;
    private String status;
    private String remark;
    private Date moditime;
    private String adnm;

    @Length(min=0, max=32, message="洪痕编号长度必须介于 0和 32 之间")
    @NotNull(message="洪痕编号不可为空")
    public String getFmcd()
    {
        return this.fmcd;
    }

    public void setFmcd(String fmcd)
    {
        this.fmcd = fmcd;
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

    public Float getEle()
    {
        return this.ele;
    }

    public void setEle(Float ele)
    {
        this.ele = ele;
    }

    public String getFloodm()
    {
        return this.floodm;
    }

    public void setFloodm(String floodm)
    {
        this.floodm = floodm;
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

    public String getAdnm()
    {
        return this.adnm;
    }

    public void setAdnm(String adnm)
    {
        this.adnm = adnm;
    }
}
