package trees;

public class BalancedBinaryTree {

	public static void main(String[] args) {
		Treenode root=new Treenode(1);
		root.left=new Treenode(2);
		root.left.left=new Treenode(3);
		root.left.right=new Treenode(4);
		root.right=new Treenode(5);
		root.right.right=new Treenode(6);
		BalancedBinaryTree object = new BalancedBinaryTree();
		System.out.println("Is the given Binary Tree balanced? " + object.isBalanced(root));
	}
	
	public boolean isBalanced(Treenode root) {
		int ans = getHeight(root);
		if(ans==-1)
			return false;
		else
			return true;		
	}
	
	public int getHeight(Treenode root) {
		if(root==null)
			return 0;
		int left = getHeight(root.left);
		int right = getHeight(root.right);
		
		if(Math.abs(left-right)>1)
			return -1;		
		else 
			return Math.max(left,right) + 1;
	}

}
