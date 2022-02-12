package ch05;
//二叉链式存储结构的节点类描述如下
public class BiTreeNode {
	public Object data;//节点域
	public BiTreeNode lchild,rchild;//左右孩子域
	//构造一个空节点
	public BiTreeNode() {
		this(null);
	}
	//构造一颗左右孩子域为空的二叉树
	public BiTreeNode(Object data) {
		this(data,null,null);
	}
	//都不为空
	public BiTreeNode(Object data,BiTreeNode lchild,BiTreeNode rchild) {
		this.data=data;
		this.lchild=lchild;
		this.rchild=rchild;
	}
}
