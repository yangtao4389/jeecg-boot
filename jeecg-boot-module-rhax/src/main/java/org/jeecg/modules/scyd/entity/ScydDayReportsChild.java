package org.jeecg.modules.scyd.entity;

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
 * @Description: scyd_day_reports_child
 * @Author: jeecg-boot
 * @Date:   2020-03-04
 * @Version: V1.0
 */
@Data
@TableName("scyd_day_reports_child")
public class ScydDayReportsChild implements Serializable {
    private static final long serialVersionUID = 1L;
    
	/**id*/
	@TableId(type = IdType.ID_WORKER_STR)
    private java.lang.Integer id;
	/**date*/
	@Excel(name = "date", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private java.util.Date date;
	/**uv*/
	@Excel(name = "uv", width = 15)
    private java.lang.Integer uv;
	/**pv*/
	@Excel(name = "pv", width = 15)
    private java.lang.Integer pv;
	/**orderNum*/
	@Excel(name = "orderNum", width = 15)
    private java.lang.Integer orderNum;
	/**fakeOrderNum*/
	@Excel(name = "fakeOrderNum", width = 15)
    private java.lang.Integer fakeOrderNum;
	/**percent*/
	@Excel(name = "percent", width = 15)
    private java.math.BigDecimal percent;
	/**carrierId*/
	@Excel(name = "carrierId", width = 15)
    private java.lang.String carrierId;
	/**carrierName*/
	@Excel(name = "carrierName", width = 15)
    private java.lang.String carrierName;
}
