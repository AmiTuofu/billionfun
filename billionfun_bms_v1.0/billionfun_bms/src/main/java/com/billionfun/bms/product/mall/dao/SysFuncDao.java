package com.billionfun.bms.product.mall.dao;

import java.util.List;

import com.billionfun.bms.product.mall.common.utils.PageUtil;
import com.billionfun.bms.product.mall.model.SysFunc;

public interface SysFuncDao extends BaseDao<SysFunc,Long> {
	public List<SysFunc> loadFunc(String parentId);
	
	public List<SysFunc> getListByPage(SysFunc func,PageUtil pl);
}
