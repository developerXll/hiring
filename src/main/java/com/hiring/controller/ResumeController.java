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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hiring.bean.Resume;
import com.hiring.bean.obj.ResumeObj;
import com.hiring.bean.obj.UserObj;
import com.hiring.constants.Constants;
import com.hiring.constants.UserType;
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
	public ResumeListData getList(HttpServletRequest request, Page page)
		{
		if (page == null)
			page = new Page();
		HttpSession session = request.getSession();
		UserObj userObj = (UserObj) session
				.getAttribute(Constants.SESSION_AUTHENTICATION);
		ResumeListData data = new ResumeListData();
		if (userObj != null)
			data.setList(resumeService.findPageObjByUser(userObj, page));
		page.setTotalNumber(resumeService.findPageNumObjByUser(userObj));
		data.setPage(page);
		return data;
		}

	@RequestMapping(value = "/add", method = {RequestMethod.POST })
	@ResponseBody
	public Map<String, Object> add(ResumeObj resObj, HttpServletRequest request)
		{
		Map<String, Object> map = new HashMap<String, Object>();
		if (resObj == null)
			{
			map.put("status", 300);
			map.put("message", "system error!");
			}
		else
			{
			resObj.setInsertTime(new Date());
			resObj.setUpdateTime(new Date());
			HttpSession session = request.getSession();
			resObj.setUser((UserObj) session
					.getAttribute(Constants.SESSION_AUTHENTICATION));
			resumeService.save(resObj.getResume());
			map.put("status", 200);
			map.put("message", "add success!");
			}
		return map;
		}

	@RequestMapping(value = "/update", method = {RequestMethod.POST })
	@ResponseBody
	public Map<String, Object> update(ResumeObj resObj)
		{
		Map<String, Object> map = new HashMap<String, Object>();
		if (resObj == null)
			{
			map.put("status", 300);
			map.put("message", "system error!");
			}
		else
			{
			resObj.setUpdateTime(new Date());
			resumeService.update(resObj.getResume());
			map.put("status", 200);
			map.put("message", "add success!");
			}
		return map;
		}

	@RequestMapping("/delete/{resObjId}")
	@ResponseBody
	public Map<String, Object> delete(@PathVariable("resObjId") String resObjId)
		{
		Map<String, Object> map = new HashMap<String, Object>();
		if (resObjId == null || resObjId.length() <= 0)
			{
			map.put("status", 300);
			map.put("message", "system error!");
			}
		else
			{
			resumeService.delById(Long.parseLong(resObjId));
			map.put("status", 200);
			map.put("message", "add success!");
			}
		return map;
		}

	@RequestMapping("/get/{resObjId}")
	public Map<String, Object> get(@PathVariable("resObjId") String resObjId)
		{
		Map<String, Object> map = new HashMap<String, Object>();
		if (resObjId == null || resObjId.length() <= 0)
			{
			map.put("status", 300);
			map.put("message", "system error!");
			}
		else
			{
			Resume res = resumeService.load(Long.parseLong(resObjId));
			if (res == null)
				{
				map.put("status", 403);
				map.put("message", "data not found!");
				}
			else
				{
				ResumeObj resObj = new ResumeObj(res);
				map.put("status", 200);
				map.put("message", "add success!");
				map.put("data", resObj);
				}
			}
		return map;
		}

	/**
	 * 根据用户名查询列表页面，此功能针对管理员用户
	 * 
	 * @param page
	 * @param name
	 * @param request
	 * @return
	 */
	@RequestMapping("/list/{name}")
	@ResponseBody
	public ResumeListData getListByUserName(Page page,
			@PathVariable("name") String name, HttpServletRequest request)
		{
		HttpSession session = request.getSession();
		UserObj user = (UserObj) session
				.getAttribute(Constants.SESSION_AUTHENTICATION);
		if (user == null)
			return null;
		String userType = user.getUserType();
		if (StringUtils.isEmpty(userType))
			return null;
		// 判断用户是否为应聘者，如果是应聘者，不支持查询简历功能
		if (!UserType.APPLICANT.equals(UserType.valueOf(userType)))
			return null;
		if (page == null)
			page = new Page();
		ResumeListData data = new ResumeListData();
		if (name == null || name.length() <= 0)
			{
			data.setList(resumeService.findPageObj(page));
			page.setTotalNumber(resumeService.loadCountNum());
			}
		else
			{
			data.setList(resumeService.findPageObjByUserName(name, page));
			page.setTotalNumber(resumeService.findPageNumObjByUserName(name));
			}
		data.setPage(page);
		return data;
		}

	/**
	 * 投递简历
	 * 
	 * @param resumeId
	 *            简历id
	 * @param recruitId
	 *            招聘信息id
	 * @return
	 */
	@RequestMapping("/deliver/{resumeId}/{recruitId}")
	@ResponseBody
	public Map<String, Object> deliver(
			@PathVariable("resumeId") String resumeId,
			@PathVariable("recruitId") String recruitId)
		{
		Map<String, Object> map = new HashMap<String, Object>();
		if (resumeService.addDeliver(recruitId, resumeId))
			{
			map.put("status", 200);
			map.put("message", "add success!");
			}
		else
			{
			map.put("status", 300);
			map.put("message", "system error!");
			}
		return map;
		}

	}
