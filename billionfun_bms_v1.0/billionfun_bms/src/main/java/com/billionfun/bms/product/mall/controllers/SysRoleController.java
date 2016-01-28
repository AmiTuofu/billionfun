package com.billionfun.bms.product.mall.controllers;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.billionfun.bms.product.mall.model.SysRole;
import com.billionfun.bms.product.mall.service.SysRoleService;
import com.billionfun.bms.product.mall.vo.SysRoleVO;
@RequestMapping("/system/role")
@Controller
public class SysRoleController extends BaseController{
	@Autowired
	private SysRoleService roleService;
	
	@RequestMapping("/query")
	public String query(ModelMap modelMap,SysRoleVO vo){
		List<SysRoleVO> roleVOs = roleService.query(vo);
		modelMap.put("list", roleVOs);
		modelMap.put("page", vo.getPage());
		modelMap.put("total", vo.getTotal());
		modelMap.put("records", vo.getRecords());
		return "system/role/query";
	}
	
	@RequestMapping("/modify")
	public String modify(ModelMap modelMap,SysRoleVO vo){
		SysRole role = new SysRole();
		BeanUtils.copyProperties(vo, role);
		roleService.update(role);
		return "system/role/modify";
	}
	
	@RequestMapping("/add")
	public String add(ModelMap modelMap,SysRoleVO vo){
		SysRole role = new SysRole();
		BeanUtils.copyProperties(vo, role);
		roleService.save(role);
		return "system/role/add";
	}
	
	@RequestMapping("/delete")
	public String delete(ModelMap modelMap,SysRoleVO vo){
		roleService.delete(vo.getId(),SysRole.class);
		return "system/role/delete";
	}
}
