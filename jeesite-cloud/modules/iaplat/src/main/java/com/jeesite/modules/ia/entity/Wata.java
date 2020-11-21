package com.jeesite.modules.ia.entity;

import com.jeesite.common.entity.DataEntity;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public class Wata
        extends DataEntity<Wata>
{
    private String wscd;
    private String wsnm;
    private String gb;
    private String pwscd;
    private String iwscd;
    private String owscd;
    private String ondcd;
    private String wscs;
    private String wstype;
    private Float wsarea;
    private Float wsperi;
    private Float wsslp;
    private Float wsshpc;
    private Float maxlen;
    private Float maxlslp;
    private Float maxls1085;
    private Float centerx;
    private Float centery;
    private Float centerelv;
    private Float outletx;
    private Float outlety;
    private Float outletelv;
    private Float maxelv;
    private Float averou;
    private Float aveinf;

    @Length(min=0, max=16, message="小流域编号长度必须介于 0和 16 之间")
    @NotNull(message="小流域编号不可为空")
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

    @Length(min=0, max=16, message="分类码长度必须介于 0和 16 之间")
    public String getGb()
    {
        return this.gb;
    }

    public void setGb(String gb)
    {
        this.gb = gb;
    }

    public String getPwscd()
    {
        return this.pwscd;
    }

    public void setPwscd(String pwscd)
    {
        this.pwscd = pwscd;
    }

    public String getIwscd()
    {
        return this.iwscd;
    }

    public void setIwscd(String iwscd)
    {
        this.iwscd = iwscd;
    }

    public String getOwscd()
    {
        return this.owscd;
    }

    public void setOwscd(String owscd)
    {
        this.owscd = owscd;
    }

    public String getWscs()
    {
        return this.wscs;
    }

    public void setWscs(String wscs)
    {
        this.wscs = wscs;
    }

    public String getWstype()
    {
        return this.wstype;
    }

    public void setWstype(String wstype)
    {
        this.wstype = wstype;
    }

    public Float getWsarea()
    {
        return this.wsarea;
    }

    public void setWsarea(Float wsarea)
    {
        this.wsarea = wsarea;
    }

    public Float getWsperi()
    {
        return this.wsperi;
    }

    public void setWsperi(Float wsperi)
    {
        this.wsperi = wsperi;
    }

    public Float getWsslp()
    {
        return this.wsslp;
    }

    public void setWsslp(Float wsslp)
    {
        this.wsslp = wsslp;
    }

    public Float getWsshpc()
    {
        return this.wsshpc;
    }

    public void setWsshpc(Float wsshpc)
    {
        this.wsshpc = wsshpc;
    }

    public Float getMaxlen()
    {
        return this.maxlen;
    }

    public void setMaxlen(Float maxlen)
    {
        this.maxlen = maxlen;
    }

    public Float getMaxlslp()
    {
        return this.maxlslp;
    }

    public void setMaxlslp(Float maxlslp)
    {
        this.maxlslp = maxlslp;
    }

    public Float getMaxls1085()
    {
        return this.maxls1085;
    }

    public void setMaxls1085(Float maxls1085)
    {
        this.maxls1085 = maxls1085;
    }

    public Float getCenterx()
    {
        return this.centerx;
    }

    public void setCenterx(Float centerx)
    {
        this.centerx = centerx;
    }

    public Float getCentery()
    {
        return this.centery;
    }

    public void setCentery(Float centery)
    {
        this.centery = centery;
    }

    public Float getCenterelv()
    {
        return this.centerelv;
    }

    public void setCenterelv(Float centerelv)
    {
        this.centerelv = centerelv;
    }

    public Float getOutletx()
    {
        return this.outletx;
    }

    public void setOutletx(Float outletx)
    {
        this.outletx = outletx;
    }

    public Float getOutlety()
    {
        return this.outlety;
    }

    public void setOutlety(Float outlety)
    {
        this.outlety = outlety;
    }

    public Float getOutletelv()
    {
        return this.outletelv;
    }

    public void setOutletelv(Float outletelv)
    {
        this.outletelv = outletelv;
    }

    public Float getMaxelv()
    {
        return this.maxelv;
    }

    public void setMaxelv(Float maxelv)
    {
        this.maxelv = maxelv;
    }

    public Float getAverou()
    {
        return this.averou;
    }

    public void setAverou(Float averou)
    {
        this.averou = averou;
    }

    public Float getAveinf()
    {
        return this.aveinf;
    }

    public void setAveinf(Float aveinf)
    {
        this.aveinf = aveinf;
    }

    public String getOndcd()
    {
        return this.ondcd;
    }

    public void setOndcd(String ondcd)
    {
        this.ondcd = ondcd;
    }
}
