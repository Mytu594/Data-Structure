package LinkList;

import java.util.Scanner;
/*class Node{
	public Object data;
	public int dataN;
	public Node next;
	
	public Node() {
		this(null,null,0);
	}
	public Node(Object data) {
		this(data,null,0);
	}
	public Node(Object data,Node next)
	{
		this(data,next,0);
	}
	public Node(Object data,int dataN)
	{
		this(data,null,dataN);
	}
	public Node(Object data,Node next,int dataN)
	{
		this.data = data;
		this.next =next;
		this.data = dataN;
	}
	
}*/
public class LinkList implements IList{
	public Node head;   //������ͷָ��
	public LinkList ()//������Ĺ�������
	{
		head=new Node();//��ʼ��ͷ�ڵ�
	}
	public LinkList(int n ,boolean Order)throws Exception{  //����һ������Ϊn�ĵ�����
		this();  //��ʼ��ͷ�ڵ�
		if(Order)   //��β�巨˳����������
			create1(n);
		else
			create2(n);
	}
	
	
	public void create1(int n)throws Exception   //β�巨
	{
		Scanner sc = new Scanner(System.in);
		for (int j=0;j<n;j++)
			insert(length(),sc.next());
	}
	public void create2(int n)throws Exception    //ͷ�巨
	{
		Scanner sc = new Scanner(System.in);      //������������Ķ���
		for (int j=0;j<n;j++)   //��������n���ڵ��������ֵ
			insert(0,sc.next());    //�����½ڵ���뵽��ͷ
			
	}
	
	public void insert(int i, Object x) throws Exception  //��ͷ�ڵ�Ĳ��뷽��
	{
		Node p=head;     //��ʼ��pΪͷ�ڵ㣬jΪ������
		int j=-1;
		while (p!=null&&j<i-1) {    //Ѱ�ҵ�i���ڵ��ǰ��
			p=p.next;
			++j;
		
		}
		if(j>i-1||p==null)
			throw new Exception("����λ�ò��Ϸ�");//�׳��쳣
		Node s = new Node(x);//�����½ڵ�
		s.next=p.next;   //�޸��������½ڵ���뵥������
		p.next=s;
	}

	public void clear() {
		head.data = null;
		head.next = null;		
	}
	
	public boolean isEmpty() {
		return head.next == null;
	}
	
	public int length() {
		Node p = head.next;
		int length = 0;
		while(p!=null)
		{
			p = p.next;
			++length;
		}
		return length;

	}

	public Object get(int i) throws Exception{
		Node p =head.next;
		int j = 0;
		while(p!=null&&j<i) {
			p = p.next;
			++j;
		}
		if(j>i||p==null)
		{
			throw new Exception("��"+i+"��Ԫ�ز�����");
		}
		return p.data;
	}
	
	public void remove(int i) throws Exception {
		Node p = head;
		int j = -1;
		while(p.next!=null&&j<i-1) {
			p = p.next;
			++j;
		}
		if(j<i-1||p.next==null)
			throw new Exception("ɾ��λ�ò��Ϸ�");
		p.next = p.next.next;
	}
	
	public int indexOf(Object x) {
		
		Node p = head.next;
		int j=0;
		while(p!=null&&!p.data.equals(x)) {
			p=p.next;
			++j;
		}
		if(p!=null)
			return j;
		else
			return -1;
	}

	public void display() {
		Node node=head.next;
		while(node!=null) {
			System.out.print(node.data+" ");
			node=node.next;
		}
		System.out.println();
	}
	public void asciipaixu() {
		Node p=head.next;
		Node s=head;
		
		for(int i=1;i<length();i++) {
			while(p.next!=null) {
				char c1[]=p.data.toString().toCharArray();
				int value1=Integer.valueOf(c1[0]);
				char c2[]=p.next.data.toString().toCharArray();
				int value2=Integer.valueOf(c2[0]);
				if(value1<value2) {
					p=p.next;
					s=s.next;
				}
				else {
					s.next=p.next;
					p.next=p.next.next;
					s.next.next=p;
					s=s.next;
		
				}
			}
			p=head.next;
			s=head;
		}
		
		display();
		}
		
}

	