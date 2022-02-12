package BiTree1;
public class LinkQueue<T> {
	public QueueNode<T> head;
	public QueueNode<T> tail;
	public LinkQueue() 
	{
		head=tail=null;
	}
	public void clear()//�����ÿ�
	{
		head=tail=null;
	}
	public boolean isEmpty()//�����п�
	{
		return head==null;
	}
	public int length()//����г���
	{
		QueueNode<T> p=head;
		int length=0;
		while(p!=null)
		{
			p=p.next;
			++length;
		}
		return length;
	}
	public T peek()//ȡ����Ԫ��
	{
		if(head!=tail)//���зǿ�
			return head.data;//�����׽��������
		else
			return null;
	}
	public void offer(T x)//���
	{
		QueueNode<T> p=new QueueNode<T>(x);//��ʼ���½��
		if(head!=null)//���зǿ�
		{
			tail.next=p;
			tail=p;//����β���
		}
		else
			head=tail=p;
	}
	public T poll()//����
	{
		if(head!=null)//���зǿ�
		{
			QueueNode<T> p=head;
			head=head.next;
			if(p==tail)//��ɾ�������β���ʱ
				tail=null;
			return p.data;
		}
		else
			return null;
	}
}
