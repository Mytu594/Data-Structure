package yanghui;
import java.lang.reflect.Array;
public class CircleSqQueue {
	private int[] queueElem;
	private int head;//队首的引用
	private int tail;//队尾的引用
	public CircleSqQueue(int maxSize)
	{
		head=tail=0;//队首、队尾初始化为0
		queueElem=new int[maxSize];//为队列分配maxSize个存储单位
	}
	public void clear()//队列置空
	{
		head=tail=0;
	}
	public boolean isEmpty()//判断是否为空
	{
		return head==tail;
	}
	public boolean isFull(){
		if((head+1)%queueElem.length==tail) {
			return true;
		}
		else 
			return false;
	}
	public int length()//求队列的长度
	{
		return (tail-head+queueElem.length)%queueElem.length;
	}
	@SuppressWarnings("null")
	public int peek()//读取队首元素
	{
		if(head==tail)
			return (Integer) null;
		else
			return queueElem[head];
	}
	public void offer(int x)throws Exception//入队
	{
		if((tail+1)%queueElem.length==head)
		{
			throw new Exception("队列已满");
		}
		else
		{
			queueElem[tail]=x;
		}
		tail=(tail+1)%queueElem.length;//修改队尾指针
	}
	@SuppressWarnings("null")
	public int poll()//出栈
	{
		if(head==tail)//队列为空
			return (Integer) null;
		else
		{
			int t=queueElem[head];
			head=(head+1)%queueElem.length;
			return t;
		}
	}
	public void display()//输出
	{
		if(!isEmpty())
		{
			for(int i=head;i!=tail;i=(i+1)%queueElem.length)
				System.out.print(queueElem[i]);
		}
		else
		{
			System.out.println("此队列为空");
		}
	}
}
