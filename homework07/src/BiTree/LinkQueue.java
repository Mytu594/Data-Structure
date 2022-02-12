package BiTree;
public class LinkQueue<S> {
	public Node<S> front;
	public Node<S> rear;
	public LinkQueue() {
		front=rear=null;
	}
	public void clear() {
		front=rear=null;
	}
	public boolean isEmpty() {
		return front==null;
	}
	public int length() {
		Node<S> p=front;
		int len=0;
		while(p!=null) {
			p=p.next;
			++len;
		}
		return len;
	}
	public S peek() {
		if(front!=null)
			return front.data;
		else
			return null;
	}
	public void offer(S x) {
		Node<S> p=new Node<S>(x);
		if(front!=null) {
			rear.next=p;
			rear=p;
		}
		else
			front=rear=p;
	}
	public S poll() {
		if(front!=null) {
			Node<S> p=front;
			front=front.next;
			if(p==rear)
				rear=null;
			return p.data;
		}
		else
			return null;
	}
}
