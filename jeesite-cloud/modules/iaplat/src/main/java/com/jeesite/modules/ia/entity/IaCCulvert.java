package com.jeesite.modules.ia.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.common.collect.Lists;
import com.jeesite.common.entity.DataEntity;
import java.util.Date;
import java.util.List;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public class IaCCulvert
        extends DataEntity<IaCCulvert>
{
    private String culcd;
    private String culname;
    private String wscd;
    private String adcd;
    private String picid;
    private Float lgtd;
    private Float lttd;
    private Float height;
    private Float width;
    private String typ;
    private String signer;
    private String audid;
    private String status;
    private String comments;
    private Date moditime;
    private String adnm;
    private String wsnm;
    private List<RelPCulv> relPCulvList = Lists.newArrayList();
    private List<IaPBase> pbaseList = Lists.newArrayList();

    @Length(min=0, max=32, message="路涵编码长度必须介于 0和 32 之间")
    @NotNull(message="路涵编码不能为空")
    public String getCulcd()
    {
        return this.culcd;
    }

    public void setCulcd(String culcd)
    {
        this.culcd = culcd;
    }

    @Length(min=0, max=50, message="路涵名称长度必须介于 0和 50 之间")
    public String getCulname()
    {
        return this.culname;
    }

    public void setCulname(String culname)
    {
        this.culname = culname;
    }

    @Length(min=0, max=16, message="小流域代码长度必须介于 0和 16 之间")
    public String getWscd()
    {
        return this.wscd;
    }

    public void setWscd(String wscd)
    {
        this.wscd = wscd;
    }

    @Length(min=0, max=15, message="行政区划代码长度必须介于 0和 15 之间")
    public String getAdcd()
    {
        return this.adcd;
    }

    public void setAdcd(String adcd)
    {
        this.adcd = adcd;
    }

    @Length(min=0, max=18, message="照片编号长度必须介于 0和 18 之间")
    public String getPicid()
    {
        return this.picid;
    }

    public void setPicid(String picid)
    {
        this.picid = picid;
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

    public Float getHeight()
    {
        return this.height;
    }

    public void setHeight(Float height)
    {
        this.height = height;
    }

    public Float getWidth()
    {
        return this.width;
    }

    public void setWidth(Float width)
    {
        this.width = width;
    }

    @Length(min=0, max=50, message="类型长度必须介于 0和 50 之间")
    public String getTyp()
    {
        return this.typ;
    }

    public void setTyp(String typ)
    {
        this.typ = typ;
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

    public String getAdnm()
    {
        return this.adnm;
    }

    public void setAdnm(String adnm)
    {
        this.adnm = adnm;
    }

    public String getWsnm()
    {
        return this.wsnm;
    }

    public void setWsnm(String wsnm)
    {
        this.wsnm = wsnm;
    }

    public List<RelPCulv> getRelPCulvList()
    {
        return this.relPCulvList;
    }

    public void setRelPCulvList(List<RelPCulv> relPCulvList)
    {
        this.relPCulvList = relPCulvList;
    }

    public List<IaPBase> getPbaseList()
    {
        return this.pbaseList;
    }

    public void setPbaseList(List<IaPBase> pbaseList)
    {
        this.pbaseList = pbaseList;
    }
}
