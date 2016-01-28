package com.billionfun.bms.product.mall.service;

import java.util.List;

import com.billionfun.bms.product.mall.model.SysUser;
import com.billionfun.bms.product.mall.vo.SysUserVO;

public interface SysUserService extends BaseService<SysUser,SysUserVO,String>{

	
	public SysUser loadUser(String username);
	
	public boolean isExsit(String username,String email,String mobile);
	
	public List findAll();
}
