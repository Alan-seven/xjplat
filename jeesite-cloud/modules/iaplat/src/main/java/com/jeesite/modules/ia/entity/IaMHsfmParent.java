package com.jeesite.modules.ia.entity;

import com.google.common.collect.Lists;
import com.jeesite.common.entity.DataEntity;
import java.util.List;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public class IaMHsfmParent extends DataEntity<IaMHsfmParent>{
    private String fmcd;
    private String channel;
    private String address;
    private String adcd;
    private String method;
    private String isctown;
    private String adnm;
    private List<RelPHsfm> relphList = Lists.newArrayList();
    private List<IAPInfo> pinfoList = Lists.newArrayList();

    @Length(min=0, max=32, message="洪痕编号长度必须介于 0和 32 之间")
    @NotNull(message="洪痕编号不可为空")
    public String getFmcd()
    {
        return this.fmcd;
    }

    public void setFmcd(String fmcd)
    {
        this.fmcd = fmcd;
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

    @Length(min=0, max=1, message="测量方法长度必须介于 0和 1 之间")
    public String getMethod()
    {
        return this.method;
    }

    public void setMethod(String method)
    {
        this.method = method;
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

    public String getAdnm()
    {
        return this.adnm;
    }

    public void setAdnm(String adnm)
    {
        this.adnm = adnm;
    }

    public List<RelPHsfm> getRelphList()
    {
        return this.relphList;
    }

    public void setRelphList(List<RelPHsfm> relphList)
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

    @Length(min=0, max=200, message="所在位置必须介于 0和 200 之间")
    public String getAddress()
    {
        return this.address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }
}
