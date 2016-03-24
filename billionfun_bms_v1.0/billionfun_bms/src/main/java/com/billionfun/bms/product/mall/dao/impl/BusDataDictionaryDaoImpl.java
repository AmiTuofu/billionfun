package com.billionfun.bms.product.mall.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.billionfun.bms.product.mall.common.utils.StringUtil;
import com.billionfun.bms.product.mall.dao.BusDataDictionaryDao;
import com.billionfun.bms.product.mall.model.BusDataDictionary;
import com.billionfun.bms.product.mall.vo.BusDataDictionaryVO;

@Repository
public class BusDataDictionaryDaoImpl extends BaseDaoImpl<BusDataDictionary,String> implements BusDataDictionaryDao{

	public List<BusDataDictionary> getListByPage(BusDataDictionaryVO vo) {
		StringBuilder hql = new StringBuilder();
		List<String> paramList = new ArrayList<String>();
		hql.append(" from BusDataDictionary l");
		hql.append(" where 1=1");
		if(vo.getSearch()){
			vo.getSearchHql(hql, vo.getFilters(), paramList);
		}
		if(!StringUtil.empty(vo.getSort())&&!StringUtil.empty(vo.getOrder())){
			hql.append(" order by l.").append(vo.getSort()).append(" ").append(vo.getOrder());
		}

		List<BusDataDictionary> list = super.getListByPage(vo, hql.toString(), paramList);
		return list;
	}

}
