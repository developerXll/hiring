package com.hiring.framework.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.support.WebApplicationContextUtils;

import com.hiring.bean.obj.UserObj;
import com.hiring.constants.Constants;
import com.hiring.service.UserService;

/**
 * session过滤器
 * 
 * @author Administrator
 *
 */
public class SessionValidateFilter implements Filter
	{

	private static final String LOGIN_URL = "loginUrl";

	private static final String PARAM_URI = "include_uri";

	private String loginUrl;

	private String[] secureUris = null;

	private UserService userService;

	@Override
	public void destroy()
		{
		this.loginUrl = null;
		this.secureUris = null;
		}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException
		{
		HttpServletRequest request = (HttpServletRequest) req;

		String requestUri = request.getRequestURI();
		System.out.println("uri============" + requestUri);

		if (isUnSecureUri(requestUri))
			{
			HttpSession session = request.getSession();
			UserObj user = (UserObj) session
					.getAttribute(Constants.SESSION_AUTHENTICATION);
			boolean isValid = false;
			if (user != null)
				{
				UserObj getUser = userService.searchUserById(user.getId());
				if (getUser != null
						&& getUser.getUserName().equals(user.getUserName())
						&& getUser.getPassword().equals(user.getPassword()))
					isValid = true;
				}

			if (!isValid)
				{
				HttpServletResponse response = (HttpServletResponse) res;
				response.sendRedirect(
						response.encodeRedirectURL(this.loginUrl));
				return;
				}
			}
		chain.doFilter(req, res);
		}

	private boolean isUnSecureUri(String requestUri)
		{
		if (secureUris != null && secureUris.length > 0)
			{
			for (String uri : secureUris)
				{
				if (requestUri.contains(uri))
					return false;
				}
			}
		return true;
		}

	@Override
	public void init(FilterConfig config) throws ServletException
		{
		String uri = config.getInitParameter(PARAM_URI);
		if (uri != null)
			{
			this.secureUris = uri.split(",");
			for (int i = 0; i < this.secureUris.length; i++)
				{
				if (this.secureUris[i] == null
						|| "".equals(this.secureUris[i].trim()))
					{
					continue;
					}

				this.secureUris[i] = this.secureUris[i].trim();
				}
			}

		this.loginUrl = config.getInitParameter(LOGIN_URL);
		ServletContext context = config.getServletContext();
		userService = (UserService) WebApplicationContextUtils
				.getWebApplicationContext(context)
				.getBean(UserService.serv_name);
		}

	}
