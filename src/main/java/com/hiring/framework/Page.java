package com.hiring.framework;

public class Page
	{

	private int pageNo = 1;

	private int pageSize = 10;

	private int totalNumber = 0;

	private int totalPageNumber;

	public int getPageNo()
		{
		return pageNo;
		}

	public void setPageNo(int pageNo)
		{
		this.pageNo = pageNo;
		}

	public int getPageSize()
		{
		return pageSize;
		}

	public void setPageSize(int pageSize)
		{
		this.pageSize = pageSize;
		}

	public int getTotalNumber()
		{
		return totalNumber;
		}

	public void setTotalNumber(int totalNumber)
		{
		this.totalNumber = totalNumber;
		}

	public int getTotalPageNumber()
		{
		if (totalPageNumber != 0)
			return totalPageNumber;
		else if (totalNumber == 0)
			return 0;
		else
			return totalNumber % pageSize == 0 ? totalNumber / pageSize
					: totalNumber / pageSize + 1;
		}

	public void setTotalPageNumber(int totalPageNumber)
		{
		this.totalPageNumber = totalPageNumber;
		}

	}
