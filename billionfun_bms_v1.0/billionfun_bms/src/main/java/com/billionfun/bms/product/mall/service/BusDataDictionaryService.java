package com.billionfun.bms.product.mall.service;

import java.util.List;

import com.billionfun.bms.product.mall.model.BusDataDictionary;
import com.billionfun.bms.product.mall.vo.BusDataDictionaryVO;

public interface BusDataDictionaryService extends
		BaseService<BusDataDictionary, BusDataDictionaryVO, String> {
	List<BusDataDictionaryVO> search(BusDataDictionaryVO vo);

	List<BusDataDictionaryVO> getAll(BusDataDictionaryVO vo);
}
