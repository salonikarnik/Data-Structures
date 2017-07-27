package trees;

import java.util.*;

public class VerticalOrder {
	
	public static void main(String args[]){
		Treenode root=new Treenode(1);
		root.left=new Treenode(2);
		root.right=new Treenode(3);
		root.left.left=new Treenode(4);
		root.left.right=new Treenode(5);
		VerticalOrder object = new VerticalOrder();
		List<List<Integer>> traversal =object.verticalOrder(root);
		System.out.println("Vertical Order Tree Traversal:");
		for(List<Integer> t:traversal){
			System.out.print(t + " ");
		}
	}
	
	public List<List<Integer>> verticalOrder(Treenode root){
		List<List<Integer>> result = new ArrayList<>();
		if(root==null)
			return result;
		Map<Integer,List<Integer>> map = new HashMap<Integer, List<Integer>>();
		Queue<Treenode> level = new LinkedList<Treenode>();
		Queue<Integer> column = new LinkedList<Integer>();
		int min=0,max=0;
		level.offer(root);
		column.offer(0);
		while(!level.isEmpty()) {
			Treenode node=level.poll();
			int col=column.poll();
			
			if(!map.containsKey(col))
				map.put(col,new ArrayList<Integer>());
			map.get(col).add(node.data);
			
			if(node.left!=null) {
				level.offer(node.left);
				column.offer(col-1);
				min=Math.min(min,col-1);
			}
			
			if(node.right!=null) {
				level.offer(node.right);
				column.offer(col+1);
				max=Math.max(max,col+1);
			}
		}
		
		for(int i=min;i<=max;i++) {
			result.add(map.get(i));
		}
		return result;		
	}
}
