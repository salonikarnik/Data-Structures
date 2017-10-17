package trees;

public class BinaryTreeFromPreorderAndInorder {
	
	public static void main(String args[]) {
		int inorder[] = {4,2,5,1,6,7,3,8};
		int preorder[] = {1,2,4,5,3,7,6,8};
		BinaryTreeFromPreorderAndInorder object = new BinaryTreeFromPreorderAndInorder();
		object.buildTree(inorder,preorder);	
	}
	
	
	public Treenode buildTree(int inorder[],int preorder[]) {
		if(inorder.length!=preorder.length)
			return null;
		return build(inorder,preorder,0,inorder.length-1,0,preorder.length-1);
	}
	
	public Treenode build(int inorder[],int preorder[],int inStart,int inEnd,int preStart,int preEnd) {
		
		if(inStart>inEnd||preStart>preEnd)
			return null;
		Treenode root = new Treenode(preorder[preStart]);
		int i=0;
		for(i=inStart;i<=inEnd;i++) {
			if(inorder[i]==root.data)
				break;
		}
		
		root.left=build(inorder,preorder,inStart,i-1,preStart+1,preStart+i-inStart);
		root.right=build(inorder,preorder,i+1,inEnd,preStart+i-inStart+1,preEnd);
		
		return root;		
	}

}
