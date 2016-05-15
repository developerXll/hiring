package com.hiring.service;

import java.util.List;

import com.hiring.bean.Resume;
import com.hiring.bean.obj.ResumeObj;
import com.hiring.bean.obj.UserObj;
import com.hiring.framework.Page;

public interface ResumeService extends BaseService<Resume>
	{

	String serv_name = "resumeService";

	List<ResumeObj> findPageObj(Page page);

	List<ResumeObj> findPageObjByUser(UserObj userObj, Page page);

	int findPageNumObjByUser(UserObj userObj);

	}
