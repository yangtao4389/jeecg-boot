package org.jeecg.modules.quartz.job;



import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.jeecg.common.util.DateUtils;
import org.jeecg.common.util.HttpRequestUtil;
import org.jeecg.common.util.SpringContextUtils;
import org.jeecg.modules.scyd.entity.ScydDayReportsVideo;
import org.jeecg.modules.scyd.service.IScydDayReportsVideoService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/*
* 每30分钟更新远程数据一次
* */
@Slf4j
public class UpdateRemoteDailyDataJob implements Job{
    @Autowired
    IScydDayReportsVideoService iScydDayReportsVideoService;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info("UpdateRemoteDailyDataJob 定时任务！ 时间："+ DateUtils.getTimestamp());

        String url = "http://112.18.251.47:8600/reports/OM/dailyOrder";
        // {"i_fakeOrderNum": 6, "date": "2020-03-16", "i_pv": 6908, "i_orderNum": 6, "i_uv": 344, "d_percent": 0.01744186046511628}
        // 存数据库
        String responseJsonData = HttpRequestUtil.getJsonContent(url);
        if (responseJsonData == null){
            return;
        }
        log.info("get url:"+url+"response:"+responseJsonData);

        JSONObject jsonObject = JSON.parseObject(responseJsonData);
        ScydDayReportsVideo scydDayReportsVideo = new ScydDayReportsVideo();
        if (jsonObject instanceof Map) {
            scydDayReportsVideo.setDate(jsonObject.getDate("date"));
            scydDayReportsVideo.setUv(jsonObject.getInteger("i_uv"));
            scydDayReportsVideo.setPv(jsonObject.getInteger("i_pv"));
            scydDayReportsVideo.setOrderNum(jsonObject.getInteger("i_orderNum"));
            scydDayReportsVideo.setFakeOrderNum(jsonObject.getInteger("i_fakeOrderNum"));
            scydDayReportsVideo.setPercent(jsonObject.getBigDecimal("d_percent"));
            iScydDayReportsVideoService.save(scydDayReportsVideo);
            log.info("get url:"+url+"定时获取数据成功");
        }else {
            log.info("get url:"+url+"定时获取数据 失败");
        }

    }
}
