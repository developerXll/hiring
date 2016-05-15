package com.hiring.controller;

import java.util.List;

import com.hiring.bean.obj.RecruitObj;
import com.hiring.framework.Page;

public class RecruitListData
	{

	private List<RecruitObj> list;

	private Page page;

	public List<RecruitObj> getList()
		{
		return list;
		}

	public void setList(List<RecruitObj> list)
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
