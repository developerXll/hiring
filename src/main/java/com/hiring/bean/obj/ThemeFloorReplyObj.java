package com.hiring.bean.obj;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hiring.bean.ThemeFloorReply;

public class ThemeFloorReplyObj
	{

	private ThemeFloorReply reply = new ThemeFloorReply();

	public ThemeFloorReplyObj()
		{
		}

	public ThemeFloorReplyObj(ThemeFloorReply reply)
		{
		this.reply = reply;
		}

	@JsonIgnore
	public ThemeFloorReply getReply()
		{
		return reply;
		}

	public void setReply(ThemeFloorReply reply)
		{
		this.reply = reply;
		}

	public UserObj getUserObj()
		{
		return new UserObj(this.reply.getUser());
		}

	public void setUserObj(UserObj userObj)
		{
		this.reply.setUser(userObj.getUser());
		}

	public ThemeFloorObj getFloor()
		{
		return new ThemeFloorObj(this.reply.getFloor());
		}

	public void setFloor(ThemeFloorObj floor)
		{
		this.reply.setFloor(floor.getFloor());
		}

	public String getInfo()
		{
		return this.reply.getInfo();
		}

	public void setInfo(String info)
		{
		this.reply.setInfo(info);
		}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	public Date getInsertDate()
		{
		return this.reply.getInsertDate();
		}

	public void setInsertDate(Date insertDate)
		{
		this.reply.setInsertDate(insertDate);
		}
	}
