package com.hiring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hiring.bean.obj.AnnouncementObj;
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
	public List<AnnouncementObj> getList(Page page)
		{
		if (page == null) page = new Page();
		return announcementService.findPageObj(page);
		}

	}
