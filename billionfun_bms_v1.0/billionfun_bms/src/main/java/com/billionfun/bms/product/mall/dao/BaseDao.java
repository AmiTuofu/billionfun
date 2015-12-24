package com.billionfun.bms.product.mall.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface BaseDao<T,P extends Serializable> {
	void save(T t);
	
	void saveOrUpdate(T t);

	void update(T t);
	
	void delete(T t);
	
	T findById(Class<T> cls, P id);
	
	T find(String sql);

	T find(String hql,Map proMap);
	
	List<T> findAll(String hql,Map proMap);
	
	List<T> findAll(String hql);
	
	T findBySql(String sql);
	
	List<T> findAllBySql(String sql);
}
