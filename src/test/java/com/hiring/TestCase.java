package com.hiring;


public class TestCase
{

	public static void main(String[] args)
	{}
	
	public void lru(){

		int max_cache_size = 3;
		int[] pages = {7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2, 1, 2, 0};
		
		// int max_cache_size = 2;
		// int[] pages = {2, 3, 1, 3, 2, 1, 4, 3, 2};
		
		// 高速缓存区
		int[] high_cahce = new int[max_cache_size];
		
		// 请求失败次数
		int expVal = 0;
		 
		for(int i = 0; i < pages.length; i++){
			int val = pages[i];
			if(i < max_cache_size){
				high_cahce[i] = val;
				expVal ++;
				System.out.println("此时高速缓存内容为 " + high_cahce[0] + " , 请求失败次数为 " + expVal);
				continue;
			}
			// 循环高速缓存判断是否已在高速缓存内
			boolean hasValInCache = false;
			for(int j = 0; j < high_cahce.length; j++){
				if(val == high_cahce[j]) {
					hasValInCache = true;
					break;
				}
			}
			
			// 如果已经包含该值
			if(!hasValInCache) {
				// 
				expVal ++;
				
				// push value into high cache
				
				// define high value size
				int[] high_value_size = new int[high_cahce.length];
				
				for(int j = 0; j < high_cahce.length; j++){
					// 高速缓存元素存在个数
					int size = 0;
					int high_value = high_cahce[j];
					
					// 循环后续数组获取该值存在的个数
					for(int k = i+1; k < pages.length; k++) {
						if(high_value == pages[k]) size++;
					}
					// 将值存入int数组中，该数组对应high_cache数组对应位置字段后续请求的次数
					high_value_size[j] = size;
				}
				
				// 循环排序
				// 要替换的高速缓存数组下标
				int high_value_num = 0;
				for(int j = 0; j < high_value_size.length - 1; j++) {
					if(high_value_size[j+1] < high_value_size[j]) high_value_num = j+1;
				}
				
				// push value
				high_cahce[high_value_num] = val;
				
				System.out.println("此时高速缓存内容为 " + high_cahce[0] + high_cahce[1] + high_cahce[2] + " , 请求失败次数为 " + expVal);
			}
		}
		
		System.out.println(expVal);
	
	}

}
