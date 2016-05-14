package com.hiring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hiring.bean.obj.ResumeObj;
import com.hiring.bean.obj.UserObj;
import com.hiring.constants.Constants;
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
	public List<ResumeObj> getList(HttpServletRequest request, Page page)
		{
		if (page == null) page = new Page();
		HttpSession session = request.getSession();
		UserObj userObj = (UserObj) session
				.getAttribute(Constants.SESSION_AUTHENTICATION);
		if (userObj != null)
			return resumeService.findPageObjByUser(userObj, page);
		return null;
		}

	}
