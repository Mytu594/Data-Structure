package SwapPairs1_3;

class SwapPairs {
	public static Node<Integer> swap(Node<Integer> head) {
		Node<Integer> root = new Node<Integer>(0);  //定义一个空结点，方便记住交换后的头
		root.next = head;  //让链表的头结点指向空结点的下一个结点
		Node<Integer> node = root;  //保存空结点，用node去交换
		while(head.next!=null ) {
			node.next = head.next.next;
			head.next.next = node.next.next.next;
			node.next.next.next = head;
			node = node.next.next.next;
			head = node.next.next;//更新下一次交换前的头
		}
		return root.next;
	}
}
public class Swap{
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
		//打印交换前的链表
		Node<Integer> pre = head;
		while(pre != null) {
			System.out.print(pre.data+" ");
			pre = pre.next;
		}
		System.out.println();
		//调用交换方法
		head = SwapPairs.swap(head);
		//打印交换后的结果
		while(head!=null) {
			System.out.print(head.data+" ");
			head = head.next;
		}
	}
}

