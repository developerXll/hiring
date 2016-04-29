package com.hiring.bean.obj;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hiring.bean.Recruit;
import com.hiring.bean.Resume;
import com.hiring.constants.RecStatus;

/**
 * 招聘信息对象
 * 
 * @author Administrator
 *
 */
public class RecruitObj
{

	private Recruit recruit = new Recruit();

	public RecruitObj( )
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
		return this.recruit.getUser() == null ? null : new UserObj(
				this.recruit.getUser());
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
		return this.recruit.getRecStatus().toString();
	}

	public void setRecStatus(String recStatus)
	{
		this.recruit.setRecStatus(RecStatus.valueOf(recStatus));
	}

	@JsonFormat (pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	public Date getInsertTime()
	{
		return this.recruit.getInsertTime();
	}

	public void setInsertTime(Date insertTime)
	{
		this.recruit.setInsertTime(insertTime);
	}

	public Set<ResumeObj> getResumes()
	{
		Set<ResumeObj> objs = new HashSet<ResumeObj>();
		if (this.recruit.getResumes() != null
				&& this.recruit.getResumes().size() > 0)
		{
			for (Resume resume : this.recruit.getResumes())
			{
				objs.add(new ResumeObj(resume));
			}

		}
		return objs;
	}

	public Set<UserObj> getApplicants()
	{
		Set<UserObj> users = new HashSet<UserObj>();
		if (this.recruit.getResumes() != null
				&& this.recruit.getResumes().size() > 0)
		{
			for (Resume resume : this.recruit.getResumes())
			{
				users.add(new UserObj(resume.getUser()));
			}
		}
		return users;
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
