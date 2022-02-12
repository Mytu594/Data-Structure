package Hotpot;
import java.lang.reflect.Array;
public class CircleSqQueue<S> {
		private S[] queueElem;
		private int head;//���׵�����
		private int tail;//��β������
		@SuppressWarnings("unchecked")
		public CircleSqQueue(Class<S> type,int maxSize) {
			head=tail=0;
			queueElem=(S[]) Array.newInstance(type,maxSize);
		}
		public void clear()//�����ÿ�
		{
			head=tail=0;
		}
		public boolean isEmpty()//�ж��Ƿ�Ϊ��
		{
			return head==tail;
		}
		public boolean isFull()//�ж��Ƿ�Ϊ��
		{
			if((tail+1)%queueElem.length==head)
				return true;
			else
				return false;
		}
		public int length()//����еĳ���
		{
			return (tail-head+queueElem.length)%queueElem.length;
		}
		@SuppressWarnings("null")
		public S peek()//��ȡ����Ԫ��
		{
			if(head==tail)
				return  null;
			else
				return queueElem[head];
		}
		public void offer(S i)throws Exception//���
		{
			if((tail+1)%queueElem.length==head)
			{
				throw new Exception("��������");
			}
			else
			{
				queueElem[tail]=i;
			}
			tail=(tail+1)%queueElem.length;//�޸Ķ�βָ��
		}
		@SuppressWarnings("null")
		public S poll()//��ջ
		{
			if(head==tail)//����Ϊ��
				return null;
			else
			{
				S t=queueElem[head];
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
}
