package yanghui;

import java.util.Scanner;

public class yanghui2 {
	CircleSqQueue queue=new CircleSqQueue(11);
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
					queue.offer(1);
					temp=queue.poll();
					System.out.println(temp);
					queue.offer(temp+peeknum);
					queue.offer(1);
					queue.offer(-1);//-1��Ϊ1��������
				}
				else
				{
					count=0;
					while(count==0)
					{
						temp=queue.poll();
						System.out.print(temp+" ");
						peeknum=queue.peek();
						if(peeknum!=-1)
						{
							queue.offer(temp+peeknum);
						}
						else
						{
							queue.offer(1);
							queue.offer(-1);
							queue.poll();//��-1poll
							peeknum=queue.peek();
							queue.offer(temp+peeknum);
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
