package week11;
import BiTree.LinkQueue;
class BiTreeNode<S> {
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
class BiTree<S> {
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
	public static int index=0;
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
	//层次遍历二叉树的算法（自左向右）
		public void levelTraverse()throws Exception {
			BiTreeNode<S> T=root;
			if(T!=null) {
				LinkQueue<BiTreeNode<S>> L=new LinkQueue<BiTreeNode<S>>();
				L.offer(T);
				while(!L.isEmpty()) {
					T=L.poll();
					if(countChild(T)==2&&T.lchild.data!="#"&&T.rchild.data!="#") {
						System.out.print(T.data+"(红) ");}
					else if(countChild(T)==2&&T.lchild.data=="#") {
						System.out.print(T.data+"(黄) ");
					}
					else if(countChild(T)==2&&T.rchild.data=="#") {
						System.out.print(T.data+"(蓝) ");
					}
					else if(countChild(T)==0) {
						System.out.print(T.data+"(黑) ");
					}
					if(T.lchild!=null)
						L.offer(T.lchild);
					if(T.rchild!=null)
						L.offer(T.rchild);
				}
			}
		}
		//统计节点数
		public int countChild(BiTreeNode<S> T) {
			int count=0;
			if(T.lchild!=null&&T.rchild!=null) {
				count=2;
			}
			else {
				count=0;
			}
			return count;
		}
}
public class color {
	public BiTree<String> breadthFirst() {
		String[] arr={"15","A","B","C","D","E","F","G","H","#","I","#","#","J","#","K"};
	    LinkQueue<BiTreeNode<String>> queue=new LinkQueue<BiTreeNode<String>>();
	    int index=1;
	    int len=Integer.parseInt(arr[0]);
	    //根结点
	    BiTreeNode<String> root=new BiTreeNode<String>(arr[index]);
	    queue.offer(root);
	    BiTreeNode<String> rootnode=root;
	    while(index<len) {
	    	rootnode=(BiTreeNode<String>)(queue.poll());  //父结点
	    	index++;
	    	BiTreeNode<String> NL=new BiTreeNode<String>(arr[index]);  //左孩子
	    	queue.offer(NL);
	    	rootnode.lchild=NL;
	    	index++;
	    	BiTreeNode<String> NR=new BiTreeNode<String>(arr[index]);  //右孩子
	    	queue.offer(NR);
	    	rootnode.rchild=NR;
	    }
	    return new BiTree<String>(root);
	}
	public static void main(String[] args) throws Exception {
		color debugBiTree=new color();
//		BiTree<String> biTree=debugBiTree.createBiTree();
		BiTree<String> biTree=debugBiTree.breadthFirst();
		BiTreeNode<String> root=biTree.root;
		System.out.println("层次遍历着色后的二叉树：");
		biTree.levelTraverse();
		System.out.println();
	}
}
