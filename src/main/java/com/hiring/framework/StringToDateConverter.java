package com.hiring.framework;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class StringToDateConverter implements Converter<String, Date>
	{

	public Date convert(String source)
		{
		DateFormat dateTimeFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = null;
		try
			{
			date = dateTimeFormat.parse(source);
			}
		catch (ParseException e)
			{
			e.printStackTrace();
			}
		return date;
		}
	}
