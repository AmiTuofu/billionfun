package com.billionfun.bms.product.mall.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.billionfun.bms.product.mall.common.utils.PageUtil;
import com.billionfun.bms.product.mall.common.utils.StringUtil;
import com.billionfun.bms.product.mall.dao.SysFuncDao;
import com.billionfun.bms.product.mall.model.SysFunc;

@Repository
public class SysFuncDaoImpl extends BaseDaoImpl<SysFunc,Long> implements SysFuncDao{

	
	public List<SysFunc> loadFunc(String parentId) {
		StringBuilder hql = new StringBuilder();
		hql.append(" from SysFunc ");
		hql.append(" where parentId = :parentId");
		Map<String, String> proMap = new HashMap<String, String>();
		proMap.put("parentId", parentId);
		
		List<SysFunc> list = super.findAll(hql.toString(), proMap);
		return list;
	}

	public List<SysFunc> getListByPage(SysFunc func,PageUtil pl) {
		StringBuilder hql = new StringBuilder();
		List<String> paramList = new ArrayList<String>();
		hql.append(" from SysFunc f");
		hql.append(" where 1=1");
		if(!StringUtil.empty(func.getName())){
			hql.append(" and f.name like '%'||?||'%'");
			paramList.add(func.getName());
		}
		
		if(!StringUtil.empty(pl.getSort())&&!StringUtil.empty(pl.getOrder())){
			hql.append(" order by f.").append(pl.getSort()).append(" ").append(pl.getOrder());
		}
		
		List<SysFunc> list = super.getListByPage(pl, hql.toString(), paramList);
		return list;
	}

}
