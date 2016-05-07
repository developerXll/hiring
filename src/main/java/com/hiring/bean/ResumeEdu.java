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
 * 简历教育信息实体类
 * 
 * @author Administrator
 *
 */
@Entity(name = "t_resume_edu")
public class ResumeEdu
	{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne(cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "RESUME_ID", referencedColumnName = "ID")
	private Resume resume;

	@Column(name = "SCHOOL_NAME", nullable = false)
	private String schoolName;

	@Column(name = "EDUCATION", nullable = false)
	private String education;

	@Column(name = "START_TIME", nullable = false, columnDefinition = "DATETIME")
	private Date startTime;

	@Column(name = "END_TIME", nullable = false, columnDefinition = "DATETIME")
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

	public String getSchoolName()
		{
		return schoolName;
		}

	public void setSchoolName(String schoolName)
		{
		this.schoolName = schoolName;
		}

	public String getEducation()
		{
		return education;
		}

	public void setEducation(String education)
		{
		this.education = education;
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
