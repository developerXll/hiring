package com.hiring.dao;

import java.util.List;

import com.hiring.bean.Theme;
import com.hiring.bean.ThemeFloor;
import com.hiring.framework.Page;

public interface ThemeFloorDao extends BaseDao<ThemeFloor, Long>
	{

	List<ThemeFloor> getByPageByName(Page page, String name, Theme theme);

	void deleteByTheme(Theme theme);

	int countByTheme(Theme theme);
	}
