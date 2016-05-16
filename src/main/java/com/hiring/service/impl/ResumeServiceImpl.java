package com.hiring.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hiring.bean.Recruit;
import com.hiring.bean.Resume;
import com.hiring.bean.obj.ResumeObj;
import com.hiring.bean.obj.UserObj;
import com.hiring.dao.RecruitDao;
import com.hiring.dao.ResumeDao;
import com.hiring.framework.Page;
import com.hiring.service.ResumeService;

@Service(ResumeService.serv_name)
@Transactional
public class ResumeServiceImpl extends BaseServiceImpl<Resume>
		implements ResumeService
	{

	@Autowired
	private ResumeDao resumeDao;

	@Autowired
	private RecruitDao recruitDao;

	@Override
	public List<ResumeObj> findPageObj(Page page)
		{
		List<Resume> ress = this.loadPage(page);
		List<ResumeObj> resObjs = new ArrayList<ResumeObj>();
		if (ress != null && ress.size() > 0)
			{
			for (Resume res : ress)
				{
				resObjs.add(new ResumeObj(res));
				}
			}
		return resObjs;
		}

	@Override
	public List<ResumeObj> findPageObjByUser(UserObj userObj, Page page)
		{
		List<Resume> ress = resumeDao.getByPageByUser(userObj.getUser(), page);
		List<ResumeObj> resObjs = new ArrayList<ResumeObj>();
		if (ress != null && ress.size() > 0)
			{
			for (Resume res : ress)
				{
				resObjs.add(new ResumeObj(res));
				}
			}
		return resObjs;
		}

	@Override
	public int findPageNumObjByUser(UserObj userObj)
		{
		return resumeDao.getSumByPageByUser(userObj.getUser());
		}

	@Override
	public List<ResumeObj> findPageObjByUserName(String userName, Page page)
		{
		List<Resume> ress = resumeDao.getByPageByUserName(page, userName);
		List<ResumeObj> resObjs = new ArrayList<ResumeObj>();
		if (ress != null && ress.size() > 0)
			{
			for (Resume res : ress)
				{
				resObjs.add(new ResumeObj(res));
				}
			}
		return resObjs;
		}

	@Override
	public int findPageNumObjByUserName(String userName)
		{
		return resumeDao.countByPageByUserName(userName);
		}

	@Override
	public boolean addDeliver(String recId, String resId)
		{
		Resume res = resumeDao.load(resId);
		Recruit rec = recruitDao.load(recId);
		if (rec == null)
			return false;
		Set<Recruit> recs = res.getRecruits();
		if (recs == null || recs.size() <= 0)
			{
			recs = new HashSet<Recruit>();
			}
		else
			{
			if (recs.contains(rec))
				return false;
			}
		recs.add(rec);
		res.setRecruits(recs);
		resumeDao.save(res);
		return true;
		}

	}
