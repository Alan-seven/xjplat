package com.jeesite.modules.ia.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.common.collect.Lists;
import com.jeesite.common.entity.DataEntity;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.util.List;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public class IaZFlood extends DataEntity<IaZFlood>{
    @ApiModelProperty("洪涝编码")
    private String fcd;
    @ApiModelProperty("事件名称")
    private String fname;
    @ApiModelProperty("发灾地点")
    private String address;
    @ApiModelProperty("发灾位置")
    private String location;
    @ApiModelProperty("开始时间")
    private Date startdate;
    @ApiModelProperty("结束时间")
    private Date enddate;
    @ApiModelProperty("单日最大总雨量")
    private Float dyp;
    @ApiModelProperty("最大一小时降雨")
    private Float drp;
    @ApiModelProperty("第一日雨量")
    private Float fdyp;
    @ApiModelProperty("第二日雨量")
    private Float sdyp;
    @ApiModelProperty("第三日雨量")
    private Float tdyp;
    @ApiModelProperty("当日最高温")
    private Float mxatmp;
    @ApiModelProperty("当日最低温")
    private Float mnatmp;
    @ApiModelProperty("前三日平均温度")
    private Float avgtmp;
    @ApiModelProperty("最高洪水水位")
    private Float z;
    @ApiModelProperty("最高洪水流量")
    private Float q;
    @ApiModelProperty("典型测站名称")
    private String stnm;
    @ApiModelProperty("最大淹深")
    private Float dep;
    @ApiModelProperty("转移安置人数")
    private Float spcount;
    @ApiModelProperty("死亡人数")
    private Float dpcount;
    @ApiModelProperty("失踪人数")
    private Float mpcount;
    @ApiModelProperty("损毁房间数")
    private Float chcount;
    @ApiModelProperty("农田受灾面积")
    private Float sarea;
    @ApiModelProperty("农田绝收面积")
    private Float carea;
    @ApiModelProperty("直接经济损失")
    private Float elose;
    @ApiModelProperty("经度")
    private Float lgtd;
    @ApiModelProperty("纬度")
    private Float lttd;
    @ApiModelProperty("备注")
    private String remark;
    @ApiModelProperty("类型")
    private String typ;
    private List<RelPFlood> relPFloodList = Lists.newArrayList();
    private List<IaPBase> pbaseList = Lists.newArrayList();

    @Length(min=0, max=32, message="编码长度必须介于 0和 32 之间")
    @NotNull(message="干旱编码不能为空")
    public String getFcd()
    {
        return this.fcd;
    }

    public void setFcd(String fcd)
    {
        this.fcd = fcd;
    }

    @Length(min=0, max=300, message="名称长度必须介于 0和 300 之间")
    public String getFname()
    {
        return this.fname;
    }

    public void setFname(String fname)
    {
        this.fname = fname;
    }

    @Length(min=0, max=500, message="发灾地点长度必须介于 0和 500 之间")
    public String getAddress()
    {
        return this.address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    @Length(min=0, max=500, message="发灾位置长度必须介于 0和 500 之间")
    public String getLocation()
    {
        return this.location;
    }

    public void setLocation(String location)
    {
        this.location = location;
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    public Date getStartdate()
    {
        return this.startdate;
    }

    public void setStartdate(Date startdate)
    {
        this.startdate = startdate;
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    public Date getEnddate()
    {
        return this.enddate;
    }

    public void setEnddate(Date enddate)
    {
        this.enddate = enddate;
    }

    public Float getDyp()
    {
        return this.dyp;
    }

    public void setDyp(Float dyp)
    {
        this.dyp = dyp;
    }

    public Float getDrp()
    {
        return this.drp;
    }

    public void setDrp(Float drp)
    {
        this.drp = drp;
    }

    public Float getFdyp()
    {
        return this.fdyp;
    }

    public void setFdyp(Float fdyp)
    {
        this.fdyp = fdyp;
    }

    public Float getSdyp()
    {
        return this.sdyp;
    }

    public void setSdyp(Float sdyp)
    {
        this.sdyp = sdyp;
    }

    public Float getTdyp()
    {
        return this.tdyp;
    }

    public void setTdyp(Float tdyp)
    {
        this.tdyp = tdyp;
    }

    public Float getMxatmp()
    {
        return this.mxatmp;
    }

    public void setMxatmp(Float mxatmp)
    {
        this.mxatmp = mxatmp;
    }

    public Float getMnatmp()
    {
        return this.mnatmp;
    }

    public void setMnatmp(Float mnatmp)
    {
        this.mnatmp = mnatmp;
    }

    public Float getAvgtmp()
    {
        return this.avgtmp;
    }

    public void setAvgtmp(Float avgtmp)
    {
        this.avgtmp = avgtmp;
    }

    public Float getZ()
    {
        return this.z;
    }

    public void setZ(Float z)
    {
        this.z = z;
    }

    public Float getQ()
    {
        return this.q;
    }

    public void setQ(Float q)
    {
        this.q = q;
    }

    @Length(min=0, max=50, message="典型测站名称长度必须介于 0和 50 之间")
    public String getStnm()
    {
        return this.stnm;
    }

    public void setStnm(String stnm)
    {
        this.stnm = stnm;
    }

    public Float getDep()
    {
        return this.dep;
    }

    public void setDep(Float dep)
    {
        this.dep = dep;
    }

    public Float getSpcount()
    {
        return this.spcount;
    }

    public void setSpcount(Float spcount)
    {
        this.spcount = spcount;
    }

    public Float getDpcount()
    {
        return this.dpcount;
    }

    public void setDpcount(Float dpcount)
    {
        this.dpcount = dpcount;
    }

    public Float getMpcount()
    {
        return this.mpcount;
    }

    public void setMpcount(Float mpcount)
    {
        this.mpcount = mpcount;
    }

    public Float getChcount()
    {
        return this.chcount;
    }

    public void setChcount(Float chcount)
    {
        this.chcount = chcount;
    }

    public Float getSarea()
    {
        return this.sarea;
    }

    public void setSarea(Float sarea)
    {
        this.sarea = sarea;
    }

    public Float getCarea()
    {
        return this.carea;
    }

    public void setCarea(Float carea)
    {
        this.carea = carea;
    }

    public Float getElose()
    {
        return this.elose;
    }

    public void setElose(Float elose)
    {
        this.elose = elose;
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

    @Length(min=0, max=500, message="备注名称长度必须介于 0和 500 之间")
    public String getRemark()
    {
        return this.remark;
    }

    public void setRemark(String remark)
    {
        this.remark = remark;
    }

    public String getTyp()
    {
        return this.typ;
    }

    public void setTyp(String typ)
    {
        this.typ = typ;
    }

    public List<RelPFlood> getRelPFloodList()
    {
        return this.relPFloodList;
    }

    public void setRelPFloodList(List<RelPFlood> relPFloodList)
    {
        this.relPFloodList = relPFloodList;
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
