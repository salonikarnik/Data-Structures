package trees;

public class PostOrderRecursive {
	
	public static void main(String args[]){
		Treenode root=new Treenode(1);
		root.left=new Treenode(2);
		root.right=new Treenode(3);
		root.left.left=new Treenode(4);
		root.left.right=new Treenode(5);
		PostOrderRecursive object=new PostOrderRecursive();
		object.postorder(root);
	}
	
	public void postorder(Treenode root){
		if(root==null)
			return;
		postorder(root.left);
		postorder(root.right);
		System.out.print(root.data + " ");
	}

}
