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
        母问题：判断输入数组是否合法（这里其实不是递归真正限制条件）
               基本操作：确定左右子树，根据后序遍历的特点确定最后一个数为根节点，从输入的数组由头往后找，第一个大于根节点的数开始就是右子树，
                   前面为左子树，后面为右子树。如果右子树存在则先判断其节点是否都大于左子树，不是就直接返回false
               接下来把问题交给孩子（先判断孩子是否存在---这个作为递归的真正限制条件）
               
    */
    public boolean VerifySquenceOfBST(int[] sequence,int start, int end){
          //这里不作为递归出口
         if(sequence == null || start>end){
             return false;
         }
         int root = sequence[end];
        //记录左子树的数目
         int n = 0;
         for(int i=start;i<end;i++){
             if(sequence[i]<root){
                 n++;
             }else{
                 break;
             }
         }
        //判断右子树中是不是都小于root
         for(int i=start+n; i<end; i++){
             if(sequence[i]<root){
                 return false;
             }
         }
        

         
        //如果符合就把问题交给孩子
        boolean left = true;
        //左孩子存在？
        if(n>0){
        	  System.out.print("左子树为：");
              for(int i=start;i<=start+n-1;i++) {
             	 System.out.print(sequence[i]+" ");
              }
              System.out.println();
            left = VerifySquenceOfBST(sequence,start,start+n-1);
           // System.out.print(left+"--");
        }
        //右孩子存在？
        boolean right = true;
        if(end-start-n>0){
        	 System.out.print("右子树为：");
             for(int i=start+n;i<=end-1;i++) {
            	 System.out.print(sequence[i]+" ");
             }
             System.out.println();
            right = VerifySquenceOfBST(sequence,start+n,end-1);
            //System.out.print(right+"--");
        }
        //两个孩子都对
        return left&&right;
     }
}