package com.hiring.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.hiring.bean.User;
import com.hiring.constants.UserStatus;
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
		criteria.add(Restrictions.eq("status", UserStatus.ACTIVE));
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
					Restrictions.eq("userType", UserType.RECRUITER));
		criteria.add(Restrictions.eq("status", UserStatus.ACTIVE));
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
					Restrictions.eq("userType", UserType.RECRUITER));
		criteria.add(Restrictions.eq("status", UserStatus.ACTIVE));
		return criteria.list() != null ? criteria.list().size() : 0;
		}
	
	@Override
	public boolean delUser(Long id)
		{
		String sql = "update t_user set USER_STATUS = '" + UserStatus.DELETED.toString() + "' where id = ?";
		Query query = getSession().createSQLQuery(sql);
		query.setParameter(0, id);
		return query.executeUpdate() > 0 ? true : false;
		}

	}
