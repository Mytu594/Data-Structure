package link;

public interface IQueue {
	public void clear();
	public boolean isEmpty();//�ж��Ƿ�Ϊ��
	public int length();
	public Object peek();//��ȡ����Ԫ�ز�����ֵ
	public void offer(Object x)throws Exception;//��x�����β
	public Object poll();//ɾ������Ԫ�ز�����ֵ����Ϊ�գ���null
}
