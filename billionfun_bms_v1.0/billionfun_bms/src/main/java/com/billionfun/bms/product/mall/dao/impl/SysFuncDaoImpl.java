package com.billionfun.bms.product.mall.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.billionfun.bms.product.mall.common.utils.StringUtil;
import com.billionfun.bms.product.mall.dao.SysFuncDao;
import com.billionfun.bms.product.mall.model.SysFunc;

@Repository
public class SysFuncDaoImpl extends BaseDaoImpl<SysFunc,Long> implements SysFuncDao{

	
	public List<SysFunc> loadFunc(String parentId) {
		StringBuilder hql = new StringBuilder();
		hql.append(" from SysFunc ");
		hql.append(" where parentId = :parentId");
		Map proMap = new HashMap();
		proMap.put("parentId", parentId);
		
		List<SysFunc> list = super.findAll(hql.toString(), proMap);
		return list;
	}

	public List<SysFunc> list(SysFunc func) {
		StringBuilder hql = new StringBuilder();
		Map proMap = new HashMap();
		hql.append(" from SysFunc f");
		hql.append(" where 1=1");
		if(!StringUtil.empty(func.getName())){
			hql.append(" and f.name like :funcName");
			proMap.put("funcName", "%"+func.getName()+"%");
		}
		
		
		
		List<SysFunc> list = super.findAll(hql.toString(),proMap);
		return list;
	}

}
