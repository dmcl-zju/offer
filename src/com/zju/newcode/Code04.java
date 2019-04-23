package com.zju.newcode;



/**
 * ����ĳ��������ǰ���������������Ľ�������ؽ����ö����������������ǰ���������������Ľ���ж������ظ������֡�
 * ��������ǰ���������{1,2,4,7,3,5,6,8}�������������{4,7,2,1,5,3,8,6}�����ؽ������������ء�
 * @author lin
 *
 */
public class Code04 {


	  public static class TreeNode {
		  int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	
	
	
	public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
		if(null==pre || pre.length==0 || null==in || in.length==0 || pre.length!=in.length) {
			return null;
		}
		return process(pre,in,0,pre.length-1,0,in.length-1);
        
    }
	
	private static TreeNode process(int[] pre,int[] in,int startPre,int endPre,int startIn,int endIn) {
		//���󷽷����������ݹ����--ֻʣ��һ�����ˣ�ֱ�Ӵ����ڵ㲢����
//		if(startPre == endPre || startIn==endIn) {
//			//���������е�ֵ������һ����
//			return new TreeNode(pre[startPre]);
//		}
		if(startPre>endPre || startIn>endIn) {
			return null;
		}
		//��ӡ��ǰ�������
//		System.out.print("�������飺");
//		for(int i=startPre;i<=endPre;i++) {
//			System.out.print(pre[i]+"-");
//		}
//		System.out.println("");
//		System.out.print("�������飺");
//		for(int i=startIn;i<=endIn;i++) {
//			System.out.print(in[i]+"-");
//		}
//		System.out.println("");
		//�ȴ����Լ�----pre�ĵ�һ��ֵһ����head
		TreeNode curNode = new TreeNode(pre[startPre]);
		//ƫ��ֵ
		int index = getIndex(in, pre[startPre]);
		int offset = index-startIn;
		//System.out.println(pre[startPre]+"---"+offset);
		//��������---�ؼ������������
		curNode.left = process(pre,in,startPre+1,startPre+offset,startIn,index-1);
		curNode.right = process(pre,in,startPre+offset+1,endPre,index+1,endIn);
		return curNode;
	}
	//������û���ظ����ֵ����
	public static int getIndex(int[] arr,int value) {
		for(int i=0;i<arr.length;i++) {
			if(value==arr[i]){
				return i;
			}
		}
		//��ʾû���ҵ�
		return -1;
	}
	
//-------------------------------------���Դ�ӡ��--------------------------------------------
	public static void printTree(TreeNode head) {
		System.out.println("Binary Tree:");
		printInOrder(head, 0, "H", 17);
		System.out.println();
	}

	public static void printInOrder(TreeNode head, int height, String to, int len) {
		if (head == null) {
			return;
		}
		printInOrder(head.right, height + 1, "v", len);
		String val = to + head.val + to;
		int lenM = val.length();
		int lenL = (len - lenM) / 2;
		int lenR = len - lenM - lenL;
		val = getSpace(lenL) + val + getSpace(lenR);
		System.out.println(getSpace(height * len) + val);
		printInOrder(head.left, height + 1, "^", len);
	}

	public static String getSpace(int num) {
		String space = " ";
		StringBuffer buf = new StringBuffer("");
		for (int i = 0; i < num; i++) {
			buf.append(space);
		}
		return buf.toString();
	}
	
	
	public static void main(String[] args) {
		int[] pre = {1,2,4,7,3,5,6,8};
		int[] in =  {4,7,2,1,5,3,8,6};
		TreeNode head = reConstructBinaryTree(pre, in);
		printTree(head);
 	}
	
}
