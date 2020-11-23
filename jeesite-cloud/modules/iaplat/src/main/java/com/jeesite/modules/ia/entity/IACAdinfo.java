package com.jeesite.modules.ia.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.common.collect.Lists;
import com.jeesite.common.entity.DataEntity;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.util.List;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public class IACAdinfo extends DataEntity<IACAdinfo>{
    @ApiModelProperty("行政区代码")
    private String adcd;
    private String adnm;
    private int pcount;
    private int htcount;
    private Float ldarea;
    private Float plarea;
    private String prevtp;
    private Float lgtd;
    private Float lttd;
    private String signer;
    private String audid;
    private String status;
    private String comments;
    private Date moditime;

    //村落照片与纵断面照片共有同一套数据表
    private List<RelPV> relpList = Lists.newArrayList();
    private List<IAPInfo> pinfoList = Lists.newArrayList();

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

    @Length(min=0, max=50, message="行政区划名称长度不能超过 50 个字符")
    @NotNull(message="行政区划名称不可为空")
    public String getAdnm()
    {
        return this.adnm;
    }

    public void setAdnm(String adnm)
    {
        this.adnm = adnm;
    }

    public int getPcount()
    {
        return this.pcount;
    }

    public void setPcount(int pcount)
    {
        this.pcount = pcount;
    }

    public int getHtcount()
    {
        return this.htcount;
    }

    public void setHtcount(int htcount)
    {
        this.htcount = htcount;
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

    @Length(min=0, max=1, message="防治区类型长度必须介于 0和 1 之间")
    public String getPrevtp()
    {
        return this.prevtp;
    }

    public void setPrevtp(String prevtp)
    {
        this.prevtp = prevtp;
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

    @Length(min=0, max=1, message="审核状态长度不能超过 1 个字符")
    public String getStatus()
    {
        return this.status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    @Length(min=0, max=200, message="备注长度必须介于 0和 200 之间")
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

    public List<RelPV> getRelpList() {
        return relpList;
    }

    public void setRelpList(List<RelPV> relpList) {
        this.relpList = relpList;
    }

    public List<IAPInfo> getPinfoList() {
        return pinfoList;
    }

    public void setPinfoList(List<IAPInfo> pinfoList) {
        this.pinfoList = pinfoList;
    }
}
