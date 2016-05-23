package com.hiring.bean.obj;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hiring.bean.Theme;

public class ThemeObj
	{

	private Theme theme = new Theme();
	
	private List<ThemeFloorObj> floors;

	public ThemeObj()
		{
		}

	public ThemeObj(Theme theme)
		{
		this.theme = theme;
		}

	@JsonIgnore
	public Theme getTheme()
		{
		return theme;
		}

	public void setTheme(Theme theme)
		{
		this.theme = theme;
		}

	public Long getId()
		{
		return this.theme.getId();
		}

	public void setId(Long id)
		{
		this.theme.setId(id);
		}

	public UserObj getUserobj()
		{
		return new UserObj(this.theme.getUser());
		}

	public void setUserobj(UserObj userobj)
		{
		this.theme.setUser(userobj.getUser());
		}

	public String getTitle()
		{
		return this.theme.getTitle();
		}

	public void setTitle(String title)
		{
		this.theme.setTitle(title);
		}

	public List<ThemeFloorObj> getFloors()
		{
		if(floors == null) return null;
		return floors;
		}
	
	public void setFloors(List<ThemeFloorObj> floors)
		{
		this.floors = floors;
		}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	public Date getInsertDate()
		{
		return this.theme.getInsertDate();
		}

	public void setInsertDate(Date insertDate)
		{
		this.theme.setInsertDate(insertDate);
		}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	public Date getUpdateDate()
		{
		return this.theme.getUpdateDate();
		}

	public void setUpdateDate(Date updateDate)
		{
		this.theme.setUpdateDate(updateDate);
		}

	}
