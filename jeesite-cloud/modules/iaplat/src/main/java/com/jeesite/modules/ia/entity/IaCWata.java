package com.jeesite.modules.ia.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jeesite.common.entity.DataEntity;
import java.util.Date;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public class IaCWata extends DataEntity<IaCWata>{
    private String wscd;
    private String wsnm;
    private String naddress;
    private Float nlgtd;
    private Float nlttd;
    private Date moditime;

    @Length(min=0, max=16, message="小流域编码长度必须介于 0和 16 之间")
    @NotNull(message="小流域编码不能为空")
    public String getWscd()
    {
        return this.wscd;
    }

    public void setWscd(String wscd)
    {
        this.wscd = wscd;
    }

    @Length(min=0, max=32, message="小流域名称长度必须介于 0和 32 之间")
    public String getWsnm()
    {
        return this.wsnm;
    }

    public void setWsnm(String wsnm)
    {
        this.wsnm = wsnm;
    }

    @Length(min=0, max=200, message="出口位置地址长度必须介于 0和 200 之间")
    public String getNaddress()
    {
        return this.naddress;
    }

    public void setNaddress(String naddress)
    {
        this.naddress = naddress;
    }

    public Float getNlgtd()
    {
        return this.nlgtd;
    }

    public void setNlgtd(Float nlgtd)
    {
        this.nlgtd = nlgtd;
    }

    public Float getNlttd()
    {
        return this.nlttd;
    }

    public void setNlttd(Float nlttd)
    {
        this.nlttd = nlttd;
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
