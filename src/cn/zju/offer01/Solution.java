package cn.zju.offer01;

 /**
  * 实现链表的基本操作：增、删、差、遍历、长度、排序等操作
  * @author LIN
  *
  */
class MyLinkedList {
 	//定义链表头
 	Node head = null;
 	/*
 	 * 增加操作
 	 */
 	public boolean addNode(int data) {
 		Node newNode = new Node(data);
 		//为空表情况
 		if(null == head) {
 			head = newNode;
 			return true;
 		}
 		//使用尾插法插入数据
 		Node temp = head;
 		while(temp.next != null) {
 			temp = temp.next;
 		}
 		temp.next = newNode;
 		return true;
 		//System.out.println("插入成功");
 	}
 	/*
 	 * 在指定节点之后插入元素
 	 */
 	public boolean addNode(int data, int index) {
 		//检查索引的合法性
 		if(index<1 || index>length()) {
 			System.out.println("输入不合法");
 			return false;
 		}
 		Node newNode = new Node(data);
 		//插入头结点
 		if(1 == index) {
 			newNode.next = head;
 			head = newNode;
 			return true;
 		}
 		int i = 1;
 		Node curNode = head;
 		//Node curNode = preNode.next;
 		while(curNode.next != null) {
 			//找到要删除的前一个节点
 			if(i == (index-1)) {
 				//执行操作
 				newNode.next = curNode.next;
 				curNode.next = newNode;
 				return true;
 			}
 			//遍历到下一个
 			curNode = curNode.next;
 			i++;
 		}
 		System.out.println("插入失败");
 		return false;
 	}
 	/*
 	 * 删除指定节点
 	 */
 	public boolean deleteNode(int index) {
 		//检查索引的合法性
 		if(index<1 || index>length()) {
 			System.out.println("输入不合法");
 			return false;
 		}
 		//删除头结点
 		if(1 == index) {
 			head = head.next;
 			return true;
 		}
 		int i = 1;
 		Node curNode = head;
 		//Node curNode = preNode.next;
 		while(curNode.next != null) {
 			//找到要删除的前一个节点
 			if(i == (index-1)) {
 				//执行操作
 				curNode.next = curNode.next.next;
 				return true;
 			}
 			//遍历到下一个
 			curNode = curNode.next;
 			i++;
 		}
 		System.out.println("删除失败");
 		return false;
 	}
 	/*
 	 * 输出链表长度
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
 	 *	遍历打印链表 
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
 	 * 链表排序
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
  * 链表的基本单元
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
        	System.out.println("数据"+node.data);
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

