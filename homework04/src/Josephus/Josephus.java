package Josephus;

public class Josephus {
	public static void main(String[] args) {
		SLineList s = new SLineList();
		//��������m
		int m = 50;
		s.init();
		//����һ����m������ѭ������
		for(int i=1;i<=m;i++){
			s.addNode(i);
		}
		s.josephus(3);
		s.list();
	}
	
	//��������
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
		//����ͷ���
		private Node head;
		//����β���
		private Node rear;
		//����������
		private int size;
		public void init(){
			head = new Node();
			rear = new Node();
			head.next = rear;
			rear.next = head;
			size = 0;
		}
		//��ӽ��(β�巨)
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
		//ѭ������ı���
		public void list(){	
			if(head.next == rear){
				System.out.println("������");
				System.out.println("����ĳ���" + size);		
			}else if(head.next.next == rear){
				System.out.println(head.next.data);
				System.out.println("����ĳ���" + size);
			}else{
				Node temp = head;
				while(temp.next.next != rear){
					temp = temp.next;
					System.out.print(temp.data + "->");
				}
				temp = temp.next;
				System.out.println(temp.data);
				System.out.println("����ĳ���" + size);
			}
		}
		//josephus���� 41����1-3����,����3����ɱ,���ʣ���2���˽������
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

