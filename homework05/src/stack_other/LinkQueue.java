package stack_other;
public class LinkQueue implements IQueue{
	private Node front;//队首指针
	private Node rear;//队尾指针
	//链队列类的构造函数
	public LinkQueue() {
		front=rear=null;
	}
	//对列置空
	public void clear() {
		front=rear=null;
	}
	//判空
	public boolean isEmpty() {
		return front==null;
	}
	//求长度
	public int length() {
		Node p=front;
		int length=0;
		while(p!=null) {
			p=p.next;
			++length;
		}return length;
	}
	//取队首
	public Object peek() {
		if(front!=null)
			return front.data;
		else
			return null;
	}
	//入队
	public void offer(Object x) {
		Node p=new Node(x);
		if(front!=null) {
			rear.next=p;
			rear=p;
		}
		else
			front=rear=p;
	}
	//出队
	public Object poll() {
		if(front!=null) {  //队列非空
			Node p=front;
			front=front.next;  //队首节点出列
			if(p==rear)  //被删除的节点是队尾节点时
				rear=null;
			return p.data;  //返回队首节点的数据域值
		}
		else
			return null;
	}
}
