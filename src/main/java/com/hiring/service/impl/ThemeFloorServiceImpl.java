package com.hiring.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hiring.bean.Theme;
import com.hiring.bean.ThemeFloor;
import com.hiring.bean.obj.ThemeFloorObj;
import com.hiring.dao.ThemeDao;
import com.hiring.dao.ThemeFloorDao;
import com.hiring.framework.Page;
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

	public List<ThemeFloorObj> getFloorsByThemeAndPageAndInfo(String themeId,
			Page page, String info)
		{
		Theme theme = themeDao.get(themeId);
		List<ThemeFloorObj> objs = new ArrayList<ThemeFloorObj>();
		if (theme == null)
			return objs;
		List<ThemeFloor> floors = floorDao.getByPageAndNameAndTheme(page, info,
				theme);
		if (floors != null)
			{
			for (ThemeFloor floor : floors)
				{
				objs.add(new ThemeFloorObj(floor));
				}
			}
		return objs;
		}

	public int countByThemeAndPageAndInfo(String themeId, Page page,
			String info)
		{
		Theme theme = themeDao.get(themeId);
		if (theme == null)
			return 0;
		return floorDao.countByNameAndTheme(info, theme);
		}

	public List<ThemeFloorObj> getFloorsByThemeAndPage(String themeId,
			Page page)
		{
		Theme theme = themeDao.get(themeId);
		List<ThemeFloorObj> objs = new ArrayList<ThemeFloorObj>();
		if (theme == null)
			return objs;
		List<ThemeFloor> floors = floorDao.getByPageAndTheme(page, theme);
		if (floors != null)
			{
			for (ThemeFloor floor : floors)
				{
				objs.add(new ThemeFloorObj(floor));
				}
			}
		return objs;
		}

	public int countByTheme(String themeId)
		{
		Theme theme = themeDao.get(themeId);
		if (theme == null)
			return 0;
		return floorDao.countByTheme(theme);
		}
	}
