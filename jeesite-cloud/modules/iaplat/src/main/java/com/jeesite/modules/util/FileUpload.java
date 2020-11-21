package com.jeesite.modules.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

public class FileUpload
{
    public static String fileUp(MultipartFile file, String filePath, String fileName)
    {
        String extName = "";
        try
        {
            if (file.getOriginalFilename().lastIndexOf(".") >= 0) {
                extName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
            }
            copyFile(file.getInputStream(), filePath, fileName + extName).replaceAll("-", "");
        }
        catch (IOException e)
        {
            System.out.println(e);
        }
        return fileName + extName;
    }

    private static String copyFile(InputStream in, String dir, String realName)
            throws IOException
    {
        File file = mkdirsmy(dir, realName);
        FileUtils.copyInputStreamToFile(in, file);
        return realName;
    }

    public static File mkdirsmy(String dir, String realName)
            throws IOException
    {
        File file = new File(dir, realName);
        if (!file.exists())
        {
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            file.createNewFile();
        }
        return file;
    }

    public static String getHtmlPicture(String httpUrl, String filePath, String myFileName)
    {
        try
        {
            String fileName = null == myFileName ? httpUrl.substring(httpUrl.lastIndexOf("/")).replace("/", "") : myFileName;
            URL url = new URL(httpUrl);
            BufferedInputStream in = new BufferedInputStream(url.openStream());

            FileOutputStream file = new FileOutputStream(mkdirsmy(filePath, fileName));
            int t;
            while ((t = in.read()) != -1) {
                file.write(t);
            }
            file.close();
            in.close();
            return fileName;
        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
