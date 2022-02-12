package BiTree;
public class LinkStack<S> {
	public Node<S> top;
	//栈置空
	public void clear() {
		top=null;
	}
	//判断栈是否为空
	public boolean isEmpty() {
		return top==null;
	}
	//获取链式栈长度
	public int length() {
		Node<S> p=top;
		int len=0;
		while(p!=null) {
			p=p.next;
			++len;
		}
		return len;
	}
	//取栈顶元素
	public S peek() {
		if(!isEmpty())
			return top.data;
		else
			return null;
	}
	//进栈
	public void push(S x) {
		Node<S> p=new Node<S>(x);
		p.next=top;
		top=p;
	}
	//出栈
	public S pop() {
		if(isEmpty())
			return null;
		else {
			Node<S> p=top;
			top=top.next;
			return p.data;
		}
	}
	//输出
	public void display() {
		Node<S> p=top;
		while(p!=null) {
			System.out.print((p.data.toString()+" "));
			p=p.next;
		}
	}
}
