package com.hiring.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.hiring.dao.BaseDao;
import com.hiring.framework.Page;

public class BaseDaoImpl<T, PK extends java.io.Serializable>
		implements BaseDao<T, PK>
	{

	@Autowired
	private SessionFactory sessionFactory;

	protected Class<T> entityClass;

	@Override
	public T get(Serializable id)
		{
		T obj = (T) this.getSession().get(getEntityClass(), id);
		return obj;
		}

	@Override
	public void save(Object newInstance)
		{
		Serializable id = this.getSession().save(newInstance);
		System.out.println("save=====" + id);

		}

	@Override
	public void delete(Object transientObject)
		{
		this.getSession().delete(transientObject);

		}

	@Override
	public void deleteById(Serializable id)
		{
		T t = get(id);
		this.getSession().delete(t);

		}

	@Override
	public void update(T t)
		{
		this.getSession().update(t);

		}

	public SessionFactory getSessionFactory()
		{
		return sessionFactory;
		}

	public Session getSession()
		{
		// 需要开启事物，才能得到CurrentSession
		return sessionFactory.getCurrentSession();
		}

	public void setSessionFactory(SessionFactory sessionFactory)
		{
		this.sessionFactory = sessionFactory;
		}

	@SuppressWarnings(
		{ "unchecked" })
	protected Class<T> getEntityClass()
		{
		if (entityClass == null)
			{
			entityClass = (Class<T>) ((ParameterizedType) getClass()
					.getGenericSuperclass()).getActualTypeArguments()[0];
			}
		return entityClass;
		}

	@Override
	public T load(PK pk)
		{
		T obj = (T) this.getSession().load(getEntityClass(), pk);
		return obj;
		}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getByPage(Page page)
		{
		Criteria criteria = this.getSession().createCriteria(getEntityClass());
		criteria.setFirstResult((page.getPageNo() - 1) * page.getPageSize());
		criteria.setMaxResults(page.getPageSize());
		return criteria.list();
		}

	@SuppressWarnings("rawtypes")
	@Override
	public int getCount()
		{
		Criteria criteria = this.getSession().createCriteria(getEntityClass());
		List list = criteria.list();
		return list != null ? list.size() : 0;
		}

	}
