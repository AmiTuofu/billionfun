package com.billionfun.bms.product.mall.service.impl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.billionfun.bms.product.mall.dao.BaseDao;
import com.billionfun.bms.product.mall.service.BaseService;

@Service("baseService")
public abstract  class BaseServiceImpl<T,P extends Serializable> implements BaseService<T,P> {

	@Autowired
	protected BaseDao<T, P> baseDao;
	
	public boolean save(T t){
		boolean sign = false;
		baseDao.save(t);
		sign = true;
		return sign;
	}
	
	public boolean update(T t){
		boolean sign = false;
		baseDao.update(t);
		sign = true;
		return sign;
	}
	
	public boolean saveOrUpdate(T t){
		boolean sign = false;
		baseDao.saveOrUpdate(t);
		sign = true;
		return sign;
	}
	public boolean delete(T t){
		boolean sign = false;
		baseDao.delete(t);
		sign = true;
		return sign;
	}
	public boolean delete(P p,Class<T> t){
		boolean sign = false;
		baseDao.delete(p,t);
		sign = true;
		return sign;
	}
}
