package com.billionfun.bms.product.mall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.billionfun.bms.product.mall.dao.SysFuncDao;
import com.billionfun.bms.product.mall.model.SysFunc;
import com.billionfun.bms.product.mall.service.SysFuncService;

@Service("funcService")
public class SysFuncServiceImpl extends BaseServiceImpl<SysFunc, Long> implements SysFuncService{
	@Autowired
	private SysFuncDao funcDao;
	
	
	public List<SysFunc> query(SysFunc func){
		
		return funcDao.list(func);
	}
}
