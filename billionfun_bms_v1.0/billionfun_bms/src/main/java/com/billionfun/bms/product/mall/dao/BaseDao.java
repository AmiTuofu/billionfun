package com.billionfun.bms.product.mall.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;

import com.billionfun.bms.product.mall.common.utils.PageUtil;

public interface BaseDao<T,P extends Serializable> {
	void create(T t);

}
