package com.hiring.controller.base;

import org.springframework.web.servlet.ModelAndView;

public class BaseController
{

	protected ModelAndView ajaxDone(int statusCode, String message,
			String forwardUrl)
	{
		ModelAndView mav = new ModelAndView();
		mav.addObject("statusCode", statusCode);
		mav.addObject("message", message);
		mav.addObject("forwardUrl", forwardUrl);
		return mav;
	}

}
