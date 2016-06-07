package com.hiring.bean;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.hiring.constants.RecStatus;

/**
 * 招聘信息实体类
 * 
 * @author Administrator
 *
 */
@Entity(name = "t_recruit")
public class Recruit {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne(cascade = CascadeType.PERSIST, optional = false)
	@JoinColumn(name = "USER_ID", referencedColumnName = "ID", updatable = false)
	private User user;

	@Column(name = "POSITION", nullable = false)
	private String possion;

	@Column(name = "PAY")
	private String pay;

	@Column(name = "PAY_MONTHS")
	private String payMonths;

	@Column(name = "POSSION_INTRODUCTION", columnDefinition = "TEXT")
	private String possionIntroduction;

	@Column(name = "JOB_REQUIREMENT", columnDefinition = "TEXT")
	private String jobRequirement;

	@Column(name = "REC_STATUS", nullable = false)
	@Enumerated(value = EnumType.STRING)
	private RecStatus recStatus;

	@Column(name = "INSERT_TIME", nullable = false, columnDefinition = "DATETIME", updatable = false)
	private Date insertTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getPossion() {
		return possion;
	}

	public void setPossion(String possion) {
		this.possion = possion;
	}

	public String getPay() {
		return pay;
	}

	public void setPay(String pay) {
		this.pay = pay;
	}

	public String getPayMonths() {
		return payMonths;
	}

	public void setPayMonths(String payMonths) {
		this.payMonths = payMonths;
	}

	public String getPossionIntroduction() {
		return possionIntroduction;
	}

	public void setPossionIntroduction(String possionIntroduction) {
		this.possionIntroduction = possionIntroduction;
	}

	public String getJobRequirement() {
		return jobRequirement;
	}

	public void setJobRequirement(String jobRequirement) {
		this.jobRequirement = jobRequirement;
	}

	public RecStatus getRecStatus() {
		return recStatus;
	}

	public void setRecStatus(RecStatus recStatus) {
		this.recStatus = recStatus;
	}

	public Date getInsertTime() {
		return insertTime;
	}

	public void setInsertTime(Date insertTime) {
		this.insertTime = insertTime;
	}
}
