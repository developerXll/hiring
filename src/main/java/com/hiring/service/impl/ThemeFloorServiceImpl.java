package com.hiring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hiring.bean.Theme;
import com.hiring.bean.ThemeFloor;
import com.hiring.dao.ThemeDao;
import com.hiring.dao.ThemeFloorDao;
import com.hiring.service.ThemeFloorService;

@Service(ThemeFloorService.serv_name)
@Transactional
public class ThemeFloorServiceImpl extends BaseServiceImpl<ThemeFloor>
		implements ThemeFloorService
	{

	@Autowired
	private ThemeFloorDao floorDao;

	@Autowired
	private ThemeDao themeDao;

	public void deleteByThemeId(String themeId)
		{
		Theme theme = themeDao.get(Long.parseLong(themeId));
		if (theme == null)
			return;
		floorDao.deleteByTheme(theme);
		}

	public int getMaxFloor(String themeId)
		{
		Theme theme = themeDao.get(Long.parseLong(themeId));
		return floorDao.countByTheme(theme);
		}
	}
