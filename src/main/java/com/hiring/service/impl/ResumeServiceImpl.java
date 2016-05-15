package com.hiring.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hiring.bean.Resume;
import com.hiring.bean.obj.ResumeObj;
import com.hiring.bean.obj.UserObj;
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

	}
