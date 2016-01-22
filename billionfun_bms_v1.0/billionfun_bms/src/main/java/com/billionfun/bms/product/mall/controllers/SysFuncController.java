package com.billionfun.bms.product.mall.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PlaceholderConfigurerSupport;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.billionfun.bms.product.mall.common.utils.PageUtil;
import com.billionfun.bms.product.mall.common.utils.StringUtil;
import com.billionfun.bms.product.mall.model.SysFunc;
import com.billionfun.bms.product.mall.service.SysFuncService;
import com.billionfun.bms.product.mall.vo.JqGridQueryBase;
import com.billionfun.bms.product.mall.vo.SysFuncVO;

@RequestMapping("/system/func")
@Controller
public class SysFuncController extends BaseController {
	
	@Autowired
	private SysFuncService funcService;
	
	@RequestMapping("/query")
	public String query(ModelMap modelMap,SysFuncVO vo){
		SysFuncVO funcVo = new SysFuncVO();
		List<SysFuncVO> funcVOs = funcService.query(funcVo,vo);
		modelMap.put("list", funcVOs);
		modelMap.put("page", vo.getPage());
		modelMap.put("total", vo.getTotal());
		modelMap.put("records", vo.getRecords());
		return "system/func/query";
	}
	
}
