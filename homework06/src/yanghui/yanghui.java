package yanghui;

import java.util.*;
import java.io.IOException;
@SuppressWarnings("unused")
public class yanghui {//队首删除队尾插入
	private int[] queueElem;
	private int head;//队首的引用
	private int tail;//队尾的引用
	public yanghui(int maxSize)
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
	public void PascalTriangle(int num) throws Exception//杨辉三角输出
	{
		if(num<=0)
			throw new Exception("您的输入不符合要求");
		else
		{
			int peeknum=0;//保存队首元素
			int count;//换行标记
			int temp=0;//保存输出值
			if(num==1)
			{
				System.out.println(1);
			}
			for(int i=1;i<=num;i++)
			{
				if(i==1)
				{
					offer(1);
					temp=poll();
					System.out.println(temp);
					offer(temp+peeknum);
					offer(1);
					offer(-1);//-1作为1的特殊标记
				}
				else
				{
					count=0;
					while(count==0)
					{
						temp=poll();
						System.out.print(temp+" ");
						peeknum=peek();
						if(peeknum!=-1)
						{
							offer(temp+peeknum);
						}
						else
						{
							offer(1);
							offer(-1);
							poll();//把-1poll
							peeknum=peek();
							offer(temp+peeknum);
							System.out.println();
							count++;
							if(i!=num)
							{
								System.out.print(1+" ");
							}
						}
					}
				}
			}
		}
	}
	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner reader=new Scanner(System.in);
		System.out.println("请输入队列长度:");
		int length=reader.nextInt();
		yanghui queue=new yanghui(length);
		Scanner reader1=new Scanner(System.in);
		System.out.println("请输入行数:");
		int l=reader1.nextInt();
		queue.PascalTriangle(l);
	}

}
