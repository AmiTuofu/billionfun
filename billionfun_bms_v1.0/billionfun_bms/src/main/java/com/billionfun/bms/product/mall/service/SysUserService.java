package com.billionfun.bms.product.mall.service;

import java.util.List;

import com.billionfun.bms.product.mall.model.SysUser;

public interface SysUserService {

	
	public void save(SysUser user);
	
	public boolean isExsit(String username,String email,String mobile);
	
	public List findAll();
}
