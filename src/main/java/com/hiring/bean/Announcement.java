package com.hiring.bean;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * 公告信息实体类
 * 
 * @author Administrator
 *
 */
@Entity (name = "t_announcement")
public class Announcement
{

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne (cascade = CascadeType.ALL, optional = false)
	@JoinColumn (name = "USER_ID", referencedColumnName = "ID")
	private User user;

	@Column (name = "TITLE", nullable = false)
	private String title;

	@Column (name = "ANN_INFO", columnDefinition = "TEXT")
	private String annInfo;

	@Column (name = "INSERT_TIME", nullable = false,
				columnDefinition = "DATETIME")
	private Date insertTime;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public User getUser()
	{
		return user;
	}

	public void setUser(User user)
	{
		this.user = user;
	}

	public String getAnnInfo()
	{
		return annInfo;
	}

	public void setAnnInfo(String annInfo)
	{
		this.annInfo = annInfo;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public Date getInsertTime()
	{
		return insertTime;
	}

	public void setInsertTime(Date insertTime)
	{
		this.insertTime = insertTime;
	}
}
