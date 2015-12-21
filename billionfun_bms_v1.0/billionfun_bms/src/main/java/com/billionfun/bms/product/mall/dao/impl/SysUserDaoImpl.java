package com.billionfun.bms.product.mall.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.billionfun.bms.product.mall.dao.SysUserDao;
import com.billionfun.bms.product.mall.model.SysUser;


@Repository
public class SysUserDaoImpl extends BaseDaoImpl<SysUser,Long> implements SysUserDao {

	/**
	 * 
	 * <p>Title: loadUserByUsername</p> 
	 * <p>Description: </p> 
	 * @param username
	 * @return 
	 * @see com.billionfun.bms.product.mall.dao.SysUserDao#loadUserByUsername(java.lang.String)
	 */
	public SysUser loadUserByUsername(String username) {
		StringBuilder hql = new StringBuilder();
		hql.append(" from SysUser u where u.username = :username");
		
		Map proMap = new HashMap();
		proMap.put("username", username);
		
		SysUser u = super.find(hql.toString(), proMap);
		return u;
	}
	
	


}
