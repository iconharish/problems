package problems.tree;

public class HeightOfTree {
	
	static class Node {
		int data;
		Node left, right;
	}
	
	private int maxHeight(Node root) {
		
		if (root == null) {
			return 0;
		}
		
		int leftHeight = maxHeight(root.left);
		int rightHeight = maxHeight(root.right);
		if (leftHeight > rightHeight) {
			return leftHeight + 1;
		} else {
			return rightHeight + 1;
		}
		
	}
	
	private int height(Node root) {
		if (root == null) {
			return 0;
		}
		
		return Math.max(height(root.left), height(root.right)) + 1;
	}
}
