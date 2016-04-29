package com.hiring;

import java.util.ArrayList;
import java.util.List;



public class LeastRecentPage{
	
	public static void main(String[] args) throws Exception{
//		int cacheSize = 3;
//		int pages[] = new int[]{7,0,1,2,0,3,0,4,2,3,0,3,2,1,2,0};
		int cacheSize = 2;
		int pages[] = new int[]{2,3,1,3,2,1,4,3,2};
		int result = lruCountMiss(cacheSize,pages);
		System.out.println(result);
	}
	
	
	public static int lruCountMiss(int max_cache_size,int[] pages){
		int count = 0;
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < pages.length; i++) {
			 Integer value = pages[i];
			 if(!contains(value,list,max_cache_size)){
				 count++;
			 }
		}
		return count;
	}
	
	public static boolean contains(Integer value,List<Integer> list,int cacheSize){
		if(list.contains(value)){
			list.remove(value);
			List<Integer> temp = new ArrayList<Integer>();
			temp.addAll(list);
			list.clear();
			list.add(value);
			list.addAll(temp);
			return true;
		}
		if(list.size() == cacheSize){
			list.remove(cacheSize - 1);
			List<Integer> temp = new ArrayList<Integer>();
			temp.addAll(list);
			list.clear();
			list.add(value);
			list.addAll(temp);
		}else{
			List<Integer> temp = new ArrayList<Integer>();
			temp.addAll(list);
			list.clear();
			list.add(value);
			list.addAll(temp);
		}
		return false;
		
	}
	
	
}

