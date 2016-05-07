package com.hiring.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hiring.bean.Announcement;
import com.hiring.bean.obj.AnnouncementObj;
import com.hiring.framework.Page;
import com.hiring.service.AnnouncementService;

@Service(AnnouncementService.serv_name)
@Transactional
public class AnnouncementServiceImpl extends BaseServiceImpl<Announcement>
		implements AnnouncementService
	{

	@Override
	public List<AnnouncementObj> findPageObj(Page page)
		{
		List<Announcement> anns = this.loadPage(page);
		List<AnnouncementObj> annObjs = new ArrayList<AnnouncementObj>();
		if (anns != null && anns.size() > 0)
			{
			for (Announcement ann : anns)
				{
				annObjs.add(new AnnouncementObj(ann));
				}
			}
		return annObjs;
		}

	}
