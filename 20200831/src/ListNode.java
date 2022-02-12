
public class ListNode {
	public Object data;
	public ListNode next;
	public ListNode() {
		this(null,null);
	}
	public ListNode(Object data) {
		this(data,null);
	}
	public ListNode(Object data,ListNode next)
	{
		this.data = data;
		this.next =next;
	}
}