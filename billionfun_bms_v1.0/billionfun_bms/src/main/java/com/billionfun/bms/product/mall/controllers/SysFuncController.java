package com.billionfun.bms.product.mall.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.billionfun.bms.product.mall.model.SysFunc;
import com.billionfun.bms.product.mall.service.SysFuncService;

@RequestMapping("/system/func")
@Controller
public class SysFuncController {
	
	@Autowired
	private SysFuncService funcService;
	
	@RequestMapping("/query")
	public String query(ModelMap modelMap){
		
		SysFunc func = new SysFunc();
		
		List<SysFunc> funcList = funcService.query(func);
		modelMap.put("funcList", funcList);
		return "system/func/query";
	}
}
