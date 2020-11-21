package com.jeesite.modules.ia.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jeesite.common.entity.DataEntity;
import java.util.Date;
import org.hibernate.validator.constraints.Length;

public class IaMHspoint
        extends DataEntity<IaMHspoint>
{
    private String hecd;
    private String pcode;
    private Float cdistance;
    private Float ele;
    private Float lgtd;
    private Float lttd;
    private Float coeff;
    private String audid;
    private String status;
    private String remark;
    private Date moditime;

    @Length(min=0, max=32, message="横断面代码长度必须介于 0和 32 之间")
    public String getHecd()
    {
        return this.hecd;
    }

    public void setHecd(String hecd)
    {
        this.hecd = hecd;
    }

    @Length(min=0, max=50, message="断面特征点代码长度必须介于 0和 50 之间")
    public String getPcode()
    {
        return this.pcode;
    }

    public void setPcode(String pcode)
    {
        this.pcode = pcode;
    }

    public Float getCdistance()
    {
        return this.cdistance;
    }

    public void setCdistance(Float cdistance)
    {
        this.cdistance = cdistance;
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

    public Float getCoeff()
    {
        return this.coeff;
    }

    public void setCoeff(Float coeff)
    {
        this.coeff = coeff;
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
}
