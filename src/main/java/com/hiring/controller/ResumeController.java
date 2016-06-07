package com.hiring.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hiring.bean.Resume;
import com.hiring.bean.obj.RecruitObj;
import com.hiring.bean.obj.ResumeObj;
import com.hiring.bean.obj.UserObj;
import com.hiring.constants.Constants;
import com.hiring.constants.ResumeStatus;
import com.hiring.constants.UserType;
import com.hiring.framework.Page;
import com.hiring.service.RecruitService;
import com.hiring.service.ResumeService;
import com.mysql.jdbc.StringUtils;

@RestController
@RequestMapping("/res")
public class ResumeController
	{

	@Autowired
	private ResumeService resumeService;

	@Autowired
	private RecruitService recruitService;

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
			{
			UserType userType = UserType.valueOf(userObj.getUserType());
			if (UserType.APPLICANT.equals(userType))
				{
				data.setList(resumeService.findPageObj(page));
				page.setTotalNumber(resumeService.loadCountNum());
				}
			else if (UserType.RECRUITER.equals(userType))
				{
				data.setList(resumeService.findPageObjByUser(userObj, page));
				page.setTotalNumber(
						resumeService.findPageNumObjByUser(userObj));
				}
			}
		data.setPage(page);
		return data;
		}

	@RequestMapping(value = "/add", method =
		{ RequestMethod.POST })
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
			String recruitId = resObj.getRecruitId();
			if (StringUtils.isNullOrEmpty(recruitId))
				{
				map.put("status", 302);
				map.put("message", "Must select recrudit!");
				}
			resObj.setRecruit(new RecruitObj(recruitService.load(recruitId)));
			// 初始为未通过
			resObj.setStatus(ResumeStatus.FAIL.toString());
			resumeService.save(resObj.getResume());
			map.put("status", 200);
			map.put("message", "add success!");
			}
		return map;
		}

	@RequestMapping(value = "/update", method =
		{ RequestMethod.POST }, produces =
		{ "application/json" })
	@ResponseBody
	public Map<String, Object> update(ResumeObj resObj,
			HttpServletRequest request)
		{
		Map<String, Object> map = new HashMap<String, Object>();
		if (resObj == null)
			{
			map.put("status", 300);
			map.put("message", "system error!");
			}
		else
			{
			HttpSession session = request.getSession();
			resObj.setUser((UserObj) session
					.getAttribute(Constants.SESSION_AUTHENTICATION));
			resObj.setUpdateTime(new Date());
			String recruitId = resObj.getRecruitId();
			if (StringUtils.isNullOrEmpty(recruitId))
				{
				map.put("status", 302);
				map.put("message", "Must select recrudit!");
				}
			resObj.setRecruit(new RecruitObj(recruitService.load(recruitId)));
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
	 * 
	 * 管理员根据招聘信息id和查询条件查询投递简历信息
	 * 
	 * @param page
	 * @param recruitId
	 * @param name
	 * @param request
	 * @return
	 */
	@RequestMapping("/listRes/{recruitId}/{name}")
	@ResponseBody
	public ResumeListData getResList(Page page,
			@PathVariable("recruitId") String recruitId,
			@PathVariable("name") String name, HttpServletRequest request)
		{
		if (page == null)
			page = new Page();
		ResumeListData data = new ResumeListData();
		data.setList(resumeService.findResPageObj(recruitId, name, page));
		page.setTotalNumber(
				resumeService.findPageNumResPageObj(recruitId, name));
		return data;
		}

	/**
	 * 
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
		if (page == null)
			page = new Page();
		ResumeListData data = new ResumeListData();
		HttpSession session = request.getSession();
		UserObj userObj = (UserObj) session
				.getAttribute(Constants.SESSION_AUTHENTICATION);
		if (userObj != null)
			{
			UserType userType = UserType.valueOf(userObj.getUserType());
			if (UserType.APPLICANT.equals(userType))
				{
				// 管理员用户
				if (name == null || name.length() <= 0)
					{
					// 如果传输name为空，查询所有信息
					data.setList(resumeService.findPageObj(page));
					page.setTotalNumber(resumeService.loadCountNum());
					}
				else
					{
					// 如果传输name不为空，根据条件查询
					data.setList(
							resumeService.findPageObjByUserName(name, page));
					page.setTotalNumber(
							resumeService.findPageNumObjByUserName(name));
					}
				}
			else if (UserType.RECRUITER.equals(userType))
				{
				// 应聘者
				data.setList(resumeService.findPageObjByUser(userObj, page));
				page.setTotalNumber(
						resumeService.findPageNumObjByUser(userObj));
				}
			}
		data.setPage(page);
		return data;
		}

	/**
	 * 
	 * 管理员改变简历状态，通过和未通过
	 * 
	 */
	@RequestMapping("/audit/{resumeId}/{resumeStatus}")
	@ResponseBody
	public Map<String, Object> audit(@PathVariable("resumeId") String resumeId,
			@PathVariable("resumeStatus") Integer resumeStatus)
		{
		Map<String, Object> map = new HashMap<String, Object>();
		ResumeStatus status = ResumeStatus.FAIL;
		if (resumeStatus > 0)
			status = ResumeStatus.PASS;
		if (resumeService.addAudit(resumeId, status))
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

	/**
	 * 投递简历(已弃用)
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
