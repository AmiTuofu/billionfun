package com.billionfun.bms.product.mall.service.impl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.billionfun.bms.product.mall.common.utils.DateUtil;
import com.billionfun.bms.product.mall.common.utils.StringUtil;
import com.billionfun.bms.product.mall.dao.SysEventDao;
import com.billionfun.bms.product.mall.model.SysEvent;
import com.billionfun.bms.product.mall.service.SysEventService;
import com.billionfun.bms.product.mall.vo.SysEventVO;

@Service("eventService")
public class SysEventServiceImpl extends
		BaseServiceImpl<SysEvent, SysEventVO, String> implements
		SysEventService {
	@Autowired
	private SysEventDao eventDao;

	public List<SysEventVO> search(SysEventVO vo) {
		List<SysEvent> list = eventDao.getList(vo);
		List<SysEventVO> listVo = new ArrayList<SysEventVO>();
		if (!StringUtil.empty(list)) {
			for (SysEvent ref : list) {
				SysEventVO voRef = new SysEventVO();
				BeanUtils.copyProperties(ref, voRef);
				listVo.add(voRef);
			}
		}
		return listVo;
	}

	public boolean save(SysEventVO vo) throws ParseException {
		if (!StringUtil.empty(vo.getRepeats()) && !vo.getRepeats().equals("0")
				&& vo.getRepeatsEndDate() != null) {
			int dateCount = DateUtil.getDateSpace(vo.getStartDate(),
					vo.getEndDate());
			List<Date> listStartDate = DateUtil.getDates(vo.getStartDate(),
					vo.getRepeatsEndDate(), vo.getRepeats(), 1);
			String repeatsId = vo.getUserId()+"-"+(int)(Math.random()*100000000);
			for (int i = 0; i < listStartDate.size(); i++) {
				Date startDate = listStartDate.get(i);
				Date endDate = DateUtil.addDate(startDate,
						dateCount * 1000 * 3600 * 24);
				SysEvent event = new SysEvent();
				BeanUtils.copyProperties(vo, event);
				event.setStartDate(startDate);
				event.setEndDate(endDate);
				event.setRepeatsId(repeatsId);
				super.save(event);
			}
		} else {
			SysEvent event = new SysEvent();
			BeanUtils.copyProperties(vo, event);
			super.save(event);
		}
		return true;
	}
	
	public boolean update(SysEventVO vo) throws ParseException{
		if(!StringUtil.empty(vo.getRepeatsId())){
			SysEvent event = eventDao.get(vo.getId());
			eventDao.delete(vo.getRepeatsId(),event.getStartDate());
			vo.setId(null);
			save(vo);
		}else{
			SysEvent event = new SysEvent();
			BeanUtils.copyProperties(vo, event);
			super.update(event);
		}
		return true;
	}

	public boolean delete(SysEventVO vo) {
		if(!StringUtil.empty(vo.getRepeatsId())){
			eventDao.delete(vo.getRepeatsId(),vo.getStartDate());
		}else{
			super.delete(vo.getId());
		}
		return true;
	}
}
