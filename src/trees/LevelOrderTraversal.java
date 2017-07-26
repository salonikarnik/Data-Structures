package trees;

import java.util.*;

public class LevelOrderTraversal {
	
	public static void main(String args[]){
		Treenode root=new Treenode(1);
		root.left=new Treenode(2);
		root.right=new Treenode(3);
		root.left.left=new Treenode(4);
		root.left.right=new Treenode(5);
		LevelOrderTraversal object = new LevelOrderTraversal();
		List<List<Integer>> traversal =object.levelOrder(root);
		System.out.println("Level Order Tree Traversal:");
		for(List<Integer> t:traversal){
			System.out.print(t + " ");
		}
	}
	
	public List<List<Integer>> levelOrder(Treenode root){
		List<List<Integer>> result = new ArrayList<>();
		if(root==null)
			return result;
		Queue<Treenode> queue = new LinkedList<Treenode>();
		queue.offer(root);
		while(!queue.isEmpty()){
			List<Integer> level = new LinkedList<Integer>();
			int size=queue.size();
			for(int i=0;i<size;i++) {
				Treenode node=queue.poll();
				level.add(node.data);
				if(node.left!=null)
					queue.offer(node.left);
				if(node.right!=null)
					queue.offer(node.right);
			}
			result.add(level);			
		}
		return result;
	}

}
