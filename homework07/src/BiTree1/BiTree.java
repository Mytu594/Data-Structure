package BiTree1;
public class BiTree<T> {
	private T[] array;
	public void setT(T[] array)
	{
		this.array=array;
	}
	public T[] getT()
	{
		return array;
	}
	public LinkQueue<BiTreeNode<T>> queue=new LinkQueue<BiTreeNode<T>>();//队列存放树结点
	public BiTreeNode<T> root;
	public BiTree()//构建空树
	{
		this.root=null;
	}
	public BiTree(BiTreeNode<T> root)//构建一棵树
	{
		this.root=root;
	}
	public  void CreateTree()//队列层次建树
	{
		int length=Integer.valueOf(array[0].toString());
		root=new BiTreeNode<T>(array[1]);
		queue.offer(root);
		BiTreeNode<T> t=root;
		BiTreeNode<T> lc;
		BiTreeNode<T> rc;
		for(int i=1;i<=length/2;i++)
		{
			t=queue.poll();
			int l=2*i;
			lc=new BiTreeNode<T>(array[l]);
			queue.offer(lc);
			int r=2*i+1;
			rc=new BiTreeNode<T>(array[r]);
			queue.offer(rc);
			t.lchild=lc;
			t.rchild=rc;
		}
	}
	public  BiTreeNode<T> BuildTree(T[] array,int n)//递归层次建树 n从1开始
	{
		int length=Integer.valueOf(array[0].toString());
		if(array.length==0)
			return null;
		else
		{
			if(n<=length)
			{
				int l=2*n;
				int r=2*n+1;
				root=new BiTreeNode<T>(array[n], BuildTree(array, l), BuildTree(array, r));
				return root;
			}
			else
				return null;
		}
	}
	/*public BiTree(String preOrder,String inOrder,int preIndex,int inIndex,int count)
	{
		if(count>0)
		{
			char r=preOrder.charAt(preIndex);
			int i=0;
			for(;i<count;i++)
			{
				if(r==inOrder.charAt(i+inIndex))
					break;
				root=new
			}
		}
	}*/
	public void preRootTraverse(BiTreeNode<T> tree)//先根遍历操作实现的递归算法
	{
		if(tree!=null)
		{
			System.out.print(tree.data+" ");
			preRootTraverse(tree.lchild);
			preRootTraverse(tree.rchild);
		}
	}
	public void inRootTraverse(BiTreeNode<T> tree)//中根遍历操作实现的递归算法
	{
		if(tree!=null)
		{
			inRootTraverse(tree.lchild);
			System.out.print(tree.data+" ");
			inRootTraverse(tree.rchild);
		}
	}
	public void postRootTraverse(BiTreeNode<T> tree)//后根遍历操作实现的递归算法
	{
		if(tree!=null)
		{
			postRootTraverse(tree.lchild);
			postRootTraverse(tree.rchild);
			System.out.print(tree.data+" ");
		}
	}
	public void preRootTraverse1()
	{
		BiTreeNode<T> t=root;
		LinkStack<BiTreeNode<T>> s=new LinkStack<BiTreeNode<T>>(); 
        while (t!= null || !s.isEmpty()) {  
            while (t != null) {  
                System.out.print(t.data+" ");  
                s.push(t);  
                t = t.lchild;  
            }  
            if (!s.isEmpty()) {  
                t = s.pop();  
                t = t.rchild;  
            }  
        }  
	}
	public void inRootTraverse1()//中根遍历操作实现的非递归算法
	{
		BiTreeNode<T> tree=root;
		if(tree!=null)
		{
			LinkStack<BiTreeNode<T>> s=new LinkStack<BiTreeNode<T>>();
			s.push(tree);
			while(!s.isEmpty())
			{
				while(s.peek()!=null)
					s.push(s.peek().lchild);
				s.pop();
				if(!s.isEmpty())
				{
					tree=s.pop();
					System.out.print(tree.data+" ");
					s.push(tree.rchild);
				}
			}
		}
	}
	public void postRootTraverse1()
	{
		BiTreeNode<T> tree=root;
		if(tree!=null)
		{
			LinkStack<BiTreeNode<T>> s=new LinkStack<BiTreeNode<T>>();
			s.push(tree);
			Boolean flag;
			BiTreeNode<T> p=null;
			while(!s.isEmpty())
			{
				while(s.peek()!=null)
					s.push(s.peek().lchild);
				s.pop();
				while(!s.isEmpty())
				{
					tree=s.peek();
					if(tree.rchild==null || tree.rchild==p)
					{
						System.out.print(tree.data+" ");
						s.pop();
						p=tree;
						flag=true;
					}
					else
					{
						s.push(tree.rchild);
						flag=false;
					}
					if(!flag)
						break;
				}
			}
		}
	}
	public void levelTraverse()//层次遍历操作实现的非递归算法
	{
		BiTreeNode<T> tree=root;
		if(tree!=null)
		{
			LinkQueue<BiTreeNode<T>> L=new LinkQueue<BiTreeNode<T>>();
			L.offer(tree);
			while(!L.isEmpty())
			{
				tree=L.poll();
				System.out.print(tree.data+" ");
				if(tree.lchild!=null)
					L.offer(tree.lchild);
				if(tree.rchild!=null)
					L.offer(tree.rchild);
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BiTree<String> bitree = new BiTree<String>();
		String[] array= {"15","A","B","C","D","E","F","G","H","#","I","#","#","J","#","K"};
		bitree.setT(array);//以上创建数组
		//bitree.BuildTree(array,1);
		bitree.CreateTree();
		bitree.preRootTraverse(bitree.root);
		System.out.println();
		bitree.preRootTraverse1();
		System.out.println();
		bitree.inRootTraverse(bitree.root);
		System.out.println();
		bitree.inRootTraverse1();
		System.out.println();
		bitree.postRootTraverse(bitree.root);
		System.out.println();
		bitree.postRootTraverse1();
		System.out.println();
		bitree.levelTraverse();
	}
}
