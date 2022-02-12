package BiTree1;
public class LinkQueue<T> {
	public QueueNode<T> head;
	public QueueNode<T> tail;
	public LinkQueue() 
	{
		head=tail=null;
	}
	public void clear()//队列置空
	{
		head=tail=null;
	}
	public boolean isEmpty()//队列判空
	{
		return head==null;
	}
	public int length()//求队列长度
	{
		QueueNode<T> p=head;
		int length=0;
		while(p!=null)
		{
			p=p.next;
			++length;
		}
		return length;
	}
	public T peek()//取队首元素
	{
		if(head!=tail)//队列非空
			return head.data;//返回首结点数据域
		else
			return null;
	}
	public void offer(T x)//入队
	{
		QueueNode<T> p=new QueueNode<T>(x);//初始化新结点
		if(head!=null)//队列非空
		{
			tail.next=p;
			tail=p;//更新尾结点
		}
		else
			head=tail=p;
	}
	public T poll()//出队
	{
		if(head!=null)//队列非空
		{
			QueueNode<T> p=head;
			head=head.next;
			if(p==tail)//被删除结点是尾结点时
				tail=null;
			return p.data;
		}
		else
			return null;
	}
}
