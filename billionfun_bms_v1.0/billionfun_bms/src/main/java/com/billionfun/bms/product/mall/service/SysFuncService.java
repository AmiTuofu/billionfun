package com.billionfun.bms.product.mall.service;

import java.util.List;

import com.billionfun.bms.product.mall.common.utils.PageUtil;
import com.billionfun.bms.product.mall.model.SysFunc;
import com.billionfun.bms.product.mall.vo.SysFuncVO;

public interface SysFuncService {
	public List<SysFuncVO> query(SysFuncVO funcVo,PageUtil pl);
}
