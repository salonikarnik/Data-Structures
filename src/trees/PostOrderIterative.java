package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PostOrderIterative {
	
	public static void main(String args[]){
		Treenode root=new Treenode(1);
		root.left=new Treenode(2);
		root.right=new Treenode(3);
		root.left.left=new Treenode(4);
		root.left.right=new Treenode(5);
		PostOrderIterative object=new PostOrderIterative();
		LinkedList<Integer> traversal2 =object.postOrder(root);
		List<Integer> traversal =object.postorder(root);
		System.out.println("Solution 1");
		for(int t:traversal){
			System.out.print(t + " ");
		}
		
		System.out.println("\nSolution 2");
		
		for(int t:traversal2){
			System.out.print(t + " ");
		}
	}
	
	//Soultion 1
	public List<Integer> postorder(Treenode root){
		List<Integer> visited=new ArrayList<Integer>();
		Stack<Treenode> temp=new Stack<Treenode>();
		temp.push(root);
		while(!temp.isEmpty()){
			Treenode see=temp.peek();
			if(see.left==null&&see.right==null){
				Treenode pop=temp.pop();
				visited.add(pop.data);
			}
			else{
				if(see.right!=null){
					temp.push(see.right);
					see.right=null;
				}
				if(see.left!=null){
					temp.push(see.left);
					see.left=null;
				}
			}
		}		
		return visited;
	}
	
	//Solution 2 - A more efficient solution
	public LinkedList<Integer> postOrder(Treenode root){
		LinkedList<Integer> result = new LinkedList<Integer>();
		Stack<Treenode> stack = new Stack<Treenode>();
		if(root==null)
			return result;
		stack.push(root);
		while(!stack.isEmpty()) {
			Treenode pop=stack.pop();
			result.addFirst(pop.data);
			if(pop.left!=null) {
				stack.push(pop.left);
			}
			if(pop.right!=null) {
				stack.push(pop.right);
			}
		}
		return result;
	}
}
