package BiTree;

public class BiTree<S> {
	public BiTreeNode<S> root;  //���ĸ����
	//����һ�ſ���
	public BiTree() {
		this.root=null;
	}
	//����һ����
	public BiTree(BiTreeNode<S> root) {
		this.root=root;
	}
	//���ȸ��������и��������д���һ�Ŷ��������㷨
	public BiTree(String preOrder,String inOrder,int preIndex,int inIndex,int count) {
		if(count>0) {  //�ȸ����и��ǿ�
			char r=preOrder.charAt(preIndex);  //Ѱ�Ҹ����������еĵ�һ�������Ϊ�����
			int i=0;
			for(;i<count;i++)
				if(r==inOrder.charAt(i+index))
					break;
			root=new BiTreeNode(r);  //�������ĸ����
			root.lchild=new BiTree(preOrder,inOrder,preIndex+1,inIndex,i).root;  //��������������
			root.rchild=new BiTree(preOrder,inOrder,preIndex+i+1,inIndex+i+1,count-i-1).root;  //��������������
		}
	}
	//�ɱ������������ȸ��������н���һ�Ŷ�������������������
	public static int index=0;  //���ڼ�¼preStr������ֵ
	public BiTree(String preStr) {
		char c=preStr.charAt(index++);  //ȡ���ַ�������Ϊindex���ַ�����index��1
		if(c!='#') {  //�ַ���Ϊ'#'
			root=new BiTreeNode(c);  //�������ĸ����
			root.lchild=new BiTree(preStr).root;  //��������������
			root.rchild=new BiTree(preStr).root;  //��������������
		}
		else
			root=null;
	}
	//�ȸ������������ĵݹ��㷨
	public void preRootTraverse(BiTreeNode<S> T) {
		if(T!=null) {
			System.out.print(T.data+" ");  //���ʸ����
			preRootTraverse(T.lchild);  //�ȸ�����������
			preRootTraverse(T.rchild);  //�ȸ�����������
		}
	}
	//�ȸ������������ķǵݹ��㷨
	public void preRootTraverse() {
		BiTreeNode<S> T=root;
		if(T!=null) {
			LinkStack<BiTreeNode<S>> S=new LinkStack<BiTreeNode<S>>();  //����ջ
			S.push(T);  //�������ջ
			while(!S.isEmpty()) {
				T=S.pop();
				if(T.lchild!=null&&T.rchild!=null) {
					System.out.print(T.data+"(��)"+" ");
				}
				else if(T.lchild!=null&&T.rchild==null) {
					System.out.print(T.data+"(��)"+" ");
				}
				else if(T.lchild==null&&T.rchild!=null) {
					System.out.print(T.data+"(��)"+" ");
				}
				while(T!=null) {
					if(T.lchild!=null)
						System.out.print(T.lchild.data+" ");
					if(T.rchild!=null)
						S.push(T.rchild);
					T=T.lchild;
				}
			}
		}
	}
	//�и������������ĵݹ��㷨
	public void inRootTraverse(BiTreeNode<S> T) {
		if(T!=null) {
			inRootTraverse(T.lchild);  //�и�����������
			System.out.print(T.data+" ");  //���ʸ����
			inRootTraverse(T.rchild);  //�и�����������
		}
	}
	//�и������������ķǵݹ��㷨
	public void inRootTraverse() {
		BiTreeNode<S> T=root;
		if(T!=null) {
			LinkStack<BiTreeNode<S>> S=new LinkStack<BiTreeNode<S>>();
			S.push(T);
			while(!S.isEmpty()) {
				while(S.peek()!=null)
					S.push((S.peek()).lchild);
				S.pop();
				if(!S.isEmpty()) {
					T=S.pop();
					System.out.print(T.data+" ");
					S.push(T.rchild);
				}
			}
		}
	}
	//��������������ĵݹ��㷨
	public void postRootTraverse(BiTreeNode<S> T) {
		if(T!=null) {
			postRootTraverse(T.lchild);  //�������������
			postRootTraverse(T.rchild);  //�������������
			System.out.print(T.data+" ");  //���ʸ����
		}
	}
	//��������������ķǵݹ��㷨
	public void postRootTraverse() {
		BiTreeNode<S> T=root;
		if(T!=null) {
			LinkStack<BiTreeNode<S>> S=new LinkStack<BiTreeNode<S>>();
			S.push(T);
			boolean flag;
			BiTreeNode<S> p=null;
			while(!S.isEmpty()) {
				while(S.peek()!=null)
					S.push(((BiTreeNode<S>)S.peek()).lchild);
				S.pop();
				while(!S.isEmpty()) {
					T=S.peek();
					if(T.rchild==null || T.rchild==p) {
						System.out.print(T.data+" ");
						S.pop();
						p=T;
						flag=true;
					}
					else {
						S.push(T.rchild);
						flag=false;
					}
					if(!flag)
						break;
				}
			}
		}
	}
	//��α������������㷨���������ң�
	public void levelTraverse() {
		BiTreeNode<S> T=root;
		if(T!=null) {
			LinkQueue<BiTreeNode<S>> L=new LinkQueue<BiTreeNode<S>>();
			L.offer(T);
			while(!L.isEmpty()) {
				T=L.poll();
				System.out.print(T.data+" ");
				if(T.lchild!=null)
					L.offer(T.lchild);
				if(T.rchild!=null)
					L.offer(T.rchild);
			}
		}
	}
	public BiTreeNode<S> getRoot() {
		return root;
	}
	public void setRoot(BiTreeNode<S> root) {
		this.root=root;
	}
	//5.8�������ϵĲ���
	public BiTreeNode<S> searchNode(BiTreeNode<S> T,Object x) {
		if(T!=null) {
			if(T.data.equals(x))
				return T;
			else {
				BiTreeNode<S> lresult=searchNode(T.lchild,x);
				return lresult!=null?lresult:searchNode(T.rchild,x);
			}
		}
		return null;
	}
	//5.9ͳ�ƶ������н��������㷨
	public int countNode(BiTreeNode<S> T) {
		int count=0;
		if(T!=null) {
			++count;
			count+=countNode(T.lchild);
			count+=countNode(T.rchild);
		}
		return count;
	}
	//5.10ͳ�ƶ������н��������㷨
	public int countNode1(BiTreeNode<S> T) {
		int count=0;
		if(T!=null) {
			LinkQueue<BiTreeNode<S>> L=new LinkQueue<BiTreeNode<S>>();
			L.offer(T);
			while(!L.isEmpty()) {
				T=(BiTreeNode<S>)L.poll();
				++count;
				if(T.lchild!=null) {
					L.offer(T.lchild);
				}
				if(T.rchild!=null) {
					L.offer(T.rchild);
				}
			}
		}
		return count;
	}
	//5.11����������
	public int getDepth(BiTreeNode<S> T) {
		if(T!=null) {
			int lDepth=getDepth(T.lchild);
			int rDepth=getDepth(T.rchild);
			return 1+(lDepth>rDepth?lDepth:rDepth);
		}
		return 0;
	}
	//5.12�ж����ö������Ƿ���ȵ��㷨
	public boolean isEqual(BiTreeNode<S> T1,BiTreeNode<S> T2) {
		if(T1==null&&T2==null) 
			return true;
		if(T1!=null&&T2!=null) 
			if(T1.data.equals(T2.data))
				if(isEqual(T1.lchild,T2.lchild))
					if(isEqual(T1.rchild,T2.rchild)) 
						return true;			
		return false;
	}
	//5.13�ݹ�ͳ�ƶ�����������
	public int countNode11(BiTreeNode<S> T) {
		if(T==null)
			return 0;
		else 
			return countNode1(T.lchild)+countNode1(T.rchild)+1;
	}
	//5.14�ݹ�����������
	public int getDept1(BiTreeNode<S> T) {
		if(T==null) 
			return 0;
		else if(T.lchild==null&&T.rchild==null) 
			return 1;
		else
			return 1+(getDept1(T.lchild)>getDept1(T.rchild)?getDept1(T.lchild):getDept1(T.rchild));
	}
	//5.15�ݹ��ж����ö������Ƿ���ȵ��㷨
	public boolean isEqual1(BiTreeNode<S> T1,BiTreeNode<S> T2) {
		if(T1==null&&T2==null) 
			return true;
		else if(T1!=null&&T2!=null) 
			return(T1.data.equals(T2.data))&&(isEqual(T1.lchild,T2.lchild))&&(isEqual(T1.rchild,T2.rchild));
		else
			return false;
	}
}
