package com.billionfun.bms.product.mall.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.billionfun.bms.product.mall.service.SysUserService;

@Controller
@RequestMapping("/")
public class DefaultController extends BaseController{
	private static final Logger logger = LoggerFactory
			.getLogger(DefaultController.class);
	
	@Autowired
	private SysUserService userService;

	@RequestMapping("/login")
	public String login(ModelMap modelMap){
		logger.info("-----------info-------------");
		logger.error("-----------error-------------");
		return "index";
	}
	
	@RequestMapping("/logout")
	public String logout(ModelMap modelMap){
		System.out.println("logout");
		return "login";
	}
}
