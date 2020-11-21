package com.jeesite.modules.util;

import com.alibaba.csp.sentinel.util.StringUtil;
import com.google.common.collect.Lists;
import com.jeesite.common.idgen.IdGen;
import com.jeesite.common.utils.excel.ExcelImport;
import com.jeesite.modules.ia.entity.IAMVsurface;
import com.jeesite.modules.ia.entity.IaMVspoint;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class FileVUtil
{
    public static IAMVsurface parseVsurface(String filePath)
    {
        IAMVsurface msurface = new IAMVsurface();
        try
        {
            ExcelImport excelImport = new ExcelImport(new File(filePath));

            Sheet sheet = excelImport.getWorkbook().getSheetAt(0);

            String address = excelImport.getCellValue(sheet.getRow(1), 1).toString();

            String channel = excelImport.getCellValue(sheet.getRow(2), 1).toString();

            String adcd = excelImport.getCellValue(sheet.getRow(2), 3).toString();

            String isctown = excelImport.getCellValue(sheet.getRow(3), 1).toString() == "是" ? "1" : "0";

            String clgtd = excelImport.getCellValue(sheet.getRow(3), 3).toString();

            String clttd = excelImport.getCellValue(sheet.getRow(4), 1).toString();
            String cele = excelImport.getCellValue(sheet.getRow(4), 3).toString();
            String eletype = excelImport.getCellValue(sheet.getRow(5), 1).toString();
            String method = excelImport.getCellValue(sheet.getRow(5), 3).toString();
            method = ResultXlsParseUtil.findMethod(method);
            msurface.setVecd(adcd + "001");
            if (StringUtils.isNotBlank(clttd)) {
                msurface.setClttd(Float.valueOf(Float.parseFloat(clttd)));
            }
            if (StringUtils.isNotBlank(clgtd)) {
                msurface.setClgtd(Float.valueOf(Float.parseFloat(clgtd)));
            }
            if (StringUtils.isNotBlank(cele)) {
                msurface.setCele(Float.valueOf(Float.parseFloat(cele)));
            }
            msurface.setMethod(method);
            msurface.setAddress(address);
            msurface.setAdcd(adcd);
            msurface.setIsctown(isctown);
            msurface.setChannel(channel);
            msurface.setEletype(eletype);
            System.out.println(clttd + "----" + clgtd + "----" + cele + "---" + method + "----" + address + "---" + adcd + "----" + isctown + "----" + channel + "----" + eletype);
        }
        catch (InvalidFormatException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return msurface;
    }

    public static List<IaMVspoint> parseVPoint(String filePath, String vecd)
    {
        List<IaMVspoint> vlist = Lists.newArrayList();
        try
        {
            ExcelImport excelImport = new ExcelImport(new File(filePath));
            Sheet sheet = excelImport.getWorkbook().getSheetAt(0);
            int rownum = sheet.getPhysicalNumberOfRows();
            for (int i = 8; i < rownum; i++)
            {
                Row row = sheet.getRow(i);
                excelImport.getCellValue(row, 3);

                String pname = excelImport.getCellValue(row, 1).toString();
                String cdistance = excelImport.getCellValue(row, 2).toString();
                String channelData = excelImport.getCellValue(row, 3).toString();

                String ele = excelImport.getCellValue(row, 4).toString();
                String lgtd = excelImport.getCellValue(row, 6).toString();
                String lttd = excelImport.getCellValue(row, 7).toString();
                IaMVspoint vspoint = new IaMVspoint();
                vspoint.setId(IdGen.uuid());
                vspoint.setVecd(vecd);
                vspoint.setPname(pname);
                if (StringUtils.isNotBlank(cdistance)) {
                    vspoint.setCdistance(Float.valueOf(Float.parseFloat(cdistance)));
                }
                if (StringUtil.isNotBlank(channelData)) {
                    vspoint.setChannel(Float.valueOf(Float.parseFloat(channelData)));
                }
                if (StringUtil.isNotBlank(ele)) {
                    vspoint.setEle(Float.valueOf(Float.parseFloat(ele)));
                }
                if (StringUtil.isNotBlank(lgtd)) {
                    vspoint.setLgtd(Float.valueOf(Float.parseFloat(lgtd)));
                }
                if (StringUtil.isNotBlank(lttd)) {
                    vspoint.setLttd(Float.valueOf(Float.parseFloat(lttd)));
                }
                System.out.println(pname + "---" + cdistance + "---=----" + ele + "----" + lgtd + "-----" + lttd);
                vlist.add(vspoint);
            }
        }
        catch (InvalidFormatException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return vlist;
    }

    public static void main(String[] args)
    {
        String str = "E:\\颐信\\X-项目\\新疆山洪灾害\\达坂城区数据\\650107达坂城区\\650107202202000黄渠泉村\\断面组号001\\纵断面0\\纵断面0.xls";
        IAMVsurface vs = parseVsurface(str);
        List<IaMVspoint> list = parseVPoint(str, vs.getVecd());
        System.out.println("----");
    }
}
