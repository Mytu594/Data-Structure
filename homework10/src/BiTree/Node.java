package BiTree;

public class Node<S>{
	public S data;
	public Node<S> next=null;
	public Node() {
		this(null);
	}
	public Node(S data) {
		this.data=data;
	}
}
