package com.hiring.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.hiring.bean.Announcement;
import com.hiring.dao.AnnouncementDao;
import com.hiring.framework.Page;

@Repository
public class AnnouncementDaoImpl extends BaseDaoImpl<Announcement, Long>
		implements AnnouncementDao
	{

	@SuppressWarnings("unchecked")
	@Override
	public List<Announcement> getByTitle(Page page, String name)
		{
		Criteria criteria = this.getSession().createCriteria(getEntityClass());
		criteria.add(Restrictions.like("title", "%" + name + "%"));
		criteria.setFirstResult((page.getPageNo() - 1) * page.getPageSize());
		criteria.setMaxResults(page.getPageSize());
		return criteria.list();
		}

	@Override
	public int getSizeByTitle(String name)
		{
		Criteria criteria = this.getSession().createCriteria(getEntityClass());
		criteria.add(Restrictions.like("title", "%" + name + "%"));
		return criteria.list() != null ? criteria.list().size() : 0;
		}

	}
