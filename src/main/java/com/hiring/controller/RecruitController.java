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

import com.hiring.bean.Recruit;
import com.hiring.bean.obj.RecruitObj;
import com.hiring.bean.obj.UserObj;
import com.hiring.constants.Constants;
import com.hiring.framework.Page;
import com.hiring.service.RecruitService;

@RestController
@RequestMapping("/rec")
public class RecruitController
	{

	@Autowired
	private RecruitService recruitService;

	@RequestMapping("/listAll")
	@ResponseBody
	public RecruitListData getListAll()
		{
		RecruitListData data = new RecruitListData();
		data.setList(recruitService.findAll());
		return data;
		}

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

	@RequestMapping("/add")
	@ResponseBody
	public Map<String, Object> add(RecruitObj recObj,
			HttpServletRequest request)
		{
		Map<String, Object> map = new HashMap<String, Object>();
		if (recObj == null)
			{
			map.put("status", 300);
			map.put("message", "system error!");
			}
		else
			{
			recObj.setInsertTime(new Date());
			HttpSession session = request.getSession();
			recObj.setPublisher((UserObj) session
					.getAttribute(Constants.SESSION_AUTHENTICATION));
			recruitService.save(recObj.getRecruit());
			map.put("status", 200);
			map.put("message", "add success!");
			}
		return map;
		}

	@RequestMapping("/update")
	@ResponseBody
	public Map<String, Object> update(RecruitObj recObj)
		{
		Map<String, Object> map = new HashMap<String, Object>();
		if (recObj == null)
			{
			map.put("status", 300);
			map.put("message", "system error!");
			}
		else
			{
			recruitService.update(recObj.getRecruit());
			map.put("status", 200);
			map.put("message", "add success!");
			}
		return map;
		}

	@RequestMapping("/delete/{recObjId}")
	@ResponseBody
	public Map<String, Object> delete(@PathVariable("recObjId") String recObjId)
		{
		Map<String, Object> map = new HashMap<String, Object>();
		if (recObjId == null || recObjId.length() <= 0)
			{
			map.put("status", 300);
			map.put("message", "system error!");
			}
		else
			{
			recruitService.delById(Long.parseLong(recObjId));
			map.put("status", 200);
			map.put("message", "add success!");
			}
		return map;
		}

	@RequestMapping("/get/{recObjId}")
	public Map<String, Object> get(@PathVariable("recObjId") String recObjId)
		{
		Map<String, Object> map = new HashMap<String, Object>();
		if (recObjId == null || recObjId.length() <= 0)
			{
			map.put("status", 300);
			map.put("message", "system error!");
			}
		else
			{
			Recruit rec = recruitService.load(Long.parseLong(recObjId));
			if (rec == null)
				{
				map.put("status", 403);
				map.put("message", "data not found!");
				}
			else
				{
				RecruitObj recObj = new RecruitObj(rec);
				map.put("status", 200);
				map.put("message", "add success!");
				map.put("data", recObj);
				}
			}
		return map;
		}

	@RequestMapping("/list/{name}")
	@ResponseBody
	public RecruitListData getListByName(Page page,
			@PathVariable("name") String name)
		{
		if (page == null)
			page = new Page();
		RecruitListData data = new RecruitListData();
		if (name == null || name.length() <= 0)
			{
			data.setList(recruitService.findPageObj(page));
			page.setTotalNumber(recruitService.loadCountNum());
			}
		else
			{
			data.setList(recruitService.findPageObjByName(page, name));
			page.setTotalNumber(recruitService.countObjByName(name));
			}
		data.setPage(page);
		return data;
		}

	}
