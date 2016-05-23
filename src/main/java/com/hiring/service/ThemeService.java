package com.hiring.service;

import java.util.List;

import com.hiring.bean.Theme;
import com.hiring.bean.obj.ThemeObj;
import com.hiring.framework.Page;

public interface ThemeService extends BaseService<Theme>
	{

	String serv_name = "themeService";

	List<ThemeObj> findPageByTitle(String title, Page page);

	ThemeObj getFloorsByPageAndInfo(String themeId, Page page, String info);
	}
