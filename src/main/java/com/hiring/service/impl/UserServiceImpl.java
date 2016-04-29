package com.hiring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hiring.bean.User;
import com.hiring.bean.obj.UserObj;
import com.hiring.dao.UserDao;
import com.hiring.service.UserService;

@Service (UserService.serv_name)
@Transactional
public class UserServiceImpl extends BaseServiceImpl<User> implements
		UserService
{

	@Autowired
	private UserDao userDao;

	@Override
	public UserObj searchUserById(Long id)
	{
		User user = userDao.get(id);
		return user == null ? new UserObj() : new UserObj(user);
	}

	@Override
	public UserObj searchUserByName(String userName)
	{
		User user = userDao.searchByUserName(userName);
		return user == null ? new UserObj() : new UserObj(user);
	}

	@Override
	public boolean isUserNameExists(String userName)
	{
		User user = userDao.searchByUserName(userName);
		if (user != null && user.getUserName() != null)
			return true;
		return false;
	}

}
