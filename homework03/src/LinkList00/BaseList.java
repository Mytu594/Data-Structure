package LinkList00;

class LinkList<T> {
	public Node<T> head;
	public LinkList() {
		head = new Node<T>();  
	}
	//获取长度
	public int length() {
		Node<T> cur = head.next;
		int len = 0;
		while(cur != null) {
			cur= cur.next;
			++len;
		}
		return len;
	}
	//尾插法
	public void Tail(T x){
		Node<T> cur= head;
		while(cur.next!=null) {
			cur = cur.next;
		}
		Node<T> next = new Node<T>(x);
		cur.next = next;
	}
	//头插法
	public void Head(T x){
		Node<T> cur = head;
		Node<T> next = new Node<T>(x);
		next.next = cur.next;
		cur.next = next;
	}
	//指定插入
	public void inset(int index,T x) throws Exception {
		Node<T> cur = head.next;
		int j = 0;
		Node<T> next = new Node<T>(x);
		while(cur!=null) {
			if(j==index-1) {
				next.next = cur.next;
				cur.next = next;
			}
			j++;
			cur =cur.next;
		}
		if(index<0 ||index>this.length())
			throw new Exception("没有此位置");
	}
	//按位查找
	public T get(int x) throws Exception {
		Node<T> cur = head.next;
		int j = 0;
		while(cur!=null && j<x) {
			cur = cur.next;
			++j;
		}
		if(j>x || cur==null)
			throw new Exception("元素不存在");
		return cur.data;
	}
	//按值查找
	public int indexOf(T data) {
		Node<T> cur = head.next;
		int j = 0;
		while(cur!=null && !cur.data.equals(data)) {
			cur = cur.next;
			++j;
		}
		if(cur != null)
			return j;
		else
			return -1;
	}
	//删除结点
	public void remove(int x) throws Exception {
		Node<T> cur = head;
		int j = 0;
		while(cur.next!=null && j<x) {
			cur = cur.next;
			j++;
		}
		if(j>x || cur.next==null)
			throw new Exception("没有此位置");
		cur.next = cur.next.next;
	}
	//输出结点
	public void display() {
		Node<T> node = head.next;
		while(node != null) {
			System.out.print(node.data+" ");
			node = node.next;
		}
		System.out.println();
	}
}
public class BaseList<T> {
	public static void main(String[] args) throws Exception{
		LinkList<Integer> LA= new LinkList<Integer>();
		Integer s = 1;
		for(int i=0; i<5; i++) {
			LA.Head(s);
			s += 2;
		}
		System.out.print("逆序(头插法):");
		LA.display();
		System.out.print("插入一个数:");
		LA.inset(1, 594);
		LA.display();	
		System.out.print("7的位置:");
		System.out.println(LA.indexOf(7));
		LinkList<Integer> LB= new LinkList<Integer>();
		s=1;
		for(int i=0; i<5; i++) {
			LB.Tail(s);
			s += 2;
		}
		System.out.print("顺序(尾插法):");
		LB.display();
		System.out.print("删掉一个数:");
		LB.remove(1);
		LB.display();
	}
}