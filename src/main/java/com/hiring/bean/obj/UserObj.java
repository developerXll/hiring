package com.hiring.bean.obj;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hiring.bean.User;
import com.hiring.constants.UserType;

/**
 * 用户信息
 * 
 * @author Administrator
 *
 */
public class UserObj
	{

	private User user = new User();

	public UserObj(User user)
		{
		this.user = user;
		}

	public UserObj()
		{

		}

	public Long getId()
		{
		return this.user.getId();
		}

	public void setId(Long id)
		{
		this.user.setId(id);
		}

	public String getUserName()
		{
		return this.user.getUserName();
		}

	public void setUserName(String userName)
		{
		this.user.setUserName(userName);
		}

	public String getPassword()
		{
		return this.user.getPassword();
		}

	public void setPassword(String password)
		{
		this.user.setPassword(password);
		}

	public String getUserType()
		{
		return this.user.getUserType().toString();
		}

	public void setUserType(String userType)
		{
		this.user.setUserType(UserType.valueOf(userType));
		}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	public Date getInsertTime()
		{
		return this.user.getInsertTime();
		}

	public void setInsertTime(Date insertTime)
		{
		this.user.setInsertTime(insertTime);
		}

	@JsonIgnore
	public User getUser()
		{
		return user;
		}

	public void setUser(User user)
		{
		this.user = user;
		}

	}
