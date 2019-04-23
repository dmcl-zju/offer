package com.zju.test;

import java.util.ArrayList;
import java.util.Collections;
public class Test {
	
	private static ArrayList<String> list = new ArrayList<>();
    public ArrayList<String> Permutation(String str) {
    	if(0 == str.length()) {
    		return list;
    	}
       permutationHelpler(str.toCharArray(),0);
       Collections.sort(list);
       return list;
    }
    
    //index表示需要进行处理的头
    public void permutationHelpler(char[] ch,int index){
    	if(index == ch.length-1) {
    		//表示需要处理的字符只剩一个了，就不需要进行处理,将结果输出到list中
    		if(!list.contains(new String(ch))) {
    			list.add(new String(ch));
        		return;
    		}
    	}
    	for(int j=index;j<ch.length;j++) {
    		swap(ch,index,j);
    		//交给孩子处理
    		permutationHelpler(ch,index+1);
    		//交换回来
    		swap(ch,j,index);
    	}
    }
    //在数组中进行元素的交换
    public void swap(char[] ch, int i,int j) {
    	char temp = ch[i];
    	ch[i] = ch[j];
    	ch[j] = temp;
    } 
    //测试函数
    public static void main(String[] args) {
		Test test = new Test();
		ArrayList<String> li = test.Permutation("abc");
		for(String s:li) {
			System.out.print(s+" ");
		}
		
	}
}