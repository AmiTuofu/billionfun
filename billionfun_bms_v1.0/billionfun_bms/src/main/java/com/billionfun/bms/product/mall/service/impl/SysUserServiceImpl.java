package com.billionfun.bms.product.mall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.billionfun.bms.product.mall.dao.SysUserDao;
import com.billionfun.bms.product.mall.model.SysUser;
import com.billionfun.bms.product.mall.service.SysUserService;

@Service("userService")
public class SysUserServiceImpl extends BaseServiceImpl<SysUser, Long> implements SysUserService {
	
	@Autowired
	private SysUserDao userDao;

	
	public void save(SysUser user) {
		// TODO Auto-generated method stub
		userDao.save(user);
	}


	public List findAll() {
		return userDao.findAll("from SysUser");
		
	}
	
	
	public boolean isExsit(String username,String email,String mobile) {
		boolean sign = false;
		SysUser user = userDao.loadUser(username, email, mobile);
		if(user!=null){
			sign = true;
		}
		return sign;
	}

	public SysUser loadUser(String username) {
		return userDao.loadUserByUsername(username);
	}
	
}
