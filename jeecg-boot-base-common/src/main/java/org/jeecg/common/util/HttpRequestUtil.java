package org.jeecg.common.util;

import lombok.extern.slf4j.Slf4j;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@Slf4j
public class HttpRequestUtil {
    public static String getJsonContent(String urlStr) {
        try {
            URL url = new URL(urlStr);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(30*1000); // 30秒
            httpURLConnection.setDoInput(true);
            httpURLConnection.setRequestMethod("GET");

            // 获取相应数据
            int respCode = httpURLConnection.getResponseCode();
            if (respCode == 200){
                return convertStream2Json(httpURLConnection.getInputStream());
            }
        }catch (MalformedURLException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    private static String convertStream2Json(InputStream inputStream) {
        String jsonStr = "";
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        try {
            while ((len = inputStream.read(buffer, 0, buffer.length)) != -1) {
                out.write(buffer,0,len);
            }
            jsonStr = new String(out.toByteArray());
        }catch (IOException e){
            log.error(e.getMessage());
        }
        return jsonStr;
    }
}
