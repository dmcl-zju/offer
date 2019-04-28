package cn.zju.offer01;



public class linkListSEB {
	
	public static class Node{
		public int value;
		public Node next;
		public Node(int value) {
			this.value = value;
		}
	}
	//链表的荷兰国旗问题
	public static Node listPartition(Node head,int num) {
		Node sH = null;
		Node sT = null;
		Node eH = null;
		Node eT = null;
		Node bH = null;
		Node bT = null;
		//用于将节点从链表解耦
		Node next = null;
		while(head != null) {
			//记录下一个节点
			next = head.next;
			//与链表断开
			head.next = null;
			if(head.value<num) {
				if(null == sH) {
					sH = head;
					sT = head;
				}else {
					sT.next = head;
					sT = sT.next;
				}
			}else if(head.value==num) {
				if(null == eH) {
					eH = head;
					eT = head;
				}else {
					eT.next = head;
					eT = eT.next;
				}
			}else {
				if(null == bH) {
					bH = head;
					bT = head;
				}else {
					bT.next = head;
					bT = bT.next;
				}
			}
			head = next;
		}
		
		//将三个串合起来
		//如果第一个存在,就把第二个跟第二个头串起来
		//如果第一个不存在直接去判断第二个
		if(sH != null) {
			
			sT.next = eH;
			//如果第二个为空就跳过第二个，sT代替第二个的尾部eT
			if(eT == null) {
				eT = sT;
			}
		}
		//只要一个存在，eT就不会为null,因此前两个至少存在一个，把第三个接上
		if(eT != null) {
			eT.next = bH;
		}
		
		//返回谁
		if(null != sH) {
			return sH;
		}else if(eH != null) {
			return eH;
		}else {
			return bH;
		}
	}
	/*---------------------------------------------------------------------*/
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
	//打印链表
	public static void printLinkedList(Node node) {
		System.out.print("Linked List: ");
		while (node != null) {
			System.out.print(node.value + " ");
			node = node.next;
		}
		System.out.println();
	}
/*---------------------------------------------------------------------*/	
	public static void main(String[] args) {
		int[] arr = {6,8,3,4,4,6,7,2,4};
		Node head = creatLinkList(arr);
		printLinkedList(head);
		Node newHead = listPartition(head,4);
		printLinkedList(newHead);
		
	}
}
