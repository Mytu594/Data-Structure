package DuLLinkList01;

public class DuLNode<T> {
	public T data;
	public DuLNode<T> prior;
	public DuLNode<T> next;
	public DuLNode() {
		this(null);
	}
	public DuLNode(T data) {
		this.data=data;
		this.prior=null;
		this.next=null;
	}

}
