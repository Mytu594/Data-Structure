package ch05;
//������ʽ�洢�ṹ�Ľڵ�����������
public class BiTreeNode {
	public Object data;//�ڵ���
	public BiTreeNode lchild,rchild;//���Һ�����
	//����һ���սڵ�
	public BiTreeNode() {
		this(null);
	}
	//����һ�����Һ�����Ϊ�յĶ�����
	public BiTreeNode(Object data) {
		this(data,null,null);
	}
	//����Ϊ��
	public BiTreeNode(Object data,BiTreeNode lchild,BiTreeNode rchild) {
		this.data=data;
		this.lchild=lchild;
		this.rchild=rchild;
	}
}
