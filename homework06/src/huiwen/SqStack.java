package huiwen;
//˳��ջ��
public class SqStack implements IStack{
	private Object[] stackElem;  //��������
	private int top; //�ڷǿ�ջ�У�topʼ��ָ��ջ���µ�һ������λ�ã���ջΪ��ʱ��topֵΪ0
	//ջ�Ĺ��캯��������һ������ռ�����Ϊmaxsize�Ŀ�ջ
	public SqStack(int maxSize) {
		top=0;  //��ʼ��top=0
		stackElem=new Object[maxSize];//Ϊջ����洢��λ
	}
	//�ÿ�ջ
	public void clear() {
		top=0;
	}
	//�ж��Ƿ�Ϊ��
	public boolean isEmpty(){
		return top==0;
	}
	//��ջ������Ԫ�صĸ���
	public int length() {
		return top;
	}
	//ȡջ��Ԫ��
	public Object peek() {
		if(!isEmpty())
			return stackElem[top-1];
		else
			return null;
	}
	//��ջ
	public void push (Object x)throws Exception
	{
		if(top==stackElem.length)
			throw new Exception("ջ������");
		else
			stackElem[top++]=x;
	}
	//��ջ
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
