package com.hiring.controller;

import java.util.Date;

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
	 * 用户登录
	 * 
	 * @param form
	 * @param request
	 * @return
	 */
	@RequestMapping ("/loginUser")
	public ModelAndView loginUser(UserForm form, HttpServletRequest request)
	{
		if (!StringUtils.isNullOrEmpty(form.getUserName())
				&& !StringUtils.isNullOrEmpty(form.getPassWord()))
		{
			UserObj user = userService.searchUserByName(form.getUserName());
			if (user != null && form.getPassWord().equals(user.getPassword())
					&& form.getUserType().equals(user.getUserType()))
			{
				// insert session
				HttpSession session = request.getSession();
				session.setAttribute(Constants.SESSION_AUTHENTICATION, user);
				return new ModelAndView("index");
			}
		}
		// login failed
		return new ModelAndView("index", "message", "login faild!");
	}

	/**
	 * 用户注册
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
