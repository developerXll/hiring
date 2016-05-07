package com.hiring.bean;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.hiring.constants.RecStatus;

/**
 * 招聘信息实体类
 * 
 * @author Administrator
 *
 */
@Entity(name = "t_recruit")
public class Recruit
	{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne(cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "USER_ID", referencedColumnName = "ID")
	private User user;

	@Column(name = "POSITION", nullable = false)
	private String possion;

	@Column(name = "POSSION_INTRODUCTION", columnDefinition = "TEXT")
	private String possionIntroduction;

	@Column(name = "JOB_REQUIREMENT", columnDefinition = "TEXT")
	private String jobRequirement;

	@Column(name = "REC_STATUS", nullable = false)
	@Enumerated(value = EnumType.STRING)
	private RecStatus recStatus;

	@Column(name = "INSERT_TIME", nullable = false, columnDefinition = "DATETIME")
	private Date insertTime;

	@ManyToMany(targetEntity = Resume.class)
	@JoinTable(name = "t_recruit_resume", joinColumns =
		{ @JoinColumn(name = "REC_ID") }, inverseJoinColumns =
		{ @JoinColumn(name = "RES_ID") })
	private Set<Resume> resumes;

	public Long getId()
		{
		return id;
		}

	public void setId(Long id)
		{
		this.id = id;
		}

	public User getUser()
		{
		return user;
		}

	public void setUser(User user)
		{
		this.user = user;
		}

	public String getPossion()
		{
		return possion;
		}

	public void setPossion(String possion)
		{
		this.possion = possion;
		}

	public String getPossionIntroduction()
		{
		return possionIntroduction;
		}

	public void setPossionIntroduction(String possionIntroduction)
		{
		this.possionIntroduction = possionIntroduction;
		}

	public String getJobRequirement()
		{
		return jobRequirement;
		}

	public void setJobRequirement(String jobRequirement)
		{
		this.jobRequirement = jobRequirement;
		}

	public RecStatus getRecStatus()
		{
		return recStatus;
		}

	public void setRecStatus(RecStatus recStatus)
		{
		this.recStatus = recStatus;
		}

	public Date getInsertTime()
		{
		return insertTime;
		}

	public void setInsertTime(Date insertTime)
		{
		this.insertTime = insertTime;
		}

	public Set<Resume> getResumes()
		{
		return resumes;
		}

	public void setResumes(Set<Resume> resumes)
		{
		this.resumes = resumes;
		}
	}
