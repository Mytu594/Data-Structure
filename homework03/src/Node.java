

//���ͽڵ���
public class Node<T> {
	public T data;
	public Node<T> next;
	public Node() {
		this(null,null);
	}
	public Node(T data) {
		this(data,null);
	}
	public Node(T data,Node<T> next) {
		this.data = data;
		this.next = next;
	}
	public T getdata() {
		// TODO �Զ����ɵķ������
		return this.data;
	}
}
