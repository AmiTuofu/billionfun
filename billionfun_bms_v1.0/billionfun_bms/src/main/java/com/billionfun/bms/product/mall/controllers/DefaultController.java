package com.billionfun.bms.product.mall.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.billionfun.bms.product.mall.model.SysUser;
import com.billionfun.bms.product.mall.service.SysUserService;

@Controller
@RequestMapping("/")
public class DefaultController {
	@Autowired
	private SysUserService userService;

	@RequestMapping("/login")
	public String login(ModelMap modelMap){
		System.out.println("login");
		SysUser user = new SysUser();
		user.setUsername("admin");
		user.setPassword("password");
		user.setFullName("fullName");
		userService.save(user);
		return "index";
	}
	
	@RequestMapping("/logout")
	public String logout(ModelMap modelMap){
		System.out.println("logout");
		return "login";
	}
}
