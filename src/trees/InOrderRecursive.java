package trees;

public class InOrderRecursive {
	
	public static void main(String args[]){
		Treenode root=new Treenode(1);
		root.left=new Treenode(2);
		root.right=new Treenode(3);
		root.left.left=new Treenode(4);
		root.left.right=new Treenode(5);		
		InOrderRecursive object=new InOrderRecursive();
		object.inorder(root);
	}
	
	public void inorder(Treenode root){
		if(root==null)
			return;
		inorder(root.left);
		System.out.println(root.data);
		inorder(root.right);
	}

}
