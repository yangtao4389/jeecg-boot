package org.jeecg;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.jeecg.common.util.HttpRequestUtil;
import org.jeecg.modules.scyd.entity.ScydDayReportsVideo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DailyDataJobTest {
    @Test
    public void testInsert2Data(){
        System.out.println("testInsert2Data");
        String url = "http://112.18.251.47:8600/reports/OM/dailyOrder";
        String responseJsonData = HttpRequestUtil.getJsonContent(url);
        log.info("get url:"+url+"response:"+responseJsonData);
        JSONObject jsonObject = JSON.parseObject(responseJsonData);
        ScydDayReportsVideo scydDayReportsVideo = new ScydDayReportsVideo();
        Date date = jsonObject.getDate("date");
        System.out.println(date);
        Date date2 = jsonObject.getDate("date2");
        System.out.println(date2);


    }

}
