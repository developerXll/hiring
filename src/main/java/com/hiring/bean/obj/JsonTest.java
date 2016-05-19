package com.hiring.bean.obj;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class JsonTest
	{
	@Test
	public void test1()
	{
	String s = "[{companyName:亚信,endTime:2016-05,startTime:2016-02,possion:JAVA开发 ,companyType:计算机软件,workIntroduction:实习生},]";
	JSONArray obj = JSONArray.parseArray(s);
	System.out.println(obj);
	}

	}
