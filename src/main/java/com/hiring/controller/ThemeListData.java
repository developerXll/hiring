package com.hiring.controller;

import java.util.List;

import com.hiring.bean.obj.ThemeObj;
import com.hiring.framework.Page;

public class ThemeListData
	{

	private List<ThemeObj> list;

	private Page page;

	public List<ThemeObj> getList()
		{
		return list;
		}

	public void setList(List<ThemeObj> list)
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
