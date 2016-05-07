package com.hiring.bean.obj;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hiring.bean.Announcement;

/**
 * 公告
 * 
 * @author Administrator
 *
 */
public class AnnouncementObj
	{

	private Announcement announcement = new Announcement();

	public AnnouncementObj()
		{

		}

	public AnnouncementObj(Announcement announcement)
		{
		this.announcement = announcement;
		}

	@JsonIgnore
	public Announcement getAnnouncement()
		{
		return announcement;
		}

	public void setAnnouncement(Announcement announcement)
		{
		this.announcement = announcement;
		}

	public long getId()
		{
		return this.announcement.getId();
		}

	public void setId(long id)
		{
		this.announcement.setId(id);
		}

	public String getTitle()
		{
		return this.announcement.getTitle();
		}

	public void setTitle(String title)
		{
		this.announcement.setTitle(title);
		}

	public String getAnnInfo()
		{
		return this.announcement.getAnnInfo();
		}

	public void setAnnInfo(String annInfo)
		{
		this.announcement.setAnnInfo(annInfo);
		}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	public Date getInsertTime()
		{
		return this.announcement.getInsertTime();
		}

	public void setInsertTime(Date insertTime)
		{
		this.announcement.setInsertTime(insertTime);
		}

	public UserObj getUser()
		{
		return this.announcement.getUser() == null ? null
				: new UserObj(this.announcement.getUser());
		}

	public void setUser(UserObj user)
		{
		this.announcement.setUser(user.getUser());
		}

	}
