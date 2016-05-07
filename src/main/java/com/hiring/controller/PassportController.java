package com.hiring.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.hiring.bean.obj.UserObj;
import com.hiring.constants.Constants;
import com.hiring.service.UserService;
import com.mysql.jdbc.StringUtils;

@RestController
@RequestMapping ("/passport")
public class PassportController
{

	@Autowired
	private UserService userService;

	/**
	 * 首页
	 * 
	 * @return
	 */
	@RequestMapping ("/index")
	public ModelAndView index()
	{
		return new ModelAndView("index");
	}

	/**
	 * 登录用户
	 * 
	 * @param form
	 * @param request
	 * @return
	 */
	@RequestMapping ("/loginUser")
	@ResponseBody
	public Map<String, Object> loginUser(UserForm form, HttpServletRequest request)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		if (!StringUtils.isNullOrEmpty(form.getUserName())
				&& !StringUtils.isNullOrEmpty(form.getPassWord()))
		{
			UserObj user = userService.searchUserByName(form.getUserName());
			if (user != null && form.getPassWord().equals(user.getPassword()))
			{
				// insert session
				HttpSession session = request.getSession();
				session.setAttribute(Constants.SESSION_AUTHENTICATION, user);
				map.put("user", user);
				map.put("status", 200);
				map.put("message", "login success!");
			}
			else
			{
				map.put("status", 300);
				map.put("message", "user doesn't exists!");
			}
		}else{
			map.put("status", 300);
			map.put("message", "userName and password must be input!");
		}
		return map;
	}

	/**
	 * 注册用户
	 * 
	 * @param form
	 * @return
	 */
	@RequestMapping ("/registerUser")
	@ResponseBody
	public ModelAndView registerUser(UserForm form, HttpServletRequest request)
	{
		if (form.getUserName() != null && form.getPassWord() != null)
		{
			if (userService.isUserNameExists(form.getUserName()))
				return new ModelAndView("index", "message",
						"the username is exists, please change a new one!");
			UserObj user = new UserObj();
			user.setUserName(form.getUserName());
			user.setPassword(form.getPassWord());
			user.setUserType(form.getUserType().toString());
			user.setInsertTime(new Date());
			userService.save(user.getUser());
			// insert session
			UserObj sessionUser = userService.searchUserByName(user
					.getUserName());
			if (sessionUser == null)
				return new ModelAndView("index", "message", "system error!");
			HttpSession session = request.getSession();
			session.setAttribute(Constants.SESSION_AUTHENTICATION, user);
			return new ModelAndView("index");
		}
		return new ModelAndView("index", "message",
				"the username and password must be filled!");

	}
}
