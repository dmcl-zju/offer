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
    
    //index��ʾ��Ҫ���д����ͷ
    public void permutationHelpler(char[] ch,int index){
    	if(index == ch.length-1) {
    		//��ʾ��Ҫ������ַ�ֻʣһ���ˣ��Ͳ���Ҫ���д���,����������list��
    		if(!list.contains(new String(ch))) {
    			list.add(new String(ch));
        		return;
    		}
    	}
    	for(int j=index;j<ch.length;j++) {
    		swap(ch,index,j);
    		//�������Ӵ���
    		permutationHelpler(ch,index+1);
    		//��������
    		swap(ch,j,index);
    	}
    }
    //�������н���Ԫ�صĽ���
    public void swap(char[] ch, int i,int j) {
    	char temp = ch[i];
    	ch[i] = ch[j];
    	ch[j] = temp;
    } 
    //���Ժ���
    public static void main(String[] args) {
		Test test = new Test();
		ArrayList<String> li = test.Permutation("abc");
		for(String s:li) {
			System.out.print(s+" ");
		}
		
	}
}