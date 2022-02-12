package BiTree;

public class BiTree<S> {
	public BiTreeNode<S> root;  //树的根结点
	//构造一颗空树
	public BiTree() {
		this.root=null;
	}
	//构造一棵树
	public BiTree(BiTreeNode<S> root) {
		this.root=root;
	}
	//由先根遍历和中根遍历序列创建一颗二叉树的算法
	public BiTree(String preOrder,String inOrder,int preIndex,int inIndex,int count) {
		if(count>0) {  //先根和中根非空
			char r=preOrder.charAt(preIndex);  //寻找根遍历序列中的第一个结点作为根结点
			int i=0;
			for(;i<count;i++)
				if(r==inOrder.charAt(i+index))
					break;
			root=new BiTreeNode(r);  //建立树的根结点
			root.lchild=new BiTree(preOrder,inOrder,preIndex+1,inIndex,i).root;  //建立树的左子树
			root.rchild=new BiTree(preOrder,inOrder,preIndex+i+1,inIndex+i+1,count-i-1).root;  //建立树的右子树
		}
	}
	//由标明空子树的先根遍历序列建立一颗二叉树，并返回其根结点
	public static int index=0;  //用于记录preStr的索引值
	public BiTree(String preStr) {
		char c=preStr.charAt(index++);  //取出字符串索引为index的字符，且index增1
		if(c!='#') {  //字符不为'#'
			root=new BiTreeNode(c);  //建立树的根结点
			root.lchild=new BiTree(preStr).root;  //建立树的左子树
			root.rchild=new BiTree(preStr).root;  //建立树的右子树
		}
		else
			root=null;
	}
	//先根遍历二叉树的递归算法
	public void preRootTraverse(BiTreeNode<S> T) {
		if(T!=null) {
			System.out.print(T.data+" ");  //访问根结点
			preRootTraverse(T.lchild);  //先根遍历左子树
			preRootTraverse(T.rchild);  //先根遍历右子树
		}
	}
	//先根遍历二叉树的非递归算法
	public void preRootTraverse() {
		BiTreeNode<S> T=root;
		if(T!=null) {
			LinkStack<BiTreeNode<S>> S=new LinkStack<BiTreeNode<S>>();  //构造栈
			S.push(T);  //根结点入栈
			while(!S.isEmpty()) {
				T=S.pop();
				if(T.lchild!=null&&T.rchild!=null) {
					System.out.print(T.data+"(红)"+" ");
				}
				else if(T.lchild!=null&&T.rchild==null) {
					System.out.print(T.data+"(蓝)"+" ");
				}
				else if(T.lchild==null&&T.rchild!=null) {
					System.out.print(T.data+"(黄)"+" ");
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
	//中根遍历二叉树的递归算法
	public void inRootTraverse(BiTreeNode<S> T) {
		if(T!=null) {
			inRootTraverse(T.lchild);  //中根遍历左子树
			System.out.print(T.data+" ");  //访问根结点
			inRootTraverse(T.rchild);  //中根遍历右子树
		}
	}
	//中根遍历二叉树的非递归算法
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
	//后根遍历二叉树的递归算法
	public void postRootTraverse(BiTreeNode<S> T) {
		if(T!=null) {
			postRootTraverse(T.lchild);  //后根遍历左子树
			postRootTraverse(T.rchild);  //后根遍历右子树
			System.out.print(T.data+" ");  //访问根结点
		}
	}
	//后根遍历二叉树的非递归算法
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
	//层次遍历二叉树的算法（自左向右）
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
	//5.8二叉树上的查找
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
	//5.9统计二叉树中结点个数的算法
	public int countNode(BiTreeNode<S> T) {
		int count=0;
		if(T!=null) {
			++count;
			count+=countNode(T.lchild);
			count+=countNode(T.rchild);
		}
		return count;
	}
	//5.10统计二叉树中结点个数的算法
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
	//5.11求二叉树深度
	public int getDepth(BiTreeNode<S> T) {
		if(T!=null) {
			int lDepth=getDepth(T.lchild);
			int rDepth=getDepth(T.rchild);
			return 1+(lDepth>rDepth?lDepth:rDepth);
		}
		return 0;
	}
	//5.12判断两棵二叉树是否相等的算法
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
	//5.13递归统计二叉树结点个数
	public int countNode11(BiTreeNode<S> T) {
		if(T==null)
			return 0;
		else 
			return countNode1(T.lchild)+countNode1(T.rchild)+1;
	}
	//5.14递归求二叉树深度
	public int getDept1(BiTreeNode<S> T) {
		if(T==null) 
			return 0;
		else if(T.lchild==null&&T.rchild==null) 
			return 1;
		else
			return 1+(getDept1(T.lchild)>getDept1(T.rchild)?getDept1(T.lchild):getDept1(T.rchild));
	}
	//5.15递归判断两棵二叉树是否相等的算法
	public boolean isEqual1(BiTreeNode<S> T1,BiTreeNode<S> T2) {
		if(T1==null&&T2==null) 
			return true;
		else if(T1!=null&&T2!=null) 
			return(T1.data.equals(T2.data))&&(isEqual(T1.lchild,T2.lchild))&&(isEqual(T1.rchild,T2.rchild));
		else
			return false;
	}
}
