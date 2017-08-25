package trees;

import java.util.*;
import trees.PreorderRecursive;

public class InvertBinaryTree {
	
	public static void main(String args[]){
		Treenode root=new Treenode(1);
		root.left=new Treenode(2);
		root.right=new Treenode(3);
		root.left.left=new Treenode(4);
		root.left.right=new Treenode(5);
		
		InvertBinaryTree object = new InvertBinaryTree();		
		PreorderRecursive obj = new PreorderRecursive();
		
		Treenode invertR =object.invertRecursive(root);
		Treenode invertI =object.invertIterative(root);
		
		System.out.println("Inverted Binary Tree - Recursive - Preorder Traversal");	
		obj.preorder(invertR);	
		System.out.println("\n\nInverted Binary Tree - Iterative - Preorder Traversal");	
		obj.preorder(invertI);
	}
	
	//Recursive Solution
	public Treenode invertRecursive(Treenode root) {
		if(root==null)
			return root;
		Treenode left=root.left;
		root.left=invertRecursive(root.right);
		root.right=invertRecursive(left);
		return root;
	}
	
	//Iterative Solution
	public Treenode invertIterative(Treenode root){
		if(root==null)
			return root;
		Queue<Treenode> queue=new LinkedList<Treenode>();		
		queue.offer(root);
		while(!queue.isEmpty()) {
			Treenode poll=queue.poll();
			Treenode left=poll.left;
			poll.left=poll.right;
			poll.right=left;
			
			if(poll.left!=null) {
				queue.offer(poll.left);
				
			}
			
			if(poll.right!=null) {
				queue.offer(poll.right);
			}
		}
		return root;		
	}

}
