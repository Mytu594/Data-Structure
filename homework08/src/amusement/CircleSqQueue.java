package amusement;

import java.lang.reflect.Array;

public class CircleSqQueue<T> {
	private T[] flagElem;
	private T[] queueElem;
	private int head;//���׵�����
	private int tail;//��β������
	public CircleSqQueue(Class<T> type, int maxSize) {
		queueElem = (T[])Array.newInstance(type, maxSize + 1);
		head = tail = 0;//���ס���β��ʼ��Ϊnull
    }
	public void clear()//�����ÿ�
	{
		head = tail = 0;
	}
	public boolean isEmpty()//�ж��Ƿ�Ϊ��
	{
		return (head+1) % queueElem.length == tail;
	}
	public boolean full() {
		return (tail + 1) % queueElem.length == head;
	}
	public int length() {
		return (tail - head + queueElem.length) % queueElem.length;
	}
	public T peek()//��ȡ����Ԫ��
	{
		if(head == tail)
			return null;
		else
			return queueElem[head];
	}
	public void offer(T x)throws Exception//���
	{
		if((tail + 1) % queueElem.length == head)
		{
			throw new Exception("��������");
		}
		else
		{
			queueElem[tail] = x;
			tail = (tail + 1) % queueElem.length;//�޸Ķ�βָ��
		}
	}
	public T poll()//��ջ
	{
		if(head == tail)//����Ϊ��
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
			System.out.println("�˶���Ϊ�գ�");
	}
}