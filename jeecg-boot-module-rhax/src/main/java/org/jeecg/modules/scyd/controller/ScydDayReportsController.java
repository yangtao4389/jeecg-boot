package org.jeecg.modules.scyd.controller;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.jeecg.common.api.vo.Result;
import org.jeecg.modules.scyd.entity.ScydDayReportsChild;
import org.jeecg.modules.scyd.entity.ScydDayReportsVideo;
import org.jeecg.modules.scyd.service.IScydDayReportsChildService;
import org.jeecg.modules.scyd.service.IScydDayReportsVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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


    @PostMapping(value = "/saveTest")
    public Result<?> saveTest(@RequestBody ScydDayReportsVideo scydDayReportsVideo){  // 这个才能获取数据@RequestBody
        // 查看是否有当天数据存在
        // 如果没有，则save
        // 如果有，则更新

        LambdaQueryWrapper<ScydDayReportsVideo> query = new LambdaQueryWrapper<ScydDayReportsVideo>();
        query.eq(ScydDayReportsVideo::getDate,scydDayReportsVideo.getDate());
        List<ScydDayReportsVideo> list =  scydDayReportsVideoService.list(query);
        if (list.size()>0){
            scydDayReportsVideoService.update(scydDayReportsVideo,query);
        }else {
            scydDayReportsVideoService.save(scydDayReportsVideo);
        }

        return Result.ok("save ok");
    }

    @PostMapping(value = "/multiType")
    public Result<?> multiType(){
        // 使用同一个entity来实现 可以抽象一个父类，然后不同的表去继承该类  暂时不用。
        // JdbcTemplete 原生写法，增删改查时 表名传进去。自己封装一下，用起来也不错 看一下mybatis-plus有这样的功能没
        // 动态表名。
        return Result.ok("save ok");


    }

}
