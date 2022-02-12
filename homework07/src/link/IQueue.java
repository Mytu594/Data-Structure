package link;

public interface IQueue {
	public void clear();
	public boolean isEmpty();//判断是否为空
	public int length();
	public Object peek();//读取队首元素并返回值
	public void offer(Object x)throws Exception;//将x插入队尾
	public Object poll();//删除队首元素并返回值，若为空，反null
}
