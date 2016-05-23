package com.hiring.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hiring.bean.Theme;
import com.hiring.bean.obj.ThemeFloorObj;
import com.hiring.bean.obj.ThemeObj;
import com.hiring.bean.obj.UserObj;
import com.hiring.constants.Constants;
import com.hiring.framework.Page;
import com.hiring.service.ThemeFloorService;
import com.hiring.service.ThemeService;

@RestController
@RequestMapping("/theme")
public class ThemeController
	{

	@Autowired
	private ThemeService themeService;

	@Autowired
	private ThemeFloorService themeFloorService;

	/**
	 * 添加论坛主题
	 * 
	 * @param theme
	 * @param request
	 * @return
	 */
	@RequestMapping("/addTheme")
	@ResponseBody
	public Map<String, Object> addTheme(ThemeForm form,
			HttpServletRequest request)
		{
		Map<String, Object> map = new HashMap<String, Object>();
		if (form == null || StringUtils.isEmpty(form.getTitle())
				|| StringUtils.isEmpty(form.getInfo()))
			{
			map.put("status", 300);
			map.put("message", "system error!");
			}
		else
			{
			HttpSession session = request.getSession();
			UserObj user = (UserObj) session
					.getAttribute(Constants.SESSION_AUTHENTICATION);
			// add theme
			ThemeObj theme = new ThemeObj();
			theme.setTitle(form.getTitle());
			theme.setInsertDate(new Date());
			theme.setUpdateDate(new Date());
			theme.setUserobj(user);
			themeService.save(theme.getTheme());
			// add theme floor 1
			ThemeFloorObj floor = new ThemeFloorObj();
			floor.setInfo(form.getInfo());
			floor.setFloorNum(1);
			floor.setThemeObj(theme);
			floor.setInsertDate(new Date());
			floor.setUser(user);
			themeFloorService.save(floor.getFloor());
			map.put("status", 200);
			map.put("message", "save success!");
			}
		return map;
		}

	@RequestMapping("/delTheme/{themeId}")
	@ResponseBody
	public Map<String, Object> deleteTheme(
			@PathVariable("themeId") String themeId)
		{
		Map<String, Object> map = new HashMap<String, Object>();
		try
			{
			// 删除论坛主题回复信息
			themeFloorService.deleteByThemeId(themeId);
			// 删除论坛主题信息
			themeService.delById(Long.parseLong(themeId));
			map.put("status", 200);
			map.put("message", "delete success!");
			}
		catch (Exception e)
			{
			e.printStackTrace();
			map.put("status", 300);
			map.put("message", "delete faild!");
			}
		return map;
		}

	/**
	 * 论坛主题列表
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/listTheme/{title}")
	@ResponseBody
	public ThemeListData ListTheme(Page page,
			@PathVariable("title") String title)
		{
		if (page == null)
			page = new Page();
		ThemeListData data = new ThemeListData();
		data.setList(themeService.findPageByTitle(title, page));
		data.setPage(page);
		return data;
		}

	/**
	 * 
	 * 论坛回复信息查询，用于管理员用户
	 * 
	 * @param page
	 * @param info
	 * @return
	 */
	@RequestMapping("/infoTheme/{themeId}/{info}")
	@ResponseBody
	public ThemeObj getTheme(Page page, @PathVariable("themeId") String themeId,
			@PathVariable("info") String info)
		{
		return themeService.getFloorsByPageAndInfo(themeId, page, info);
		}

	/**
	 * 
	 * 分页查询回复信息用于列表显示
	 * 
	 * @param page
	 * @param themeId
	 * @return
	 */
	@RequestMapping("/getTheme/{themeId}")
	@ResponseBody
	public ThemeObj getTheme(Page page, @PathVariable("themeId") String themeId)
		{
		return themeService.getFloorsByPageAndInfo(themeId, page, null);
		}

	/**
	 * 添加论坛主题回复
	 * 
	 * @param theme
	 * @param request
	 * @return
	 */
	@RequestMapping("/addThemeFloor")
	@ResponseBody
	public Map<String, Object> addThemeFloor(ThemeForm form,
			HttpServletRequest request)
		{
		Map<String, Object> map = new HashMap<String, Object>();
		if (form == null || StringUtils.isEmpty(form.getThemeId())
				|| StringUtils.isEmpty(form.getInfo()))
			{
			map.put("status", 300);
			map.put("message", "system error!");
			}
		else
			{
			HttpSession session = request.getSession();
			UserObj user = (UserObj) session
					.getAttribute(Constants.SESSION_AUTHENTICATION);
			// 查询获得theme对象
			Theme theme = themeService.load(Long.parseLong(form.getThemeId()));
			if (theme == null)
				{
				map.put("status", 403);
				map.put("message", "data not found!");
				}
			ThemeObj themeObj = new ThemeObj(theme);
			Date now = new Date();
			// 设置更新时间为最新时间，可以查询
			themeObj.setUpdateDate(now);
			// add theme floor
			ThemeFloorObj floor = new ThemeFloorObj();
			floor.setInfo(form.getInfo());
			int floorNum = themeFloorService.getMaxFloor(form.getThemeId()) + 1;
			floor.setFloorNum(floorNum);
			floor.setThemeObj(themeObj);
			floor.setInsertDate(now);
			floor.setUser(user);

			// 更新
			themeService.update(themeObj.getTheme());
			// 保存
			themeFloorService.save(floor.getFloor());
			map.put("status", 200);
			map.put("message", "save success!");
			}
		return map;
		}

	/**
	 * 删除论坛主题回复
	 * 
	 * @param theme
	 * @param request
	 * @return
	 */
	@RequestMapping("/delThemeFloor/{floorId}")
	@ResponseBody
	public Map<String, Object> delThemeFloor(
			@PathVariable("floorId") String floorId)
		{
		Map<String, Object> map = new HashMap<String, Object>();
		try
			{
			themeFloorService.delById(Long.parseLong(floorId));
			map.put("status", 200);
			map.put("message", "delete success!");
			}
		catch (Exception e)
			{
			e.printStackTrace();
			map.put("status", 300);
			map.put("message", "delete faild!");
			}
		return map;
		}

	/**
	 * 批量删除论坛主题回复
	 * 
	 * @param theme
	 * @param request
	 * @return
	 */
	@RequestMapping("/delThemeFloors/{floorIds}")
	@ResponseBody
	public Map<String, Object> delThemeFloors(
			@PathVariable("floorIds") String floorIds)
		{
		Map<String, Object> map = new HashMap<String, Object>();
		if (com.mysql.jdbc.StringUtils.isNullOrEmpty(floorIds))
			{
			map.put("status", 300);
			map.put("message", "delete faild!");
			return map;
			}
		try
			{
			String[] floorId = floorIds.split(",");
			if (floorId != null && floorId.length > 0)
				{
				for (String id : floorId)
					{
					themeFloorService.delById(Long.parseLong(id));
					}
				}
			map.put("status", 200);
			map.put("message", "delete success!");
			}
		catch (Exception e)
			{
			e.printStackTrace();
			map.put("status", 300);
			map.put("message", "delete faild!");
			}
		return map;
		}

	}
