package SwapPairs1_3;

class SwapPairs {
	public static Node<Integer> swap(Node<Integer> head) {
		Node<Integer> root = new Node<Integer>(0);  //����һ���ս�㣬�����ס�������ͷ
		root.next = head;  //�������ͷ���ָ��ս�����һ�����
		Node<Integer> node = root;  //����ս�㣬��nodeȥ����
		while(head.next!=null ) {
			node.next = head.next.next;
			head.next.next = node.next.next.next;
			node.next.next.next = head;
			node = node.next.next.next;
			head = node.next.next;//������һ�ν���ǰ��ͷ
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
		//��ӡ����ǰ������
		Node<Integer> pre = head;
		while(pre != null) {
			System.out.print(pre.data+" ");
			pre = pre.next;
		}
		System.out.println();
		//���ý�������
		head = SwapPairs.swap(head);
		//��ӡ������Ľ��
		while(head!=null) {
			System.out.print(head.data+" ");
			head = head.next;
		}
	}
}

