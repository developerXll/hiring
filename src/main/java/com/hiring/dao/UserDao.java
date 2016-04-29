package com.hiring.dao;

import com.hiring.bean.User;

public interface UserDao extends BaseDao<User, Long>
{
	User searchByUserName(String userName);

}
