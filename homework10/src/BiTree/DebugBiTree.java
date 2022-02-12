package BiTree;

public class DebugBiTree {
	public BiTree<String> createBiTree() {
		BiTreeNode<String> d=new BiTreeNode<String>("D");
		BiTreeNode<String> g=new BiTreeNode<String>("G");
		BiTreeNode<String> h=new BiTreeNode<String>("H");
		BiTreeNode<String> e=new BiTreeNode<String>("E",g,null);
		BiTreeNode<String> b=new BiTreeNode<String>("B",d,e);
		BiTreeNode<String> f=new BiTreeNode<String>("F",null,h);
		BiTreeNode<String> c=new BiTreeNode<String>("C",f,null);
		BiTreeNode<String> a=new BiTreeNode<String>("A",b,c);
		return new BiTree<String>(a);
	}
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
		DebugBiTree debugBiTree=new DebugBiTree();
//		BiTree<String> biTree=debugBiTree.createBiTree();
		BiTree<String> biTree=debugBiTree.breadthFirst();
		BiTreeNode<String> root=biTree.root;
		System.out.println("（递归）先根遍历序列为：");
		biTree.preRootTraverse(root);
		System.out.println();
		System.out.println("（非递归）先根遍历序列为：");
		biTree.preRootTraverse();
		System.out.println();
		System.out.println("（递归）中根遍历序列为：");
		biTree.inRootTraverse(root);
		System.out.println();
		System.out.println("（非递归）中根遍历序列为：");
		biTree.inRootTraverse();
		System.out.println();
		System.out.println("（递归）后根遍历序列为：");
		biTree.postRootTraverse(root);
		System.out.println();
		System.out.println("（非递归）后根遍历序列为：");
		biTree.postRootTraverse();
		System.out.println();
		System.out.println("层次遍历序列为：");
		biTree.levelTraverse();
		System.out.println();
		BiTree<String> biTree1=debugBiTree.breadthFirst();
		BiTreeNode<String> root1=biTree1.root;
//		System.out.println("E的位置：");
//		biTree1.searchNode(root1,1);
//		System.out.println();
		System.out.println("二叉树结点个数(先根)："+biTree1.countNode(root1));
		System.out.println("二叉树结点个数(层次)："+biTree1.countNode1(root1));		
		System.out.println("二叉树结点个数(递归)："+biTree1.countNode1(root1));
		System.out.println("二叉树的深度为(后根)："+biTree1.getDepth(root1));
		System.out.println("二叉树的深度为(递归)："+biTree1.getDept1(root1));
		
	}
}
