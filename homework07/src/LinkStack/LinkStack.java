package LinkStack;

public class LinkStack implements IStack{
	private Node top;
	//���ջ
	public void clear() {
		top=null;
	}
	//�ж��Ƿ�Ϊ��
	public boolean isEmpty() {
		return top == null;
	}
	//��ջ�ĳ���
	public int length() {
		Node p=top;
		int length =0;
		while (p!=null) {
			p=p.next;
			++length;
		}
		return length;
	}
	//ȡջ��Ԫ�ز�������ֵ
	public Object peek() {
		if(!isEmpty())
			return top.data;
		else 
			return null;
	}
	//��ջ
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
	//���ջ�����е�����Ԫ��
	public void display() {
		Node p=top;
		while(p!=null) {
			System.out.print(p.data.toString()+" ");
			p=p.next;
		}
	}

}
