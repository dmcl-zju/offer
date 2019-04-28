package cn.zju.offer01;

 /**
  * ʵ������Ļ�������������ɾ������������ȡ�����Ȳ���
  * @author LIN
  *
  */
class MyLinkedList {
 	//��������ͷ
 	Node head = null;
 	/*
 	 * ���Ӳ���
 	 */
 	public boolean addNode(int data) {
 		Node newNode = new Node(data);
 		//Ϊ�ձ����
 		if(null == head) {
 			head = newNode;
 			return true;
 		}
 		//ʹ��β�巨��������
 		Node temp = head;
 		while(temp.next != null) {
 			temp = temp.next;
 		}
 		temp.next = newNode;
 		return true;
 		//System.out.println("����ɹ�");
 	}
 	/*
 	 * ��ָ���ڵ�֮�����Ԫ��
 	 */
 	public boolean addNode(int data, int index) {
 		//��������ĺϷ���
 		if(index<1 || index>length()) {
 			System.out.println("���벻�Ϸ�");
 			return false;
 		}
 		Node newNode = new Node(data);
 		//����ͷ���
 		if(1 == index) {
 			newNode.next = head;
 			head = newNode;
 			return true;
 		}
 		int i = 1;
 		Node curNode = head;
 		//Node curNode = preNode.next;
 		while(curNode.next != null) {
 			//�ҵ�Ҫɾ����ǰһ���ڵ�
 			if(i == (index-1)) {
 				//ִ�в���
 				newNode.next = curNode.next;
 				curNode.next = newNode;
 				return true;
 			}
 			//��������һ��
 			curNode = curNode.next;
 			i++;
 		}
 		System.out.println("����ʧ��");
 		return false;
 	}
 	/*
 	 * ɾ��ָ���ڵ�
 	 */
 	public boolean deleteNode(int index) {
 		//��������ĺϷ���
 		if(index<1 || index>length()) {
 			System.out.println("���벻�Ϸ�");
 			return false;
 		}
 		//ɾ��ͷ���
 		if(1 == index) {
 			head = head.next;
 			return true;
 		}
 		int i = 1;
 		Node curNode = head;
 		//Node curNode = preNode.next;
 		while(curNode.next != null) {
 			//�ҵ�Ҫɾ����ǰһ���ڵ�
 			if(i == (index-1)) {
 				//ִ�в���
 				curNode.next = curNode.next.next;
 				return true;
 			}
 			//��������һ��
 			curNode = curNode.next;
 			i++;
 		}
 		System.out.println("ɾ��ʧ��");
 		return false;
 	}
 	/*
 	 * ���������
 	 */
 	public int length() {
 		int len = 0;
 		Node temp = head;
 		while(temp != null) {
 			len++;
 			temp = temp.next;
 		}
 		return len;
 	}
 	
 	/*
 	 *	������ӡ���� 
 	 */
 	public void printList() {
 		Node temp = head;
 		while(temp != null) {
 			System.out.print(temp.data+"  ");
 			temp = temp.next;
 		}
 		System.out.println();
 	}
 	/*
 	 * ��������
 	 */
 	public void orderList() {
 		int temp;
 		Node curNode = head;
 		Node nextNode = null;
 		while(curNode.next != null)
 		{
 			nextNode = curNode.next;
 			while(nextNode != null) {
 				if(curNode.data>nextNode.data) {
 					temp = nextNode.data;
 					nextNode.data = curNode.data;
 					curNode.data = temp;
 				}
 				nextNode = nextNode.next;
 			}
 			curNode = curNode.next;
 		}
 	}
 }

 /*
  * ����Ļ�����Ԫ
  */
 class Node{
 	Node next = null;
 	int data;
 	public Node(int data) {
 		this.data = data;
 	}
 }
 
public class Solution {
    public Node ReverseList(Node head) {
       Node newListHead = null;
       Node node = head;
        Node preNode = null;
        while(node != null){
        	System.out.println("����"+node.data);
           Node nextNode = node.next;
            if(nextNode == null){
                newListHead=node;
                System.out.println("haha");
            }
            node.next = preNode;
            preNode = node;
            node = nextNode;
        }
        return newListHead;
    }
    public static void main(String[] args) {
    	MyLinkedList link  = new MyLinkedList();
 		link.addNode(1);
 		link.addNode(2);
 		//System.out.println(link.length());
 		link.addNode(3);
 		link.addNode(4);
 		link.addNode(5);
 		link.printList();
 		
 		Solution s = new Solution();
 		Node head = s.ReverseList(link.head);
 		link.head = head;
 		link.printList();
 		
    	
    }
}

