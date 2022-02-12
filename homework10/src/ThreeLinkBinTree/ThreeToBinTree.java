package ThreeLinkBinTree;
interface ThreeToBinTree1 {
    //����ӿ�����
    public int data=0;
    //����ӿڷ���������
    public void traverse();
}
public class ThreeToBinTree{
    //һ�����࣬ʵ�����ӿ�
    class TreeNode implements ThreeToBinTree1{
        int data;
        TreeNode children[];

        public TreeNode(int data){
            this.data=data;
        }
        public TreeNode(int data,TreeNode[] children){
            this.data=data;
            this.children=children;
        }
        public void setChildren(TreeNode[] children){
            this.children=children;
        }

        //һ����ת�������㷨
        BinaryTreeNode toBinaryTreeNode(){

            TreeNode treeNode=this;
            BinaryTreeNode bTreeNode=new BinaryTreeNode();
            bTreeNode.data=treeNode.data;

            BinaryTreeNode temp=bTreeNode;
            //�ж��Ƿ����ӽڵ�
            if(treeNode.children!=null){
                //������ӽڵ㣬�����������δ���
                for(int i=0;i<treeNode.children.length;i++){
                    //�ݹ���ã���ÿ���ӽڵ�Ҳת��Ϊ�������ڵ�
                    BinaryTreeNode ttemp=((TreeNode) treeNode.children[i]).toBinaryTreeNode();
                    //��һ���ڵ㣬������������
                    if(i==0){
                        temp.left=ttemp;
                        temp=(BinaryTreeNode) temp.left;//�α�ָ���һ�ӽڵ�
                    }else{
                        temp.right=ttemp;//�ڶ����ӽڵ���ڵ�һ���ӽڵ���������ϣ��Դ�����
                        temp=(BinaryTreeNode) temp.right;
                    }
                }
            }

            return bTreeNode;
        }

        //���廯��������
        public void traverse(){
            System.out.println(data);
            if(this.children!=null){
                for(TreeNode tn:(TreeNode[])this.children){
                    tn.traverse();
                }
            }
        }
    }

    //�������࣬ʵ�����ӿ�
    class BinaryTreeNode implements ThreeToBinTree1{
        int data;
        BinaryTreeNode left;
        BinaryTreeNode right;

        //���廯��������
        public void traverse(){
            System.out.println(data);
            if(this.left!=null)
                this.left.traverse();
            if(this.right!=null)
                this.right.traverse();
        }
    }


    public static void main(String[] args){
        //����һ����
        TreeNode node=new TreeNode();
        TreeNode node1=new TreeNode(1);
        TreeNode node2=new TreeNode(2);
        TreeNode node3=new TreeNode(3);
        TreeNode node4=new TreeNode(4);
        TreeNode node5=new TreeNode(5);
        TreeNode node6=new TreeNode(6);

        node.setChildren(new TreeNode[]{node1,node2,node3});
        node1.setChildren(new TreeNode[]{node4,node5});
        node2.setChildren(new TreeNode[]{node6});

        //����һ����
        node.traverse();
        System.out.println("--------------");
        //һ����תΪ������
        BinaryTreeNode tree2=node.toBinaryTreeNode();
        //����ת�͵õ��Ķ�����
        tree2.traverse();
    }
}
