package ThreeLinkBinTree;

public class ThreeLinkBinTree {
	private static class Node{
        private String data;
        private Node left;
        private Node right;
        private Node parent;
        public Node(){};
        public Node(String data){
            this.data=data;
        }
        public Node(String data,Node parent,Node left,Node right){
            this.data=data;
            this.left=left;
            this.right=right;
        }
    }
    private Node root;
    public ThreeLinkBinTree(){
        this.root=new Node();
    }
    public ThreeLinkBinTree(String data){
        this.root=new Node(data);
    }
    public Node add(Node parent,String data,boolean left){
        if(parent==null){
            throw new RuntimeException("父节点为空");
        }
        if(left&&parent.left!=null){
            throw new RuntimeException("已有左节点");
        }
        if(!left&&parent.right!=null){
            throw new RuntimeException("已有右节点");
        }
        Node node=new Node(data);
        if(left){
            parent.left=node;
        }else {
            parent.right=node;
        }
        node.parent=parent;
        return node;
    }
    public boolean empty(){
        return root==null;
    }
    public Node getRoot(){
        if(root==null){
            throw new RuntimeException("没有根节点");
        }
        return root;
    }
    public Node getPar(Node node){
        if(node==null){
            throw new RuntimeException("此节点为空");
        }return node.parent;
    }
    public Node getLeft(Node parent){
        if(parent==null){
            throw new RuntimeException("父节点为空");
        }
        return parent.left==null?null:parent.left;
    }
    public Node getRight(Node parent){
        if(parent==null){
            throw new RuntimeException("父节点为空");
        }
        return parent.right==null?null:parent.right;
    }
    public int deep(){
        return deep(this.root);
    }
 
    private int deep(Node node) {
        if(node==null){
            return 0;
        }
        if(node.left==null&&node.right==null){
            return 1;
        }else {
            int leftDeep=deep(node.left);
            int rightDeep=deep(node.right);
            int max=leftDeep>rightDeep?leftDeep:rightDeep;
            return max+1;
        }
    }
 
    public static void main(String[] args) {
        ThreeLinkBinTree tree=new ThreeLinkBinTree("Root");
        Node root=tree.getRoot();
        Node node1=tree.add(root,"A",true);
        Node node2=tree.add(root,"B",false);
        System.out.println(node1.parent.data);
        System.out.println(tree.deep());
    }
}
