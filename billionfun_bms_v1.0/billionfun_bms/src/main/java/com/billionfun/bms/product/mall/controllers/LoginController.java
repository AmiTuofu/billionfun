package com.billionfun.bms.product.mall.controllers;

import java.util.Date;

import org.hibernate.service.spi.Startable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.billionfun.bms.product.mall.common.utils.DateUtil;
import com.billionfun.bms.product.mall.common.utils.StringUtil;
import com.billionfun.bms.product.mall.service.SysUserService;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;

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
	public String login(@RequestParam(value="username",required=false)String username,
			@RequestParam(value="password",required=false)String password,ModelMap modelMap){
		
		if(StringUtil.empty(username)&&StringUtil.empty(password)){
			modelMap.addAttribute("msg", "login");
			return "login";
		}else{
			long begin = System.currentTimeMillis();
			logger.info("---------------- user login start---------------------" +DateUtil.formatYYMMDDHHmmss(new Date()));
			rAttr.addAttribute("info","info");
			rAttr.addFlashAttribute("error", "error");
			
			logger.info("---------------- user login end---------------------" +DateUtil.formatYYMMDDHHmmss(new Date()));
			long end = System.currentTimeMillis();
			logger.info("user login used : " + (end-begin));
			
			return "redirect:/index.html";
		}
		
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
