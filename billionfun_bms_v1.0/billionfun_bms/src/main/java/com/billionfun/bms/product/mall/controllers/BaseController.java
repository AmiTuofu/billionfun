package com.billionfun.bms.product.mall.controllers;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * 
 * @ClassName: BaseController 
 * @Description: TODO
 * @author  AmiTuofu
 * @date  2015年12月21日 上午12:03:37 
 *
 */
@Controller
public class BaseController {
	
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected HttpSession session;
	protected RedirectAttributes rAttr;
	
	/**
	 * 
	 * @Title: setReqAndRes 
	 * @Description: TODO
	 * @param @param request
	 * @param @param response
	 * @param @param rAttr 
	 * @return void
	 * @throws
	 */
	@ModelAttribute
	public void setReqAndRes(HttpServletRequest request, HttpServletResponse response,
			RedirectAttributes rAttr) {
		this.request = request;
		this.response = response;
		this.session = request.getSession();
		this.rAttr = rAttr;
				
				
		String remoteIp = getIpAddr(request);
		MDC.put("remoteIp", remoteIp);
	}
	
	/**
	 * 
	 * @Title: init 
	 * @Description: TODO
	 * @param  
	 * @return void
	 * @throws
	 */
	@PostConstruct
	public void init() {

	}
	
	/**
	 * 
	 * @Title: destroy 
	 * @Description: TODO
	 * @param  
	 * @return void
	 * @throws
	 */
	@PreDestroy
	public void destroy() {

	}
	
	/**
	 * 
	 * @Title: getIpAddr 
	 * @Description: TODO
	 * @param @param request
	 * @param @return 
	 * @return String
	 * @throws
	 */
	public String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
}
