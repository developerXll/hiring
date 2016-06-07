package com.hiring.bean.obj;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hiring.bean.Recruit;
import com.hiring.constants.RecStatus;

/**
 * 招聘信息
 * 
 * @author Administrator
 *
 */
public class RecruitObj
	{

	private Recruit recruit = new Recruit();
	private List<ResumeObj> resumes;
	private List<UserObj> applicants;

	public RecruitObj()
		{

		}

	public RecruitObj(Recruit recruit)
		{
		this.recruit = recruit;
		}

	public Long getId()
		{
		return this.recruit.getId();
		}

	public void setId(Long id)
		{
		this.recruit.setId(id);
		}

	public UserObj getPublisher()
		{
		return this.recruit.getUser() == null ? null
				: new UserObj(this.recruit.getUser());
		}

	public void setPublisher(UserObj publisher)
		{
		this.recruit.setUser(publisher.getUser());
		}

	public String getPossion()
		{
		return this.recruit.getPossion();
		}

	public void setPossion(String possion)
		{
		this.recruit.setPossion(possion);
		}

	public String getPay()
		{
		return this.recruit.getPay();
		}

	public void setPay(String pay)
		{
		this.recruit.setPay(pay);
		}
	
	public String getPayMonths()
		{
		return this.recruit.getPayMonths();
		}

	public void setPayMonths(String payMonths)
		{
		this.recruit.setPayMonths(payMonths);
		}

	public String getPossionIntroduction()
		{
		return this.recruit.getPossionIntroduction();
		}

	public void setPossionIntroduction(String possionIntroduction)
		{
		this.recruit.setPossionIntroduction(possionIntroduction);
		}

	public String getJobRequirement()
		{
		return this.recruit.getJobRequirement();
		}

	public void setJobRequirement(String jobRequirement)
		{
		this.recruit.setJobRequirement(jobRequirement);
		}

	public String getRecStatus()
		{
		return this.recruit.getRecStatus() != null ? this.recruit.getRecStatus().toString() : null;
		}

	public void setRecStatus(String recStatus)
		{
		if(recStatus != null) this.recruit.setRecStatus(RecStatus.valueOf(recStatus));
		}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	public Date getInsertTime()
		{
		return this.recruit.getInsertTime();
		}

	public void setInsertTime(Date insertTime)
		{
		this.recruit.setInsertTime(insertTime);
		}

	public List<ResumeObj> getResumes()
		{
		return resumes;
		}
	
	public void setResumes(List<ResumeObj> resumes)
		{
		this.resumes = resumes;
		}

	public List<UserObj> getApplicants()
		{
		return applicants;
		}
	
	public void setApplicants(List<UserObj> applicants)
		{
		this.applicants = applicants;
		}

	@JsonIgnore
	public Recruit getRecruit()
		{
		return recruit;
		}

	public void setRecruit(Recruit recruit)
		{
		this.recruit = recruit;
		}

	}
