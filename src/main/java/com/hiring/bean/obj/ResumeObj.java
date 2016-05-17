package com.hiring.bean.obj;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hiring.bean.Recruit;
import com.hiring.bean.Resume;
import com.hiring.bean.ResumeEdu;
import com.hiring.bean.ResumeOcc;
import com.hiring.bean.ResumePro;
import com.hiring.constants.Gender;

/**
 * 简历信息
 * 
 * @author Administrator
 *
 */
public class ResumeObj
	{

	private Resume resume = new Resume();

	public ResumeObj()
		{

		}

	public ResumeObj(Resume resume)
		{
		this.resume = resume;
		}

	@JsonIgnore
	public Resume getResume()
		{
		return resume;
		}

	public void setResume(Resume resume)
		{
		this.resume = resume;
		}

	public Long getId()
		{
		return this.resume.getId();
		}

	public void setId(Long id)
		{
		this.resume.setId(id);
		}

	public UserObj getUser()
		{
		return new UserObj(this.resume.getUser());
		}

	public void setUser(UserObj user)
		{
		this.resume.setUser(user.getUser());
		}

	public String getName()
		{
		return this.resume.getName();
		}

	public void setName(String name)
		{
		this.resume.setName(name);
		}

	public String getTel()
		{
		return this.resume.getTel();
		}

	public void setTel(String tel)
		{
		this.resume.setTel(tel);
		}

	public String getEmail()
		{
		return this.resume.getEmail();
		}

	public void setEmail(String email)
		{
		this.resume.setEmail(email);
		}

	public String getResidence()
		{
		return this.resume.getResidence();
		}

	public void setResidence(String residence)
		{
		this.resume.setResidence(residence);
		}

	public String getDomicile()
		{
		return this.resume.getDomicile();
		}

	public void setDomicile(String domicile)
		{
		this.resume.setDomicile(domicile);
		}

	public String getIdentification()
		{
		return this.resume.getIdentification();
		}

	public void setIdentification(String identification)
		{
		this.resume.setIdentification(identification);
		}

	public String getIdentificationType()
		{
		return this.resume.getIdentificationType();
		}

	public void setIdentificationType(String identificationType)
		{
		this.resume.setIdentificationType(identificationType);
		}

	public String getJobIntension()
		{
		return this.resume.getJobIntension();
		}

	public void setJobIntension(String jobIntension)
		{
		this.resume.setJobIntension(jobIntension);
		}

	public String getExpectSalary()
		{
		return this.resume.getExpectSalary();
		}

	public void setExpectSalary(String expectSalary)
		{
		this.resume.setExpectSalary(expectSalary);
		}

	public String getGender()
		{
		return this.resume.getGender().toString();
		}

	public void setGender(String gender)
		{
		this.resume.setGender(Gender.valueOf(gender));
		}

	public int getAge()
		{
		return this.resume.getAge();
		}

	public void setAge(int age)
		{
		this.resume.setAge(age);
		}

	public String getGraduateSchool()
		{
		return this.resume.getGraduateSchool();
		}

	public void setGraduateSchool(String graduateSchool)
		{
		this.resume.setGraduateSchool(graduateSchool);
		}

	public String getEducation()
		{
		return this.resume.getEducation();
		}

	public void setEducation(String education)
		{
		this.resume.setEducation(education);
		}

	public String getSelfIntroduction()
		{
		return this.resume.getSelfIntroduction();
		}

	public void setSelfIntroduction(String selfIntroduction)
		{
		this.resume.setSelfIntroduction(selfIntroduction);
		}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	public Date getInsertTime()
		{
		return this.resume.getInsertTime();
		}

	public void setInsertTime(Date insertTime)
		{
		this.resume.setInsertTime(insertTime);
		}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	public Date getUpdateTime()
		{
		return this.resume.getUpdateTime();
		}

	public void setUpdateTime(Date updateTime)
		{
		this.resume.setUpdateTime(updateTime);
		}

	public Set<ResumeEduObj> getResumeEdus()
		{
		Set<ResumeEduObj> edus = new HashSet<ResumeEduObj>();
		if (this.resume.getResumeEdus() != null
				&& this.resume.getResumeEdus().size() > 0)
			{
			for (ResumeEdu edu : this.resume.getResumeEdus())
				{
				edus.add(new ResumeEduObj(edu));
				}
			}
		return edus;
		}

	public void setResumeEdus(Set<ResumeEduObj> resumeEdus)
		{
		Set<ResumeEdu> edus = new HashSet<ResumeEdu>();
		if (resumeEdus != null && resumeEdus.size() > 0)
			{
			for (ResumeEduObj obj : resumeEdus)
				{
				ResumeEdu edu = obj.getResumeEdu();
				edu.setResume(this.resume);
				edus.add(edu);
				}
			}
		this.resume.setResumeEdus(edus);
		}

	public Set<ResumeOccObj> getResumeOccs()
		{
		Set<ResumeOccObj> occs = new HashSet<ResumeOccObj>();
		if (this.resume.getResumeOccs() != null
				&& this.resume.getResumeOccs().size() > 0)
			{
			for (ResumeOcc occ : this.resume.getResumeOccs())
				{
				occs.add(new ResumeOccObj(occ));
				}
			}
		return occs;
		}

	public void setResumeOccs(Set<ResumeOccObj> resumeOccs)
		{
		Set<ResumeOcc> occs = new HashSet<ResumeOcc>();
		if (resumeOccs != null && resumeOccs.size() > 0)
			{
			for (ResumeOccObj obj : resumeOccs)
				{
				ResumeOcc occ = obj.getResumeOcc();
				occ.setResume(this.resume);
				occs.add(occ);
				}
			}
		this.resume.setResumeOccs(occs);
		}

	public Set<ResumeProObj> getResumePros()
		{
		Set<ResumeProObj> pros = new HashSet<ResumeProObj>();
		if (this.resume.getResumePros() != null
				&& this.resume.getResumePros().size() > 0)
			{
			for (ResumePro pro : this.resume.getResumePros())
				{
				pros.add(new ResumeProObj(pro));
				}
			}
		return pros;
		}

	public void setResumePros(Set<ResumeProObj> resumePros)
		{
		Set<ResumePro> pros = new HashSet<ResumePro>();
		if (resumePros != null && resumePros.size() > 0)
			{
			for (ResumeProObj obj : resumePros)
				{
				ResumePro pro = obj.getResumePro();
				pro.setResume(this.resume);
				pros.add(pro);
				}
			}
		this.resume.setResumePros(pros);
		}

	public Set<RecruitObj> getRecruits()
		{
		Set<RecruitObj> recruits = new HashSet<RecruitObj>();
		if (this.resume.getRecruits() != null
				&& this.resume.getRecruits().size() > 0)
			{
			for (Recruit recruit : this.resume.getRecruits())
				{
				recruits.add(new RecruitObj(recruit));
				}
			}
		return recruits;
		}

	}
