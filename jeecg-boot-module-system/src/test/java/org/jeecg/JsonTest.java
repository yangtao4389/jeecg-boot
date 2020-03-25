package org.jeecg;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.jeecg.common.util.HttpRequestUtil;
import org.jeecg.modules.scyd.entity.ScydDayReportsChild;

import java.io.Serializable;
import java.util.Date;

public class JsonTest {

    private static Serializable getClass(String classname) throws Exception{
        Class<?> class1 = Class.forName(classname);
        return (Serializable)class1.newInstance();
    }

    public static void main(String[] args) throws Exception{
        String url = "http://112.18.251.47:8600/reports/OM/dailyOrder?date=2020-03-88";
        String responseJsonData = HttpRequestUtil.getJsonContent(url);

        System.out.println(responseJsonData);

        JSONObject jsonObject = JSON.parseObject(responseJsonData);
        System.out.println(jsonObject);
        Date date = jsonObject.getDate("date");
        System.out.println(date);
        int pv = jsonObject.getInteger("i_pvd");
        System.out.println(pv);
        Date date2 = jsonObject.getDate("date");
        System.out.println(date2);
//        ScydDayReportsChild aClass = (ScydDayReportsChild)getClass("org.jeecg.modules.scyd.entity.ScydDayReportsVideo");
//        aClass.setDate(date);

        ScydDayReportsChild scydDayReportsChild = new ScydDayReportsChild();
        scydDayReportsChild.setDate(date);

        


//        Class dd = Class.forName("org.jeecg.modules.scyd.entity.ScydDayReportsVideo");
//        dd.newInstance();
//        factory = dd.setDate(date);
    }
}
