package com.hiring.service;

import java.util.List;

import com.hiring.bean.Announcement;
import com.hiring.bean.obj.AnnouncementObj;
import com.hiring.framework.Page;

public interface AnnouncementService extends BaseService<Announcement>
{

	String serv_name = "announcementService";

	List<AnnouncementObj> findPageObj(Page page);

}
