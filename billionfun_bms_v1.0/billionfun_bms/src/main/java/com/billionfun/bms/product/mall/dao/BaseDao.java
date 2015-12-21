package com.billionfun.bms.product.mall.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T,P extends Serializable> {
	void save(T t);
	
	void saveOrUpdate(T t);

	void update(T t);
	
	void delete(T t);
	
	T findById(Class<T> cls, P id);
	
	T find(String sql);
	
	List<T> findAll(String sql);
}
