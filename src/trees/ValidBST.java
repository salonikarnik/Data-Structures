package trees;

import java.util.*;

public class ValidBST {
	
	public static void main(String args[]) {
		Treenode root=new Treenode(17);
		root.left=new Treenode(13);
		root.right=new Treenode(18);
		root.right.right=new Treenode(111);
		root.right.right.right=new Treenode(120);
		ValidBST object = new ValidBST();
		System.out.println("Validating iteratively...");
		System.out.println("Is given binary tree, a binary search tree? " + object.validate(root));
		System.out.println("Validating recursively...");
		System.out.println("Is given binary tree, a binary search tree? " + object.validateRecursively(root));
	}
	
	//Iterative method
	public boolean validate(Treenode root){
		
		if(root==null)
			return true;
		Stack<Treenode> stack = new Stack<>();
		Treenode curr=null;
		while(root!=null||!stack.isEmpty()) {
			while(root!=null) {
				stack.push(root);		
				root=root.left;				
			}
			root=stack.pop();
			if(curr!=null&&root.data<=curr.data)
				return false;
			curr=root;
			root=root.right;						
		}		
		return true;				
	} 
	
	//Recursive method
	public boolean validateRecursively(Treenode root){
		return helper(root,null,null);		
	}
	
	public boolean helper(Treenode root,Treenode min,Treenode max) {
		
		if(root==null)
			return true;
		
		if(min!=null&&root.data<min.data)
			return false;
		
		if(max!=null&&root.data>max.data)
			return false;
		
		else if (!(helper(root.left,min,root)&&helper(root.right,root,max)))
			return false;
		
		return true;
		
	}

}
