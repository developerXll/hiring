package com.hiring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hiring.bean.obj.ResumeObj;
import com.hiring.framework.Page;
import com.hiring.service.ResumeService;

@RestController
@RequestMapping("/res")
public class ResumeController
	{

	@Autowired
	private ResumeService resumeService;

	@RequestMapping("/list")
	@ResponseBody
	public List<ResumeObj> getList()
		{
		Page page = new Page();
		return resumeService.findPageObj(page);
		}

	}
