package com.zju.newcode;


/**
 * ��һ����ά�����У�ÿ��һά����ĳ�����ͬ����ÿһ�ж����մ����ҵ�����˳������
 * ÿһ�ж����մ��ϵ��µ�����˳�����������һ������������������һ����ά�����һ
 * ���������ж��������Ƿ��и�������
 * @author lin
 *
 */
public class Code01 {
	
	public boolean Find(int target, int [][] array) {
		if(null==array || array.length==0 ||array[0]==null ||array[0].length==0) {
			return false;
		}
		//�����½ǿ�ʼ
		int row = array.length-1;
		int col = 0;
		//�����鷶Χ��ѭ��
		while(row>=0 && col<array[0].length) {
			if(target==array[row][col]) {
				return true;
			}else if(target>array[row][col]) {
				//������������ƶ�
				col++;
			}else {
				//���С�ˣ������ƶ�
				row--;
			}
		}
		//���ִ�����˶�û�У��ͷ���false
		return false;
    }
	
	
}
