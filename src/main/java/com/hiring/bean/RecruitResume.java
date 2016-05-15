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
 * 招聘应聘信息实体类
 * 
 * @author Administrator
 *
 */
@Entity(name = "t_recruit_resume")
public class RecruitResume
	{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne(cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "REC_ID", referencedColumnName = "ID")
	private Recruit recruit;

	@ManyToOne(cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "RES_ID", referencedColumnName = "ID")
	private Resume resume;

	@Column(name = "INSERT_TIME", nullable = false, columnDefinition = "DATETIME", updatable = false)
	private Date insertTime;

	public Long getId()
		{
		return id;
		}

	public void setId(Long id)
		{
		this.id = id;
		}

	public Recruit getRecruit()
		{
		return recruit;
		}

	public void setRecruit(Recruit recruit)
		{
		this.recruit = recruit;
		}

	public Resume getResume()
		{
		return resume;
		}

	public void setResume(Resume resume)
		{
		this.resume = resume;
		}

	public Date getInsertTime()
		{
		return insertTime;
		}

	public void setInsertTime(Date insertTime)
		{
		this.insertTime = insertTime;
		}
	}
