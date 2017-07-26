package trees;

public class PreorderRecursive {
	
	public static void main(String args){
		Treenode root=new Treenode(1);
		root.left=new Treenode(2);
		root.right=new Treenode(3);
		root.left.left=new Treenode(4);
		root.left.right=new Treenode(5);
		PreorderRecursive object=new PreorderRecursive();
		object.preorder(root);
	}
	
	public void preorder(Treenode root){
		if(root==null)
			return;
		System.out.print(root.data + " ");
		preorder(root.left);
		preorder(root.right);
		
	}

}
