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
	    //�����
	    BiTreeNode<String> root=new BiTreeNode<String>(arr[index]);
	    queue.offer(root);
	    BiTreeNode<String> rootnode=root;
	    while(index<len) {
	    	rootnode=(BiTreeNode<String>)(queue.poll());  //�����
	    	index++;
	    	BiTreeNode<String> NL=new BiTreeNode<String>(arr[index]);  //����
	    	queue.offer(NL);
	    	rootnode.lchild=NL;
	    	index++;
	    	BiTreeNode<String> NR=new BiTreeNode<String>(arr[index]);  //�Һ���
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
		System.out.println("���ݹ飩�ȸ���������Ϊ��");
		biTree.preRootTraverse(root);
		System.out.println();
		System.out.println("���ǵݹ飩�ȸ���������Ϊ��");
		biTree.preRootTraverse();
		System.out.println();
		System.out.println("���ݹ飩�и���������Ϊ��");
		biTree.inRootTraverse(root);
		System.out.println();
		System.out.println("���ǵݹ飩�и���������Ϊ��");
		biTree.inRootTraverse();
		System.out.println();
		System.out.println("���ݹ飩�����������Ϊ��");
		biTree.postRootTraverse(root);
		System.out.println();
		System.out.println("���ǵݹ飩�����������Ϊ��");
		biTree.postRootTraverse();
		System.out.println();
		System.out.println("��α�������Ϊ��");
		biTree.levelTraverse();
		System.out.println();
		BiTree<String> biTree1=debugBiTree.breadthFirst();
		BiTreeNode<String> root1=biTree1.root;
//		System.out.println("E��λ�ã�");
//		biTree1.searchNode(root1,1);
//		System.out.println();
		System.out.println("������������(�ȸ�)��"+biTree1.countNode(root1));
		System.out.println("������������(���)��"+biTree1.countNode1(root1));		
		System.out.println("������������(�ݹ�)��"+biTree1.countNode1(root1));
		System.out.println("�����������Ϊ(���)��"+biTree1.getDepth(root1));
		System.out.println("�����������Ϊ(�ݹ�)��"+biTree1.getDept1(root1));
		
	}
}
