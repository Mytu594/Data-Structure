package ThreeTree;
public class ThTreeNode<T> {
	public T data;
	public ThTreeNode<T> lchild,mchild,rchild,child;
	public ThTreeNode()//空结点
	{
		this(null);
	}
	public ThTreeNode(T data)//左、右孩子域为空
	{
		this(data,null,null,null);
	}
	public ThTreeNode(T data,ThTreeNode<T> lchild,ThTreeNode<T> mchild,ThTreeNode<T> rchild)//数据域与左右孩子域皆不为空
	{
		this.data=data;
		this.lchild=lchild;
		this.mchild=mchild;
		this.rchild=rchild;
	}
}
