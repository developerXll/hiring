package com.hiring.dao;

import java.util.List;

import com.hiring.bean.Recruit;
import com.hiring.framework.Page;

public interface RecruitDao extends BaseDao<Recruit, Long>
	{

	public List<Recruit> getByPositon(Page page, String name);

	public int countByPositon(String name);

	}
