package LinkStack;

public class LinkStack implements IStack{
	private Node top;
	//清空栈
	public void clear() {
		top=null;
	}
	//判断是否为空
	public boolean isEmpty() {
		return top == null;
	}
	//求栈的长度
	public int length() {
		Node p=top;
		int length =0;
		while (p!=null) {
			p=p.next;
			++length;
		}
		return length;
	}
	//取栈顶元素并返回其值
	public Object peek() {
		if(!isEmpty())
			return top.data;
		else 
			return null;
	}
	//入栈
	public void push(Object x) {
		Node p= new Node(x);
		p.next=top;
		top=p;
		
	}
	public Object pop() {
		if (isEmpty()) {
			return null;
		}
		else
		{
			Node p=top;
			top=top.next;
			return p.data;
		}
	}
	//输出栈中所有的数据元素
	public void display() {
		Node p=top;
		while(p!=null) {
			System.out.print(p.data.toString()+" ");
			p=p.next;
		}
	}

}
