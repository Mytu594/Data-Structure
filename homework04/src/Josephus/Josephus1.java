package Josephus;

class SLink extends LinkList{
	public Node head;
	public Node tail;
	public SLink() {  //����յ�ѭ������
		head=new Node();
		tail=new Node();
		head.next=tail;
		tail.next=head;
	}
	public void Add(Object data) {  // β�巨
		Node node=new Node(data);
		if(head.next==tail) {
			node.next=tail;
			head.next=node;
		}
		else {
			Node pre=head;
			while(pre.next!=tail) {
				pre=pre.next;
			}
			node.next=tail;
			pre.next=node;
		}
	}
	public void countoff(int n) {
		Node pre=head;
		int out=n-2;
		while(pre!=pre.next) {
			for(int j=1;j<out;j++) {
				pre=pre.next;  //��ʱ�ǽ����߳���ǰһ���
			}
			System.out.print(pre.next.data+" ");
			pre.next=pre.next.next;  //��ԭ��������
			for(int j=1;j<=(n-out);j++) {
				pre=pre.next;
			}  //�������߳���Ľ��
		}
		System.out.println();
		System.out.println("Survivor is "+pre.data);
	}
}
public class Josephus1 {
	public static void main(String[] args) {
		SLink s=new SLink();
		int num=49;
		for(int i=1;i<=num;i++) {
			s.Add(i);
		}
		s.countoff(7);
		SLink s2=new SLink();
		for(int i=1;i<=num;i++) {
			s2.Add(i);
		}
		s2.countoff(9);
	}
}

