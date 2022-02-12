package week11;

public class isSymmetrical {
	boolean isSymmetrical(TreeNode root) {
		if(root==null) {
			return true;
		}
		return comRoot(root.left,root.right);
	}
	private boolean comRoot(TreeNode left,TreeNode right) {
		if(left==null) return right==null;
		if(right==null)return false;
		if(left.val!=right.val)return false;
		return comRoot(left.right,right.left)&&comRoot(left.left,right.right);
	}
	public static void main(String[] args) {
		TreeNode x1=new TreeNode(1);
		TreeNode x2=new TreeNode(2);
		TreeNode x3=new TreeNode(3);
		TreeNode x4=new TreeNode(3);
		TreeNode x5=new TreeNode(2);
		TreeNode x6=new TreeNode(3);
		TreeNode x7=new TreeNode(3);
		x1.left=x2;
		x1.right=x5;
		x2.left=x3;
		x2.right=x4;
		x5.left=x6;
		x5.right=x7;
		TreeNode s1=new TreeNode(1);
		TreeNode s2=new TreeNode(2);
		TreeNode s3=new TreeNode(4);
		TreeNode s4=new TreeNode(3);
		TreeNode s5=new TreeNode(2);
		TreeNode s6=new TreeNode(6);
		TreeNode s7=new TreeNode(3);
		s1.left=s2;
		s1.right=s5;
		s2.left=s3;
		s2.right=s4;
		s5.left=s6;
		s5.right=s7;
		isSymmetrical root=new isSymmetrical();
		System.out.println("1 2 3 3 2 3 3¶Ô³ÆÂð?");
		System.out.println(root.isSymmetrical(x1));
		System.out.println("1 2 4 3 2 6 3¶Ô³ÆÂð?");
		System.out.println(root.isSymmetrical(s1));
	}

}
