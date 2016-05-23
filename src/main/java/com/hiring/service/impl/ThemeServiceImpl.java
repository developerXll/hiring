package com.hiring.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.hiring.bean.Theme;
import com.hiring.bean.ThemeFloor;
import com.hiring.bean.obj.ThemeFloorObj;
import com.hiring.bean.obj.ThemeObj;
import com.hiring.dao.ThemeDao;
import com.hiring.dao.ThemeFloorDao;
import com.hiring.framework.Page;
import com.hiring.service.ThemeService;

@Service(ThemeService.serv_name)
@Transactional
public class ThemeServiceImpl extends BaseServiceImpl<Theme>
		implements ThemeService
	{

	@Autowired
	private ThemeDao themeDao;

	@Autowired
	private ThemeFloorDao floorDao;

	public List<ThemeObj> findPageByTitle(String title, Page page)
		{
		List<Theme> themes = themeDao.getByPageByName(page, title);
		List<ThemeObj> objs = new ArrayList<ThemeObj>();
		if (themes != null && themes.size() > 0)
			{
			for (Theme theme : themes)
				{
				objs.add(new ThemeObj(theme));
				}
			}
		return objs;
		}

	public ThemeObj getFloorsByPageAndInfo(String themeId, Page page,
			String info)
		{
		Theme theme = themeDao.load(Long.parseLong(themeId));
		if (theme == null)
			return null;
		if (StringUtils.isEmpty(info))
			info = "";
		List<ThemeFloor> floors = floorDao.getByPageByName(page, info, theme);
		List<ThemeFloorObj> floorObjs = new ArrayList<ThemeFloorObj>();
		if (floors != null && floors.size() > 0)
			{
			for (ThemeFloor floor : floors)
				{
				floorObjs.add(new ThemeFloorObj(floor));
				}
			}
		ThemeObj obj = new ThemeObj(theme);
		obj.setFloors(floorObjs);
		return obj;
		}
	}
