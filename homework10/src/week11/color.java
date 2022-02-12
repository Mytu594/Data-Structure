package week11;
import BiTree.LinkQueue;
class BiTreeNode<S> {
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
class BiTree<S> {
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
	public static int index=0;
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
	//��α������������㷨���������ң�
		public void levelTraverse()throws Exception {
			BiTreeNode<S> T=root;
			if(T!=null) {
				LinkQueue<BiTreeNode<S>> L=new LinkQueue<BiTreeNode<S>>();
				L.offer(T);
				while(!L.isEmpty()) {
					T=L.poll();
					if(countChild(T)==2&&T.lchild.data!="#"&&T.rchild.data!="#") {
						System.out.print(T.data+"(��) ");}
					else if(countChild(T)==2&&T.lchild.data=="#") {
						System.out.print(T.data+"(��) ");
					}
					else if(countChild(T)==2&&T.rchild.data=="#") {
						System.out.print(T.data+"(��) ");
					}
					else if(countChild(T)==0) {
						System.out.print(T.data+"(��) ");
					}
					if(T.lchild!=null)
						L.offer(T.lchild);
					if(T.rchild!=null)
						L.offer(T.rchild);
				}
			}
		}
		//ͳ�ƽڵ���
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
		color debugBiTree=new color();
//		BiTree<String> biTree=debugBiTree.createBiTree();
		BiTree<String> biTree=debugBiTree.breadthFirst();
		BiTreeNode<String> root=biTree.root;
		System.out.println("��α�����ɫ��Ķ�������");
		biTree.levelTraverse();
		System.out.println();
	}
}
