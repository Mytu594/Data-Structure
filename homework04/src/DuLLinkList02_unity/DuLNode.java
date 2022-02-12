package DuLLinkList02_unity;
public class DuLNode<S> {
	public S data;
	public DuLNode<S> prior;
	public DuLNode<S> next;
	public DuLNode() {
		this(null);
	}
	public DuLNode(S data) {
		this.data=data;
		this.prior=null;
		this.next=null;
	}
}
