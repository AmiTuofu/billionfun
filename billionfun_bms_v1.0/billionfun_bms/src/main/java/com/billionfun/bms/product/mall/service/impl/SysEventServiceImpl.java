package com.billionfun.bms.product.mall.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.billionfun.bms.product.mall.common.utils.StringUtil;
import com.billionfun.bms.product.mall.dao.SysEventDao;
import com.billionfun.bms.product.mall.model.SysEvent;
import com.billionfun.bms.product.mall.service.SysEventService;
import com.billionfun.bms.product.mall.vo.SysEventVO;

@Service("eventService")
public class SysEventServiceImpl extends BaseServiceImpl<SysEvent,SysEventVO, String> implements SysEventService{
	@Autowired
	private SysEventDao eventDao;

	public List<SysEventVO> search(SysEventVO vo){
		List<SysEvent> list = eventDao.getListByPage(vo);
		List<SysEventVO> listVo = new ArrayList<SysEventVO>();
		if(!StringUtil.empty(list)){
			for (SysEvent ref : list) {
				SysEventVO voRef = new SysEventVO();
				BeanUtils.copyProperties(ref, voRef);
				listVo.add(voRef);
			}
		}
		return listVo;
	}
	
}
