package com.hiring.bean;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.hiring.constants.UserStatus;
import com.hiring.constants.UserType;

/**
 * 用户实体类
 * 
 * @author Administrator
 *
 */
@Entity(name = "t_user")
public class User
	{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "USER_NAME", nullable = false, unique = true)
	private String userName;

	@Column(name = "PASSWORD", nullable = false)
	private String password;

	@Column(name = "USER_TYPE", nullable = false)
	@Enumerated(value = EnumType.STRING)
	private UserType userType;

	@Column(name = "INSERT_TIME", nullable = false, columnDefinition = "DATETIME", updatable = false)
	private Date insertTime;

	@OneToMany(mappedBy = "user")
	private Set<Resume> resumes;

	@OneToMany(mappedBy = "user")
	private Set<Recruit> recruits;

	@OneToMany(mappedBy = "user")
	private Set<Announcement> announcements;
	
	@Column(name = "USER_STATUS")
	@Enumerated(value = EnumType.STRING)
	private UserStatus status;

	public Long getId()
		{
		return id;
		}

	public void setId(Long id)
		{
		this.id = id;
		}

	public String getUserName()
		{
		return userName;
		}

	public void setUserName(String userName)
		{
		this.userName = userName;
		}

	public String getPassword()
		{
		return password;
		}

	public void setPassword(String password)
		{
		this.password = password;
		}

	public UserType getUserType()
		{
		return userType;
		}

	public void setUserType(UserType userType)
		{
		this.userType = userType;
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

	public Set<Recruit> getRecruits()
		{
		return recruits;
		}

	public void setRecruits(Set<Recruit> recruits)
		{
		this.recruits = recruits;
		}

	public Set<Announcement> getAnnouncements()
		{
		return announcements;
		}

	public void setAnnouncements(Set<Announcement> announcements)
		{
		this.announcements = announcements;
		}

	public UserStatus getStatus() {
		return status;
	}

	public void setStatus(UserStatus status) {
		this.status = status;
	}

	}
