package com.hiring.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.hiring.bean.Theme;
import com.hiring.bean.ThemeFloor;
import com.hiring.dao.ThemeFloorDao;
import com.hiring.framework.Page;

@Repository
public class ThemeFloorDaoImpl extends BaseDaoImpl<ThemeFloor, Long>
		implements ThemeFloorDao
	{

	private String delByThemeHql = "delete ThemeFloor where theme=:theme";

	@SuppressWarnings("unchecked")
	public List<ThemeFloor> getByPageAndNameAndTheme(Page page, String name,
			Theme theme)
		{
		Criteria criteria = this.getSession().createCriteria(getEntityClass());
		criteria.add(Restrictions.eq("theme", theme));
		criteria.add(Restrictions.like("info", "%" + name + "%"));
		criteria.addOrder(Order.desc("updateDate"));
		criteria.setFirstResult((page.getPageNo() - 1) * page.getPageSize());
		criteria.setMaxResults(page.getPageSize());
		return criteria.list();
		}

	public int countByNameAndTheme(String name, Theme theme)
		{
		Criteria criteria = this.getSession().createCriteria(getEntityClass());
		criteria.add(Restrictions.eq("theme", theme));
		criteria.add(Restrictions.like("info", "%" + name + "%"));
		return criteria.list() != null ? criteria.list().size() : 0;
		}

	public void deleteByTheme(Theme theme)
		{
		Session session = this.getSession();
		Query query = session.createQuery(delByThemeHql);
		query.setParameter("theme", theme);
		query.executeUpdate();
		}

	public int countByTheme(Theme theme)
		{
		Criteria criteria = this.getSession().createCriteria(getEntityClass());
		criteria.add(Restrictions.eq("theme", theme));
		return criteria.list() != null ? criteria.list().size() : 0;
		}

	@SuppressWarnings("unchecked")
	public List<ThemeFloor> getByPageAndTheme(Page page, Theme theme)
		{
		Criteria criteria = this.getSession().createCriteria(getEntityClass());
		criteria.add(Restrictions.eq("theme", theme));
		criteria.addOrder(Order.desc("updateDate"));
		criteria.setFirstResult((page.getPageNo() - 1) * page.getPageSize());
		criteria.setMaxResults(page.getPageSize());
		return criteria.list();
		}
	}
