package org.jeecg.modules.scyd.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.common.util.oConvertUtils;
import org.jeecg.modules.scyd.entity.ScydDayReportsChild;
import org.jeecg.modules.scyd.service.IScydDayReportsChildService;

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
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import com.alibaba.fastjson.JSON;

 /**
 * @Description: scyd_day_reports_child
 * @Author: jeecg-boot
 * @Date:   2020-03-04
 * @Version: V1.0
 */

@RestController
@Api(tags = "四川移动日常报表")
@RequestMapping("/scyd/scydDayReportsChild")
@Slf4j
public class ScydDayReportsChildController extends JeecgController<ScydDayReportsChild, IScydDayReportsChildService> {
	@Autowired
	private IScydDayReportsChildService scydDayReportsChildService;
	
	/**
	 * 分页列表查询
	 *
	 * @param scydDayReportsChild
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	@ApiOperation(value = "列表", notes = "获取数据列表")
	@GetMapping(value = "/list")
	public Result<?> queryPageList(ScydDayReportsChild scydDayReportsChild,
//								   @RequestParam(name="date")  java.util.Date date,
								   @DateTimeFormat(pattern = "yyyy-MM-dd")Date date,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {


//		QueryWrapper<ScydDayReportsChild> queryWrapper = new QueryWrapper<ScydDayReportsChild>();
//		queryWrapper.eq("role_id", sysRoleId).eq("user_id",sysUserId);



		QueryWrapper<ScydDayReportsChild> queryWrapper = QueryGenerator.initQueryWrapper(scydDayReportsChild, req.getParameterMap());

		log.info(req.getParameterMap().toString());
		log.info(queryWrapper.toString());
		Page<ScydDayReportsChild> page = new Page<ScydDayReportsChild>(pageNo, pageSize);
		IPage<ScydDayReportsChild> pageList = scydDayReportsChildService.page(page, queryWrapper);
		return Result.ok(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param scydDayReportsChild
	 * @return
	 */
	@ApiOperation(value = "新增", notes = "新增数据")
	@PostMapping(value = "/add")
	public Result<?> add(@RequestBody ScydDayReportsChild scydDayReportsChild) {
		scydDayReportsChildService.save(scydDayReportsChild);
		return Result.ok("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param scydDayReportsChild
	 * @return
	 */
	@ApiOperation(value = "编辑", notes = "编辑数据")
	@PutMapping(value = "/edit")
	public Result<?> edit(@RequestBody ScydDayReportsChild scydDayReportsChild) {
		scydDayReportsChildService.updateById(scydDayReportsChild);
		return Result.ok("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "删除", notes = "删除数据")
	@DeleteMapping(value = "/delete")
	public Result<?> delete(@RequestParam(name="id",required=true) String id) {
		scydDayReportsChildService.removeById(id);
		return Result.ok("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@ApiOperation(value = "批量删除", notes = "批量删除数据")
	@DeleteMapping(value = "/deleteBatch")
	public Result<?> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.scydDayReportsChildService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.ok("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "通过ID查询", notes = "通过ID查询")
	@GetMapping(value = "/queryById")
	public Result<?> queryById(@RequestParam(name="id",required=true) String id) {
		ScydDayReportsChild scydDayReportsChild = scydDayReportsChildService.getById(id);
		if(scydDayReportsChild==null) {
			return Result.error("未找到对应数据");
		}
		return Result.ok(scydDayReportsChild);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param scydDayReportsChild
    */
	@ApiOperation(value = "导出excel", notes = "导出excel")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, ScydDayReportsChild scydDayReportsChild) {
        return super.exportXls(request, scydDayReportsChild, ScydDayReportsChild.class, "scyd_day_reports_child");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
	@ApiOperation(value = "导入excel", notes = "导入excel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, ScydDayReportsChild.class);
    }

}
