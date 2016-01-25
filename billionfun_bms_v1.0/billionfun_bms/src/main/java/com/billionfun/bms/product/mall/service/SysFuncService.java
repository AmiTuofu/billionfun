package com.billionfun.bms.product.mall.service;

import java.io.Serializable;
import java.util.List;

import com.billionfun.bms.product.mall.model.SysFunc;
import com.billionfun.bms.product.mall.vo.SysFuncVO;

public interface SysFuncService extends BaseService<SysFunc,String>{
	public List<SysFuncVO> query(SysFuncVO funcVo);
	
}
