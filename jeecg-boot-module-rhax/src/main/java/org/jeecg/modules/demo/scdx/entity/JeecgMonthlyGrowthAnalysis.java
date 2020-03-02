package org.jeecg.modules.demo.scdx.entity;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecg.common.aspect.annotation.Dict;

/**
 * @Description: jeecg_monthly_growth_analysis
 * @Author: jeecg-boot
 * @Date:   2020-03-02
 * @Version: V1.0
 */
@Data
@TableName("jeecg_monthly_growth_analysis")
public class JeecgMonthlyGrowthAnalysis implements Serializable {
    private static final long serialVersionUID = 1L;
    
	/**id*/
	@TableId(type = IdType.ID_WORKER_STR)
    private Integer id;
	/**year*/
	@Excel(name = "year", width = 15)
    private String year;
	/**月份*/
	@Excel(name = "月份", width = 15)
    private String month;
	/**佣金/主营收入*/
	@Excel(name = "佣金/主营收入", width = 15)
    private BigDecimal mainIncome;
	/**其他收入*/
	@Excel(name = "其他收入", width = 15)
    private BigDecimal otherIncome;
}
