package ThreeTree;
import BiTree.LinkQueue;
public class ThtoBi<T> {
	private T[] array;//������������
	public void setT(T[] array)
	{
		this.array=array;
	}
	public T[] getT()
	{
		return array;
	}
	public ThTreeNode<T> root;//�����
	public ThtoBi()//���췽��һ ��������
	{
		this.root=null;
	}
	public ThtoBi(ThTreeNode<T> root)//���췽���� ����һ���� 
	{
		this.root=root;
	}
	public LinkQueue<ThTreeNode<T>> queue=new LinkQueue<ThTreeNode<T>>();//���д�������
	//���в�ν�������
	public void CreateTree()
	{
		int length=array.length-1;
		root=new ThTreeNode<T>(array[0]);//�����=��A��
		queue.offer(root);//��A�������
		ThTreeNode<T> t=root;
		ThTreeNode<T> lc;
		ThTreeNode<T> mc;
		ThTreeNode<T> rc;
		for(int i=0;i<=length/3-1;i++)//ֻ������1/3-1ʱ������ɽ���
		{
			t=queue.poll();//��������
			int l=(i+1)*3-2;//���Ӷ�Ӧ�����±�
			lc=new ThTreeNode<T>(array[l]);//����
			queue.offer(lc);//���������
			int m=(i+1)*3-1;//�к��Ӷ�Ӧ�����±�
			mc=new ThTreeNode<T>(array[m]);//�к���
			queue.offer(mc);//�к��������
			int r=(i+1)*3;//�Һ��Ӷ�Ӧ�����±�
			rc=new ThTreeNode<T>(array[r]);//�Һ���
			queue.offer(rc);//�Һ��������
			t.lchild=lc;//������
			t.mchild=mc;//������
			t.rchild=rc;//������
		}
		levelTraverse();
	}
	public void levelTraverse()//��α�������ʵ�ֵķǵݹ��㷨
	{
		ThTreeNode<T> tree=root;
		if(tree!=null)
		{
			LinkQueue<ThTreeNode<T>> L=new LinkQueue<ThTreeNode<T>>();
			L.offer(tree);//����������
			while(!L.isEmpty())
			{
				tree=L.poll();
				if(tree.lchild!=null)//�ǿ������
				{
					if(tree.lchild.data=="null")
						tree.lchild=null;
					else
						L.offer(tree.lchild);
				}
				if(tree.mchild!=null)//�ǿ������
				{
					if(tree.mchild.data=="null")
						tree.mchild=null;
					else
						L.offer(tree.mchild);
				}
				if(tree.rchild!=null)//�ǿ������
				{
					if(tree.rchild.data=="null")
						tree.rchild=null;
					else
						L.offer(tree.rchild);
				}
			}
		}
	}
	public void levelTraverse1()//��α�������ʵ�ֵķǵݹ��㷨
	{
		ThTreeNode<T> tree=root;
		if(tree!=null)
		{
			LinkQueue<ThTreeNode<T>> L=new LinkQueue<ThTreeNode<T>>();
			L.offer(tree);//����������
			while(!L.isEmpty())
			{
				tree=L.poll();
				System.out.print(tree.data+" ");
				if(tree.lchild!=null)//�ǿ������
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
			L.offer(tree);//����������
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
	public void levelTraverse2()//��α�������ʵ�ֵķǵݹ��㷨
	{
		ThTreeNode<T> tree=root;
		if(tree!=null)
		{
			LinkQueue<ThTreeNode<T>> L=new LinkQueue<ThTreeNode<T>>();
			L.offer(tree);//����������
			while(!L.isEmpty())
			{
				tree=L.poll();
				System.out.print(tree.data+" ");
				if(tree.lchild!=null)//�ǿ������
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
		bitree.setT(array);//���ϴ�������
		bitree.CreateTree();//����
		bitree.levelTraverse1();
		bitree.thtobi();
		System.out.println();
		bitree.levelTraverse2();
	}

}
