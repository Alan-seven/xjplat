package com.jeesite.modules.ia.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.common.collect.Lists;
import com.jeesite.common.entity.DataEntity;
import java.util.Date;
import java.util.List;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public class IaMHsurface extends DataEntity<IaMHsurface>{
    private String hecd;
    private String adcd;
    private String channel;
    private String address;
    private String isctown;
    private String dmidentit;
    private String dmform;
    private String texture;
    private String coordinate;
    private String eletype;
    private Float baseele;
    private Float baselgtd;
    private Float baselttd;
    private Float azimuth;
    private Float hmz;
    private Float czz;
    private String method;
    private String vecd;
    private String signer;
    private String audid;
    private String status;
    private String remark;
    private Date moditime;
    private Float lgtd;
    private Float lttd;
    private String adnm;
    private List<RelPH> relphList = Lists.newArrayList();
    private List<IAPInfo> pinfoList = Lists.newArrayList();

    @Length(min=0, max=32, message="横断面代码长度必须介于 0和 32 之间")
    public String getHecd()
    {
        return this.hecd;
    }

    public void setHecd(String hecd)
    {
        this.hecd = hecd;
    }

    @Length(min=0, max=15, message="行政区划代码长度必须介于 0和 15 之间")
    @NotNull(message="行政区划代码不可为空")
    public String getAdcd()
    {
        return this.adcd;
    }

    public void setAdcd(String adcd)
    {
        this.adcd = adcd;
    }

    @Length(min=0, max=50, message="沟道长度必须介于 0和 50 之间")
    public String getChannel()
    {
        return this.channel;
    }

    public void setChannel(String channel)
    {
        this.channel = channel;
    }

    @Length(min=0, max=100, message="位置长度必须介于 0和 100 之间")
    public String getAddress()
    {
        return this.address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    @Length(min=0, max=1, message="是否跨县长度必须介于 0和 1 之间")
    public String getIsctown()
    {
        return this.isctown;
    }

    public void setIsctown(String isctown)
    {
        this.isctown = isctown;
    }

    @Length(min=0, max=20, message="断面标识长度必须介于 0和 20 之间")
    public String getDmidentit()
    {
        return this.dmidentit;
    }

    public void setDmidentit(String dmidentit)
    {
        this.dmidentit = dmidentit;
    }

    @Length(min=0, max=1, message="断面形态长度必须介于 0和 1 之间")
    public String getDmform()
    {
        return this.dmform;
    }

    public void setDmform(String dmform)
    {
        this.dmform = dmform;
    }

    @Length(min=0, max=1, message="河床底质长度必须介于 0和 1 之间")
    public String getTexture()
    {
        return this.texture;
    }

    public void setTexture(String texture)
    {
        this.texture = texture;
    }

    @Length(min=0, max=1, message="坐标系长度必须介于 0和 1 之间")
    public String getCoordinate()
    {
        return this.coordinate;
    }

    public void setCoordinate(String coordinate)
    {
        this.coordinate = coordinate;
    }

    @Length(min=0, max=1, message="高程系长度必须介于 0和 1 之间")
    public String getEletype()
    {
        return this.eletype;
    }

    public void setEletype(String eletype)
    {
        this.eletype = eletype;
    }

    public Float getBaseele()
    {
        return this.baseele;
    }

    public void setBaseele(Float baseele)
    {
        this.baseele = baseele;
    }

    public Float getBaselgtd()
    {
        return this.baselgtd;
    }

    public void setBaselgtd(Float baselgtd)
    {
        this.baselgtd = baselgtd;
    }

    public Float getBaselttd()
    {
        return this.baselttd;
    }

    public void setBaselttd(Float baselttd)
    {
        this.baselttd = baselttd;
    }

    public Float getAzimuth()
    {
        return this.azimuth;
    }

    public void setAzimuth(Float azimuth)
    {
        this.azimuth = azimuth;
    }

    public Float getHmz()
    {
        return this.hmz;
    }

    public void setHmz(Float hmz)
    {
        this.hmz = hmz;
    }

    public Float getCzz()
    {
        return this.czz;
    }

    public void setCzz(Float czz)
    {
        this.czz = czz;
    }

    @Length(min=0, max=1, message="测量方法长度必须介于 0和 1 之间")
    public String getMethod()
    {
        return this.method;
    }

    public void setMethod(String method)
    {
        this.method = method;
    }

    @Length(min=0, max=18, message="纵断面代码长度必须介于 0和 18 之间")
    @NotNull(message="纵断面代码不可为空")
    public String getVecd()
    {
        return this.vecd;
    }

    public void setVecd(String vecd)
    {
        this.vecd = vecd;
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

    public List<RelPH> getRelphList()
    {
        return this.relphList;
    }

    public void setRelphList(List<RelPH> relphList)
    {
        this.relphList = relphList;
    }

    public List<IAPInfo> getPinfoList()
    {
        return this.pinfoList;
    }

    public void setPinfoList(List<IAPInfo> pinfoList)
    {
        this.pinfoList = pinfoList;
    }

    public String getAdnm()
    {
        return this.adnm;
    }

    public void setAdnm(String adnm)
    {
        this.adnm = adnm;
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
}
