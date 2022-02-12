package BiTree1;
public class LinkStack<T> {
	public StackNode<T> top;
	public void clear()//置空
	{
		top=null;
	}
	public boolean isEmpty()//判空
	{
		return top==null;
	}
	public int length()//长度
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
	public T peek()//取栈顶元素并返回其值
	{
		if(!isEmpty())
			return top.data;
		else
			return null;
	}
	public void push(T x)//入栈
	{
		StackNode<T> p=new StackNode<T>(x); 
		p.next=top;
		top=p;
	}
	public T pop()//出栈
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
	public void display()//输出
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
