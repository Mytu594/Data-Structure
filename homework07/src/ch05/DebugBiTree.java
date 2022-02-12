package ch05;

import link.LinkQueue;
import link.LinkStack;

public class DebugBiTree {
	public BiTree createBiTree() {
		
		BiTreeNode g=new BiTreeNode("G");
		BiTreeNode k=new BiTreeNode("K");
		BiTreeNode j=new BiTreeNode("J",null,null);
		BiTreeNode i=new BiTreeNode("I",k,null);
		BiTreeNode d=new BiTreeNode("D",i,j);
		
		BiTreeNode h=new BiTreeNode("H");
		BiTreeNode e=new BiTreeNode("E");
		BiTreeNode f=new BiTreeNode("F",null,h);
		BiTreeNode b=new BiTreeNode("B",d,e);
		BiTreeNode c=new BiTreeNode("C",f,null);
		BiTreeNode a=new BiTreeNode("A",b,c);
		
		return new BiTree(a);
	}
	public static void main(String [] args) {
		DebugBiTree x=new DebugBiTree();
		BiTree bitree=x.createBiTree();
		BiTreeNode root=bitree.getRoot();
		System.out.print("递归先根:");
		bitree.preRootTraverse(root);
		System.out.println();
		System.out.print("非递归先根:");
		bitree.preRootTraverse();
		System.out.println();
		System.out.print("递归中根:");
		bitree.inRootTraverse(root);
		System.out.println();//
		System.out.println(x.GetDepth(root));
	}
	int GetDepth(BiTreeNode T){
		int i=0;
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
					if(i<S.length())
						i=S.length();
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
		return i;
	}
}
