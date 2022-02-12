package yanghui;
import java.lang.reflect.Array;
public class CircleSqQueue {
	private int[] queueElem;
	private int head;//���׵�����
	private int tail;//��β������
	public CircleSqQueue(int maxSize)
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
	public boolean isFull(){
		if((head+1)%queueElem.length==tail) {
			return true;
		}
		else 
			return false;
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
}
