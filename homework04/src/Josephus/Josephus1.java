package Josephus;

class SLink extends LinkList{
	public Node head;
	public Node tail;
	public SLink() {  //构造空的循环链表
		head=new Node();
		tail=new Node();
		head.next=tail;
		tail.next=head;
	}
	public void Add(Object data) {  // 尾插法
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
				pre=pre.next;  //此时是将被踢出的前一结点
			}
			System.out.print(pre.next.data+" ");
			pre.next=pre.next.next;  //从原链中脱离
			for(int j=1;j<=(n-out);j++) {
				pre=pre.next;
			}  //遍历被踢出后的结点
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

