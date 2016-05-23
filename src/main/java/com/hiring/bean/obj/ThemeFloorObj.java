package com.hiring.bean.obj;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hiring.bean.ThemeFloor;

public class ThemeFloorObj
	{

	private ThemeFloor floor = new ThemeFloor();

	public ThemeFloorObj()
		{
		}

	public ThemeFloorObj(ThemeFloor floor)
		{
		this.floor = floor;
		}

	@JsonIgnore
	public ThemeFloor getFloor()
		{
		return floor;
		}

	public void setFloor(ThemeFloor floor)
		{
		this.floor = floor;
		}

	public Long getId()
		{
		return this.floor.getId();
		}

	public void setId(Long id)
		{
		this.floor.setId(id);
		}

	public UserObj getUserObj()
		{
		return new UserObj(this.floor.getUser());
		}

	public void setUser(UserObj userObj)
		{
		this.floor.setUser(userObj.getUser());
		}

	@JsonIgnore
	public ThemeObj getThemeObj()
		{
		return new ThemeObj(this.floor.getTheme());
		}

	public void setThemeObj(ThemeObj themeObj)
		{
		this.floor.setTheme(themeObj.getTheme());
		}

	public String getInfo()
		{
		return this.floor.getInfo();
		}

	public void setInfo(String info)
		{
		this.floor.setInfo(info);
		}

	public Integer getFloorNum()
		{
		return this.floor.getFloorNum();
		}

	public void setFloorNum(Integer floorNum)
		{
		this.floor.setFloorNum(floorNum);
		}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	public Date getInsertDate()
		{
		return this.floor.getInsertDate();
		}

	public void setInsertDate(Date insertDate)
		{
		this.floor.setInsertDate(insertDate);
		}

	}
