package BiTree1;
public class LinkStack<T> {
	public StackNode<T> top;
	public void clear()//�ÿ�
	{
		top=null;
	}
	public boolean isEmpty()//�п�
	{
		return top==null;
	}
	public int length()//����
	{
		StackNode<T> p=top;
		int length=0;
		while(p!=null)
		{
			p=p.next;
			++length;
		}
		return length;
	}
	public T peek()//ȡջ��Ԫ�ز�������ֵ
	{
		if(!isEmpty())
			return top.data;
		else
			return null;
	}
	public void push(T x)//��ջ
	{
		StackNode<T> p=new StackNode<T>(x); 
		p.next=top;
		top=p;
	}
	public T pop()//��ջ
	{
		if(isEmpty())
		{
			return null;
		}
		else
		{
			StackNode<T> p=top;
			top=top.next;
			return p.data;
		}
	}
	public void display()//���
	{
		StackNode<T> p=top;
		while(p!=null)
		{
			System.out.print(p.data.toString()+" ");
			p=p.next;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkStack<String> b=new LinkStack<String>();
		for(int i=0;i<5;i++)
		{
			b.push(i+"");
		}
		for(int i=0;i<5;i++)
		{
			System.out.print(b.pop()+" ");
		}
	}
}
