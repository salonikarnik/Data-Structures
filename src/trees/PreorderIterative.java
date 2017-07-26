package trees;

import java.util.*;

public class PreorderIterative {
	
	public static void main(String args[]){
		Treenode root=new Treenode(1);
		root.left=new Treenode(2);
		root.right=new Treenode(3);
		root.left.left=new Treenode(4);
		root.left.right=new Treenode(5);
		PreorderIterative obj=new PreorderIterative();
		List<Integer> traversal =obj.preorder(root);
		for(int t:traversal){
			System.out.print(t + " ");
		}
	}
	
	public List<Integer> preorder(Treenode root){
		List<Integer> visited=new LinkedList<Integer>();
		Stack<Treenode> temp=new Stack<Treenode>();
		temp.push(root);
		while(!temp.isEmpty()){
			Treenode node=temp.pop();
			visited.add(node.data);
			if(node.right!=null)
				temp.push(node.right);
			
			if(node.left!=null)
				temp.push(node.left);
					
		}
		return visited;
	}

}

class Treenode{
	Treenode left,right;
	int data;
	
	public Treenode(int value){
		data=value;
	}
}

