package com.billionfun.bms.product.mall.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.billionfun.bms.product.mall.common.Contants;
import com.billionfun.bms.product.mall.common.utils.StringUtil;
import com.billionfun.bms.product.mall.dao.SysEventDao;
import com.billionfun.bms.product.mall.model.SysEvent;
import com.billionfun.bms.product.mall.vo.SysEventVO;

@Repository
public class SysEventDaoImpl extends BaseDaoImpl<SysEvent, String> implements
		SysEventDao {

	public List<SysEvent> getListByPage(SysEventVO vo) {
		StringBuilder hql = new StringBuilder();
		List<String> paramList = new ArrayList<String>();
		hql.append(" from SysEvent e");
		hql.append(" where 1=1");
		if (vo.getSearch()) {
			vo.getSearchHql(hql, vo.getFilters(), paramList);
		}
		if (!StringUtil.empty(vo.getSort()) && !StringUtil.empty(vo.getOrder())) {
			hql.append(" order by e.").append(vo.getSort()).append(" ")
					.append(vo.getOrder());
		}

		List<SysEvent> list = super
				.getListByPage(vo, hql.toString(), paramList);
		return list;
	}

	public List<SysEvent> getList(SysEventVO vo) {
		StringBuilder hql = new StringBuilder();
		List paramList = new ArrayList();
		hql.append(" from SysEvent e");
		hql.append(" where 1=1");

		if (vo.getStartDate() != null && vo.getEndDate() != null) {
			hql.append(" and e.startDate >= ? and e.endDate<= ?");
			paramList.add(vo.getStartDate());
			paramList.add(vo.getEndDate());
		}
		if (!StringUtil.empty(vo.getUserId())) {
			hql.append(" and e.userId = ?");
			paramList.add(vo.getUserId());
		}
		if (vo.getSearch()) {
			vo.getSearchHql(hql, vo.getFilters(), paramList);
		}
		if (!StringUtil.empty(vo.getSort()) && !StringUtil.empty(vo.getOrder())) {
			hql.append(" order by e.").append(vo.getSort()).append(" ")
					.append(vo.getOrder());
		}

		List<SysEvent> list = super.getList(hql.toString(), paramList);
		return list;
	}
	
	public boolean delete(String repeatsId,Date startDate){
		boolean sign = false;
		StringBuilder hql = new StringBuilder();
		List paramList = new ArrayList();
		hql.append(" delete from SysEvent e where e.repeatsId = ? and e.startDate >= ?");
		paramList.add(repeatsId);
		paramList.add(startDate);
		super.exec(hql.toString(), paramList);
		sign = true;
		return sign;
	}
	
	public List<SysEvent> getRemindList(){
		StringBuilder sql = new StringBuilder();
		sql.append(Contants.REMIND_LIST_SQL);
		List list = super.getListBySql(sql.toString());	
		List<SysEvent> listRef = new ArrayList<SysEvent>();
		for (int i = 0; i < list.size(); i++) {
			Object[] objs = (Object[])list.get(i);
			SysEvent event = new SysEvent();
			event.setName(objs[0].toString());
			event.setDescription(objs[1]==null?null:objs[1].toString());
			event.setStartDate((Date)objs[2]);
			event.setEndDate((Date)objs[3]);
			event.setRemind(objs[4].toString());
			event.setRemindWay(objs[5]==null?null:objs[5].toString());
			event.setPlace(objs[6]==null?null:objs[6].toString());
			event.setStatus((Integer)objs[7]);
			event.setUserId(objs[8].toString());
			event.setId(objs[9].toString());
			listRef.add(event);
		}
		return listRef;
	}
	
	public void updateNoticeCount(String id){
		super.exec("update SysEvent set noticeCount = noticeCount+1 where id = '"+id+"'");
	}
}
