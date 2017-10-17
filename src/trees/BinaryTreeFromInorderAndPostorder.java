package trees;

import trees.InOrderRecursive;

public class BinaryTreeFromInorderAndPostorder {
	
	public static void main(String args[]) {
		
		BinaryTreeFromInorderAndPostorder obj = new BinaryTreeFromInorderAndPostorder();
		InOrderRecursive obj2 = new InOrderRecursive();
		int inorder[] =  {4, 2, 5, 1, 6, 3, 7};
		int postorder[]= {4, 5, 2, 6, 7, 3, 1};
		Treenode root = obj.orderTree(inorder, postorder);
		obj2.inorder(root);		
	}
	
	public Treenode orderTree(int[] inorder, int[] postorder) {
		if(inorder.length!=postorder.length)
			return null;
		return order(inorder,postorder,0,inorder.length-1,0,postorder.length-1);
	}
	
	public Treenode order(int [] inorder,int [] postorder,int inStart,int inEnd,int postStart,int postEnd) {
		
		if(inStart>inEnd||postStart>postEnd)
			return null;
		
		Treenode root = new Treenode(postorder[postEnd]);		
		if(inEnd==inStart)
			return root;
		
		int i=0;
		
		for(i=inStart;i<=inEnd;i++) {
			if(inorder[i]==root.data) 
				break;				
		}
		
		Treenode left = order(inorder,postorder,inStart,i-1,postStart,postStart + i - inStart - 1);		
		Treenode right = order(inorder,postorder,i+1,inEnd,postStart + i - inStart,postEnd-1);
		
		root.left=left;
		root.right=right;
		
		return root;
	}
}
