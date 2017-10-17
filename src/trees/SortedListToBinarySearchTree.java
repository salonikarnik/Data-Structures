package trees;

public class SortedListToBinarySearchTree {
	
	public static void main(String args[]) {
		
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		head.next.next.next.next.next.next = new ListNode(7);
		head.next.next.next.next.next.next.next = new ListNode(8);
		SortedListToBinarySearchTree obj = new SortedListToBinarySearchTree();
		obj.constructBST(head, null);		
	}
	
	public Treenode constructBST(ListNode head, ListNode tail) {
		if(head==tail)
			return null;
		ListNode slow=head;
		ListNode fast=head;
		
		while(fast!=tail&&fast.next!=tail) {
			fast=fast.next.next;
			slow=slow.next;
		}
		Treenode root = new Treenode(slow.val);
		root.left = constructBST(head,slow);		
		root.right = constructBST(slow.next,tail);
		return root;
	}

}

class ListNode{
	
	int val;
	ListNode next;
	
	public ListNode(int val) {
		this.val=val;
	}
}


