package com.billionfun.bms.product.mall.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.billionfun.bms.product.mall.dao.SysUserDao;
import com.billionfun.bms.product.mall.model.SysRole;
import com.billionfun.bms.product.mall.model.SysUser;

/*@Service("securityService")*/
public class SecurityServiceImpl implements UserDetailsService{
	
	@Autowired
	private SysUserDao userDao;
	
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

	@Transactional
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		SysUser user = userDao.loadUserByUsername(arg0);
		
		if(user==null){
			throw new UsernameNotFoundException("username not found");
		} 
		List < GrantedAuthority >  authsList  =   new ArrayList<GrantedAuthority>();
		for (SysRole role : user.getListRoles()) {
			authsList.add(new SimpleGrantedAuthority(role.getCode()));
		}
		UserDetails userDetails = new User(user.getUsername(), user.getPassword(), true, true, true, true, authsList);
		
		return userDetails;
	}

	
}
