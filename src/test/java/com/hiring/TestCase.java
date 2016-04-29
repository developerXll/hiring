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
		
		// ���ٻ�����
		int[] high_cahce = new int[max_cache_size];
		
		// ����ʧ�ܴ���
		int expVal = 0;
		 
		for(int i = 0; i < pages.length; i++){
			int val = pages[i];
			if(i < max_cache_size){
				high_cahce[i] = val;
				expVal ++;
				System.out.println("��ʱ���ٻ�������Ϊ " + high_cahce[0] + " , ����ʧ�ܴ���Ϊ " + expVal);
				continue;
			}
			// ѭ�����ٻ����ж��Ƿ����ڸ��ٻ�����
			boolean hasValInCache = false;
			for(int j = 0; j < high_cahce.length; j++){
				if(val == high_cahce[j]) {
					hasValInCache = true;
					break;
				}
			}
			
			// ����Ѿ�������ֵ
			if(!hasValInCache) {
				// 
				expVal ++;
				
				// push value into high cache
				
				// define high value size
				int[] high_value_size = new int[high_cahce.length];
				
				for(int j = 0; j < high_cahce.length; j++){
					// ���ٻ���Ԫ�ش��ڸ���
					int size = 0;
					int high_value = high_cahce[j];
					
					// ѭ�����������ȡ��ֵ���ڵĸ���
					for(int k = i+1; k < pages.length; k++) {
						if(high_value == pages[k]) size++;
					}
					// ��ֵ����int�����У��������Ӧhigh_cache�����Ӧλ���ֶκ�������Ĵ���
					high_value_size[j] = size;
				}
				
				// ѭ������
				// Ҫ�滻�ĸ��ٻ��������±�
				int high_value_num = 0;
				for(int j = 0; j < high_value_size.length - 1; j++) {
					if(high_value_size[j+1] < high_value_size[j]) high_value_num = j+1;
				}
				
				// push value
				high_cahce[high_value_num] = val;
				
				System.out.println("��ʱ���ٻ�������Ϊ " + high_cahce[0] + high_cahce[1] + high_cahce[2] + " , ����ʧ�ܴ���Ϊ " + expVal);
			}
		}
		
		System.out.println(expVal);
	
	}

}
