class ListNode {
  int val;
  ListNode next;
  ListNode(){ this(0,null); }
  ListNode(int x) { this(x,null); }
  ListNode(int x,ListNode next) { this.val = x;
	this.next =next; }
  
 }
public class deleteodd {
	/*
	 * ɾ�������ڵ�
	 */
	 public ListNode deleteNode(ListNode head) {
	        //��ʼ��һ������ڵ�
	    ListNode dummy = new ListNode(0);
	    //������ڵ�ָ��ͷ���
	    dummy.next = head;
	    ListNode cur = head;
	    ListNode pre = dummy;
	    while (cur != null) {
	        if (cur.val % 2 == 1) {
	            //����ҵ�Ҫɾ���Ľ�㣬ֱ�Ӱ���ɾ��
	            pre.next = cur.next;
	            break;
	        }
	        //���û�ҵ���preָ���curָ�붼ͬʱ������һ��
	        pre = cur;
	        cur = cur.next;
	    }
	    //��󷵻�����ڵ����һ����㼴��
	    return dummy.next;
	 }
	 public static void main(String[] args)throws Exception {
		 
	 }
}
