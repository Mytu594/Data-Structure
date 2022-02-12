package ThreeLinkBinTree;
interface ThreeToBinTree1 {
    //定义接口属性
    public int data=0;
    //定义接口方法，遍历
    public void traverse();
}
public class ThreeToBinTree{
    //一般树类，实现树接口
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

        //一般树转二叉树算法
        BinaryTreeNode toBinaryTreeNode(){

            TreeNode treeNode=this;
            BinaryTreeNode bTreeNode=new BinaryTreeNode();
            bTreeNode.data=treeNode.data;

            BinaryTreeNode temp=bTreeNode;
            //判断是否有子节点
            if(treeNode.children!=null){
                //如果有子节点，遍历它们依次处理
                for(int i=0;i<treeNode.children.length;i++){
                    //递归调用，将每个子节点也转换为二叉树节点
                    BinaryTreeNode ttemp=((TreeNode) treeNode.children[i]).toBinaryTreeNode();
                    //第一个节点，放在左子树上
                    if(i==0){
                        temp.left=ttemp;
                        temp=(BinaryTreeNode) temp.left;//游标指向第一子节点
                    }else{
                        temp.right=ttemp;//第二个子节点放在第一个子节点的右子树上，以此类推
                        temp=(BinaryTreeNode) temp.right;
                    }
                }
            }

            return bTreeNode;
        }

        //具体化遍历方法
        public void traverse(){
            System.out.println(data);
            if(this.children!=null){
                for(TreeNode tn:(TreeNode[])this.children){
                    tn.traverse();
                }
            }
        }
    }

    //二叉树类，实现树接口
    class BinaryTreeNode implements ThreeToBinTree1{
        int data;
        BinaryTreeNode left;
        BinaryTreeNode right;

        //具体化遍历方法
        public void traverse(){
            System.out.println(data);
            if(this.left!=null)
                this.left.traverse();
            if(this.right!=null)
                this.right.traverse();
        }
    }


    public static void main(String[] args){
        //创建一般树
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

        //遍历一般树
        node.traverse();
        System.out.println("--------------");
        //一般树转为二叉树
        BinaryTreeNode tree2=node.toBinaryTreeNode();
        //遍历转型得到的二叉树
        tree2.traverse();
    }
}
