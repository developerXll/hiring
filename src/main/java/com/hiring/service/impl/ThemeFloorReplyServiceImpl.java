package com.hiring.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hiring.bean.ThemeFloorReply;
import com.hiring.service.ThemeFloorReplyService;

@Service(ThemeFloorReplyService.serv_name)
@Transactional
public class ThemeFloorReplyServiceImpl extends BaseServiceImpl<ThemeFloorReply>
		implements ThemeFloorReplyService
	{
	}
