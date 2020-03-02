package org.jeecg.modules.demo.scdx.controller;

import java.util.Arrays;
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
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.aspect.annotation.AutoLog;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.common.util.oConvertUtils;
import org.jeecg.modules.demo.scdx.entity.JeecgMonthlyGrowthAnalysis;
import org.jeecg.modules.demo.scdx.service.IJeecgMonthlyGrowthAnalysisService;

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
 * @Description: jeecg_monthly_growth_analysis
 * @Author: jeecg-boot
 * @Date:   2020-03-02
 * @Version: V1.0
 */

@RestController
@RequestMapping("/scdx/jeecgMonthlyGrowthAnalysis")
@Slf4j
@Api(tags = "四川电信")
public class JeecgMonthlyGrowthAnalysisController extends JeecgController<JeecgMonthlyGrowthAnalysis, IJeecgMonthlyGrowthAnalysisService> {
	@Autowired
	private IJeecgMonthlyGrowthAnalysisService jeecgMonthlyGrowthAnalysisService;
	
	/**
	 * 分页列表查询
	 *
	 * @param jeecgMonthlyGrowthAnalysis
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	@AutoLog(value = "四川电信-列表")
	@ApiOperation(value = "四川电信-分页列表查询", notes = "四川电信-分页列表查询")
	@GetMapping(value = "/list")
	public Result<?> queryPageList(JeecgMonthlyGrowthAnalysis jeecgMonthlyGrowthAnalysis,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<JeecgMonthlyGrowthAnalysis> queryWrapper = QueryGenerator.initQueryWrapper(jeecgMonthlyGrowthAnalysis, req.getParameterMap());
		Page<JeecgMonthlyGrowthAnalysis> page = new Page<JeecgMonthlyGrowthAnalysis>(pageNo, pageSize);
		IPage<JeecgMonthlyGrowthAnalysis> pageList = jeecgMonthlyGrowthAnalysisService.page(page, queryWrapper);
		return Result.ok(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param jeecgMonthlyGrowthAnalysis
	 * @return
	 */
	@PostMapping(value = "/add")
	public Result<?> add(@RequestBody JeecgMonthlyGrowthAnalysis jeecgMonthlyGrowthAnalysis) {
		jeecgMonthlyGrowthAnalysisService.save(jeecgMonthlyGrowthAnalysis);
		return Result.ok("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param jeecgMonthlyGrowthAnalysis
	 * @return
	 */
	@PutMapping(value = "/edit")
	public Result<?> edit(@RequestBody JeecgMonthlyGrowthAnalysis jeecgMonthlyGrowthAnalysis) {
		jeecgMonthlyGrowthAnalysisService.updateById(jeecgMonthlyGrowthAnalysis);
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
		jeecgMonthlyGrowthAnalysisService.removeById(id);
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
		this.jeecgMonthlyGrowthAnalysisService.removeByIds(Arrays.asList(ids.split(",")));
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
		JeecgMonthlyGrowthAnalysis jeecgMonthlyGrowthAnalysis = jeecgMonthlyGrowthAnalysisService.getById(id);
		if(jeecgMonthlyGrowthAnalysis==null) {
			return Result.error("未找到对应数据");
		}
		return Result.ok(jeecgMonthlyGrowthAnalysis);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param jeecgMonthlyGrowthAnalysis
    */
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, JeecgMonthlyGrowthAnalysis jeecgMonthlyGrowthAnalysis) {
        return super.exportXls(request, jeecgMonthlyGrowthAnalysis, JeecgMonthlyGrowthAnalysis.class, "jeecg_monthly_growth_analysis");
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
        return super.importExcel(request, response, JeecgMonthlyGrowthAnalysis.class);
    }

}
