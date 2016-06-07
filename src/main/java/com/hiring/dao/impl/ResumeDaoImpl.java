package com.hiring.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.hiring.bean.Recruit;
import com.hiring.bean.Resume;
import com.hiring.bean.User;
import com.hiring.dao.ResumeDao;
import com.hiring.framework.Page;

@Repository
public class ResumeDaoImpl extends BaseDaoImpl<Resume, Long>
		implements ResumeDao
	{

	@SuppressWarnings("unchecked")
	@Override
	public List<Resume> getByPageByUser(User user, Page page)
		{
		Criteria criteria = this.getSession().createCriteria(getEntityClass());
		criteria.add(Restrictions.eq("user", user));
		criteria.setFirstResult((page.getPageNo() - 1) * page.getPageSize());
		criteria.setMaxResults(page.getPageSize());
		return criteria.list();
		}

	@Override
	public int getSumByPageByUser(User user)
		{
		Criteria criteria = this.getSession().createCriteria(getEntityClass());
		criteria.add(Restrictions.eq("user", user));
		return criteria.list() == null ? 0 : criteria.list().size();
		}

	@SuppressWarnings("unchecked")
	@Override
	public List<Resume> getByPageByUserName(Page page, String name)
		{
		Criteria criteria = this.getSession().createCriteria(getEntityClass());
		criteria.add(Restrictions.like("name", "%" + name + "%"));
		criteria.setFirstResult((page.getPageNo() - 1) * page.getPageSize());
		criteria.setMaxResults(page.getPageSize());
		return criteria.list();
		}

	@Override
	public int countByPageByUserName(String name)
		{
		Criteria criteria = this.getSession().createCriteria(getEntityClass());
		criteria.add(Restrictions.like("name", "%" + name + "%"));
		return criteria.list() == null ? 0 : criteria.list().size();
		}

	@SuppressWarnings("unchecked")
	@Override
	public List<Resume> getResPage(Recruit recruit, Page page, String name)
		{

		Criteria criteria = this.getSession().createCriteria(getEntityClass());
		criteria.add(Restrictions.like("name", "%" + name + "%"));
		criteria.add(Restrictions.eq("recruit", recruit));
		criteria.setFirstResult((page.getPageNo() - 1) * page.getPageSize());
		criteria.setMaxResults(page.getPageSize());
		return criteria.list();

		}

	@Override
	public int countRes(Recruit recruit, String name)
		{
		Criteria criteria = this.getSession().createCriteria(getEntityClass());
		criteria.add(Restrictions.like("name", "%" + name + "%"));
		criteria.add(Restrictions.eq("recruit", recruit));
		return criteria.list() == null ? 0 : criteria.list().size();
		}

	@Override
	public boolean addAudit(String recId, String status)
		{
		String hql = "update Resume set status = :status where id = :id";
		Query query = getSession().createQuery(hql);
		query.setParameter("status", status);
		query.setParameter("id", recId);
		return query.executeUpdate() > 0 ? true : false;
		}
	}
