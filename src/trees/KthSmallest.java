package trees;

import java.io.*;
import java.util.Stack;

public class KthSmallest {
	
	public static void main(String args[]) throws IOException{
		Treenode root = new Treenode(15);
		root.left=new Treenode(10);
		root.right=new Treenode(20);
		root.left.left=new Treenode(8);
		root.left.right=new Treenode(12);
		root.right.left=new Treenode(16);
		root.right.right=new Treenode(25);
		
		KthSmallest object = new KthSmallest();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter a value for k: ");
		int k=Integer.parseInt(br.readLine());
		System.out.println("Iterative Soultion:");
		System.out.println(k + "th smallest element in the BST is : " + object.findSmallest(root,k));
		System.out.println();
		System.out.println("Recursive solution:");
		System.out.println(k + "th smallest element is: " + object.binarySearchKthSmallest(root, k));
	}
	
	//Iterative
	public int findSmallest(Treenode root, int k) {
		int count=0;
		Stack<Treenode> stack = new Stack<>();
		Treenode curr=root;
		while(!stack.isEmpty()||curr!=null) {
			if(curr!=null) {
				stack.push(curr);
				curr=curr.left;
			}
			else {
				Treenode pop=stack.pop();
				if(++count==k)
					return pop.data;
				curr=pop.right;
			}
		}		
		
		return Integer.MIN_VALUE;
	}
	
	//Recursive Binary Search Solution
	public int binarySearchKthSmallest(Treenode root,int k){
		int count = nodeCount(root.left);
		
		if(k<=count)
			return binarySearchKthSmallest(root.left,k);
		
		else if(k>count+1)
			return binarySearchKthSmallest(root.right,k-1-count);
		
		return root.data;
			
	}
	
	public int nodeCount(Treenode root) {
		if(root==null)
			return 0;
		
		return 1+ nodeCount(root.left) + nodeCount(root.right);
	}
		
	

}
