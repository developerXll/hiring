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
 * 简历项目经验实体类
 * 
 * @author Administrator
 *
 */

@Entity (name = "t_resume_pro")
public class ResumePro
{

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne (cascade = CascadeType.ALL, optional = false)
	@JoinColumn (name = "RESUME_ID", referencedColumnName = "ID")
	private Resume resume;

	@Column (name = "PROJECT_NAME", nullable = false)
	private String projectName;

	@Column (name = "POSITION", nullable = false)
	private String possion;

	@Column (name = "PROJECT_INTRODUCTION", columnDefinition = "TEXT")
	private String projectIntroduction;

	@Column (name = "START_TIME", nullable = false,
				columnDefinition = "DATETIME")
	private Date startTime;

	@Column (name = "END_TIME", nullable = false, columnDefinition = "DATETIME")
	private Date endTime;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public Resume getResume()
	{
		return resume;
	}

	public void setResume(Resume resume)
	{
		this.resume = resume;
	}

	public String getProjectName()
	{
		return projectName;
	}

	public void setProjectName(String projectName)
	{
		this.projectName = projectName;
	}

	public String getPossion()
	{
		return possion;
	}

	public void setPossion(String possion)
	{
		this.possion = possion;
	}

	public String getProjectIntroduction()
	{
		return projectIntroduction;
	}

	public void setProjectIntroduction(String projectIntroduction)
	{
		this.projectIntroduction = projectIntroduction;
	}

	public Date getStartTime()
	{
		return startTime;
	}

	public void setStartTime(Date startTime)
	{
		this.startTime = startTime;
	}

	public Date getEndTime()
	{
		return endTime;
	}

	public void setEndTime(Date endTime)
	{
		this.endTime = endTime;
	}

}
