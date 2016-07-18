package com.o2o.util;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class FileUtils {
	/**http下载*/
	public static byte[] httpDownload(String httpUrl){
        // 下载网络文件
        int bytesum = 1204;
        int byteread = 0;

        URL url = null;
		try {
			url = new URL(httpUrl);
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return null;
		}

        try {
            URLConnection conn = url.openConnection();
            conn.setConnectTimeout(30000);  
            conn.setReadTimeout(10*60*000);  

            InputStream inStream = conn.getInputStream();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            byte[] buffer = new byte[bytesum];
            while ((byteread = inStream.read(buffer)) != -1) {
                bytesum += byteread;               
                baos.write(buffer, 0, byteread);
            }
            byte[] bytes = baos.toByteArray();          
            baos.close();
            return bytes;
        } catch (Exception e) {
            e.printStackTrace();           
        } 
        return null;
    }

}
