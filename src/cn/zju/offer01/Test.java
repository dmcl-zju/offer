package cn.zju.offer01;

public class Test {
	public static void main(String[] args) {
		//System.out.println(sum(100));
//		String s = "abcd";
//		System.out.println(s.charAt(0));
//		s.length();
//		StringBuffer sb = new StringBuffer("haha");
//		sb.append("lala");
//		System.out.println(sb.length());
//		System.out.println(sb.charAt(0)=='h');
		int[] array = {1,2,3,4,5,6,7};
		int[] array1 = {};
		array1 = fun(array1);
		for(int a:array1) {
			System.out.print(a+" ");
		}
		
	}
	
	public static int[] fun(int[] array) {
		if(array.length<=1) {
			return array;
		}
		int start = 0;
		int end = array.length-1;
		while(start<end) {
			//走到第一个偶数
			while(array[start]%2==1){
				start++;
			}
			//走到第一个奇数
			while(array[end]%2==0){
				end--;
			}
			if(start<end) {
				int temp = array[start];
				array[start] = array[end];
				array[end] = temp;
			}
		}
		return array;
	}
	public static int sum(int n) {
		if(n==1) {
			return 1;
		}
		return (n+sum(n-1));
		
	}
}
