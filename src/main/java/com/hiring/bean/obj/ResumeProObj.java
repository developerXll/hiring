package com.hiring.bean.obj;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hiring.bean.ResumePro;

/**
 * 简历项目经验实体类
 * 
 * @author Administrator
 *
 */

public class ResumeProObj
{

	private ResumePro resumePro = new ResumePro();

	public ResumeProObj( )
	{

	}

	public ResumeProObj(ResumePro resumePro)
	{
		this.resumePro = resumePro;
	}

	@JsonIgnore
	public ResumePro getResumePro()
	{
		return resumePro;
	}

	public void setResumePro(ResumePro resumePro)
	{
		this.resumePro = resumePro;
	}

	public Long getId()
	{
		return this.resumePro.getId();
	}

	public void setId(Long id)
	{
		this.resumePro.setId(id);
	}

	public String getProjectName()
	{
		return this.resumePro.getProjectName();
	}

	public void setProjectName(String projectName)
	{
		this.resumePro.setProjectName(projectName);
	}

	public String getPossion()
	{
		return this.resumePro.getPossion();
	}

	public void setPossion(String possion)
	{
		this.resumePro.setPossion(possion);
	}

	public String getProjectIntroduction()
	{
		return this.resumePro.getProjectIntroduction();
	}

	public void setProjectIntroduction(String projectIntroduction)
	{
		this.resumePro.setProjectIntroduction(projectIntroduction);
	}

	@JsonFormat (pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	public Date getStartTime()
	{
		return this.resumePro.getStartTime();
	}

	public void setStartTime(Date startTime)
	{
		this.resumePro.setStartTime(startTime);
	}

	@JsonFormat (pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	public Date getEndTime()
	{
		return this.resumePro.getEndTime();
	}

	public void setEndTime(Date endTime)
	{
		this.resumePro.setEndTime(endTime);
	}

}
