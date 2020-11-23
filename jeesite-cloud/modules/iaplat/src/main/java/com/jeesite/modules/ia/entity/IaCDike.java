package com.jeesite.modules.ia.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jeesite.common.entity.DataEntity;
import java.util.Date;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public class IaCDike extends DataEntity<IaCDike>{
    private String dikecd;
    private String dikecode;
    private String dikename;
    private String adcd;
    private String wscd;
    private String rvcode;
    private String rvbank;
    private String dikecorboun;
    private String diketype;
    private String dikestyl;
    private String dikegrad;
    private String planflsta;
    private Float dikelen;
    private Float flstalen;
    private String elesys;
    private Float desstag;
    private Float dikehigmax;
    private Float dikewidmax;
    private String endtask;
    private Float dikehigmin;
    private Float dikewidmin;
    private Float damcrebegele;
    private Float damcreednele;
    private String signer;
    private String audid;
    private String status;
    private Date moditime;
    private String adnm;
    private String wsnm;

    @Length(min=0, max=32, message="堤防索引长度必须介于 0和 32 之间")
    public String getDikecd()
    {
        return this.dikecd;
    }

    public void setDikecd(String dikecd)
    {
        this.dikecd = dikecd;
    }

    @Length(min=0, max=12, message="堤防编码长度必须介于 0和 12 之间")
    @NotNull(message="堤防编码不能为空")
    public String getDikecode()
    {
        return this.dikecode;
    }

    public void setDikecode(String dikecode)
    {
        this.dikecode = dikecode;
    }

    @Length(min=0, max=50, message="堤防名称长度必须介于 0和 50 之间")
    public String getDikename()
    {
        return this.dikename;
    }

    public void setDikename(String dikename)
    {
        this.dikename = dikename;
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

    @Length(min=0, max=20, message="河流岸别长度必须介于 0和 20 之间")
    public String getRvbank()
    {
        return this.rvbank;
    }

    public void setRvbank(String rvbank)
    {
        this.rvbank = rvbank;
    }

    @Length(min=0, max=20, message="堤防跨界情况长度必须介于 0和 20 之间")
    public String getDikecorboun()
    {
        return this.dikecorboun;
    }

    public void setDikecorboun(String dikecorboun)
    {
        this.dikecorboun = dikecorboun;
    }

    @Length(min=0, max=20, message="堤防类型长度必须介于 0和 20 之间")
    public String getDiketype()
    {
        return this.diketype;
    }

    public void setDiketype(String diketype)
    {
        this.diketype = diketype;
    }

    @Length(min=0, max=16, message="堤防型式长度必须介于 0和 16 之间")
    public String getDikestyl()
    {
        return this.dikestyl;
    }

    public void setDikestyl(String dikestyl)
    {
        this.dikestyl = dikestyl;
    }

    @Length(min=0, max=16, message="堤防级别长度必须介于 0和 16 之间")
    public String getDikegrad()
    {
        return this.dikegrad;
    }

    public void setDikegrad(String dikegrad)
    {
        this.dikegrad = dikegrad;
    }

    @Length(min=0, max=4, message="规划防洪标准长度必须介于 0和 4 之间")
    public String getPlanflsta()
    {
        return this.planflsta;
    }

    public void setPlanflsta(String planflsta)
    {
        this.planflsta = planflsta;
    }

    public Float getDikelen()
    {
        return this.dikelen;
    }

    public void setDikelen(Float dikelen)
    {
        this.dikelen = dikelen;
    }

    public Float getFlstalen()
    {
        return this.flstalen;
    }

    public void setFlstalen(Float flstalen)
    {
        this.flstalen = flstalen;
    }

    @Length(min=0, max=20, message="高程系统长度必须介于 0和 20 之间")
    public String getElesys()
    {
        return this.elesys;
    }

    public void setElesys(String elesys)
    {
        this.elesys = elesys;
    }

    public Float getDesstag()
    {
        return this.desstag;
    }

    public void setDesstag(Float desstag)
    {
        this.desstag = desstag;
    }

    public Float getDikehigmax()
    {
        return this.dikehigmax;
    }

    public void setDikehigmax(Float dikehigmax)
    {
        this.dikehigmax = dikehigmax;
    }

    public Float getDikewidmax()
    {
        return this.dikewidmax;
    }

    public void setDikewidmax(Float dikewidmax)
    {
        this.dikewidmax = dikewidmax;
    }

    @Length(min=0, max=13, message="工程任务长度必须介于 0和 13 之间")
    public String getEndtask()
    {
        return this.endtask;
    }

    public void setEndtask(String endtask)
    {
        this.endtask = endtask;
    }

    public Float getDikehigmin()
    {
        return this.dikehigmin;
    }

    public void setDikehigmin(Float dikehigmin)
    {
        this.dikehigmin = dikehigmin;
    }

    public Float getDikewidmin()
    {
        return this.dikewidmin;
    }

    public void setDikewidmin(Float dikewidmin)
    {
        this.dikewidmin = dikewidmin;
    }

    public Float getDamcrebegele()
    {
        return this.damcrebegele;
    }

    public void setDamcrebegele(Float damcrebegele)
    {
        this.damcrebegele = damcrebegele;
    }

    public Float getDamcreednele()
    {
        return this.damcreednele;
    }

    public void setDamcreednele(Float damcreednele)
    {
        this.damcreednele = damcreednele;
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
