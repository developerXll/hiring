package com.hiring.service;

import com.hiring.bean.ThemeFloor;

public interface ThemeFloorService extends BaseService<ThemeFloor>
	{

	String serv_name = "themeFloorService";

	void deleteByThemeId(String themeId);

	int getMaxFloor(String themeId);
	}
