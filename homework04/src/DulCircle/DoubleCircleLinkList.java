package DulCircle;

import java.util.*;
public class DoubleCircleLinkList<T> {
	public class DCLLNode 
	{
		private T data;
		private DCLLNode prev;
		private DCLLNode next;
		public DCLLNode(T data)
		{
			this.data=data;
			prev=null;
			next=null;
		}
	}
	DCLLNode head;
	public DoubleCircleLinkList()
	{
		head=new DCLLNode(null);
		head.prev=head;
		head.next=head;
	}
	public void display()//���
	{
		DCLLNode node=head;
		if(head.next==head)//�жϿ�����
			System.out.println("��ǰ����Ϊ��");
		while(node.next!=head)
		{
			node=node.next;
			System.out.print(node.data+" ");
		}
		System.out.println();
	}
	public void addtail(T data)//��β����ӽڵ�
	{
		DCLLNode node=new DCLLNode(data);
		node.prev=head.prev.next;
		node.next=head;
		head.prev.next=node;
		head.prev=node;	
}
	public int getLength()//������
	{
		int count=0;
		DCLLNode node=head.next;
		if(head.next==head)//�жϿ�����
			return 0;
		while(node!=head)
		{
			node=node.next;
			count++;
		}
		return count;
	}
	public void insertNode(int i,T data)//������
	{
		DCLLNode node=new DCLLNode(data);
		DCLLNode p=head;
		DCLLNode q=head.prev;
		int p1=0,q1=getLength();
		while(p!=q)
		{
			if(getLength()<i-1 || i==0)
			{
				System.out.println("����λ�ó���");
				break;
			}
			if(p1==i-1)
			{
				node.next=p.next;
				p.next=node;
				node.prev=p;
				node.next.prev=node;
				break;
			}
			else if(q1==i)
			{
				node.prev=q.prev;
				q.prev=node;
				node.next=q;
				node.prev.next=node;
				break;
			}
			else
			{
				p=p.next;
				p1++;
				q=q.prev;
				q1--;
			}
		}
		display();
	}
	public void deleteNode(int index)//��λ�ò��Ҳ�ɾ���ڵ�
	{
		DCLLNode p=head;
		DCLLNode q=head.prev;
		int p1=0,q1=getLength();
		while(p!=q)
		{
			if(getLength()<index || index==0)
			{
				System.out.println("ɾ��λ�ó���");
				break;
			}
			if(p1==index)
			{
				p.prev.next=p.next;
				p.next.prev=p.prev;
				break;
			}
			else if(q1==index)
			{
				q.prev.next=q.next;
				q.next.prev=q.prev;
				break;
			}
			else
			{
				p=p.next;
				p1++;
				q=q.prev;
				q1--;
			}
		}
		display();
	}
	public void removeNode(T data)//��ֵ���Ҳ�ɾ���ڵ�
	{
		if(getLength()==0)
			System.out.println("��ǰ����Ϊ��");
		else 
		{
			DCLLNode p=head;
			DCLLNode q=head.prev;
			int oddLength=getLength();
			while(p!=q)
			{
				if(p.data==data)
				{
					p.prev.next=p.next;
					p.next.prev=p.prev;
					p=p.next;
					if(q.data==q.data && q.data==data)
					{
						q.prev.next=q.next;
						q.next.prev=q.prev;
						break;
					}
				}
				else if(q.data==data)
				{
					q.prev.next=q.next;
					q.next.prev=q.prev;
					q=q.prev;
				}
				else
				{
					p=p.next;
					if(p==q)
						break;
					else
						q=q.prev;
				}
			}
			int newLength=getLength();
			if(oddLength==newLength)
				System.out.println("���޴�ֵ");
			else
				display();
		}
	}
	public void InvertNode()//����
	{
		if(getLength()==0)
			System.out.println("��ǰ����Ϊ��");
		else
		{
			DCLLNode head1= new DCLLNode(null);
			DCLLNode node=head.prev;
			node.next=head1;
			head1.next=head.next;//head1����ĩβ�ڵ�
			head1.prev=node;
			node=head.next;
			head=head1;//head����ĩβ�ڵ�
			node.prev=head;
			DCLLNode p;
			while(node!=head)//ÿ���ڵ���ָ�뽻��
			{
				p=node.prev;
				node.prev=node.next;
				node.next=p;
				node=node.prev;
			}
			p=head.prev;
			head.prev=head.next;
			head.next=p;
		}
		display();
	}
	public void ParitySwap()//��ż����
	{
		 if(getLength()==0)
			 System.out.println("��ǰ����Ϊ��");
		 else if(getLength()==1)
			 display();
		 else
		 {
			 DCLLNode odd=head.next;
			 odd.prev=head;
			 DCLLNode even;
			 while(odd!=head)
			 {
				 if(odd.next==head)
				 {
					 break;
				 }
				 else
				 {
					 even=odd.next;
					 odd.prev.next=even;
					 odd.next.prev=odd.prev;//����ɾ���ڵ�odd
					 odd.next=even.next;
					 even.next=odd;
					 odd.prev=even;
					 odd.next.prev=odd;//�������odd��even����
					 odd=odd.next;
				}
			}
			 head.prev=odd;
			 display();
		 }
	}
	public void Recursion1(DCLLNode dulnode)//�ݹ�˳�����
	{
		DCLLNode node=dulnode.next;
		if(getLength()==0)
			System.out.println("��ǰ����Ϊ��");
		else
		{
			if(node==head)
				return ;
			else
			{
				System.out.print(node.data+" ");
				Recursion1(node);
			}
		}
	}
	public void Recursion2(DCLLNode dulnode)//�ݹ��������
	{
		DCLLNode node=dulnode.next;
		if(getLength()==0)
			System.out.println("��ǰ����Ϊ��");
		else
		{
			if(node==head)
				return ;
			else
			{
				Recursion2(node);
				System.out.print(node.data+" ");
			}
		}
	}
	public void Separate(DCLLNode n1,DCLLNode n2)//����
	{
		if(getLength()==0)
			System.out.println("��ǰ����Ϊ�ղ����Ϸ�������");
		else
		{
			DCLLNode node;//��¼��ǰ�ڵ�
			while(head.next!=head)//�ж�ԭ�����Ƿ�ʣ�ڵ�
			{
				node=head.next;
				head.next=node.next;
				node.next.prev=head;
				node.prev=n1.prev.next;
				node.next=n1;
				n1.prev.next=node;
				n1.prev=node;
				if(head.next!=head)
				{
					node=head.next;
					head.next=node.next;
					node.next.prev=head;
					node.prev=n2.prev.next;
					node.next=n2;
					n2.prev.next=node;
					n2.prev=node;
				}
				else
					break;
			}
			head.prev=null;
			head.next=null;
		}		
	}
	public void mergeList(DCLLNode head1,DCLLNode head2,DCLLNode head3)//�ϲ�����
	{
		if(head1.next==head1)
		{
			if(head2.next==head2)
				System.out.println("�������Ϊ��");
			else
			{
				head3.next=head2.next;
				head2.next.prev=head3;
				head3.prev=head2.prev;
				head2.prev.next=head3;
				head2.next=null;
				head2.prev=null;
			}
		}
		else if(head2.next==head2)
		{
			head3.next=head1.next;
			head1.next.prev=head3;
			head3.prev=head1.prev;
			head1.prev.next=head3;
			head1.next=null;
			head1.prev=null;
		}		
else
		{
			int d1,d2;
			DCLLNode p1,p2;
			p1=head1.next;
			p2=head2.next;
			while(head2.next!=head2 && head1.next!=head1)
			{
				d1=Integer.valueOf(p1.data.toString());
				d2=Integer.valueOf(p2.data.toString());
				if(d1<=d2)
				{
					head1.next=p1.next;
					p1.next.prev=head1;//����ɾ��p1
					p1.prev=head3.prev.next;
					p1.next=head3;
					head3.prev.next=p1;
					head3.prev=p1;//����p1����������3
					if(head1.next==head1)
						break;
					else
						p1=head1.next;
					if(d1==d2)
					{
						head2.next=p2.next;
						p2.next.prev=head2;//����ɾ��p2
						if(head2.next==head2)
							break;
						else
							p2=head2.next;
					}
				}
				else
				{
					head2.next=p2.next;
					p2.next.prev=head;//����ɾ��p2
					p2.prev=head3.prev.next;
					p2.next=head3;
					head3.prev.next=p2;
					head3.prev=p2;//����p2����������3
					if(head2.next==head)
						break;
					else
						p2=head2.next;
				}
			}
			if(head1.next!=head1)
			{
				head3.prev.next=head1.next;
				head1.next.prev=head3.prev;
				head1.prev.next=head3;
				head1.prev=null;
				head1.next=null;
			}
			if(head2.prev!=head2)
			{
				head3.prev.next=head2.next;
				head2.next.prev=head3.prev;
				head2.prev.next=head3;
				head2.prev=null;
				head2.next=null;
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*DoubleCircleLinkList<Integer> dclist=new DoubleCircleLinkList();//�����������
		Scanner reader=new Scanner(System.in);
		System.out.println("������������:");
		int length=reader.nextInt();
		System.out.println("������"+length+"���ڵ�ֵ");
		for(int i=0;i<length;i++)
		{
			Scanner sc=new Scanner(System.in);
			dclist.addtail(sc.nextInt());
		}
		System.out.println("��������:");
		dclist.display();
		
		//����ڵ�
		Scanner reader1=new Scanner(System.in);
		System.out.println("���������ڵ�λ��:");
		int index=reader1.nextInt();
		Scanner reader2=new Scanner(System.in);
		System.out.println("���������ڵ�ֵ:");
		int data=reader2.nextInt();
		dclist.insertNode(index,data);
		
		//��λ�ò��Ҳ�ɾ��
		Scanner reader3=new Scanner(System.in);
		System.out.println("������ɾ���ڵ�λ��:");
		int index1=reader3.nextInt();
		dclist.deleteNode(index1);
		
		//��ֵ���Ҳ�ɾ��
		Scanner reader4=new Scanner(System.in);
		System.out.println("������ɾ���ڵ�ֵ:");
		int data1=reader4.nextInt();
		dclist.removeNode(data1);
		
		//����
		System.out.println("���ú�:");
		dclist.InvertNode();
		
		//��ż˳�򽻻�
		System.out.println("��ż������:");
		dclist.ParitySwap();
		
		//�ݹ�˳�����
		System.out.println("�ݹ�˳�����");
		dclist.Recursion1(dclist.head);
		
		//�ݹ��������
		System.out.println("�ݹ��������");
		dclist.Recursion2(dclist.head);
		
		//��������
		DoubleCircleLinkList<Integer> dclista=new DoubleCircleLinkList();//�����������
		DoubleCircleLinkList<Integer> dclistb=new DoubleCircleLinkList();//�����������
		dclist.Separate(dclista.head,dclistb.head);
		System.out.println("��һ������:");
		dclista.display();
		System.out.println("�ڶ�������:");
		dclistb.display();*/
		
		//�ϲ�����
		DoubleCircleLinkList<Integer> dclist1=new DoubleCircleLinkList();//�����������
		Scanner reader5=new Scanner(System.in);
		System.out.println("��˳���һ������������:");
		int length1=reader5.nextInt();
		System.out.println("������"+length1+"���ڵ�ֵ");
		for(int i=0;i<length1;i++)
		{
			Scanner sc1=new Scanner(System.in);
			dclist1.addtail(sc1.nextInt());
		}
		System.out.println("��������:");
		dclist1.display();
		DoubleCircleLinkList<Integer> dclist2=new DoubleCircleLinkList();//�����������
		Scanner reader6=new Scanner(System.in);
		System.out.println("������ڶ���������:");
		int length2=reader6.nextInt();
		System.out.println("��˳������"+length2+"���ڵ�ֵ");
		for(int i=0;i<length2;i++)
		{
			Scanner sc2=new Scanner(System.in);
			dclist2.addtail(sc2.nextInt());
		}
		System.out.println("��������:");
		dclist2.display();
		DoubleCircleLinkList<Integer> dclist3=new DoubleCircleLinkList();//�����������
		dclist1.mergeList(dclist1.head, dclist2.head, dclist3.head);
		System.out.println("�ϲ�������:");
		dclist3.display();
	}

}

