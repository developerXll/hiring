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
 * 论坛回复信息
 * 
 * @author Administrator
 *
 */

@Entity(name = "t_theme_floor")
public class ThemeFloor
	{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne(cascade =
		{ CascadeType.PERSIST }, optional = false)
	@JoinColumn(name = "THEME_ID", referencedColumnName = "ID")
	private Theme theme;

	@ManyToOne(cascade =
		{ CascadeType.PERSIST }, optional = false)
	@JoinColumn(name = "USER_ID", referencedColumnName = "ID")
	private User user;

	@Column(name = "INFO", nullable = false, updatable = false)
	private String info;

	@Column(name = "FLOOR_NUM", nullable = false, columnDefinition = "INT", updatable = false)
	private int floorNum;

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

	public Theme getTheme()
		{
		return theme;
		}

	public void setTheme(Theme theme)
		{
		this.theme = theme;
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

	public int getFloorNum()
		{
		return floorNum;
		}

	public void setFloorNum(int floorNum)
		{
		this.floorNum = floorNum;
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
