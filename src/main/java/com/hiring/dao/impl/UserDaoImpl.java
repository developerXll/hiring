package com.hiring.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.hiring.bean.User;
import com.hiring.constants.UserType;
import com.hiring.dao.UserDao;
import com.hiring.framework.Page;

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

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findPageByUserName(Page page, String userName,
			boolean isApp)
		{
		Criteria criteria = getSession().createCriteria(User.class);
		criteria.add(Restrictions.like("userName", "%" + userName + "%"));
		if (isApp)
			criteria.add(
					Restrictions.eq("userType", UserType.RECRUITER.toString()));
		criteria.setFirstResult((page.getPageNo() - 1) * page.getPageSize());
		criteria.setMaxResults(page.getPageSize());
		return criteria.list();
		}

	@Override
	public int countByUserName(String userName, boolean isApp)
		{
		Criteria criteria = getSession().createCriteria(User.class);
		criteria.add(Restrictions.like("userName", "%" + userName + "%"));
		if (isApp)
			criteria.add(
					Restrictions.eq("userType", UserType.RECRUITER.toString()));
		return criteria.list() != null ? criteria.list().size() : 0;
		}

	}
