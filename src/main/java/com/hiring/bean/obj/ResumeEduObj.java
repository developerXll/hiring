package com.hiring.bean.obj;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hiring.bean.ResumeEdu;

/**
 * 简历教育经历信息
 * 
 * @author Administrator
 *
 */
public class ResumeEduObj
	{

	private ResumeEdu resumeEdu = new ResumeEdu();

	public ResumeEduObj()
		{

		}

	public ResumeEduObj(ResumeEdu resumeEdu)
		{
		this.resumeEdu = resumeEdu;
		}

	@JsonIgnore
	public ResumeEdu getResumeEdu()
		{
		return resumeEdu;
		}

	public void setResumeEdu(ResumeEdu resumeEdu)
		{
		this.resumeEdu = resumeEdu;
		}

	public Long getId()
		{
		return this.resumeEdu.getId();
		}

	public void setId(Long id)
		{
		this.resumeEdu.setId(id);
		}

	public String getSchoolName()
		{
		return this.resumeEdu.getSchoolName();
		}

	public void setSchoolName(String schoolName)
		{
		this.resumeEdu.setSchoolName(schoolName);
		}

	public String getEducation()
		{
		return this.resumeEdu.getEducation();
		}

	public void setEducation(String education)
		{
		this.resumeEdu.setEducation(education);
		}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	public Date getStartTime()
		{
		return this.resumeEdu.getStartTime();
		}

	public void setStartTime(Date startTime)
		{
		this.resumeEdu.setStartTime(startTime);
		}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	public Date getEndTime()
		{
		return this.resumeEdu.getEndTime();
		}

	public void setEndTime(Date endTime)
		{
		this.resumeEdu.setEndTime(endTime);
		}

	}
