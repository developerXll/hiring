package com.hiring.dao;

import java.util.List;

import com.hiring.bean.Announcement;
import com.hiring.framework.Page;

public interface AnnouncementDao extends BaseDao<Announcement, Long>
	{

	List<Announcement> getByTitle(Page page, String name);

	int getSizeByTitle(String name);

	}
