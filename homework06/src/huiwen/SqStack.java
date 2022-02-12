package huiwen;
//顺序栈类
public class SqStack implements IStack{
	private Object[] stackElem;  //对象数组
	private int top; //在非空栈中，top始终指向栈顶下的一个储存位置，当栈为空时，top值为0
	//栈的构造函数，构造一个储存空间容量为maxsize的空栈
	public SqStack(int maxSize) {
		top=0;  //初始化top=0
		stackElem=new Object[maxSize];//为栈分配存储单位
	}
	//置空栈
	public void clear() {
		top=0;
	}
	//判断是否为空
	public boolean isEmpty(){
		return top==0;
	}
	//求栈中数据元素的个数
	public int length() {
		return top;
	}
	//取栈顶元素
	public Object peek() {
		if(!isEmpty())
			return stackElem[top-1];
		else
			return null;
	}
	//入栈
	public void push (Object x)throws Exception
	{
		if(top==stackElem.length)
			throw new Exception("栈已满！");
		else
			stackElem[top++]=x;
	}
	//出栈
	public Object pop()
	{
		if(isEmpty())
			return null;
		else
			return stackElem[--top];
	}
	public void display() {
		for (int i=top-1;i>=0;i--)
		{
			System.out.println(stackElem[i].toString()+" ");
		}
	}

}
