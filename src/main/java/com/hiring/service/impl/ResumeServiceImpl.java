package com.hiring.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hiring.bean.Resume;
import com.hiring.service.ResumeService;

@Service (ResumeService.serv_name)
@Transactional
public class ResumeServiceImpl extends BaseServiceImpl<Resume> implements
		ResumeService
{

}
