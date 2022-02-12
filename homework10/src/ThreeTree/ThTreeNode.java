package ThreeTree;
public class ThTreeNode<T> {
	public T data;
	public ThTreeNode<T> lchild,mchild,rchild,child;
	public ThTreeNode()//�ս��
	{
		this(null);
	}
	public ThTreeNode(T data)//���Һ�����Ϊ��
	{
		this(data,null,null,null);
	}
	public ThTreeNode(T data,ThTreeNode<T> lchild,ThTreeNode<T> mchild,ThTreeNode<T> rchild)//�����������Һ�����Բ�Ϊ��
	{
		this.data=data;
		this.lchild=lchild;
		this.mchild=mchild;
		this.rchild=rchild;
	}
}
