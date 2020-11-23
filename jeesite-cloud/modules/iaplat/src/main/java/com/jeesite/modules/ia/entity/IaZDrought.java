package com.jeesite.modules.ia.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.common.collect.Lists;
import com.jeesite.common.entity.DataEntity;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.util.List;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public class IaZDrought extends DataEntity<IaZDrought>{
    @ApiModelProperty("干旱编码")
    private String dcd;
    @ApiModelProperty("名称")
    private String dname;
    @ApiModelProperty("发灾范围")
    private String location;
    @ApiModelProperty("开始时间")
    private Date startdate;
    @ApiModelProperty("结束时间")
    private Date enddate;
    @ApiModelProperty("总雨量")
    private Float dyp;
    @ApiModelProperty("连续无雨天气")
    private Float avgd;
    @ApiModelProperty("前三日平均温度")
    private Float avgtmp;
    @ApiModelProperty("最高洪水水位")
    private Float z;
    @ApiModelProperty("最高洪水流量")
    private Float q;
    @ApiModelProperty("总调水量")
    private Float w;
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
    private List<RelPDrought> relPDroughtList = Lists.newArrayList();
    private List<IaPBase> pbaseList = Lists.newArrayList();

    @Length(min=0, max=32, message="干旱编码长度必须介于 0和 32 之间")
    @NotNull(message="干旱编码不能为空")
    public String getDcd()
    {
        return this.dcd;
    }

    public void setDcd(String dcd)
    {
        this.dcd = dcd;
    }

    @Length(min=0, max=300, message="干旱名称长度必须介于 0和 300 之间")
    public String getDname()
    {
        return this.dname;
    }

    public void setDname(String dname)
    {
        this.dname = dname;
    }

    @Length(min=0, max=500, message="发灾范围长度必须介于 0和 500 之间")
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

    public Float getAvgd()
    {
        return this.avgd;
    }

    public void setAvgd(Float avgd)
    {
        this.avgd = avgd;
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

    public Float getW()
    {
        return this.w;
    }

    public void setW(Float w)
    {
        this.w = w;
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

    @Length(min=0, max=500, message="备注长度必须介于 0和 500 之间")
    public String getRemark()
    {
        return this.remark;
    }

    public void setRemark(String remark)
    {
        this.remark = remark;
    }

    public List<RelPDrought> getRelPDroughtList()
    {
        return this.relPDroughtList;
    }

    public void setRelPDroughtList(List<RelPDrought> relPDroughtList)
    {
        this.relPDroughtList = relPDroughtList;
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
