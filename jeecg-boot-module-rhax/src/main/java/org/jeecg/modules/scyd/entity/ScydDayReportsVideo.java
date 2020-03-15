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
 * @Description: scyd_day_reports_video
 * @Author: jeecg-boot
 * @Date:   2020-03-09
 * @Version: V1.0
 */
@Data
@TableName("scyd_day_reports_video")
public class ScydDayReportsVideo implements Serializable {
    private static final long serialVersionUID = 1L;
    
	/**id*/
	@TableId(type = IdType.ID_WORKER_STR)
    private Integer id;
	/**日期*/
	@Excel(name = "日期", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date date;
	/**uv*/
	@Excel(name = "uv", width = 15)
    private Integer uv;
	/**pv*/
	@Excel(name = "pv", width = 15)
    private Integer pv;
	/**订购量*/
	@Excel(name = "订购量", width = 15)
    private Integer orderNum;
	/**转化率*/
	@Excel(name = "转化率", width = 15)
    private BigDecimal percent;
	/**地区ID*/
//	@Excel(name = "地区ID", width = 15)
//    private String carrierid;
//	/**地区名*/
//	@Excel(name = "地区名", width = 15)
//    private String carriername;
	/**自订购数据*/
	@Excel(name = "自订购数据", width = 15)
    private Integer fakeOrderNum;
}
