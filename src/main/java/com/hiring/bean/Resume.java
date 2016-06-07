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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.hiring.constants.Gender;
import com.hiring.constants.ResumeStatus;

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

	@ManyToOne(cascade = CascadeType.PERSIST, optional = false)
	@JoinColumn(name = "USER_ID", referencedColumnName = "ID")
	private User user;

	@Column(name = "NAME", nullable = false)
	private String name;

	@Column(name = "TEL", nullable = false)
	private String tel;

	@Column(name = "EMAIL", nullable = false)
	private String email;

	/**
	 * 居住地
	 */
	@Column(name = "RESIDENCE", nullable = false)
	private String residence;

	/**
	 * 户籍所在地
	 */
	@Column(name = "DOMICILE", nullable = false)
	private String domicile;

	@Column(name = "IDENTIFICATION", nullable = false)
	private String identification;

	@Column(name = "IDENTIFICATION_TYPE", nullable = false)
	private String identificationType;

	@Column(name = "JOB_INTENSION", nullable = false)
	private String jobIntension;

	@Column(name = "EXPECT_SALARY", nullable = false)
	private String expectSalary;

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

	@Column(name = "INSERT_TIME", nullable = false, columnDefinition = "DATETIME", updatable = false)
	private Date insertTime;

	@Column(name = "UPDATE_TIME", nullable = false, columnDefinition = "DATETIME")
	private Date updateTime;

	@OneToMany(mappedBy = "resume", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<ResumeEdu> resumeEdus;

	@OneToMany(mappedBy = "resume", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<ResumeOcc> resumeOccs;

	@OneToMany(mappedBy = "resume", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<ResumePro> resumePros;

	@ManyToOne(cascade = CascadeType.PERSIST, optional = false)
	@JoinColumn(name = "REC_ID", referencedColumnName = "ID")
	private Recruit recruit;

	@Column(name = "STATUS", nullable = false)
	@Enumerated(value = EnumType.STRING)
	private ResumeStatus status;

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

	public String getTel()
		{
		return tel;
		}

	public void setTel(String tel)
		{
		this.tel = tel;
		}

	public String getEmail()
		{
		return email;
		}

	public void setEmail(String email)
		{
		this.email = email;
		}

	public String getResidence()
		{
		return residence;
		}

	public void setResidence(String residence)
		{
		this.residence = residence;
		}

	public String getDomicile()
		{
		return domicile;
		}

	public void setDomicile(String domicile)
		{
		this.domicile = domicile;
		}

	public String getIdentification()
		{
		return identification;
		}

	public void setIdentification(String identification)
		{
		this.identification = identification;
		}

	public String getIdentificationType()
		{
		return identificationType;
		}

	public void setIdentificationType(String identificationType)
		{
		this.identificationType = identificationType;
		}

	public String getJobIntension()
		{
		return jobIntension;
		}

	public void setJobIntension(String jobIntension)
		{
		this.jobIntension = jobIntension;
		}

	public String getExpectSalary()
		{
		return expectSalary;
		}

	public void setExpectSalary(String expectSalary)
		{
		this.expectSalary = expectSalary;
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

	public Recruit getRecruit()
		{
		return recruit;
		}

	public void setRecruit(Recruit recruit)
		{
		this.recruit = recruit;
		}

	public ResumeStatus getStatus()
		{
		return status;
		}

	public void setStatus(ResumeStatus status)
		{
		this.status = status;
		}

	}
