package com.hiring.controller;

import java.util.List;

import com.hiring.bean.obj.UserObj;
import com.hiring.framework.Page;

public class UserListData
	{

	private List<UserObj> list;

	private Page page;

	public List<UserObj> getList()
		{
		return list;
		}

	public void setList(List<UserObj> list)
		{
		this.list = list;
		}

	public Page getPage()
		{
		return page;
		}

	public void setPage(Page page)
		{
		this.page = page;
		}

	}
