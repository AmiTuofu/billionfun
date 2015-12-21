package com.billionfun.bms.product.mall.dao;

import com.billionfun.bms.product.mall.model.SysUser;

public interface SysUserDao extends BaseDao<SysUser,Long> {
	public SysUser loadUserByUsername(String username);
}
