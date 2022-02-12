package LinkList00;

class LinkList<T> {
	public Node<T> head;
	public LinkList() {
		head = new Node<T>();  
	}
	//��ȡ����
	public int length() {
		Node<T> cur = head.next;
		int len = 0;
		while(cur != null) {
			cur= cur.next;
			++len;
		}
		return len;
	}
	//β�巨
	public void Tail(T x){
		Node<T> cur= head;
		while(cur.next!=null) {
			cur = cur.next;
		}
		Node<T> next = new Node<T>(x);
		cur.next = next;
	}
	//ͷ�巨
	public void Head(T x){
		Node<T> cur = head;
		Node<T> next = new Node<T>(x);
		next.next = cur.next;
		cur.next = next;
	}
	//ָ������
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
			throw new Exception("û�д�λ��");
	}
	//��λ����
	public T get(int x) throws Exception {
		Node<T> cur = head.next;
		int j = 0;
		while(cur!=null && j<x) {
			cur = cur.next;
			++j;
		}
		if(j>x || cur==null)
			throw new Exception("Ԫ�ز�����");
		return cur.data;
	}
	//��ֵ����
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
	//ɾ�����
	public void remove(int x) throws Exception {
		Node<T> cur = head;
		int j = 0;
		while(cur.next!=null && j<x) {
			cur = cur.next;
			j++;
		}
		if(j>x || cur.next==null)
			throw new Exception("û�д�λ��");
		cur.next = cur.next.next;
	}
	//������
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
		System.out.print("����(ͷ�巨):");
		LA.display();
		System.out.print("����һ����:");
		LA.inset(1, 594);
		LA.display();	
		System.out.print("7��λ��:");
		System.out.println(LA.indexOf(7));
		LinkList<Integer> LB= new LinkList<Integer>();
		s=1;
		for(int i=0; i<5; i++) {
			LB.Tail(s);
			s += 2;
		}
		System.out.print("˳��(β�巨):");
		LB.display();
		System.out.print("ɾ��һ����:");
		LB.remove(1);
		LB.display();
	}
}