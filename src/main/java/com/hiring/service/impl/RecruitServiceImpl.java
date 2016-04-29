package com.hiring.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hiring.bean.Recruit;
import com.hiring.service.RecruitService;

@Service (RecruitService.serv_name)
@Transactional
public class RecruitServiceImpl extends BaseServiceImpl<Recruit> implements
		RecruitService
{

}
