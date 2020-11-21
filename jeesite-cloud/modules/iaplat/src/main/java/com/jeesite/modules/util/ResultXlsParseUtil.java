package com.jeesite.modules.util;

public class ResultXlsParseUtil
{
    public static String findMethod(String method)
    {
        if (method.contains("水准仪")) {
            method = "1";
        } else if (method.contains("GNSS")) {
            method = "2";
        } else if (method.contains("全站仪法")) {
            method = "3";
        } else if (method.contains("三维激光")) {
            method = "4";
        }
        return method;
    }

    public static String findDmform(String dmform)
    {
        if ("矩形".equals(dmform)) {
            dmform = "0";
        } else if ("抛物线型".equals(dmform)) {
            dmform = "1";
        } else if ("三角形".equals(dmform)) {
            dmform = "2";
        } else if ("复合型".equals(dmform)) {
            dmform = "3";
        }
        return dmform;
    }

    public static String findTextTure(String texture)
    {
        if ("岩石".equals(texture)) {
            texture = "0";
        } else if ("砂砾石".equals(texture)) {
            texture = "1";
        } else if ("砂土".equals(texture)) {
            texture = "2";
        } else if ("壤土".equals(texture)) {
            texture = "3";
        } else if ("粘土".equals(texture)) {
            texture = "4";
        }
        return texture;
    }
}
