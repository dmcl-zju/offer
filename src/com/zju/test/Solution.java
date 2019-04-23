package com.zju.test;

public class Solution {
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] array = {4,8,6,12,16,14,10};
		s.VerifySquenceOfBST(array);
	}
	
	
	
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(null == sequence || sequence.length<=0){
            return false;
        }
        return VerifySquenceOfBST(sequence,0,sequence.length-1);
    }
    /*
        ĸ���⣺�ж����������Ƿ�Ϸ���������ʵ���ǵݹ���������������
               ����������ȷ���������������ݺ���������ص�ȷ�����һ����Ϊ���ڵ㣬�������������ͷ�����ң���һ�����ڸ��ڵ������ʼ������������
                   ǰ��Ϊ������������Ϊ��������������������������ж���ڵ��Ƿ񶼴��������������Ǿ�ֱ�ӷ���false
               �����������⽻�����ӣ����жϺ����Ƿ����---�����Ϊ�ݹ����������������
               
    */
    public boolean VerifySquenceOfBST(int[] sequence,int start, int end){
          //���ﲻ��Ϊ�ݹ����
         if(sequence == null || start>end){
             return false;
         }
         int root = sequence[end];
        //��¼����������Ŀ
         int n = 0;
         for(int i=start;i<end;i++){
             if(sequence[i]<root){
                 n++;
             }else{
                 break;
             }
         }
        //�ж����������ǲ��Ƕ�С��root
         for(int i=start+n; i<end; i++){
             if(sequence[i]<root){
                 return false;
             }
         }
        

         
        //������ϾͰ����⽻������
        boolean left = true;
        //���Ӵ��ڣ�
        if(n>0){
        	  System.out.print("������Ϊ��");
              for(int i=start;i<=start+n-1;i++) {
             	 System.out.print(sequence[i]+" ");
              }
              System.out.println();
            left = VerifySquenceOfBST(sequence,start,start+n-1);
           // System.out.print(left+"--");
        }
        //�Һ��Ӵ��ڣ�
        boolean right = true;
        if(end-start-n>0){
        	 System.out.print("������Ϊ��");
             for(int i=start+n;i<=end-1;i++) {
            	 System.out.print(sequence[i]+" ");
             }
             System.out.println();
            right = VerifySquenceOfBST(sequence,start+n,end-1);
            //System.out.print(right+"--");
        }
        //�������Ӷ���
        return left&&right;
     }
}