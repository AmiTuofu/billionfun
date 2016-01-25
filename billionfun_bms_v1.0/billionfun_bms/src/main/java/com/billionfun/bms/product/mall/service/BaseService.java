package com.billionfun.bms.product.mall.service;

import java.io.Serializable;

public interface BaseService<T,P extends Serializable> {
	boolean save(T t);
	boolean update(T t);
	boolean saveOrUpdate(T t);
	boolean delete(T t);
	boolean delete(P p,Class<T> t);
}
