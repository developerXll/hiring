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
 * 简历工作经历实体类
 * 
 * @author Administrator
 *
 */

@Entity (name = "t_resume_occ")
public class ResumeOcc
{

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne (cascade = CascadeType.ALL, optional = false)
	@JoinColumn (name = "RESUME_ID", referencedColumnName = "ID")
	private Resume resume;

	@Column (name = "COMPANY_NAME", nullable = false)
	private String companyName;

	@Column (name = "COMPANY_TYPE")
	private String companyType;

	@Column (name = "POSITION", nullable = false)
	private String possion;

	@Column (name = "WORK_INTRODUCTION", columnDefinition = "TEXT")
	private String workIntroduction;

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

	public String getCompanyName()
	{
		return companyName;
	}

	public void setCompanyName(String companyName)
	{
		this.companyName = companyName;
	}

	public String getCompanyType()
	{
		return companyType;
	}

	public void setCompanyType(String companyType)
	{
		this.companyType = companyType;
	}

	public String getPossion()
	{
		return possion;
	}

	public void setPossion(String possion)
	{
		this.possion = possion;
	}

	public String getWorkIntroduction()
	{
		return workIntroduction;
	}

	public void setWorkIntroduction(String workIntroduction)
	{
		this.workIntroduction = workIntroduction;
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
