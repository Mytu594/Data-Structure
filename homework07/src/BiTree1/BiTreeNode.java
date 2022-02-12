package BiTree1;
public class BiTreeNode<T> {
	
	public T data;
	public BiTreeNode<T> lchild,rchild;
	public BiTreeNode()//空结点
	{
		this(null);
	}
	public BiTreeNode(T data)//左、右孩子域为空
	{
		this(data,null,null);
	}
	public BiTreeNode(T data,BiTreeNode<T> lchild,BiTreeNode<T> rchild)//数据域与左右孩子域皆不为空
	{
		this.data=data;
		this.lchild=lchild;
		this.rchild=rchild;
	}
}
