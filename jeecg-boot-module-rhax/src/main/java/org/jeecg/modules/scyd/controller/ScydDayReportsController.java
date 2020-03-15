package org.jeecg.modules.scyd.controller;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.jeecg.common.api.vo.Result;
import org.jeecg.modules.scyd.entity.ScydDayReportsChild;
import org.jeecg.modules.scyd.entity.ScydDayReportsVideo;
import org.jeecg.modules.scyd.service.IScydDayReportsChildService;
import org.jeecg.modules.scyd.service.IScydDayReportsVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.jeecg.common.constant.HallConstant;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/scyd/dayReports")
public class ScydDayReportsController {
    @Autowired
    private IScydDayReportsChildService scydDayReportsChildService;

    @Autowired
    private IScydDayReportsVideoService scydDayReportsVideoService;



    /*
    * 全部返回  result={data:[], count:10 }
    * */
    @GetMapping(value = "/list")
    public Result<?> queryList(@RequestParam(name = "dateBegin") String dateBegin,
                               @RequestParam(name = "dateEnd") String dateEnd,
                               @RequestParam(name = "productType") String productType) throws Exception{


        if(productType.equals(HallConstant.PRODUCT_CHILDREN)){
            LambdaQueryWrapper<ScydDayReportsChild> query = new LambdaQueryWrapper<ScydDayReportsChild>();
            query.ge(ScydDayReportsChild::getDate,dateBegin).le(ScydDayReportsChild::getDate,dateEnd);
            List<ScydDayReportsChild> list = scydDayReportsChildService.list(query);
            JSONObject obj = new JSONObject();
            obj.put("data",list);
            obj.put("count",list.size());
            return Result.ok(obj);
        }else if(productType.equals(HallConstant.PRODUCT_VIDEO)){
            LambdaQueryWrapper<ScydDayReportsVideo> query = new LambdaQueryWrapper<ScydDayReportsVideo>();
            query.ge(ScydDayReportsVideo::getDate,dateBegin).le(ScydDayReportsVideo::getDate,dateEnd);
            List<ScydDayReportsVideo> list = scydDayReportsVideoService.list(query);
            JSONObject obj = new JSONObject();
            obj.put("data",list);
            obj.put("count",list.size());
            return Result.ok(obj);
        }else {
            return Result.error("no productType");
        }

    }

}
