package com.billionfun.bms.product.mall.dao;

import java.util.List;

import com.billionfun.bms.product.mall.model.BusDataDictionary;
import com.billionfun.bms.product.mall.vo.BusDataDictionaryVO;

public interface BusDataDictionaryDao extends BaseDao<BusDataDictionary,String> {
	List<BusDataDictionary> getListByPage(BusDataDictionaryVO vo);
}
