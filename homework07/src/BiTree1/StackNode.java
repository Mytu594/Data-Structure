package BiTree1;
public class StackNode<T> {
	public T data;
	public StackNode<T> next;
	public StackNode()
	{
		this(null);
	}
	public StackNode(T data)
	{
		this.data=data;
		this.next=null;
	}
}
