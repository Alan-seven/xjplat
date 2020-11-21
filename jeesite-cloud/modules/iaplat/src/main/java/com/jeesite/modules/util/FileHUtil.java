package com.jeesite.modules.util;

import com.google.common.collect.Lists;
import com.jeesite.common.idgen.IdGen;
import com.jeesite.common.utils.excel.ExcelImport;
import com.jeesite.modules.ia.entity.IaMHspoint;
import com.jeesite.modules.ia.entity.IaMHsurface;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class FileHUtil
{
    public static IaMHsurface parseHsurface(String filePath)
    {
        IaMHsurface hsurface = new IaMHsurface();
        try
        {
            ExcelImport excelImport = new ExcelImport(new File(filePath));

            Sheet sheet = excelImport.getWorkbook().getSheetAt(0);

            String address = excelImport.getCellValue(sheet.getRow(1), 1).toString();
            String adcd = excelImport.getCellValue(sheet.getRow(1), 4).toString();
            String channel = excelImport.getCellValue(sheet.getRow(2), 1).toString();
            String dmidentit = excelImport.getCellValue(sheet.getRow(2), 4).toString();
            String dmform = excelImport.getCellValue(sheet.getRow(3), 1).toString();
            dmform = ResultXlsParseUtil.findDmform(dmform);
            String isctown = excelImport.getCellValue(sheet.getRow(3), 4).toString() == "是" ? "1" : "0";
            String texture = excelImport.getCellValue(sheet.getRow(4), 1).toString();
            texture = ResultXlsParseUtil.findTextTure(texture.trim());
            String method = String.valueOf(sheet.getRow(4).getCell(4));
            method = ResultXlsParseUtil.findMethod(method.trim());

            String lgtd = excelImport.getCellValue(sheet.getRow(5), 1).toString();
            String lttd = excelImport.getCellValue(sheet.getRow(5), 4).toString();
            String baseele = excelImport.getCellValue(sheet.getRow(6), 1).toString();
            String azimuth = excelImport.getCellValue(sheet.getRow(6), 4).toString();
            String hmz = excelImport.getCellValue(sheet.getRow(7), 1).toString();
            String czz = excelImport.getCellValue(sheet.getRow(7), 4).toString();

            String hecd = IdGen.uuid();
            hsurface.setHecd(hecd);
            hsurface.setAdcd(adcd);
            hsurface.setAddress(address);
            hsurface.setChannel(channel);
            hsurface.setDmidentit(dmidentit);
            hsurface.setDmform(dmform);
            hsurface.setIsctown(isctown);
            hsurface.setTexture(texture);
            hsurface.setMethod(method);
            hsurface.setVecd(adcd + "001");
            if (StringUtils.isNotBlank(baseele)) {
                hsurface.setBaseele(Float.valueOf(Float.parseFloat(baseele)));
            }
            if (StringUtils.isNotBlank(azimuth)) {
                hsurface.setAzimuth(Float.valueOf(Float.parseFloat(azimuth)));
            }
            if (StringUtils.isNotBlank(hmz)) {
                hsurface.setHmz(Float.valueOf(Float.parseFloat(hmz)));
            }
            if (StringUtils.isNotBlank(czz)) {
                hsurface.setCzz(Float.valueOf(Float.parseFloat(czz)));
            }
            if (StringUtils.isNotBlank(lgtd)) {
                hsurface.setLgtd(Float.valueOf(Float.parseFloat(lgtd)));
            }
            if (StringUtils.isNotBlank(lttd)) {
                hsurface.setLttd(Float.valueOf(Float.parseFloat(lttd)));
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
        return hsurface;
    }

    public static List<IaMHspoint> parseHPoint(String filePath, String hecd)
    {
        List<IaMHspoint> hlist = Lists.newArrayList();
        try
        {
            ExcelImport excelImport = new ExcelImport(new File(filePath));
            Sheet sheet = excelImport.getWorkbook().getSheetAt(0);
            int rownum = sheet.getPhysicalNumberOfRows();
            for (int i = 9; i < rownum; i++)
            {
                String pcode = excelImport.getCellValue(sheet.getRow(i), 1).toString().trim();
                String cdistance = excelImport.getCellValue(sheet.getRow(i), 2).toString().trim();
                String ele = excelImport.getCellValue(sheet.getRow(i), 3).toString().trim();
                String lgtd = excelImport.getCellValue(sheet.getRow(i), 4).toString().trim();
                String lttd = excelImport.getCellValue(sheet.getRow(i), 5).toString().trim();
                String coeff = excelImport.getCellValue(sheet.getRow(i), 6).toString().trim();
                IaMHspoint vhpoint = new IaMHspoint();
                vhpoint.setHecd(hecd);

                vhpoint.setId(IdGen.uuid());
                if (StringUtils.isNotBlank(ele)) {
                    vhpoint.setEle(Float.valueOf(Float.parseFloat(ele)));
                }
                if (StringUtils.isNotBlank(cdistance)) {
                    vhpoint.setCdistance(Float.valueOf(Float.parseFloat(cdistance)));
                }
                if (StringUtils.isNotBlank(lgtd)) {
                    vhpoint.setLgtd(Float.valueOf(Float.parseFloat(lgtd)));
                }
                if (StringUtils.isNotBlank(lttd)) {
                    vhpoint.setLttd(Float.valueOf(Float.parseFloat(lttd)));
                }
                if (StringUtils.isNotBlank(coeff)) {
                    vhpoint.setCoeff(Float.valueOf(Float.parseFloat(coeff)));
                }
                hlist.add(vhpoint);
                System.out.println(pcode + "----" + cdistance + "----" + ele + "----" + lgtd + "---" + lttd + "-----" + vhpoint.getCoeff());
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
        return hlist;
    }

    public static void main(String[] args)
    {
        String str = "E:\\颐信\\X-项目\\新疆山洪灾害\\达坂城区数据\\650107达坂城区\\650107202202000黄渠泉村\\断面组号001\\横断面01\\横断面001.xls";



        String path = "E:\\颐信\\X-项目\\新疆山洪灾害\\达坂城区数据\\650107达坂城区\\650107202202000黄渠泉村\\断面组号001\\横断面01\\6501072022020002l002A.jpg";
        String suffix = path.substring(path.lastIndexOf(".") + 1);
        System.out.println(suffix);
    }
}
