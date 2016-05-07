package com.hiring.service;

import com.hiring.bean.User;
import com.hiring.bean.obj.UserObj;

public interface UserService extends BaseService<User>
	{

	String serv_name = "userService";

	UserObj searchUserById(Long id);

	UserObj searchUserByName(String userName);

	boolean isUserNameExists(String userName);
	}
