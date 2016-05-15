package com.hiring.controller;

import java.util.List;

import com.hiring.bean.obj.ResumeObj;
import com.hiring.framework.Page;

public class ResumeListData
	{

	private List<ResumeObj> list;

	private Page page;

	public List<ResumeObj> getList()
		{
		return list;
		}

	public void setList(List<ResumeObj> list)
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
