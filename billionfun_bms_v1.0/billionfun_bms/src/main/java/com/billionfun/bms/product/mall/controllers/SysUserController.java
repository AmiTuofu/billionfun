package com.billionfun.bms.product.mall.controllers;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.billionfun.bms.product.mall.model.SysUser;
import com.billionfun.bms.product.mall.service.SysUserService;
import com.billionfun.bms.product.mall.vo.SysUserVO;

@RequestMapping("/system/user")
@Controller
public class SysUserController extends BaseController{
	@Autowired
	private SysUserService userService;
	

	@RequestMapping("/query")
	public String query(ModelMap modelMap,SysUserVO vo){
		List<SysUserVO> userVOs = userService.query(vo);
		modelMap.put("list", userVOs);
		modelMap.put("page", vo.getPage());
		modelMap.put("total", vo.getTotal());
		modelMap.put("records", vo.getRecords());
		return "system/user/query";
	}
	
	@RequestMapping("/modify")
	public String modify(ModelMap modelMap,SysUserVO vo){
		SysUser user = new SysUser();
		BeanUtils.copyProperties(vo, user);
		userService.update(user);
		return "system/user/modify";
	}
	
	@RequestMapping("/add")
	public String add(ModelMap modelMap,SysUserVO vo){
		SysUser user = new SysUser();
		BeanUtils.copyProperties(vo, user);
		userService.save(user);
		return "system/user/add";
	}
	
	@RequestMapping("/delete")
	public String delete(ModelMap modelMap,SysUserVO vo){
		userService.delete(vo.getId(),SysUser.class);
		return "system/user/delete";
	}
}
