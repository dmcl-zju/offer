package com.zju.newcode;

/**
 * ��ʵ��һ����������һ���ַ����е�ÿ���ո��滻�ɡ�%20�������磬���ַ���ΪWe Are Happy.
 * �򾭹��滻֮����ַ���ΪWe%20Are%20Happy��
 * @author lin
 *
 */

public class Code02 {
	 public String replaceSpace(StringBuffer str) {
		 if(null==str ||str.length()==0) {
			 return null;
		 }
		 StringBuilder sb = new StringBuilder();
		 for(int i=0;i<str.length();i++) {
			 if(str.charAt(i)==' ') {
				 sb.append("%20");
			 }else {
				 sb.append(str.charAt(i));
			 }
		 }
		return sb.toString();
	 }
	 
	 public static void main(String[] args) {
		 Code02 code = new Code02();
		 StringBuffer sb = new StringBuffer("We Are Happy");
		 System.out.println(code.replaceSpace(sb));
	}
}
