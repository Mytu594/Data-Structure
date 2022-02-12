package amusement;

import java.lang.reflect.Array;

public class CircleSqQueue<T> {
	private T[] flagElem;
	private T[] queueElem;
	private int head;//队首的引用
	private int tail;//队尾的引用
	public CircleSqQueue(Class<T> type, int maxSize) {
		queueElem = (T[])Array.newInstance(type, maxSize + 1);
		head = tail = 0;//队首、队尾初始化为null
    }
	public void clear()//队列置空
	{
		head = tail = 0;
	}
	public boolean isEmpty()//判断是否为空
	{
		return (head+1) % queueElem.length == tail;
	}
	public boolean full() {
		return (tail + 1) % queueElem.length == head;
	}
	public int length() {
		return (tail - head + queueElem.length) % queueElem.length;
	}
	public T peek()//读取队首元素
	{
		if(head == tail)
			return null;
		else
			return queueElem[head];
	}
	public void offer(T x)throws Exception//入队
	{
		if((tail + 1) % queueElem.length == head)
		{
			throw new Exception("队列已满");
		}
		else
		{
			queueElem[tail] = x;
			tail = (tail + 1) % queueElem.length;//修改队尾指针
		}
	}
	public T poll()//出栈
	{
		if(head == tail)//队列为空
			return null;
		else
		{
			T t = queueElem[head];
			head = (head + 1) % queueElem.length;
			return t;
		}
	}
	public void display() {
		if(!isEmpty()) {
			for (int i = head; i != tail; i = (i + 1) % queueElem.length)
				System.out.println(queueElem[i].toString() + " ");
		}
		else
			System.out.println("此队列为空！");
	}
}