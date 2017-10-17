package trees;

public class SortedArrayToBinarySearchTree {
	
	public static void main(String args[]) {
		int array[] = {1,2,3,4,5,6,7,8};
		SortedArrayToBinarySearchTree obj = new SortedArrayToBinarySearchTree();
		obj.constructBTree(array);
	}
	
	public Treenode constructBTree(int array[]) {
		if(array.length==0)
			return null;
		return construct(array,0,array.length-1);
	}
	
	public Treenode construct(int array[],int low,int high) {	
		if(low>high)
			return null;
		int mid = low + (high-low)/2;
		Treenode root = new Treenode(array[mid]);
		root.left = construct(array,low,mid-1);
		root.right =construct(array,mid+1,high);		
		return root;		
	}

}
