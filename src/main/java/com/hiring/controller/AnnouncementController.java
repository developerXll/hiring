package com.hiring.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hiring.bean.Announcement;
import com.hiring.bean.obj.AnnouncementObj;
import com.hiring.bean.obj.UserObj;
import com.hiring.constants.Constants;
import com.hiring.framework.Page;
import com.hiring.service.AnnouncementService;

@RestController
@RequestMapping("/announ")
public class AnnouncementController
	{

	@Autowired
	private AnnouncementService announcementService;

	@RequestMapping("/list")
	@ResponseBody
	public AnnouncementListData getList(Page page)
		{
		if (page == null)
			page = new Page();
		AnnouncementListData data = new AnnouncementListData();
		data.setList(announcementService.findPageObj(page));
		page.setTotalNumber(announcementService.loadCountNum());
		data.setPage(page);
		return data;
		}

	@RequestMapping("/add")
	@ResponseBody
	public Map<String, Object> add(AnnouncementObj annObj,
			HttpServletRequest request)
		{
		Map<String, Object> map = new HashMap<String, Object>();
		if (annObj == null)
			{
			map.put("status", 300);
			map.put("message", "system error!");
			}
		else
			{
			annObj.setInsertTime(new Date());
			HttpSession session = request.getSession();
			annObj.setUser((UserObj) session
					.getAttribute(Constants.SESSION_AUTHENTICATION));
			announcementService.save(annObj.getAnnouncement());
			map.put("status", 200);
			map.put("message", "add success!");
			}
		return map;
		}

	@RequestMapping("/update")
	@ResponseBody
	public Map<String, Object> update(AnnouncementObj annObj)
		{
		Map<String, Object> map = new HashMap<String, Object>();
		if (annObj == null)
			{
			map.put("status", 300);
			map.put("message", "system error!");
			}
		else
			{
			announcementService.update(annObj.getAnnouncement());
			map.put("status", 200);
			map.put("message", "add success!");
			}
		return map;
		}

	@RequestMapping("/delete/{annObjId}")
	@ResponseBody
	public Map<String, Object> delete(@PathVariable("annObjId") String annObjId)
		{
		Map<String, Object> map = new HashMap<String, Object>();
		if (annObjId == null || annObjId.length() <= 0)
			{
			map.put("status", 300);
			map.put("message", "system error!");
			}
		else
			{
			announcementService.delById(Long.parseLong(annObjId));
			map.put("status", 200);
			map.put("message", "add success!");
			}
		return map;
		}

	@RequestMapping("/get/{annObjId}")
	public Map<String, Object> get(@PathVariable("annObjId") String annObjId)
		{
		Map<String, Object> map = new HashMap<String, Object>();
		if (annObjId == null || annObjId.length() <= 0)
			{
			map.put("status", 300);
			map.put("message", "system error!");
			}
		else
			{
			Announcement ann = announcementService
					.load(Long.parseLong(annObjId));
			if (ann == null)
				{
				map.put("status", 403);
				map.put("message", "data not found!");
				}
			else
				{
				AnnouncementObj annObj = new AnnouncementObj(ann);
				map.put("status", 200);
				map.put("message", "add success!");
				map.put("data", annObj);
				}
			}
		return map;
		}

	@RequestMapping("/list/{name}")
	@ResponseBody
	public AnnouncementListData getListByName(Page page,
			@PathVariable("name") String name)
		{
		if (page == null)
			page = new Page();
		AnnouncementListData data = new AnnouncementListData();
		if (name == null || name.length() <= 0)
			{
			data.setList(announcementService.findPageObj(page));
			page.setTotalNumber(announcementService.loadCountNum());
			}
		else
			{
			data.setList(announcementService.findPageObjByName(page, name));
			page.setTotalNumber(announcementService.findSizeObjByName(name));
			}
		data.setPage(page);
		return data;
		}

	}
