package LinkList;

class ListNode{
    int val;
    ListNode next;
 
    ListNode(int x){
        val = x;
    }
}
public class mergeTwoLists {

	public static ListNode mergeTwoList(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
 
        ListNode head = null;
        if (l1.val <= l2.val){
            head = l1;
            head.next = mergeTwoList(l1.next, l2);
        } else {
            head = l2;
            head.next = mergeTwoList(l1, l2.next);
        }
        return head;
	}

	public static ListNode oddEvenList(ListNode head) 
    {
        if(head==null)
            return null;
        if(head.next==null||head.next.next==null)
            return head;
        ListNode odd=head;
        ListNode even=head.next;
        ListNode evenhead=even;//此处的evenhead是链表奇偶化之后偶半链的第一个节点，在下买你的while循环中，evenhead一直处于无前驱节点状态
        while(odd.next!=null&&even.next!=null){
            odd.next=odd.next.next;
            even.next=even.next.next;
            odd=odd.next;
            even=even.next;
        }//经过while循环之后，实际上链表已经被切成两半了，一般是奇链表，一半是偶链表，其中保留了两个指针，一个是odd奇链表的最后一个元素，evenhead是偶链表的第一个节点。
        odd.next=evenhead;//将奇偶链表连接起来
        return head;
	}

	public static void main(String[] args)throws Exception{
		ListNode head1=new ListNode(0);
		ListNode node1=new ListNode(2);
		ListNode node2=new ListNode(4);
		ListNode node3=new ListNode(6);
		ListNode node4=new ListNode(8);
		ListNode node5=new ListNode(10);
		node1.next=node2;
		node2.next=node3;
		node3.next=node4;
		node4.next=node5;
		head1.next=node1;
		ListNode head2=new ListNode(1);
		ListNode node6=new ListNode(3);
		ListNode node7=new ListNode(5);
		ListNode node8=new ListNode(7);
		ListNode node9=new ListNode(9);
		ListNode node10=new ListNode(11);
		node6.next=node7;
		node7.next=node8;
		node8.next=node9;
		node9.next=node10;
		head2.next=node6;
		ListNode pre1 = head1;
		ListNode pre2 = head2;
		System.out.println("第一条链表:");
		while(pre1 != null) {
			System.out.print(pre1.val+" ");
			pre1 = pre1.next;
		}
		System.out.println();
		System.out.println("第二条链表:");
		while(pre2 != null) {
			System.out.print(pre2.val+" ");
			pre2 = pre2.next;
		}
		System.out.println();
		System.out.println("合二为一:");
		ListNode head = mergeTwoList(head1, head2);
		//打印交换后的结果
		while(head!=null) {
			System.out.print(head.val+" ");
			head = head.next;	
			}
		System.out.println();
		System.out.println("一分为二:");
		ListNode head3 = oddEvenList(head1);
		//打印交换后的结果
		while(head3!=null) {
			System.out.print(head3.val+" ");
			head3 = head3.next;	
		}
	}
}
