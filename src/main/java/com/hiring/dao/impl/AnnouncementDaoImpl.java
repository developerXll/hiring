package com.hiring.dao.impl;

import org.springframework.stereotype.Repository;

import com.hiring.bean.Announcement;
import com.hiring.dao.AnnouncementDao;

@Repository
public class AnnouncementDaoImpl extends BaseDaoImpl<Announcement, Long>
		implements AnnouncementDao
{

}
