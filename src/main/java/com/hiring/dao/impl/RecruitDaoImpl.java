package com.hiring.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.hiring.bean.Recruit;
import com.hiring.dao.RecruitDao;
import com.hiring.framework.Page;

@Repository
public class RecruitDaoImpl extends BaseDaoImpl<Recruit, Long>
		implements RecruitDao
	{

	@SuppressWarnings("unchecked")
	@Override
	public List<Recruit> getByPositon(Page page, String name)
		{
		Criteria criteria = this.getSession().createCriteria(getEntityClass());
		criteria.add(Restrictions.like("possion", "%" + name + "%"));
		criteria.setFirstResult((page.getPageNo() - 1) * page.getPageSize());
		criteria.setMaxResults(page.getPageSize());
		return criteria.list();
		}

	@Override
	public int countByPositon(String name)
		{
		Criteria criteria = this.getSession().createCriteria(getEntityClass());
		criteria.add(Restrictions.like("possion", "%" + name + "%"));
		return criteria.list() != null ? criteria.list().size() : 0;
		}

	}
