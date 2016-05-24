package com.hiring.controller;

import java.util.List;

import com.hiring.bean.obj.ThemeFloorObj;
import com.hiring.framework.Page;

public class ThemeFloorListData
	{

	private List<ThemeFloorObj> list;

	private Page page;

	public List<ThemeFloorObj> getList()
		{
		return list;
		}

	public void setList(List<ThemeFloorObj> list)
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
