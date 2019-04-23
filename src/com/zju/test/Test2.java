package com.zju.test;

import java.util.HashSet;
import java.util.Set;

public class Test2 {

	public static void main(String[] args) {
		
		int[] array = {5,4,3,2,1};
		//int result = MoreThanHalfNum_Solution(array);
		//System.out.println(result);
		int[] arr = array = sort(array);
		for(int i:arr) {
			System.out.print(i+" ");
		}
		System.out.println("");
		System.out.println("--------");
		arr = array = sel(array);
		for(int i:arr) {
			System.out.print(i+" ");
		}
		
	}
	
	public static int[] sort (int [] array) {
		for(int i=0;i<array.length-1;i++) {
			for(int j=0;j<array.length-i-1;j++) {
				if(array[j]>array[j+1]){
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
		return array;
	}
	public static int[] sel(int[] array) {
		for(int i=0;i<array.length-1;i++) {
			for(int j=i+1;j<array.length;j++) {
				if(array[i]>array[j]){
					int temp = array[j];
					array[j] = array[i];
					array[i] = temp;
				}
			}
		}
		return array;
	}
	
	
	public static int MoreThanHalfNum_Solution(int [] array) {
        int cur = 0;
        int times = 0;
        int result =0;
        for(int i=0;i<array.length;i++){
            if(cur == 0){
                cur=array[i];
                times++;
                result = cur;
            }else{
                if(cur == array[i]){
                    times++;
                }else{
                    times--;
                    if(times == 0){
                        cur = 0;
                    }
                }
            }
        }
        times = 0;
        for(int i=0;i<array.length;i++) {
        	if(array[i] == result) {
        		times++;
        	}
        }
        if(times>array.length/2) {
        	return result;
        }else {
        	return 0;
        }
        
    }
}
