package yanghui;

import java.util.*;
import java.io.IOException;
@SuppressWarnings("unused")
public class yanghui {//����ɾ����β����
	private int[] queueElem;
	private int head;//���׵�����
	private int tail;//��β������
	public yanghui(int maxSize)
	{
		head=tail=0;//���ס���β��ʼ��Ϊ0
		queueElem=new int[maxSize];//Ϊ���з���maxSize���洢��λ
	}
	public void clear()//�����ÿ�
	{
		head=tail=0;
	}
	public boolean isEmpty()//�ж��Ƿ�Ϊ��
	{
		return head==tail;
	}
	public int length()//����еĳ���
	{
		return (tail-head+queueElem.length)%queueElem.length;
	}
	@SuppressWarnings("null")
	public int peek()//��ȡ����Ԫ��
	{
		if(head==tail)
			return (Integer) null;
		else
			return queueElem[head];
	}
	public void offer(int x)throws Exception//���
	{
		if((tail+1)%queueElem.length==head)
		{
			throw new Exception("��������");
		}
		else
		{
			queueElem[tail]=x;
		}
		tail=(tail+1)%queueElem.length;//�޸Ķ�βָ��
	}
	@SuppressWarnings("null")
	public int poll()//��ջ
	{
		if(head==tail)//����Ϊ��
			return (Integer) null;
		else
		{
			int t=queueElem[head];
			head=(head+1)%queueElem.length;
			return t;
		}
	}
	public void display()//���
	{
		if(!isEmpty())
		{
			for(int i=head;i!=tail;i=(i+1)%queueElem.length)
				System.out.print(queueElem[i]);
		}
		else
		{
			System.out.println("�˶���Ϊ��");
		}
	}
	public void PascalTriangle(int num) throws Exception//����������
	{
		if(num<=0)
			throw new Exception("�������벻����Ҫ��");
		else
		{
			int peeknum=0;//�������Ԫ��
			int count;//���б��
			int temp=0;//�������ֵ
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
					offer(-1);//-1��Ϊ1��������
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
							poll();//��-1poll
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
		System.out.println("��������г���:");
		int length=reader.nextInt();
		yanghui queue=new yanghui(length);
		Scanner reader1=new Scanner(System.in);
		System.out.println("����������:");
		int l=reader1.nextInt();
		queue.PascalTriangle(l);
	}

}
