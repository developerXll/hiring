package com.hiring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hiring.bean.obj.RecruitObj;
import com.hiring.framework.Page;
import com.hiring.service.RecruitService;

@RestController
@RequestMapping("/rec")
public class RecruitController
	{

	@Autowired
	private RecruitService recruitService;

	@RequestMapping("/list")
	@ResponseBody
	public List<RecruitObj> getList(Page page)
		{
		if (page == null) page = new Page();
		return recruitService.findPageObj(page);
		}

	}
