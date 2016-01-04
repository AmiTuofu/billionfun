package com.billionfun.bms.product.mall.dao.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@SuppressWarnings({"unchecked","rawtypes"})
@Repository
public  class BaseDaoImpl<T ,P extends Serializable>   {
	
	@Autowired
	protected SessionFactory sessionFactory;
	
	private Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}
	
	public void save (T t){
		getCurrentSession().save(t);
	}
	
	public void saveOrUpdate(T t){
		getCurrentSession().saveOrUpdate(t);
	}
	
	public void update(T t) {
		Session session = sessionFactory.getCurrentSession();
		
		session.update(t);
	}
	
	public void delete(T t) {
		Session session = sessionFactory.getCurrentSession();
		
		session.delete(t);
	}
	
	public T findById(Class<T> className, P id) {
		Session session = sessionFactory.getCurrentSession();
		
		T t = (T)session.get(className, id);
		
		return t;
	}
	
	public T find(String hql){
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		return (T) query.uniqueResult();
	}
	
	public T find(String hql,Map proMap){
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		query.setProperties(proMap);
		return (T) query.uniqueResult();
	}
	
	public List<T> findAll(String hql){
		Session session = sessionFactory.getCurrentSession();
		
		Query query = session.createQuery(hql);
		return (List<T>) query.list();
	}
	
	public List<T> findAll(String hql,Map proMap){
		Session session = sessionFactory.getCurrentSession();
		
		Query query = session.createQuery(hql);
		query.setProperties(proMap);
		return (List<T>) query.list();
	}
	
	
	public T findBySql(String sql) {
		Session session = sessionFactory.getCurrentSession();
		
		Query query = session.createSQLQuery(sql);
		return (T) query.uniqueResult();
	}
	
	public List<T> findAllBySql(String sql) {
		Session session = sessionFactory.getCurrentSession();
		
		Query query = session.createSQLQuery(sql);
		return (List<T>) query.list();
	}
}
