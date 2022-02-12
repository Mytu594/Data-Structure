
class odd{
	//输出奇数
	public void odd(Node<Integer> head){
		Node<Integer> root = new Node<Integer>(0);  
		root=head.next;
		while(root!=null) {
			if(root.getdata()%2!=0)
				System.out.print(root.getdata()+" ");
				root=root.next;
		}
	}
}
public class putOdd {
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Node<Integer> head1 = new Node<Integer>(0);
		Node<Integer> node1 = new Node<Integer>(1);
		Node<Integer> node2 = new Node<Integer>(2);
		Node<Integer> node3 = new Node<Integer>(3);
		Node<Integer> node4 = new Node<Integer>(4);
		Node<Integer> node5 = new Node<Integer>(5);
		node4.next = node5;
		node3.next = node4;
		node2.next = node3;
		node1.next = node2;
		head1.next = node1;
		Node<Integer> pre = head1;
		while(pre != null) {
			System.out.print(pre.data+" ");
			pre = pre.next;
		}
		pre = head1;
		System.out.println();
		odd s=new odd();
		s.odd(pre);
	}
}


