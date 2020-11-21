package com.jeesite.modules.util;

import com.google.common.collect.Lists;
import com.jeesite.common.idgen.IdGen;
import com.jeesite.common.lang.StringUtils;
import com.jeesite.common.utils.excel.ExcelImport;
import com.jeesite.modules.ia.entity.IaMHsfm;
import com.jeesite.modules.ia.entity.IaMHsfmParent;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class FileHsFmUtil
{
    public static IaMHsfmParent parseHsFmParent(String filePath)
    {
        IaMHsfmParent iaMHsfmParent = new IaMHsfmParent();
        try
        {
            ExcelImport excelImport = new ExcelImport(new File(filePath));
            Sheet sheet = excelImport.getWorkbook().getSheetAt(0);
            int rownum = sheet.getPhysicalNumberOfRows();
            String address = excelImport.getCellValue(sheet.getRow(1), 1).toString();
            String channel = excelImport.getCellValue(sheet.getRow(2), 1).toString();
            String adcd = excelImport.getCellValue(sheet.getRow(2), 4).toString();
            String method = excelImport.getCellValue(sheet.getRow(3), 1).toString();
            method = ResultXlsParseUtil.findMethod(method);
            String isctown = excelImport.getCellValue(sheet.getRow(3), 4).toString() == "是" ? "1" : "0";

            iaMHsfmParent.setFmcd(IdGen.uuid());
            iaMHsfmParent.setAddress(address);
            iaMHsfmParent.setChannel(channel);
            iaMHsfmParent.setAdcd(adcd);
            iaMHsfmParent.setMethod(method);
            iaMHsfmParent.setIsctown(isctown);
        }
        catch (InvalidFormatException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return iaMHsfmParent;
    }

    public static List<IaMHsfm> parseHsFm(String filePath, String fmcd)
    {
        List<IaMHsfm> list = Lists.newArrayList();
        try
        {
            ExcelImport excelImport = new ExcelImport(new File(filePath));
            Sheet sheet = excelImport.getWorkbook().getSheetAt(0);
            int rownum = sheet.getPhysicalNumberOfRows();
            for (int i = 6; i < rownum; i++)
            {
                String lgtd = String.valueOf(excelImport.getCellValue(sheet.getRow(i), 1));
                String lttd = String.valueOf(excelImport.getCellValue(sheet.getRow(i), 2));
                String ele = String.valueOf(excelImport.getCellValue(sheet.getRow(i), 3));

                String floodm = String.valueOf(excelImport.getCellValue(sheet.getRow(i), 4));

                IaMHsfm iaMHsfm = new IaMHsfm();
                iaMHsfm.setId(IdGen.uuid());
                iaMHsfm.setFmcd(fmcd);
                iaMHsfm.setFloodm(floodm);
                if (StringUtils.isNotBlank(lgtd)) {
                    iaMHsfm.setLgtd(Float.valueOf(Float.parseFloat(lgtd)));
                }
                if (StringUtils.isNotBlank(lttd)) {
                    iaMHsfm.setLttd(Float.valueOf(Float.parseFloat(lttd)));
                }
                if (StringUtils.isNotBlank(ele)) {
                    iaMHsfm.setEle(Float.valueOf(Float.parseFloat(ele)));
                }
                list.add(iaMHsfm);
                System.out.println(iaMHsfm.getLgtd() + "--" + iaMHsfm.getLttd() + "----" + iaMHsfm.getFloodm() + "---" + floodm);
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
        return list;
    }

    public static void main(String[] args)
    {
        String str = "E:\\颐信\\X-项目\\新疆山洪灾害\\达坂城区数据\\650107达坂城区\\650107202202000黄渠泉村\\断面组号001\\历史痕迹01\\历史洪痕阿克苏乡黄渠泉村01.xls";
        IaMHsfmParent entity = parseHsFmParent(str);
        parseHsFm(str, entity.getFmcd());
    }
}
