package problems.tree;

public class MirrorReflection {
	static class Node {
		int data;
		Node left, right;
	}
	
	private Node reverse(Node root) {
		if (root == null) {
			return root;
		}
		
		Node left = reverse(root.left);
		Node right = reverse(root.right);
		
		root.left = right;
		root.right = left;
		
		return root;
	}
	
	private boolean areMirror(Node root1, Node root2) {
		if (root1 == null && root2 == null) {
			return true;
		}
		
		if (root1 == null || root2 == null) {
			return false;
		}
		
		return root1.data == root2.data && areMirror(root1.left, root2.right) 
				&& areMirror(root1.right, root2.left);
	}
}
