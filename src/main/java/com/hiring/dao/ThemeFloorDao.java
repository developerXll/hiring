package com.hiring.dao;

import java.util.List;

import com.hiring.bean.Theme;
import com.hiring.bean.ThemeFloor;
import com.hiring.framework.Page;

public interface ThemeFloorDao extends BaseDao<ThemeFloor, Long>
	{

	List<ThemeFloor> getByPageAndNameAndTheme(Page page, String name,
			Theme theme);

	int countByNameAndTheme(String name, Theme theme);

	void deleteByTheme(Theme theme);

	List<ThemeFloor> getByPageAndTheme(Page page, Theme theme);

	int countByTheme(Theme theme);
	}
