package com.billionfun.bms.product.mall.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.billionfun.bms.product.mall.service.SysUserService;

/**
 * 
 * @ClassName: DefaultController 
 * @Description: TODO
 * @author  AmiTuofu
 * @date  2015年12月21日 上午12:04:50 
 *
 */
@Controller
@RequestMapping("/")
public class LoginController extends BaseController{
	private static final Logger logger = LoggerFactory
			.getLogger(LoginController.class);
	
	@Autowired
	private SysUserService userService;
	
	/**
	 * 
	 * @Title: login 
	 * @Description: TODO
	 * @param @param modelMap
	 * @param @return 
	 * @return String
	 * @throws
	 */
	@RequestMapping({"/login"})
	public Object login(){
		
		return "login";
	}
	
	/**
	 * 
	 * @Title: index 
	 * @Description: TODO
	 * @param @param modelMap
	 * @param @return 
	 * @return String
	 * @throws
	 */
	@RequestMapping("/index")
	public String index(ModelMap modelMap){
		return "index";
	}
	
	/**
	 * 
	 * @Title: logout 
	 * @Description: TODO
	 * @param @param modelMap
	 * @param @return 
	 * @return String
	 * @throws
	 */
	@RequestMapping("/logout")
	public String logout(ModelMap modelMap){
		return "index";
	}
}
