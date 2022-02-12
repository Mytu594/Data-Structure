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
	public Node head;   //单链表头指针
	public LinkList ()//单链表的构建函数
	{
		head=new Node();//初始化头节点
	}
	public LinkList(int n ,boolean Order)throws Exception{  //构造一个长度为n的单链表
		this();  //初始化头节点
		if(Order)   //用尾插法顺序建立单链表
			create1(n);
		else
			create2(n);
	}
	
	
	public void create1(int n)throws Exception   //尾插法
	{
		Scanner sc = new Scanner(System.in);
		for (int j=0;j<n;j++)
			insert(length(),sc.next());
	}
	public void create2(int n)throws Exception    //头插法
	{
		Scanner sc = new Scanner(System.in);      //构造用于输入的对象
		for (int j=0;j<n;j++)   //逆序输入n个节点的数据域值
			insert(0,sc.next());    //生成新节点插入到表头
			
	}
	
	public void insert(int i, Object x) throws Exception  //带头节点的插入方法
	{
		Node p=head;     //初始化p为头节点，j为计数器
		int j=-1;
		while (p!=null&&j<i-1) {    //寻找第i个节点的前驱
			p=p.next;
			++j;
		
		}
		if(j>i-1||p==null)
			throw new Exception("插入位置不合法");//抛出异常
		Node s = new Node(x);//生成新节点
		s.next=p.next;   //修改链，让新节点插入单链表中
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
			throw new Exception("第"+i+"个元素不存在");
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
			throw new Exception("删除位置不合法");
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

	