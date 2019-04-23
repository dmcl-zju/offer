package com.zju.newcode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * ����һ������������ֵ��β��ͷ��˳�򷵻�һ��ArrayList��
 * @author lin
 *
 */

public class Code03 {
	
	public static class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
	}
	//����1������ջ����
	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		ArrayList<Integer> list = new ArrayList<>();
		if(null==listNode) {
			return list;
		}
		Stack<Integer> stack = new Stack<>();
		//��������Ȼ����ջ
		while(listNode!=null) {
			stack.push(listNode.val);
			listNode = listNode.next;
		}
		//��ջ��ȡ��
		while(!stack.isEmpty()) {
			//System.out.println(stack.peek());
			list.add(stack.pop());
		}
		return list; 
	}
	
	//����2�����õݹ�����
	public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
		ArrayList<Integer> list = new ArrayList<>();
		if(null==listNode) {
			return list;
		}
		//���õݹ鴦��
		process(listNode,list);
		return list;
	}
	private void process(ListNode listNode,ArrayList<Integer> list) {
		//�ݹ����
		if(listNode==null) {
			return;
		}
		process(listNode.next,list);
		list.add(listNode.val);
	}
	
	public static void main(String[] args) {
		ListNode node = new ListNode(1);
		node.next = new ListNode(2);
		node.next.next = new ListNode(3);
		node.next.next.next = new ListNode(4);
		node.next.next.next.next = new ListNode(5);
		ArrayList<Integer> list = new Code03().printListFromTailToHead(node);
		for(int i:list) {
			System.out.println(i);
		}
		
	}
}
