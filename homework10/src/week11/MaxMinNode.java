package week11;

public class MaxMinNode {
	public static TreeNode maxNode(TreeNode root){
		if(root==null) {
			return root;
		}
		TreeNode left=maxNode(root.left);
		TreeNode right=maxNode(root.right);
		return max(root,max(left,right));
	}
	public static TreeNode minNode(TreeNode root){
		if(root==null) {
			return root;
		}
		TreeNode left=minNode(root.left);
		TreeNode right=minNode(root.right);
		return min(root,min(left,right));
	}
	public static TreeNode max(TreeNode a,TreeNode b) {
		if(a==null) {return b;}
		if(b==null) {return a;}
		if(a.val>b.val) {return a;}
		return b;
	}
	public static TreeNode min(TreeNode a,TreeNode b) {
		if(a==null) {return b;}
		if(b==null) {return a;}
		if(a.val>b.val) {return b;}
		return a;
	}
	public static void main(String[] args) {
		TreeNode x1=new TreeNode(1);
		TreeNode x2=new TreeNode(-5);
		TreeNode x3=new TreeNode(2);
		TreeNode x4=new TreeNode(-9);
		TreeNode x5=new TreeNode(11);
		TreeNode x6=new TreeNode(7);
		TreeNode x7=new TreeNode(5);
		x1.left=x2;
		x1.right=x5;
		x2.left=x3;
		x2.right=x4;
		x5.left=x6;
		x5.right=x7;
		MaxMinNode root=new MaxMinNode();
		System.out.println("1 -5 2 -9 11 7 5");
		System.out.println("这棵二叉树的最小值为:"+root.minNode(x1).val);
		System.out.println("这棵二叉树的最大值为:"+root.maxNode(x1).val);
		
	}
}
