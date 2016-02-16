package com.billionfun.bms.product.mall.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.billionfun.bms.product.mall.common.utils.PageUtil;

public interface BaseDao<T,P extends Serializable> {
	void save(T t);
	
	void saveObject (Object o);
	
	void saveOrUpdate(T t);

	void update(T t);
	
	void merge(T t);
	
	void delete(T t);
	
	void delete(P id);
	
	void delete(P id,Class<T> cls);
	
	void deleteByHql(String hql);
	
	T findById(P id);
	
	T find(String sql);

	T find(String hql,Map<String,String> proMap);
	
	List<T> findAll(String hql,Map<String,String> proMap);
	
	List<T> findAll(String hql);
	
	T findBySql(String sql);
	
	List<T> findAllBySql(String sql);
	
	T get(P id);
	
	T get(P id,Class<T> cls);
	
	List<T> getList(final String hql);
	
	List<T> getList(final String hql,final List<String> paramList);
	
	List<T> getListByPage(PageUtil<T> pl);
	
	List<T> getListByPage(PageUtil<T> pl,String hql,List<String> params);
	
	List<T> getListByPage(final int begin, final int pageSize, final String hql);
	
	List<T> getListByPage(final int begin, final int pageSize, final String hql,List<String> paramList);
	
	int getTotalCount(String hql, List<String> params);
}
