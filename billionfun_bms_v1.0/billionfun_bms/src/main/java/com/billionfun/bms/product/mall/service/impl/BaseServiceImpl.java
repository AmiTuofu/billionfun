package com.billionfun.bms.product.mall.service.impl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.billionfun.bms.product.mall.dao.BaseDao;
import com.billionfun.bms.product.mall.service.BaseService;

@Service("baseService")
public abstract class BaseServiceImpl<T,P extends Serializable> implements BaseService<T,P> {

	@Autowired
	private BaseDao<T, P> baseDao;
	
	
}
