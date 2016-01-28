package com.billionfun.bms.product.mall.dao;

import com.billionfun.bms.product.mall.model.SysUser;

public interface SysUserDao extends BaseDao<SysUser,String> {
	public SysUser loadUserByUsername(String username);
	
	public SysUser loadUser(String username,String email,String mobile);
}
