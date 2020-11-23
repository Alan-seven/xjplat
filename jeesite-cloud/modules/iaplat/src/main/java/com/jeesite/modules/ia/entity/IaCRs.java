package com.jeesite.modules.ia.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jeesite.common.entity.DataEntity;
import java.util.Date;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public class IaCRs extends DataEntity<IaCRs>{
    private String rscd;
    private String rscode;
    private String rsname;
    private String adcd;
    private String wscd;
    private String rvcode;
    private String rstype;
    private String mainwrtype;
    private String damtype;
    private String mainfltype;
    private Float mulaverrun;
    private String enggrad;
    private Float damsizehig;
    private Float damsizelen;
    private Float maxdisflow;
    private Float desflstag;
    private Float totcap;
    private Float corsurarea;
    private Float lgtd;
    private Float lttd;
    private String signer;
    private String audid;
    private String status;
    private Date moditime;
    private String adnm;
    private String wsnm;

    @Length(min=0, max=32, message="水库索引长度必须介于 0和 32 之间")
    public String getRscd()
    {
        return this.rscd;
    }

    public void setRscd(String rscd)
    {
        this.rscd = rscd;
    }

    @Length(min=0, max=12, message="水库编码长度必须介于 0和 12 之间")
    @NotNull(message="水库编码不能为空")
    public String getRscode()
    {
        return this.rscode;
    }

    public void setRscode(String rscode)
    {
        this.rscode = rscode;
    }

    @Length(min=0, max=50, message="水库名称长度必须介于 0和 50 之间")
    public String getRsname()
    {
        return this.rsname;
    }

    public void setRsname(String rsname)
    {
        this.rsname = rsname;
    }

    @Length(min=0, max=15, message="行政区划代码长度必须介于 0和 15 之间")
    @NotNull(message="行政区划代码不能为空")
    public String getAdcd()
    {
        return this.adcd;
    }

    public void setAdcd(String adcd)
    {
        this.adcd = adcd;
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

    @Length(min=0, max=50, message="河流代码长度必须介于 0和 50 之间")
    public String getRvcode()
    {
        return this.rvcode;
    }

    public void setRvcode(String rvcode)
    {
        this.rvcode = rvcode;
    }

    @Length(min=0, max=1, message="水库类型长度必须介于 0和 1 之间")
    public String getRstype()
    {
        return this.rstype;
    }

    public void setRstype(String rstype)
    {
        this.rstype = rstype;
    }

    @Length(min=0, max=6, message="主要挡水建筑物类型长度必须介于 0和 6 之间")
    public String getMainwrtype()
    {
        return this.mainwrtype;
    }

    public void setMainwrtype(String mainwrtype)
    {
        this.mainwrtype = mainwrtype;
    }

    @Length(min=0, max=6, message="挡水主坝类型长度必须介于 0和 6 之间")
    public String getDamtype()
    {
        return this.damtype;
    }

    public void setDamtype(String damtype)
    {
        this.damtype = damtype;
    }

    @Length(min=0, max=6, message="主要泄洪建筑物型式长度必须介于 0和 6 之间")
    public String getMainfltype()
    {
        return this.mainfltype;
    }

    public void setMainfltype(String mainfltype)
    {
        this.mainfltype = mainfltype;
    }

    public Float getMulaverrun()
    {
        return this.mulaverrun;
    }

    public void setMulaverrun(Float mulaverrun)
    {
        this.mulaverrun = mulaverrun;
    }

    @Length(min=0, max=6, message="工程类别长度必须介于 0和 6 之间")
    public String getEnggrad()
    {
        return this.enggrad;
    }

    public void setEnggrad(String enggrad)
    {
        this.enggrad = enggrad;
    }

    public Float getDamsizehig()
    {
        return this.damsizehig;
    }

    public void setDamsizehig(Float damsizehig)
    {
        this.damsizehig = damsizehig;
    }

    public Float getDamsizelen()
    {
        return this.damsizelen;
    }

    public void setDamsizelen(Float damsizelen)
    {
        this.damsizelen = damsizelen;
    }

    public Float getMaxdisflow()
    {
        return this.maxdisflow;
    }

    public void setMaxdisflow(Float maxdisflow)
    {
        this.maxdisflow = maxdisflow;
    }

    public Float getDesflstag()
    {
        return this.desflstag;
    }

    public void setDesflstag(Float desflstag)
    {
        this.desflstag = desflstag;
    }

    public Float getTotcap()
    {
        return this.totcap;
    }

    public void setTotcap(Float totcap)
    {
        this.totcap = totcap;
    }

    public Float getCorsurarea()
    {
        return this.corsurarea;
    }

    public void setCorsurarea(Float corsurarea)
    {
        this.corsurarea = corsurarea;
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
}
