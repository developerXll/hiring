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
 * 
 * 论坛主题
 * 
 * @author Administrator
 *
 */

@Entity(name = "t_theme")
public class Theme
	{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne(cascade = CascadeType.PERSIST, optional = false)
	@JoinColumn(name = "USER_ID", referencedColumnName = "ID")
	private User user;

	@Column(name = "TITLE", nullable = false, updatable = false)
	private String title;

	@Column(name = "INSERT_TIME", nullable = false, columnDefinition = "DATETIME", updatable = false)
	private Date insertDate;

	@Column(name = "UPDATE_TIME", nullable = false, columnDefinition = "DATETIME", updatable = false)
	private Date updateDate;

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

	public String getTitle()
		{
		return title;
		}

	public void setTitle(String title)
		{
		this.title = title;
		}

	public Date getInsertDate()
		{
		return insertDate;
		}

	public void setInsertDate(Date insertDate)
		{
		this.insertDate = insertDate;
		}

	public Date getUpdateDate()
		{
		return updateDate;
		}

	public void setUpdateDate(Date updateDate)
		{
		this.updateDate = updateDate;
		}
	}
