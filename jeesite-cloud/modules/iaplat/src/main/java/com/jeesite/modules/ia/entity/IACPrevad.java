package com.jeesite.modules.ia.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jeesite.common.entity.DataEntity;
import java.util.Date;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public class IACPrevad
        extends DataEntity<IACPrevad>
{
    private String adcd;
    private int ptcount;
    private Float ldarea;
    private Float plarea;
    private int etcount;
    private int ecount1;
    private int ecount2;
    private int ecount3;
    private int ecount4;
    private Float htcount;
    private Float htcount1;
    private Float htcount2;
    private Float htcount3;
    private Float htcount4;
    private String signer;
    private String audid;
    private String status;
    private String comments;
    private Date moditime;

    @Length(min=0, max=15, message="行政区划代码长度不能超过 15 个字符")
    @NotNull(message="行政区划代码不可为空")
    public String getAdcd()
    {
        return this.adcd;
    }

    public void setAdcd(String adcd)
    {
        this.adcd = adcd;
    }

    public int getPtcount()
    {
        return this.ptcount;
    }

    public void setPtcount(int ptcount)
    {
        this.ptcount = ptcount;
    }

    public Float getLdarea()
    {
        return this.ldarea;
    }

    public void setLdarea(Float ldarea)
    {
        this.ldarea = ldarea;
    }

    public Float getPlarea()
    {
        return this.plarea;
    }

    public void setPlarea(Float plarea)
    {
        this.plarea = plarea;
    }

    public int getEtcount()
    {
        return this.etcount;
    }

    public void setEtcount(int etcount)
    {
        this.etcount = etcount;
    }

    public int getEcount1()
    {
        return this.ecount1;
    }

    public void setEcount1(int ecount1)
    {
        this.ecount1 = ecount1;
    }

    public int getEcount2()
    {
        return this.ecount2;
    }

    public void setEcount2(int ecount2)
    {
        this.ecount2 = ecount2;
    }

    public int getEcount3()
    {
        return this.ecount3;
    }

    public void setEcount3(int ecount3)
    {
        this.ecount3 = ecount3;
    }

    public int getEtcount4()
    {
        return this.ecount4;
    }

    public void setEcount4(int ecount4)
    {
        this.ecount4 = ecount4;
    }

    public Float getHtcount()
    {
        return this.htcount;
    }

    public void setHtcount(Float htcount)
    {
        this.htcount = htcount;
    }

    public Float getHtcount1()
    {
        return this.htcount1;
    }

    public void setHtcount1(Float htcount1)
    {
        this.htcount1 = htcount1;
    }

    public Float getHtcount2()
    {
        return this.htcount2;
    }

    public void setHtcount2(Float htcount2)
    {
        this.htcount2 = htcount2;
    }

    public Float getHtcount3()
    {
        return this.htcount3;
    }

    public void setHtcount3(Float htcount3)
    {
        this.htcount3 = htcount3;
    }

    public Float getHtcount4()
    {
        return this.htcount4;
    }

    public void setHtcount4(Float htcount4)
    {
        this.htcount4 = htcount4;
    }

    @Length(min=0, max=10, message="填写人姓名长度不能超过 10 个字符")
    public String getSigner()
    {
        return this.signer;
    }

    public void setSigner(String signer)
    {
        this.signer = signer;
    }

    @Length(min=0, max=20, message="审核批次号长度不能超过 20 个字符")
    public String getAudid()
    {
        return this.audid;
    }

    public void setAudid(String audid)
    {
        this.audid = audid;
    }

    @Length(min=0, max=1, message="审核状态长度不能超过 1 个字符")
    public String getStatus()
    {
        return this.status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    @Length(min=0, max=255, message="备注长度不能超过 255 个字符")
    public String getComments()
    {
        return this.comments;
    }

    public void setComments(String comments)
    {
        this.comments = comments;
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
