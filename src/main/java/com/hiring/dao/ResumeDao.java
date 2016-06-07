package com.hiring.dao;

import java.util.List;

import com.hiring.bean.Recruit;
import com.hiring.bean.Resume;
import com.hiring.bean.User;
import com.hiring.framework.Page;

public interface ResumeDao extends BaseDao<Resume, Long>
	{

	public List<Resume> getByPageByUser(User user, Page page);

	public int getSumByPageByUser(User user);

	public List<Resume> getByPageByUserName(Page page, String name);

	public int countByPageByUserName(String name);
	
	public List<Resume> getResPage(Recruit recruit, Page page, String name);

	public int countRes(Recruit recruit, String name);
	
	public boolean addAudit(String recId, String status);

	}
