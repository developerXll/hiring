package com.hiring.service;

import java.util.List;

import com.hiring.bean.User;
import com.hiring.bean.obj.UserObj;
import com.hiring.framework.Page;

public interface UserService extends BaseService<User>
	{

	String serv_name = "userService";

	UserObj searchUserById(Long id);

	UserObj searchUserByName(String userName);

	boolean isUserNameExists(String userName);

	List<UserObj> findPageByUserName(Page page, String userName, boolean isApp);

	int countByUserName(String userName, boolean isApp);
	
	boolean delUser(String userId);
	}
