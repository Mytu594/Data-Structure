package LinkList00;

class SwapLists {

	//递归
		public static Node<Integer> swapPairs1(Node<Integer> head){
			if(head==null||head.next==null) {
				return head;
			}
			Node<Integer> next=head.next;
			head.next=swapPairs1(next.next);
			next.next=head;
			return next;
		}
	//非递归
		public static Node<Integer> swapPairs2(Node<Integer> head) {
			Node<Integer> root = new Node<Integer>(0);  
			root.next = head;  
			Node<Integer> node = root; 		
	while(head!=null && head.next!=null) {
				node.next = head.next;
				head.next = node.next.next;
				node.next.next = head;
				node = node.next.next;
				head = node.next;  
			}
			return root.next;
		}
	
	//输出奇数
	public static void odd(Node<Integer> head){
		Node<Integer> root = new Node<Integer>(0);  
		root=head.next;
		while(root!=null) {
			if(root.getdata()%2!=0)
				System.out.println(root.getdata());
			root=root.next;
		}
	}
}
	public class SwapPairs1_2 {
		public static void main(String[] args) {
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
			SwapLists s=new SwapLists();
			s.odd(pre);
//			while(pre != null) {
//				System.out.print(pre.data+" ");
//				pre = pre.next;
//			}
//			System.out.println();
//			System.out.println("递归结果:");
//			head1 = SwapLists.swapPairs1(head1);
//			while(head1!=null) {
//				System.out.print(head1.data+" ");
//				head1 = head1.next;
//			}
//			Node<Integer> head2 = new Node<Integer>(1);
//			Node<Integer> node5= new Node<Integer>(2);
//			Node<Integer> node6 = new Node<Integer>(3);
//			Node<Integer> node7 = new Node<Integer>(4);
//			Node<Integer> node8 = new Node<Integer>(5);
//			node7.next = node8;
//			node6.next = node7;
//			node5.next = node6;
//			head2.next = node5;
//			Node<Integer> pre2 = head2;
//			System.out.println();
//			System.out.println("非递归结果:");
//			head2 = SwapLists.swapPairs1(head2);
//			while(head2!=null) {
//				System.out.print(head2.data+" ");
//				head2 = head2.next;
//			}

		}
	}
