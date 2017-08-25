package trees;

import java.util.*;

public class LongestConsecutiveSequence {
	
	private int max=0;
	
	public static void main(String args[]) {
		Treenode root=new Treenode(7);
		root.left=new Treenode(6);
		root.right=new Treenode(10);
		root.right.right=new Treenode(11);
		root.right.right.right=new Treenode(12);
		LongestConsecutiveSequence object = new LongestConsecutiveSequence();
		System.out.println("Length of longest consecutive sequence is: " + object.sequence(root));
	
	}
	
	//Recursive
	public int sequence(Treenode root) {
		if(root==null)
			return 0;
		helper(root,0,root.data);
		return max;		
	}
	
	public void helper(Treenode root, int curr, int target) {
		if(root==null)
			return;
		if(root.data==target)
			curr++;
		else 
			curr=1;
		max=Math.max(curr,max);
		helper(root.left,curr,root.data+1);
		helper(root.right,curr,root.data+1);
	}

}
