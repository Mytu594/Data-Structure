package DuLLinkList02_unity;
public class Unity {
	class DuLNode {
		public int data;
		public DuLNode prior;
		public DuLNode next;
		public DuLNode() {
			this(0);
		}
		public DuLNode(int data) {
			this.data=data;
			this.prior=null;
			this.next=null;
		}
	}
	public DuLNode head1;
	public DuLNode head2;
	public Unity() {
		head1=new DuLNode();
		head2=new DuLNode();
	}
	public void Add(int i) {  //head1��β�巨
		DuLNode pre=head1;
		DuLNode s=new DuLNode(i);
		if(head1.next==null) {
			head1.next=s;
			s.prior=head1;
		}
		else {
			while(pre.next!=null) {
				pre=pre.next;
			}
			pre.next=s;
			s.prior=pre;
		}
	}
	public void insert(int i) {  //head2��β�巨
		DuLNode pre=head2;
		DuLNode s=new DuLNode(i);
		if(head2.next==null) {
			head2.next=s;
			s.prior=head2;
		}
		else {
			while(pre.next!=null) {
				pre=pre.next;
			}
			pre.next=s;
			s.prior=pre;
		}
	}
	public void unity() {
		DuLNode newHead=head1.next.data<head2.next.data?head1:head2;
		DuLNode cur1=newHead==head1?head1.next:head2.next;
		DuLNode cur2=newHead==head1?head2.next:head1.next;
		DuLNode pre=null;  //newHead��ָ��
		DuLNode last;  //����cur2�ĺ�һ��Ԫ��
		while(cur1!=null && cur2!=null) {
			if(cur1.data<=cur2.data) {
				pre=cur1;
				cur1=cur1.next;
			}
			else {
				last=cur2.next;  //����cur2����һ�����
				pre.next=cur2;
				cur2.prior=pre;
				cur2.next=cur1;
				cur1.prior=cur2;
				pre=cur2;
				cur2=last;
			}
		}
		//��ʣ������
		if(cur1==null) {
			pre.next=cur2;
			cur2.prior=pre;
		}
		else if(cur2==null){
			pre.next=cur1;
			cur1.prior=pre;
		}
		display(newHead);
	}
	public void display(DuLNode Head) {
		DuLNode node=Head.next;
		while(node!=null) {
			System.out.print(node.data+" ");
			node=node.next;
		}
		System.out.println();
	}
	public void test() {
		display(head1);
		display(head2);
	}
	public static void main(String[] args) {
		Unity u=new Unity();
		for(int i=1;i<13;i+=2) {
			u.Add(i);
		}
		for(int i=2;i<12;i+=2) {
			u.insert(i);
		}
		System.out.println("�ϲ�ǰ���������ֱ�Ϊ��");
		u.test();
		System.out.println("�ϲ������Ϊ��");
		u.unity();
	}
}
