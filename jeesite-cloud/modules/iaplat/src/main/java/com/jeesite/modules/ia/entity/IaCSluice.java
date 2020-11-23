package com.jeesite.modules.ia.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jeesite.common.entity.DataEntity;
import java.util.Date;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public class IaCSluice extends DataEntity<IaCSluice>{
    private String spcd;
    private String gatecode;
    private String gatename;
    private String rvcode;
    private String adcd;
    private String wscd;
    private String gatetype;
    private Float holenum;
    private Float holewid;
    private Float flgateflow;
    private Float rubdamhig;
    private Float rubdamlen;
    private Float lgtd;
    private Float lttd;
    private String signer;
    private String audid;
    private String status;
    private Date moditime;
    private String adnm;
    private String wsnm;

    @Length(min=0, max=32, message="水闸索引长度必须介于 0和 32 之间")
    public String getSpcd()
    {
        return this.spcd;
    }

    public void setSpcd(String spcd)
    {
        this.spcd = spcd;
    }

    @Length(min=0, max=12, message="水闸编码长度必须介于 0和 12 之间")
    @NotNull(message="水闸编码不能为空")
    public String getGatecode()
    {
        return this.gatecode;
    }

    public void setGatecode(String gatecode)
    {
        this.gatecode = gatecode;
    }

    @Length(min=0, max=50, message="水闸名称长度必须介于 0和 50 之间")
    public String getGatename()
    {
        return this.gatename;
    }

    public void setGatename(String gatename)
    {
        this.gatename = gatename;
    }

    @Length(min=0, max=50, message="河流长度必须介于 0和 50 之间")
    public String getRvcode()
    {
        return this.rvcode;
    }

    public void setRvcode(String rvcode)
    {
        this.rvcode = rvcode;
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

    @Length(min=0, max=8, message="水闸类型必须介于 0和 8 之间")
    public String getGatetype()
    {
        return this.gatetype;
    }

    public void setGatetype(String gatetype)
    {
        this.gatetype = gatetype;
    }

    public Float getHolenum()
    {
        return this.holenum;
    }

    public void setHolenum(Float holenum)
    {
        this.holenum = holenum;
    }

    public Float getHolewid()
    {
        return this.holewid;
    }

    public void setHolewid(Float holewid)
    {
        this.holewid = holewid;
    }

    public Float getFlgateflow()
    {
        return this.flgateflow;
    }

    public void setFlgateflow(Float flgateflow)
    {
        this.flgateflow = flgateflow;
    }

    public Float getRubdamhig()
    {
        return this.rubdamhig;
    }

    public void setRubdamhig(Float rubdamhig)
    {
        this.rubdamhig = rubdamhig;
    }

    public Float getRubdamlen()
    {
        return this.rubdamlen;
    }

    public void setRubdamlen(Float rubdamlen)
    {
        this.rubdamlen = rubdamlen;
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
