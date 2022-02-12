package stack_other;
public class LinkQueue implements IQueue{
	private Node front;//����ָ��
	private Node rear;//��βָ��
	//��������Ĺ��캯��
	public LinkQueue() {
		front=rear=null;
	}
	//�����ÿ�
	public void clear() {
		front=rear=null;
	}
	//�п�
	public boolean isEmpty() {
		return front==null;
	}
	//�󳤶�
	public int length() {
		Node p=front;
		int length=0;
		while(p!=null) {
			p=p.next;
			++length;
		}return length;
	}
	//ȡ����
	public Object peek() {
		if(front!=null)
			return front.data;
		else
			return null;
	}
	//���
	public void offer(Object x) {
		Node p=new Node(x);
		if(front!=null) {
			rear.next=p;
			rear=p;
		}
		else
			front=rear=p;
	}
	//����
	public Object poll() {
		if(front!=null) {  //���зǿ�
			Node p=front;
			front=front.next;  //���׽ڵ����
			if(p==rear)  //��ɾ���Ľڵ��Ƕ�β�ڵ�ʱ
				rear=null;
			return p.data;  //���ض��׽ڵ��������ֵ
		}
		else
			return null;
	}
}
