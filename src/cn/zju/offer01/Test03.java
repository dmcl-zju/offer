package cn.zju.offer01;

import java.util.Arrays;

/**
 * ��ָoffer������
 * �ҳ�������ظ�����
 * ������
 * [3,2,5,4,0,6,3,4]
 * @author LIN
 *
 */
public class Test03 {
	public static boolean duplicate(int[] arr) {
		
		for(int i=0; i<arr.length; i++) {
			if(arr[i] != i) {
				//����Ԫ��
				int temp = arr[i];
				arr[i] = arr[temp];
				arr[temp] = temp;
				System.out.println(i+":"+arr);
			}
			
		}
		System.out.println(Arrays.toString(arr));
		return false;
		
	}
	public static void main(String[] args) {
		int[] arr = {3,2,5,4,0,6,3,4};
		duplicate(arr);
		
	}
	
}
