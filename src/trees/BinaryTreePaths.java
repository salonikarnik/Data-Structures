package trees;

import java.util.*;

public class BinaryTreePaths {

	public static void main(String[] args) {
		Treenode root=new Treenode(5);
		root.left=new Treenode(3);
		root.right=new Treenode(7);
		root.left.left=new Treenode(2);
		root.left.right=new Treenode(4);
		root.right.left=new Treenode(6);
		root.right.right=new Treenode(8);
		BinaryTreePaths obj = new BinaryTreePaths();
		List<String> list = new ArrayList<>();
		List<String> result = obj.findPaths(root,"",list);
		for(String answer:result) {
			System.out.println(answer);
		}
	}
	
	public List<String> findPaths(Treenode root,String path,List<String> list) {
		if(root==null)
			return null;
		
		if(root.left==null&&root.right==null) {
			list.add(path + root.data);
		}
		
		findPaths(root.left,path + root.data + "->",list);
		findPaths(root.right,path + root.data + "->",list);	
		
		return list;
	}

}
