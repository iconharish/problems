package problems.tree;

public class LeafNodes {
	
	static class Node {
		int data;
		Node left;
		Node right;
	}
	
	private void printLeafNodes(Node root) {
		if (root == null) {
			return;
		}
		
		if (root.left == null && root.right == null) {
			System.out.println(root.data);
			return;
		}
		
		printLeafNodes(root.left);
		printLeafNodes(root.right);
	}
	

}
