package cn.zju.offer01;



public class LinkedListTest {
	
	public static class Node{
		public int value;
		public Node next;
		public Node(int value) {
			this.value = value;
		}
	}
	
	//把一个数组转换成链表，返回链表头
	public static Node creatLinkList(int[] arr) {
		//head记录链表头
		Node head = null;
		//tail记录链表尾
		Node tail = null;
		for(int i=0;i<arr.length;i++) {
			Node newNode = new Node(arr[i]);
			if(null == head) {
				head = newNode;
				tail = head;
			}else {
				tail.next = newNode;
				tail = tail.next;
			}
		}
		return head;
	}
	
	public static void printLinkList(Node head) {
		while(head != null) {
			System.out.print(head.value+" ");
			head = head.next;
		}
		System.out.println("");
	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,6,5,4,8,9};
		Node head = creatLinkList(arr);
		printLinkList(head);
		
	}
	
	
	
}
