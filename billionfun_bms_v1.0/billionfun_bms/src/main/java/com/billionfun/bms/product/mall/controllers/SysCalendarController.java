package com.billionfun.bms.product.mall.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.billionfun.bms.product.mall.service.SysLogService;
import com.billionfun.bms.product.mall.vo.SysLogVO;

@RequestMapping("/system/calendar")
@Controller
public class SysCalendarController extends BaseController {

	@Autowired
	private SysLogService logService;

	@RequestMapping("/query")
	public String query(ModelMap modelMap, SysLogVO vo) {
		// List<SysLogVO> logVOs = logService.query(vo);
		// modelMap.put("list", logVOs);
		// modelMap.put("page", vo.getPage());
		// modelMap.put("total", vo.getTotal());
		// modelMap.put("records", vo.getRecords());
		return "system/calendar/query";
	}
}
