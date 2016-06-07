package com.hiring.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hiring.bean.User;
import com.hiring.bean.obj.UserObj;
import com.hiring.dao.UserDao;
import com.hiring.framework.Page;
import com.hiring.service.UserService;

@Service(UserService.serv_name)
@Transactional
public class UserServiceImpl extends BaseServiceImpl<User>
		implements UserService
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

	@Override
	public List<UserObj> findPageByUserName(Page page, String userName,
			boolean isApp)
		{
		List<User> users = userDao.findPageByUserName(page, userName, isApp);
		List<UserObj> objs = new ArrayList<UserObj>();
		for (User user : users)
			{
			objs.add(new UserObj(user));
			}
		return objs;
		}

	@Override
	public int countByUserName(String userName, boolean isApp)
		{
		return userDao.countByUserName(userName, isApp);
		}

	}
