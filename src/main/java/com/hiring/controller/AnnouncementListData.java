package com.hiring.controller;

import java.util.List;

import com.hiring.bean.obj.AnnouncementObj;
import com.hiring.framework.Page;

public class AnnouncementListData
	{

	private List<AnnouncementObj> list;

	private Page page;

	public List<AnnouncementObj> getList()
		{
		return list;
		}

	public void setList(List<AnnouncementObj> list)
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
