package com.hiring.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.hiring.dao.BaseDao;
import com.hiring.framework.Page;
import com.hiring.service.BaseService;

@Transactional
public class BaseServiceImpl<T> implements BaseService<T>
{

	@Autowired
	private BaseDao<T, ?> dao;

	@Override
	public void save(T t)
	{
		dao.save(t);

	}

	@Override
	public void update(T t)
	{
		dao.update(t);

	}

	@Override
	public void delById(Serializable id)
	{
		dao.deleteById(id);

	}

	@Override
	public void delete(T t)
	{
		dao.delete(t);

	}

	@Override
	public List<T> loadPage(Page page)
	{
		return dao.getByPage(page);
	}

	@Override
	public int loadCountNum()
	{
		return dao.getCount();
	}

}
