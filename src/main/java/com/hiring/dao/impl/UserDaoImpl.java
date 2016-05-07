package com.hiring.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.hiring.bean.User;
import com.hiring.dao.UserDao;

@Repository
public class UserDaoImpl extends BaseDaoImpl<User, Long> implements UserDao
	{

	@SuppressWarnings("unchecked")
	@Override
	public User searchByUserName(String userName)
		{
		Session session = getSession();
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("userName", userName));
		List<User> list = criteria.list();
		if (list == null || list.size() <= 0)
			return null;
		return list.get(0);
		}

	}
