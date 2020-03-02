package org.jeecg.modules.demo.scdx.service.impl;

import org.jeecg.modules.demo.scdx.entity.TestOrderMain;
import org.jeecg.modules.demo.scdx.entity.TestOrderProduct;
import org.jeecg.modules.demo.scdx.mapper.TestOrderProductMapper;
import org.jeecg.modules.demo.scdx.mapper.TestOrderMainMapper;
import org.jeecg.modules.demo.scdx.service.ITestOrderMainService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.io.Serializable;
import java.util.List;
import java.util.Collection;

/**
 * @Description: 测试订单主表
 * @Author: jeecg-boot
 * @Date:   2020-03-02
 * @Version: V1.0
 */
@Service
public class TestOrderMainServiceImpl extends ServiceImpl<TestOrderMainMapper, TestOrderMain> implements ITestOrderMainService {

	@Autowired
	private TestOrderMainMapper testOrderMainMapper;
	@Autowired
	private TestOrderProductMapper testOrderProductMapper;
	
	@Override
	@Transactional
	public void saveMain(TestOrderMain testOrderMain, List<TestOrderProduct> testOrderProductList) {
		testOrderMainMapper.insert(testOrderMain);
		if(testOrderProductList!=null && testOrderProductList.size()>0) {
			for(TestOrderProduct entity:testOrderProductList) {
				//外键设置
				entity.setOrderFkId(testOrderMain.getId());
				testOrderProductMapper.insert(entity);
			}
		}
	}

	@Override
	@Transactional
	public void updateMain(TestOrderMain testOrderMain,List<TestOrderProduct> testOrderProductList) {
		testOrderMainMapper.updateById(testOrderMain);
		
		//1.先删除子表数据
		testOrderProductMapper.deleteByMainId(testOrderMain.getId());
		
		//2.子表数据重新插入
		if(testOrderProductList!=null && testOrderProductList.size()>0) {
			for(TestOrderProduct entity:testOrderProductList) {
				//外键设置
				entity.setOrderFkId(testOrderMain.getId());
				testOrderProductMapper.insert(entity);
			}
		}
	}

	@Override
	@Transactional
	public void delMain(String id) {
		testOrderProductMapper.deleteByMainId(id);
		testOrderMainMapper.deleteById(id);
	}

	@Override
	@Transactional
	public void delBatchMain(Collection<? extends Serializable> idList) {
		for(Serializable id:idList) {
			testOrderProductMapper.deleteByMainId(id.toString());
			testOrderMainMapper.deleteById(id);
		}
	}
	
}
