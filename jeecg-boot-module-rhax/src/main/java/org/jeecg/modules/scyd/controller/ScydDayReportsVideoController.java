package org.jeecg.modules.scyd.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.common.util.oConvertUtils;
import org.jeecg.modules.scyd.entity.ScydDayReportsVideo;
import org.jeecg.modules.scyd.service.IScydDayReportsVideoService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;

import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.def.NormalExcelConstants;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.view.JeecgEntityExcelView;
import org.jeecg.common.system.base.controller.JeecgController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import com.alibaba.fastjson.JSON;

 /**
 * @Description: scyd_day_reports_video
 * @Author: jeecg-boot
 * @Date:   2020-03-09
 * @Version: V1.0
 */
@RestController
@RequestMapping("/scyd/scydDayReportsVideo")
@Slf4j
public class ScydDayReportsVideoController extends JeecgController<ScydDayReportsVideo, IScydDayReportsVideoService> {
	@Autowired
	private IScydDayReportsVideoService scydDayReportsVideoService;
	
	/**
	 * 分页列表查询
	 *
	 * @param scydDayReportsVideo
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	@GetMapping(value = "/list")
	public Result<?> queryPageList(ScydDayReportsVideo scydDayReportsVideo,
								   @RequestParam(name="pageNo", defaultValue="100") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="1000") Integer pageSize,
								   HttpServletRequest req) {
		//todo 直接傳入req.getParameterMap()  肯定出问题。
        Map<String, String[]> parameterMap = new HashMap<>();
//        parameterMap.put("pageNo",new String[]{"1000"});
//		QueryWrapper<ScydDayReportsVideo> queryWrapper = QueryGenerator.initQueryWrapper(scydDayReportsVideo,parameterMap);
		QueryWrapper<ScydDayReportsVideo> queryWrapper = QueryGenerator.initQueryWrapper(scydDayReportsVideo, req.getParameterMap());
		Page<ScydDayReportsVideo> page = new Page<ScydDayReportsVideo>(pageNo, pageSize);
//        Map<String, Object> pageList = scydDayReportsVideoService.getMap(queryWrapper);
        System.out.println("pageList_____________");
//        pageList.entrySet().forEach(System.out::println);
		IPage<ScydDayReportsVideo> pageList = scydDayReportsVideoService.page(page, queryWrapper);
		return Result.ok(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param scydDayReportsVideo
	 * @return
	 */
	@PostMapping(value = "/add")
	public Result<?> add(@RequestBody ScydDayReportsVideo scydDayReportsVideo) {
		scydDayReportsVideoService.save(scydDayReportsVideo);
		return Result.ok("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param scydDayReportsVideo
	 * @return
	 */
	@PutMapping(value = "/edit")
	public Result<?> edit(@RequestBody ScydDayReportsVideo scydDayReportsVideo) {
		scydDayReportsVideoService.updateById(scydDayReportsVideo);
		return Result.ok("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@DeleteMapping(value = "/delete")
	public Result<?> delete(@RequestParam(name="id",required=true) String id) {
		scydDayReportsVideoService.removeById(id);
		return Result.ok("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@DeleteMapping(value = "/deleteBatch")
	public Result<?> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.scydDayReportsVideoService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.ok("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/queryById")
	public Result<?> queryById(@RequestParam(name="id",required=true) String id) {
		ScydDayReportsVideo scydDayReportsVideo = scydDayReportsVideoService.getById(id);
		if(scydDayReportsVideo==null) {
			return Result.error("未找到对应数据");
		}
		return Result.ok(scydDayReportsVideo);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param scydDayReportsVideo
    */
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, ScydDayReportsVideo scydDayReportsVideo) {
        return super.exportXls(request, scydDayReportsVideo, ScydDayReportsVideo.class, "scyd_day_reports_video");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, ScydDayReportsVideo.class);
    }

}
