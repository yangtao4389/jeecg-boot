package org.jeecg.modules.demo.scdx.service;

import org.jeecg.modules.demo.scdx.entity.TestOrderProduct;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

/**
 * @Description: 订单产品明细
 * @Author: jeecg-boot
 * @Date:   2020-03-02
 * @Version: V1.0
 */
public interface ITestOrderProductService extends IService<TestOrderProduct> {

	public List<TestOrderProduct> selectByMainId(String mainId);
}
