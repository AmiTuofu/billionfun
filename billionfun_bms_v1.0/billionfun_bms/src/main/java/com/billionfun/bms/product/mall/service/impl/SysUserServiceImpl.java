package com.billionfun.bms.product.mall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.billionfun.bms.product.mall.dao.SysUserDao;
import com.billionfun.bms.product.mall.model.SysUser;
import com.billionfun.bms.product.mall.service.SysUserService;

@Service
public class SysUserServiceImpl extends BaseServiceImpl<SysUser, Long> implements SysUserService {
	
	@Autowired
	private SysUserDao userDao;

	
	public void save(SysUser user) {
		// TODO Auto-generated method stub
		userDao.create(user);
	}
}
