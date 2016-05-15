package com.hiring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
	public RecruitListData getList(Page page)
		{
		if (page == null)
			page = new Page();
		RecruitListData data = new RecruitListData();
		data.setList(recruitService.findPageObj(page));
		page.setTotalNumber(recruitService.loadCountNum());
		data.setPage(page);
		return data;
		}

	}
