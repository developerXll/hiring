package com.hiring.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hiring.bean.obj.UserObj;
import com.hiring.constants.Constants;
import com.hiring.constants.UserType;
import com.hiring.framework.Page;
import com.hiring.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController
	{

	@Autowired
	private UserService userService;

	/**
	 * 
	 * 管理员列表用户
	 * 
	 * @param page
	 * @param name
	 * @return
	 */
	@RequestMapping("/list/{name}")
	@ResponseBody
	public UserListData getList(Page page, @PathVariable("name") String name,
			HttpServletRequest request)
		{
		if (page == null)
			page = new Page();
		UserListData data = new UserListData();
		HttpSession session = request.getSession();
		UserObj user = (UserObj) session
				.getAttribute(Constants.SESSION_AUTHENTICATION);
		if (user != null)
			{
			// 管理员用户
			if (UserType.APPLICANT.equals(UserType.valueOf(user.getUserType())))
				{
				data.setList(userService.findPageByUserName(page, name, true));
				page.setTotalNumber(userService.countByUserName(name, true));
				data.setPage(page);
				}
			else
				{
				data.setList(userService.findPageByUserName(page, name, false));
				page.setTotalNumber(userService.countByUserName(name, false));
				data.setPage(page);
				}
			}
		return data;
		}
	
	/**
	 * 
	 * 管理员列表用户
	 * 
	 * @param page
	 * @param name
	 * @return
	 */
	@RequestMapping("/list")
	@ResponseBody
	public UserListData getList(Page page, HttpServletRequest request)
		{
		if (page == null)
			page = new Page();
		UserListData data = new UserListData();
		HttpSession session = request.getSession();
		UserObj user = (UserObj) session
				.getAttribute(Constants.SESSION_AUTHENTICATION);
		if (user != null)
			{
			// 管理员用户
			if (UserType.APPLICANT.equals(UserType.valueOf(user.getUserType())))
				{
				data.setList(userService.findPageByUserName(page, "", true));
				page.setTotalNumber(userService.countByUserName("", true));
				data.setPage(page);
				}
			else
				{
				data.setList(userService.findPageByUserName(page, "", false));
				page.setTotalNumber(userService.countByUserName("", false));
				data.setPage(page);
				}
			}
		return data;
		}

	@RequestMapping("/del/{userId}")
	@ResponseBody
	public Map<String, Object> deleteUser(@PathVariable("userId") String userId)
		{
		Map<String, Object> map = new HashMap<String, Object>();
		try
			{
			userService.delUser(userId);
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
