package BiTree1;
public class BiTreeNode<T> {
	
	public T data;
	public BiTreeNode<T> lchild,rchild;
	public BiTreeNode()//�ս��
	{
		this(null);
	}
	public BiTreeNode(T data)//���Һ�����Ϊ��
	{
		this(data,null,null);
	}
	public BiTreeNode(T data,BiTreeNode<T> lchild,BiTreeNode<T> rchild)//�����������Һ�����Բ�Ϊ��
	{
		this.data=data;
		this.lchild=lchild;
		this.rchild=rchild;
	}
}
