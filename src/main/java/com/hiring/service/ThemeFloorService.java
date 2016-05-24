package com.hiring.service;

import java.util.List;

import com.hiring.bean.ThemeFloor;
import com.hiring.bean.obj.ThemeFloorObj;
import com.hiring.framework.Page;

public interface ThemeFloorService extends BaseService<ThemeFloor>
	{

	String serv_name = "themeFloorService";

	void deleteByThemeId(String themeId);

	int getMaxFloor(String themeId);

	List<ThemeFloorObj> getFloorsByThemeAndPageAndInfo(String themeId,
			Page page, String info);

	int countByThemeAndPageAndInfo(String themeId, Page page, String info);

	List<ThemeFloorObj> getFloorsByThemeAndPage(String themeId, Page page);

	int countByTheme(String themeId);
	}
