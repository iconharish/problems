package problems.tree;

public class DFS {
	
	static class Node {
		int data;
		Node left, right;
	}
	
	private void DFSPreOrder(Node root) {
		if (root == null) {
			return;
		}
		System.out.println(root.data);
		DFSPreOrder(root.left);
		DFSPreOrder(root.right);
	}
	
	private void DFSPostOrder(Node root) {
		if (root == null) {
			return;
		}
		DFSPostOrder(root.left);
		DFSPostOrder(root.right);
		System.out.println(root.data);
	}
	
	private void DFSInOrder(Node root) {
		if (root == null) {
			return;
		}
		DFSInOrder(root.left);
		System.out.println(root.data);
		DFSInOrder(root.right);
	}

}
