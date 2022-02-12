package hotpot;
import java.util.Random;
class IQueue<T>{
	public T[] queueElem;
	public int front;
	public int rear;
	@SuppressWarnings("unchecked")
	public IQueue(int size)
	{
		queueElem=(T[])new Object[size]; 
		front=rear=0;
	}
	public void clear()
	{
		front=rear=0;
	}
	public boolean isEmpty()
	{
		return front==rear;
	}
	public int length()
	{
		return (rear-front+queueElem.length) % queueElem.length;
	}
	public T peek()
	{
		if(front==rear)
			return null;
		else
			return queueElem[front];
	}
	public void push(T data)
	{
		if(front==(rear+1)%queueElem.length)
		{
			System.out.println("ȡ��̨�������޷��Ųˣ�");
		}
		else
		{
			queueElem[rear]=data;
			System.out.println("��ʦ����һ����");
			rear=(rear+1)%queueElem.length;
		}
	}
	public T pop()
	{
		if(front==rear)
			return null;
		else
		{
			T a=queueElem[front];
			front=(front+1)%queueElem.length;
			return a;
		}
	}	
}
class MyThread1 implements Runnable
{
	private String who;
	public MyThread1(String str)
	{
		who=str;
	}
	public void run() {
		// TODO Auto-generated method stub
		//for(int i=0;i<2;i++)
		//{
			try {
				Thread.sleep((int)(1000*Math.random()));
			}
			catch(InterruptedException e)
			{
				System.out.println(e.toString());	
			}
			hotpot.hotpot(who);
			System.out.println(who+"���겢���ˣ���");
			System.out.println();
			
		//}
	}
}
public class hotpot {
	public static void hotpot(String name)
	{
		IQueue<Integer> b=new IQueue<Integer>(15);
		int q=0;
		b.push(1);
		while(b.peek()!=null)
		{
			Random j=new Random();
			float z=j.nextFloat();
			if(z>0.5)
			{
				b.push(1);		
			}
			else
			{
				if(b.peek()!=null)
				{
					b.pop();
					q++;
					System.out.println("�˿�ȡ�߲�̨��һ���ˣ�");
				}
			}
		}
		int j=q*20;
		System.out.println();
		System.out.println(name+"����"+q+"����");
		System.out.println("����"+j+"Ԫ");
		System.out.println("֧��������"+j+"Ԫ");
		System.out.println("��ӭ�´ι���С�꣬�������������ǵ����޶���");
	}
	public static void main(String[] args) {
		MyThread1 No1=new MyThread1("1�Ź˿�");
		MyThread1 No2=new MyThread1("2�Ź˿�");
		MyThread1 No3=new MyThread1("3�Ź˿�");
		MyThread1 No4=new MyThread1("4�Ź˿�");
		Thread n1=new Thread(No1);
		Thread n2=new Thread(No2);
		Thread n3=new Thread(No3);
		Thread n4=new Thread(No4);
		n1.start();
		n2.start();
		n3.start();
		n4.start();		
	}

}
