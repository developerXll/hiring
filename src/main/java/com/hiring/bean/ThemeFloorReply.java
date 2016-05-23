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

@Entity(name = "t_theme_floor_reply")
public class ThemeFloorReply
	{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne(cascade =
		{ CascadeType.PERSIST }, optional = false)
	@JoinColumn(name = "THEME_FLOOR_ID", referencedColumnName = "ID")
	private ThemeFloor floor;

	@ManyToOne(cascade = CascadeType.PERSIST, optional = false)
	@JoinColumn(name = "USER_ID", referencedColumnName = "ID")
	private User user;

	@Column(name = "INFO", nullable = false, updatable = false)
	private String info;

	@Column(name = "INSERT_TIME", nullable = false, columnDefinition = "DATETIME", updatable = false)
	private Date insertDate;

	public Long getId()
		{
		return id;
		}

	public void setId(Long id)
		{
		this.id = id;
		}

	public ThemeFloor getFloor()
		{
		return floor;
		}

	public void setFloor(ThemeFloor floor)
		{
		this.floor = floor;
		}

	public User getUser()
		{
		return user;
		}

	public void setUser(User user)
		{
		this.user = user;
		}

	public String getInfo()
		{
		return info;
		}

	public void setInfo(String info)
		{
		this.info = info;
		}

	public Date getInsertDate()
		{
		return insertDate;
		}

	public void setInsertDate(Date insertDate)
		{
		this.insertDate = insertDate;
		}

	}
