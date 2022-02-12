package BiTree;
public class LinkStack<S> {
	public Node<S> top;
	//ջ�ÿ�
	public void clear() {
		top=null;
	}
	//�ж�ջ�Ƿ�Ϊ��
	public boolean isEmpty() {
		return top==null;
	}
	//��ȡ��ʽջ����
	public int length() {
		Node<S> p=top;
		int len=0;
		while(p!=null) {
			p=p.next;
			++len;
		}
		return len;
	}
	//ȡջ��Ԫ��
	public S peek() {
		if(!isEmpty())
			return top.data;
		else
			return null;
	}
	//��ջ
	public void push(S x) {
		Node<S> p=new Node<S>(x);
		p.next=top;
		top=p;
	}
	//��ջ
	public S pop() {
		if(isEmpty())
			return null;
		else {
			Node<S> p=top;
			top=top.next;
			return p.data;
		}
	}
	//���
	public void display() {
		Node<S> p=top;
		while(p!=null) {
			System.out.print((p.data.toString()+" "));
			p=p.next;
		}
	}
}
