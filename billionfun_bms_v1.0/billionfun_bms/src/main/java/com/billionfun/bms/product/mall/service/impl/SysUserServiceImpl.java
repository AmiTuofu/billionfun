package com.billionfun.bms.product.mall.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.billionfun.bms.product.mall.dao.SysUserDao;
import com.billionfun.bms.product.mall.model.SysRole;
import com.billionfun.bms.product.mall.model.SysUser;
import com.billionfun.bms.product.mall.service.SysUserService;

@Service("userService")
public class SysUserServiceImpl extends BaseServiceImpl<SysUser, Long> implements SysUserService,UserDetailsService {
	
	@Autowired
	private SysUserDao userDao;

	
	public void save(SysUser user) {
		// TODO Auto-generated method stub
		userDao.save(user);
	}

	/**
	 * 
	 * <p>Title: loadUserByUsername</p> 
	 * <p>Description: </p> 
	 * @param arg0
	 * @return
	 * @throws UsernameNotFoundException
	 * @throws DataAccessException 
	 * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
	 */
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
		//		SysUserDao sysUserDao = (SysUserDao)SpringBeanFactory.getSpringBean("sysUserDao");
		SysUser user = userDao.loadUserByUsername(username);
		
//		List<SysUser> users = getHibernateTemplate().find("from SysUser u where u.username = '"+username+"' and u.status = 1");  
//		if(users.isEmpty()) {  
//			throw   new  UsernameNotFoundException(username  +   "  ������ " );
//		} 
		List < GrantedAuthority >  authsList  =   new  ArrayList < GrantedAuthority > ();
//		SysUser user = (SysUser)users.get(0);
		for (SysRole role : user.getListRoles()) {
			authsList.add(new GrantedAuthorityImpl(role.getCode()));
		}
		
		
		org.springframework.security.core.userdetails.User userDetails  =   new  org.springframework.security.core.userdetails.User(
		        user.getUsername(), user.getPassword(),  true ,  true ,  true ,  true , authsList
		                .toArray( new  GrantedAuthority[authsList.size()]));
		//System.out.println(userDetails);
		return userDetails;
	}
}
