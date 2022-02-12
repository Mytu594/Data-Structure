package DuLLinkList01;
import java.util.Scanner;

class DuLinkList<T> {
	public DuLNode<T> head;
	//鏋勯?犲彧鍚?1涓ご缁撶偣鐨勫弻鍚戝惊鐜摼琛?
	public DuLinkList() {  
		head=new DuLNode<T>();
		head.prior=head;
		head.next=head;
	}
	public DuLinkList(int n ,boolean Order)throws Exception{  //锟斤拷锟斤拷一锟斤拷锟斤拷锟斤拷为n锟侥碉拷锟斤拷锟斤拷
		this();  
		if(Order)   
			create1(n);
		else
			create2(n);
	}
	
	public void create1(int n)throws Exception  
	{
		Scanner sc = new Scanner(System.in);
		for (int j=0;j<n;j++)
			insert(length(),sc.next());
	}
	public void create2(int n)throws Exception   
	{
		Scanner sc = new Scanner(System.in);      
		for (int j=0;j<n;j++) 
			insert(0,sc.next());   
			
	}

	public void insert(int i,Object x) throws Exception{
		DuLNode<T> p=head.next;
		int j=0;
		while(!p.equals(head) && j<i) {
			p=p.next;
			++j;
		}
		if(j!=i && !p.equals(head))
			throw new Exception("鎻掑叆浣嶇疆涓嶅悎娉?");
		DuLNode<T> s=new DuLNode<T>();
		p.prior.next=s;
		s.prior=p.prior;
		s.next=p;
		p.prior=s;
	}
	public void remove(int i) throws Exception{
		DuLNode<T> p=head.next;
		int j=0;
		while(!p.equals(head) && j<i) {
			p=p.next;
			++j;
		}
		if(i!=j)
			throw new Exception("鍒犻櫎浣嶇疆涓嶅悎鐞?");
		p.prior.next=p.next;
		p.next.prior=p.prior;
	}
	public void clear() {
		head.data=null;
		head.prior=head;
		head.next=head;
	}
	public boolean isEmpty() {
		return head.next==head;
	}
	public Object get(int i) throws Exception{
		DuLNode<T> p =head.next;
		int j = 0;
		while(p!=null&&j<i) {
			p = p.next;
			++j;
		}
		if(j>i||p==null)
		{
			throw new Exception("绗琝"+i+"涓厓绱犱笉瀛樺湪");
		}
		return p.data;
	}
	public int length() {
		DuLNode<T> p = head.next;
		int length = 0;
		while(p!=null)
		{
			p = p.next;
			++length;
		}
		return length;
	}
	public int indexOf(Object x) {
		DuLNode<T> p = head.next;
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
		DuLNode<T> node=head.next;
		while(!node.equals(head)) {
			System.out.print(node.data+" ");
			node=node.next;
		}
		System.out.println();
	}
}
public class DuLLinkList<T> {
	public static void main(String[] args) throws Exception {
		DuLNode<Integer> head = new DuLNode<Integer>(1);
		DuLNode<Integer> node1 = new DuLNode<Integer>(2);
		DuLNode<Integer> node2 = new DuLNode<Integer>(3);
		DuLNode<Integer> node3 = new DuLNode<Integer>(4);
		DuLNode<Integer> node4 = new DuLNode<Integer>(5);
		node3.next = node4;
		node2.next = node3;
		node1.next = node2;
		head.next = node1;
		DuLNode<Integer> cur = head;
		System.out.println("原链表为:");
		while(cur != null) {
			System.out.print(cur.data+" ");
			cur = cur.next;
		}
		System.out.println();
	}
}

