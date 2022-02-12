package BiTree;

public class BiTreeNode<S> {
	public S data;
	public BiTreeNode<S> lchild,rchild;
	//构造一个空结点
	public BiTreeNode() {
		this(null);
	}
	public BiTreeNode(S data) {
		this(data,null,null);
	}
	public BiTreeNode(S data,BiTreeNode<S> lchild,BiTreeNode<S> rchild) {
		this.data=data;
		this.lchild=lchild;
		this.rchild=rchild;
	}
}
