package ch05;
import link.LinkQueue;
import link.LinkStack;
public class BiTree {
	private BiTreeNode root;//���ĸ��ڵ�
	public BiTree() {  //����һ�ſ���
		this.root=null;
	}
	public BiTree(BiTreeNode root) { //����һ����
		this.root=root;
	}
	
	//���ȸ��������и��������д���һ�Ŷ��������㷨
//	public BiTree(String preOrder, String inOrder, int preIndex, int inIndex, int count)
//	{
//		if(count>0) {
//			char r=preOrder.charAt(preIndex);
//			int i=0;
//			for(;i<count;i++)
//				if(r==inOrder.charAt(i+inIndex))
//					break;
//			root=new BiTreeNode(r);
//			root.lchild=new BiTree(preOrder,inOrder,preIndex+1,inIndex,i).root;
//			root.rchild=new BiTree(preOrder,inOrder,preIndex+i+1,inIndex+i+1,count-i-1).root;
//		}
//	}
	public BiTree(String preOrder,String inOrder,int preIndex,int inIndex,int count) {
		if(count>0) {
			char r=preOrder.charAt(preIndex);
			int i=0;
			for(;i<count;i++) {
				if(r==inOrder.charAt(i+inIndex))
					break;
			root=new BiTreeNode(r);
			root.lchild=new BiTree(preOrder,inOrder,preIndex+1,inIndex,i).root;
			root.rchild=new BiTree(preOrder,inOrder,preIndex+i+1,inIndex+i+1,count-i-1).root;
			}
		}
	}
	//�ɱ������������ȸ��������д�����һ�Ŷ��������㷨
//	private static int index=0; //���ڼ�¼preStr������ֵ
//	public BiTree(String preStr)
//	{
//		char c=preStr.charAt(index++);
//		if(c!='#') {
//			root=new BiTreeNode(c);
//			root.lchild = new BiTree(preStr).root;
//			root.rchild = new BiTree(preStr).root;
//		}else {
//			root=null;
//		}
//	}
	private static int index=0;
	public BiTree(String preStr) {
		char c=preStr.charAt(index++);
		if(c!='#') {
			root=new BiTreeNode(c);
			root.lchild=new BiTree(preStr).root;
			root.rchild=new BiTree(preStr).root;
		}else {
			root=null;
		}
	}
	//�ȸ������������ĵݹ��㷨
	public void preRootTraverse(BiTreeNode T)
	{
		if(T!=null) {
			System.out.print(T.data);
			preRootTraverse(T.lchild);
			preRootTraverse(T.rchild);
		}
	}
	//�ȸ������������ķǵݹ��㷨
//	public void preRootTraverse()
//	{
//		BiTreeNode T=root;
//		if(T!=null) {
//			LinkStack S=new LinkStack();
//			S.push(T);
//			while(!S.isEmpty()) {
//				T=(BiTreeNode)S.pop();
//				System.out.print(T.data);
//				while(T!=null) {
//					if(T.lchild!=null)
//						System.out.print(T.lchild.data);
//					if(T.rchild!=null)
//						S.push(T.rchild);
//					T=T.lchild;
//				}
//			}
//		}
//	}
	public void preRootTraverse() {
		BiTreeNode T=root;
		if(T!=null) {
			LinkStack S=new LinkStack();
			S.push(T);
			while(!S.isEmpty()) {
				T=(BiTreeNode)S.pop();
				System.out.print(T.data);
				while(T!=null) {
					if(T.lchild!=null) {
						System.out.println(T.lchild.data);
					if(T.rchild!=null) {
						S.push(T.rchild);
					T=T.lchild;
					}
				}
			}
			}
		}
	}
	//�и������������ĵݹ��㷨
	public void inRootTraverse(BiTreeNode T)
	{
		if(T!=null) {
			inRootTraverse(T.lchild);
			System.out.print(T.data);
			inRootTraverse(T.rchild);
		}
	}
	//�и������������ķǵݹ��㷨
	public void inRoorTraverse()
	{
		BiTreeNode T=root;
		if(T!=null) {
			LinkStack S=new LinkStack();
			S.push(T);
			while(S!=null) {
				while(S.peek()!=null)
					S.push(((BiTreeNode)S.peek()).lchild);
				S.pop();
				if(!S.isEmpty()) {
					T = (BiTreeNode)S.pop();
					System.out.print(T.data);
					S.push(T.rchild);
				}
			}
		}
	}
	//��������������ĵݹ��㷨
	public void postRootTraverse(BiTreeNode T)
	{
		if(T!=null) {
			postRootTraverse(T.lchild);
			postRootTraverse(T.rchild);
			System.out.print(T.data);
		}
	}
	//��������������ķǵݹ��㷨
	public void postRoorTraverse()
	{
		BiTreeNode T = root;
		if(T!=null) {
			LinkStack S=new LinkStack();
			S.push(T);
			Boolean flag;
			BiTreeNode p=null;
			while(!S.isEmpty()) {
				while(S.peek()!=null) 
					S.push(((BiTreeNode)S.peek()).lchild);
				S.pop();
				while(!S.isEmpty()) {
					T=(BiTreeNode)S.peek();
					if(T.rchild==null||T.rchild==p) {
						System.out.print(T.data);
						S.pop();
						p=T;
						flag=true;
					}else {
						S.push(T.rchild);
						flag=false;
					}
					if(!flag)
						break;
				}
			}
		}
	}
	//��α������������㷨(��������)
//	public void levelTraverse()
//	{
//		BiTreeNode T=root;
//		if(T!=null) {
//			LinkQueue L=new LinkQueue();
//			L.offer(T);
//			while(!L.isEmpty()) {
//				T=(BiTreeNode)L.poll();
//				System.out.print(T.data);
//				if(T.lchild!=null)
//					L.offer(T.lchild);
//				if(T.rchild!=null)
//					L.offer(T.rchild);
//			}
//		}
//	}
	public void levelTraverse() {
		BiTreeNode T=root;
		if(T!=null) {
			LinkQueue L=new LinkQueue();
			L.offer(T);
			while(!L.isEmpty()) {
				T=(BiTreeNode)L.poll();
				System.out.print(T.data);
				if(T.lchild!=null)
					L.offer(T.lchild);
				if(T.rchild!=null) {
					L.offer(T.rchild);
				}
			}
			
		}
	}
	public BiTreeNode getRoot()
	{
		return root;
	}
	public void setRoot(BiTreeNode root) {
		this.root=root;
	}
	public int getDepth(BiTreeNode T) {
		if(T==null)
			return 0;
		else if(T.lchild==null&&T.rchild==null)
			return 1;
		else
			return 1+(getDepth(T.lchild)>getDepth(T.rchild)?getDepth(T.lchild):getDepth(T.rchild));
		
	}
}
