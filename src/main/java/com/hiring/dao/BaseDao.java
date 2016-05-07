package com.hiring.dao;

import java.io.Serializable;
import java.util.List;

import com.hiring.framework.Page;

public interface BaseDao<T, PK extends Serializable>
	{

	T get(PK pk);

	T load(PK pk);

	void save(T newInstance);

	void delete(T transientObject);

	void deleteById(Serializable id);

	void update(T newInstance);

	List<T> getByPage(Page page);

	int getCount();
	}
