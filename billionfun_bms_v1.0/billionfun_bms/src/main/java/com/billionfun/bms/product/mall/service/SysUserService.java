package com.billionfun.bms.product.mall.service;

import java.util.List;

import com.billionfun.bms.product.mall.model.SysUser;

public interface SysUserService {

	
	public void save(SysUser user);
	
	public List findAll();
}
