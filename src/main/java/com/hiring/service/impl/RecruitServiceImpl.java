package com.hiring.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hiring.bean.Recruit;
import com.hiring.bean.obj.RecruitObj;
import com.hiring.dao.RecruitDao;
import com.hiring.framework.Page;
import com.hiring.service.RecruitService;

@Service(RecruitService.serv_name)
@Transactional
public class RecruitServiceImpl extends BaseServiceImpl<Recruit>
		implements RecruitService
	{

	@Autowired
	private RecruitDao recDao;

	@Override
	public List<RecruitObj> findPageObj(Page page)
		{
		List<Recruit> recs = this.loadPage(page);
		List<RecruitObj> recObjs = new ArrayList<RecruitObj>();
		if (recs != null && recs.size() > 0)
			{
			for (Recruit rec : recs)
				{
				recObjs.add(new RecruitObj(rec));
				}
			}
		return recObjs;
		}

	@Override
	public List<RecruitObj> findPageObjByName(Page page, String name)
		{
		List<Recruit> recs = recDao.getByPositon(page, name);
		List<RecruitObj> recObjs = new ArrayList<RecruitObj>();
		if (recs != null && recs.size() > 0)
			{
			for (Recruit rec : recs)
				{
				recObjs.add(new RecruitObj(rec));
				}
			}
		return recObjs;
		}

	@Override
	public int countObjByName(String name)
		{
		return recDao.countByPositon(name);
		}

	}
