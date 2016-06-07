package com.hiring.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

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
	public List<Resume> getResPage(Long recruitId, Page page, String name)
		{

		Criteria criteria = this.getSession().createCriteria(getEntityClass());
		criteria.add(Restrictions.like("name", "%" + name + "%"));
		criteria.add(Restrictions.eq("recruitId", recruitId));
		criteria.setFirstResult((page.getPageNo() - 1) * page.getPageSize());
		criteria.setMaxResults(page.getPageSize());
		return criteria.list();

		}

	@Override
	public int countRes(Long recruitId, String name)
		{
		Criteria criteria = this.getSession().createCriteria(getEntityClass());
		criteria.add(Restrictions.like("name", "%" + name + "%"));
		criteria.add(Restrictions.eq("recruitId", recruitId));
		return criteria.list() == null ? 0 : criteria.list().size();
		}

	@Override
	public boolean addAudit(Long recId, String status)
		{
		String hql = "update t_resume set STATUS = ? where id = ?";
		Query query = getSession().createSQLQuery(hql);
		query.setParameter(0, status);
		query.setParameter(1, recId);
		return query.executeUpdate() > 0 ? true : false;
		}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Resume> getByRecId(Long recId)
		{
		Criteria criteria = this.getSession().createCriteria(getEntityClass());
		criteria.add(Restrictions.eq("recruitId", recId));
		return criteria.list();
		}
	}
