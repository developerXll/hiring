package com.hiring.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.hiring.bean.Theme;
import com.hiring.dao.ThemeDao;
import com.hiring.framework.Page;

@Repository
public class ThemeDaoImpl extends BaseDaoImpl<Theme, Long> implements ThemeDao
	{

	@SuppressWarnings("unchecked")
	public List<Theme> getByPageByName(Page page, String name)
		{
		Criteria criteria = this.getSession().createCriteria(getEntityClass());
		criteria.add(Restrictions.like("title", "%" + name + "%"));
		criteria.addOrder(Order.desc("updateDate"));
		criteria.setFirstResult((page.getPageNo() - 1) * page.getPageSize());
		criteria.setMaxResults(page.getPageSize());
		return criteria.list();
		}
	}
