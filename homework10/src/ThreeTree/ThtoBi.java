package ThreeTree;
import BiTree.LinkQueue;
public class ThtoBi<T> {
	private T[] array;//创建泛型数组
	public void setT(T[] array)
	{
		this.array=array;
	}
	public T[] getT()
	{
		return array;
	}
	public ThTreeNode<T> root;//根结点
	public ThtoBi()//构造方法一 构建空树
	{
		this.root=null;
	}
	public ThtoBi(ThTreeNode<T> root)//构造方法二 构建一棵树 
	{
		this.root=root;
	}
	public LinkQueue<ThTreeNode<T>> queue=new LinkQueue<ThTreeNode<T>>();//队列存放树结点
	//队列层次建三叉树
	public void CreateTree()
	{
		int length=array.length-1;
		root=new ThTreeNode<T>(array[0]);//根结点=‘A’
		queue.offer(root);//‘A’入队列
		ThTreeNode<T> t=root;
		ThTreeNode<T> lc;
		ThTreeNode<T> mc;
		ThTreeNode<T> rc;
		for(int i=0;i<=length/3-1;i++)//只遍历到1/3-1时即可完成建树
		{
			t=queue.poll();//结点出队列
			int l=(i+1)*3-2;//左孩子对应数组下标
			lc=new ThTreeNode<T>(array[l]);//左孩子
			queue.offer(lc);//左孩子入队列
			int m=(i+1)*3-1;//中孩子对应数组下标
			mc=new ThTreeNode<T>(array[m]);//中孩子
			queue.offer(mc);//中孩子入队列
			int r=(i+1)*3;//右孩子对应数组下标
			rc=new ThTreeNode<T>(array[r]);//右孩子
			queue.offer(rc);//右孩子入队列
			t.lchild=lc;//根连左
			t.mchild=mc;//根连中
			t.rchild=rc;//根连右
		}
		levelTraverse();
	}
	public void levelTraverse()//层次遍历操作实现的非递归算法
	{
		ThTreeNode<T> tree=root;
		if(tree!=null)
		{
			LinkQueue<ThTreeNode<T>> L=new LinkQueue<ThTreeNode<T>>();
			L.offer(tree);//根结点入队列
			while(!L.isEmpty())
			{
				tree=L.poll();
				if(tree.lchild!=null)//非空入队列
				{
					if(tree.lchild.data=="null")
						tree.lchild=null;
					else
						L.offer(tree.lchild);
				}
				if(tree.mchild!=null)//非空入队列
				{
					if(tree.mchild.data=="null")
						tree.mchild=null;
					else
						L.offer(tree.mchild);
				}
				if(tree.rchild!=null)//非空入队列
				{
					if(tree.rchild.data=="null")
						tree.rchild=null;
					else
						L.offer(tree.rchild);
				}
			}
		}
	}
	public void levelTraverse1()//层次遍历操作实现的非递归算法
	{
		ThTreeNode<T> tree=root;
		if(tree!=null)
		{
			LinkQueue<ThTreeNode<T>> L=new LinkQueue<ThTreeNode<T>>();
			L.offer(tree);//根结点入队列
			while(!L.isEmpty())
			{
				tree=L.poll();
				System.out.print(tree.data+" ");
				if(tree.lchild!=null)//非空入队列
					L.offer(tree.lchild);
				if(tree.mchild!=null)
					L.offer(tree.mchild);
				if(tree.rchild!=null)
					L.offer(tree.rchild);
			}
		}
	} 
	public void thtobi()
	{
		if(root!=null)
		{
			ThTreeNode<T> tree=root;
			LinkQueue<ThTreeNode<T>> L=new LinkQueue<ThTreeNode<T>>();
			L.offer(tree);//根结点入队列
			while(!L.isEmpty())
			{
				tree=L.poll();
				if(tree.lchild!=null)
				{
					L.offer(tree.lchild);
					if(tree.mchild!=null)
					{
						tree.lchild.child=tree.mchild;
						tree.mchild=null;
						if(tree.rchild!=null)
						{
							tree.lchild.child.child=tree.rchild;
							tree.rchild=null;
						}
					}
					else
					{
						if(tree.rchild!=null)
						{
							L.offer(tree.rchild);
							tree.lchild.child=tree.rchild;
							tree.rchild=null;
						}
					}
				}
				else
				{
					if(tree.mchild!=null)
					{
						tree.lchild=tree.mchild;
						L.offer(tree.lchild);
						tree.mchild=null;
						if(tree.rchild!=null)
						{
							tree.lchild.child=tree.rchild;
							tree.rchild=null;
						}
					}
					else
					{
						if(tree.rchild!=null)
						{
							tree.lchild=tree.rchild;
							tree.rchild=null;
						}
						else
						{
							if(tree.child!=null)
							{
								tree.lchild=tree.child;
								tree.child=null;
							}
						}
					}
				}
				if(tree.child!=null)
					L.offer(tree.child);
			}
		}
	}
	public void levelTraverse2()//层次遍历操作实现的非递归算法
	{
		ThTreeNode<T> tree=root;
		if(tree!=null)
		{
			LinkQueue<ThTreeNode<T>> L=new LinkQueue<ThTreeNode<T>>();
			L.offer(tree);//根结点入队列
			while(!L.isEmpty())
			{
				tree=L.poll();
				System.out.print(tree.data+" ");
				if(tree.lchild!=null)//非空入队列
					L.offer(tree.lchild);
				if(tree.child!=null)
					L.offer(tree.child);
			}
		}
	} 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThtoBi<String> bitree = new ThtoBi<String>();
		String[] array= {"A","B","C","D","E","null","null","F","null","G","null","H","null"};
		bitree.setT(array);//以上创建数组
		bitree.CreateTree();//建树
		bitree.levelTraverse1();
		bitree.thtobi();
		System.out.println();
		bitree.levelTraverse2();
	}

}
