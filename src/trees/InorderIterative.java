package trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class InorderIterative {
	
	public static void main(String args[]){
		Treenode root=new Treenode(1);
		root.left=new Treenode(2);
		root.right=new Treenode(3);
		root.left.left=new Treenode(4);
		root.left.right=new Treenode(5);
		InorderIterative obj=new InorderIterative();
		List<Integer> traversal =obj.inorder(root);
		System.out.println("Inorder Tree Traversal - Iterative:");
		for(int t:traversal){
			System.out.print(t + " ");
		}
	}
	
	public List<Integer> inorder(Treenode root){
		List<Integer> result = new LinkedList<Integer>();
		Stack<Treenode> stack = new Stack<Treenode>();
		if(root==null)
			return result;
		Treenode curr=root;
		while(curr!=null||!stack.isEmpty()) {
			while(curr!=null) {
				stack.push(curr);
				curr=curr.left;
			}
			curr=stack.pop();
			result.add(curr.data);
			curr=curr.right;
		}
		return result;
	}

}