package com.hiring.dao;

import java.util.List;

import com.hiring.bean.Theme;
import com.hiring.framework.Page;

public interface ThemeDao extends BaseDao<Theme, Long>
	{

	public List<Theme> getByPageByName(Page page, String name);
	}
