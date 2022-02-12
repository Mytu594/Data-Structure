package BiTree1;
public class QueueNode<T> {
	public T data;
	public QueueNode<T> next;
	public QueueNode()
	{
		this(null);
	}
	public QueueNode(T data)
	{
		this.data=data;
		this.next=null;
	}
}
