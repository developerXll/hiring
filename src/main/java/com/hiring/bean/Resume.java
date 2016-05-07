package com.hiring.bean;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.hiring.constants.Gender;

/**
 * 简历信息实体类
 * 
 * @author Administrator
 *
 */
@Entity(name = "t_resume")
public class Resume
	{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne(cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "USER_ID", referencedColumnName = "ID")
	private User user;

	@Column(name = "NAME", nullable = false)
	private String name;

	@Column(name = "GENDER", nullable = false)
	@Enumerated(value = EnumType.STRING)
	private Gender gender;

	@Column(name = "AGE", nullable = false)
	private int age;

	@Column(name = "GRADUATE_SCHOOL")
	private String graduateSchool;

	@Column(name = "EDUCATION")
	private String education;

	@Column(name = "SELF_INTRODUCTION", columnDefinition = "TEXT")
	private String selfIntroduction;

	@Column(name = "INSERT_TIME", nullable = false, columnDefinition = "DATETIME")
	private Date insertTime;

	@Column(name = "UPDATE_TIME", nullable = false, columnDefinition = "DATETIME")
	private Date updateTime;

	@OneToMany(mappedBy = "resume", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<ResumeEdu> resumeEdus;

	@OneToMany(mappedBy = "resume", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<ResumeOcc> resumeOccs;

	@OneToMany(mappedBy = "resume", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<ResumePro> resumePros;

	@ManyToMany(targetEntity = Recruit.class, mappedBy = "resumes")
	private Set<Recruit> recruits;

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

	public String getName()
		{
		return name;
		}

	public void setName(String name)
		{
		this.name = name;
		}

	public Gender getGender()
		{
		return gender;
		}

	public void setGender(Gender gender)
		{
		this.gender = gender;
		}

	public int getAge()
		{
		return age;
		}

	public void setAge(int age)
		{
		this.age = age;
		}

	public String getGraduateSchool()
		{
		return graduateSchool;
		}

	public void setGraduateSchool(String graduateSchool)
		{
		this.graduateSchool = graduateSchool;
		}

	public String getEducation()
		{
		return education;
		}

	public void setEducation(String education)
		{
		this.education = education;
		}

	public String getSelfIntroduction()
		{
		return selfIntroduction;
		}

	public void setSelfIntroduction(String selfIntroduction)
		{
		this.selfIntroduction = selfIntroduction;
		}

	public Date getInsertTime()
		{
		return insertTime;
		}

	public void setInsertTime(Date insertTime)
		{
		this.insertTime = insertTime;
		}

	public Date getUpdateTime()
		{
		return updateTime;
		}

	public void setUpdateTime(Date updateTime)
		{
		this.updateTime = updateTime;
		}

	public Set<ResumeEdu> getResumeEdus()
		{
		return resumeEdus;
		}

	public void setResumeEdus(Set<ResumeEdu> resumeEdus)
		{
		this.resumeEdus = resumeEdus;
		}

	public Set<ResumeOcc> getResumeOccs()
		{
		return resumeOccs;
		}

	public void setResumeOccs(Set<ResumeOcc> resumeOccs)
		{
		this.resumeOccs = resumeOccs;
		}

	public Set<ResumePro> getResumePros()
		{
		return resumePros;
		}

	public void setResumePros(Set<ResumePro> resumePros)
		{
		this.resumePros = resumePros;
		}

	public Set<Recruit> getRecruits()
		{
		return recruits;
		}

	public void setRecruits(Set<Recruit> recruits)
		{
		this.recruits = recruits;
		}

	}
