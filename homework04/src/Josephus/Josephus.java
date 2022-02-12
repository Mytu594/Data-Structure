package Josephus;

public class Josephus {
	public static void main(String[] args) {
		SLineList s = new SLineList();
		//定义人数m
		int m = 50;
		s.init();
		//建立一个有m个结点的循环链表
		for(int i=1;i<=m;i++){
			s.addNode(i);
		}
		s.josephus(3);
		s.list();
	}
	
	//定义结点类
	public static class Node{
		public int data;
		public Node next;
		public Node(){	}
		public Node(int data){
			this.data = data;
			this.next = null;
		}
	}
	public static  class SLineList{
		//定义头结点
		private Node head;
		//定义尾结点
		private Node rear;
		//定义链表长度
		private int size;
		public void init(){
			head = new Node();
			rear = new Node();
			head.next = rear;
			rear.next = head;
			size = 0;
		}
		//添加结点(尾插法)
		public void addNode(int data){	
			Node node = new Node(data);
			if(head.next == rear){
				node.next = rear;
				head.next = node;
				size++;
			}else{
				Node temp = head;
				while(temp.next != rear){
					temp = temp.next;
				}
				node.next = rear;
				temp.next = node;
				size++;	
			}
		}
		//循环链表的遍历
		public void list(){	
			if(head.next == rear){
				System.out.println("空链表");
				System.out.println("链表的长度" + size);		
			}else if(head.next.next == rear){
				System.out.println(head.next.data);
				System.out.println("链表的长度" + size);
			}else{
				Node temp = head;
				while(temp.next.next != rear){
					temp = temp.next;
					System.out.print(temp.data + "->");
				}
				temp = temp.next;
				System.out.println(temp.data);
				System.out.println("链表的长度" + size);
			}
		}
		//josephus问题 41个人1-3报数,数到3的自杀,最后剩余的2个人结点数据
		public void josephus(int n){
			int s = n-1;
			Node p = head;
			while(size != s){
				for(int i=0;i<s;i++){
					p = p.next;
					if(p == rear){
						p = p.next.next;
					}else if( p == head){
						p = p.next;
					}
				}
				if(p.next == rear){
					p = p.next.next;
					Node temp = p.next;
					p.next = p.next.next;
					temp = null;
					size--;
				}else if(p == head){
					p = p.next;
					Node temp = p.next;
					p.next = p.next.next;
					temp = null;
					size--;
				}else if(p == rear){
					p = p.next.next;
					Node temp = p.next;
					p.next = p.next.next;
					temp = null;
					size--;
				}else{
					Node temp = p.next;
					p.next = p.next.next;
					temp = null;
					size--;
				}		
			}
		}
	}
}

