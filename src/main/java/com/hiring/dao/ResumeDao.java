package com.hiring.dao;

import java.util.List;

import com.hiring.bean.Resume;
import com.hiring.bean.User;
import com.hiring.framework.Page;

public interface ResumeDao extends BaseDao<Resume, Long>
	{

	public List<Resume> getByPageByUser(User user, Page page);

	public int getSumByPageByUser(User user);

	public List<Resume> getByPageByUserName(Page page, String name);

	public int countByPageByUserName(String name);
	
	public List<Resume> getResPage(Long recruitId, Page page, String name);

	public int countRes(Long recruitId, String name);
	
	public boolean addAudit(Long recId, String status);
	
	public List<Resume> getByRecId(Long recId);

	}
