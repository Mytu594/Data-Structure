package DuLLinkList02_unity;
class DuLLink<S> {
	public DuLNode<S> head;
	//����ֻ��1��ͷ����˫��ѭ������
	public DuLLink() {  
		head=new DuLNode<S>();
		head.prior=head;  //˫��ѭ������
		head.next=head;
	}
	//����������
	public int length() {
		int len=0;
		DuLNode<S> pre=head.next;
		while(!pre.equals(head)) {
			pre=pre.next;
			++len;
		}
		return len;
	}
	//������
	public void insert(int i,S x) throws Exception{
		DuLNode<S> pre=head.next;
		int j=0;
		while(!pre.equals(head) && j<i) {
			pre=pre.next;
			++j;
		}
		if(j!=i && !pre.equals(head))
			throw new Exception("����λ�ò��Ϸ�");
		DuLNode<S> s=new DuLNode<S>(x);
		pre.prior.next=s;
		s.prior=pre.prior;
		s.next=pre;
		pre.prior=s;
	}
	//ɾ�����
	public void remove(int i) throws Exception {
		DuLNode<S> pre=head.next;
		int j=0;
		while(!pre.equals(head) && j<i) {
			pre=pre.next;
			++j;
		}
		if(i!=j)
			throw new Exception("ɾ��λ�ò�����");
		pre.prior.next=pre.next;
		pre.next.prior=pre.prior;
	}
	//�������
	public void clear() {
		head.data=null;
		head.prior=head;
		head.next=head;
	}
	//�ж��Ƿ�Ϊ��
	public boolean isEmpty() {
		return head.next==head;
	}
	//���ң����ֵ
	public S get(int i) throws Exception{
		DuLNode<S> pre=head.next;
		int j=0;
		while(!pre.equals(head) && j<i) {
			pre=pre.next;
			++j;
		}
		if(j>i || pre.equals(head))
			throw new Exception("��"+i+"��Ԫ�ز�����");
		return pre.data;
	}
	//���ң�����±�
	public int index(S x) {
		DuLNode<S> pre=head.next;
		int j=0;
		while(!pre.equals(head) && !pre.data.equals(x)) {
			pre=pre.next;
			++j;
		}
		if(!pre.equals(head))
			return j;
		else
			return -1;
	}
	//�������
	public void display() {
		DuLNode<S> node=head.next;
		while(!node.equals(head)) {
			System.out.print(node.data+" ");
			node=node.next;
		}
		System.out.println();
	}
	//��ת����
	public void reverse() {
		DuLNode<S> pre=head;
		DuLNode<S> cur=head.next;
        while (cur!=head) {
            DuLNode<S> temp=cur;
            cur=cur.next;  //curָ�����
            temp.next=pre;  //��ת
            pre.prior=temp;
            pre=temp;  //preָ�����
        }
        pre.prior=head;
        head.next=pre;
	}
	//����������1-2��3-4��
	public void swap1() {
		DuLNode<S> odd=head.next;
		DuLNode<S> even=odd.next;
		while(odd!=head && even!=head) {
			odd.prior.next=even;  //����1-2
			even.next.prior=odd;
			odd.next=even.next;  //�ֱ�����1��2ǰ��
			even.prior=odd.prior;
			odd.prior=even;  //����1-2
			even.next=odd;
			odd=odd.next;  //����λ��
			even=odd.next;
		}
	}
	//����������1-3��2-4��
	public void swap2() {
		DuLNode<S> cur=head;
		DuLNode<S> cure=head;
		DuLNode<S> odd=head.next;
		DuLNode<S> even=odd.next;
		int len=length();
		while(odd.next!=head && even!=head) {
			if(len==2) {  //������ʣ�������ڵ㹹��ѭ����ֱ�����
				even.next=cure;
				cure.prior=even;
				break;
			}
			else if(len==3) {
				cur.next=even.next;  //h->3
				even.next.prior=cur;
				cur=cur.next;  //h==3
				cur.next=even;  //3->2
				even.prior=cur;
				even.next=odd;  //2->1
				odd.prior=even;
				odd.next=cure;  //1->h
				cure.prior=odd;
				len-=3;
			}
			else {
				cur.next=even.next;  //h->3
				even.next.prior=cur;
				cur=cur.next.next;  //h==4
				DuLNode<S> temp=cur.next;  //��5
				cur.next=odd;  //4->1
				odd.prior=cur;
				even.next=temp;  //2->5
				temp.prior=even;
				len-=4;
				if(temp==head) {  //�����Ľ����4�ı���
					break;
				}
				else if(temp!=head && temp.next!=head) {
					even=temp.next;  //����λ��
					odd=temp;
					cur=cur.next.next;
				}
				else if(temp.next==head) {  //������ֻʣһ����㹹��ѭ����ֱ�����
					temp.next=cure;
					cure.prior=temp;
					break;
				}
			}
		}
	}
	//�������
	public void divide() {
		if(head.next==head || head.next.next==head)
			return;
		DuLNode<S> odd=head.next,even=odd.next;
		DuLNode<S> newHead=new DuLNode<S>();  //����һ���µĿ�ѭ��˫������
		newHead.next=even;  //�׸�ż���
		even.prior=newHead;
        while(odd!=head && even!=head) {
            odd.next=even.next;  //������
            even.next.prior=odd;
            odd=even.next;  //��������λ��
            even.next=odd.next;  //��ż���
            odd.next.prior=even;
            even=odd.next;  //����ż���λ��
        }
        System.out.print("������Ϊ��");
        display();
		//��ԭ˫��ѭ�������β�ж�
		even.next=null;
		System.out.print("ż����Ϊ��");
        DuLNode<S> node1=newHead.next;
		while(node1.next!=null) {
			System.out.print(node1.data+" "); 
			node1=node1.next;
		}
		System.out.println();
	}
	//˳ʱ��ݹ����
	public void clockwise(DuLNode<S> node) {
		if(node.next==head)
			return;  //���ؿ�����
		else {
			System.out.print(node.next.data+" ");
			clockwise(node.next);
		}
	}
	//��ʱ�����
	public void anticlockwise(DuLNode<S> node) {
		if(node.prior==head)
			return;  //���ؿ�����
		else {
			System.out.print(node.prior.data+" ");
			anticlockwise(node.prior);
		}
	}
	//ִ�еݹ�
	public void act() {
		System.out.print("˳ʱ�������");
		clockwise(head);
		System.out.println();
		System.out.print("��ʱ�������");
		anticlockwise(head);
		System.out.println();
	}
}
public class DuLLinkList<S> {
	public static void main(String[] args) throws Exception {
		DuLLink<Integer> dul=new DuLLink<Integer>();
		for(int i=1;i<10;i++) {
			dul.insert(dul.length(),i);
		}
		System.out.print("��������");
		dul.display();
		dul.act();
	//	dul.divide();
		System.out.print("��ת��");
		dul.reverse();
		dul.display();
		System.out.print("��������(1-2��3-4)��");
		dul.swap1();
		dul.display();
		System.out.print("��������(1-3��2-4)��");
		dul.swap2();
		dul.display();
		System.out.print("ɾ���±�Ϊ5�Ľ�㣺");
		if(data%2==1) {
			dul.remove(i);
		}
		//dul.remove(5);
		dul.display();
		System.out.println("��ȡ�±�Ϊ2�Ľ�㣺"+dul.get(2));
		System.out.println("��ȡ���5���±꣺"+dul.index(5));
		dul.clear();
		System.out.println("�����Ƿ�Ϊ�գ�"+dul.isEmpty());
	}
}
