package LinkList00;

class Reverse<T> {
	public Node<T> reverse(Node<T> head) {
		Node<T>  H1 = null; 
		Node<T> cur = head;
		while(cur != null) {
			head = cur.next; 
			cur.next = H1;;
			H1 = cur;
			cur = head; 
		}
		return H1;
	}
}
public class ReverseLink {
	public static void main(String[] args) {
		Node<Integer> head = new Node<Integer>(1);
		Node<Integer> node1 = new Node<Integer>(2);
		Node<Integer> node2 = new Node<Integer>(3);
		Node<Integer> node3 = new Node<Integer>(4);
		Node<Integer> node4 = new Node<Integer>(5);
		node3.next = node4;
		node2.next = node3;
		node1.next = node2;
		head.next = node1;
		Node<Integer> cur = head;
		System.out.println("原链表:");
		while(cur != null) {
			System.out.print(cur.data+" ");
			cur = cur.next;
		}
		System.out.println();
		Reverse<Integer> list = new Reverse<Integer>();
		head = list.reverse(head);
		System.out.println("转置后:");
		while(head!=null) {
			System.out.print(head.data+" ");
			head = head.next;
		}
	}
}