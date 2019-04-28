package cn.zju.offer01;



public class linkListSEB {
	
	public static class Node{
		public int value;
		public Node next;
		public Node(int value) {
			this.value = value;
		}
	}
	//����ĺ�����������
	public static Node listPartition(Node head,int num) {
		Node sH = null;
		Node sT = null;
		Node eH = null;
		Node eT = null;
		Node bH = null;
		Node bT = null;
		//���ڽ��ڵ���������
		Node next = null;
		while(head != null) {
			//��¼��һ���ڵ�
			next = head.next;
			//������Ͽ�
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
		
		//��������������
		//�����һ������,�Ͱѵڶ������ڶ���ͷ������
		//�����һ��������ֱ��ȥ�жϵڶ���
		if(sH != null) {
			
			sT.next = eH;
			//����ڶ���Ϊ�վ������ڶ�����sT����ڶ�����β��eT
			if(eT == null) {
				eT = sT;
			}
		}
		//ֻҪһ�����ڣ�eT�Ͳ���Ϊnull,���ǰ�������ٴ���һ�����ѵ���������
		if(eT != null) {
			eT.next = bH;
		}
		
		//����˭
		if(null != sH) {
			return sH;
		}else if(eH != null) {
			return eH;
		}else {
			return bH;
		}
	}
	/*---------------------------------------------------------------------*/
	//��һ������ת����������������ͷ
	public static Node creatLinkList(int[] arr) {
		//head��¼����ͷ
		Node head = null;
		//tail��¼����β
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
	//��ӡ����
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
