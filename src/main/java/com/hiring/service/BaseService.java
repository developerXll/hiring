package com.hiring.service;

import java.io.Serializable;
import java.util.List;

import com.hiring.framework.Page;

public interface BaseService<T>
{

	void save(T t);

	void update(T t);

	void delById(Serializable id);

	void delete(T t);

	List<T> loadPage(Page page);
	
	int loadCountNum();
}
