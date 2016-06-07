package com.hiring.dao;

import java.util.List;

import com.hiring.bean.User;
import com.hiring.framework.Page;

public interface UserDao extends BaseDao<User, Long>
	{

	User searchByUserName(String userName);
	
	List<User> findPageByUserName(Page page, String userName, boolean isApp);

	int countByUserName(String userName, boolean isApp);

	}
