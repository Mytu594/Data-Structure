package BiTree;

public class BiTreeNode<S> {
	public S data;
	public BiTreeNode<S> lchild,rchild;
	//����һ���ս��
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
