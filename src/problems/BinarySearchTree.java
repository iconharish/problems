package problems;

public class BinarySearchTree {
	
	private class Node {
		int value;
		Node leftNode;
		Node rightNode;
		
		public Node (int value, Node leftNode, Node rightNode) {
			this.value = value;
			this.leftNode = leftNode;
			this.rightNode = rightNode;
		}
	}
	
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		Node treeRoot = bst.getSampleTree();
		System.out.println(bst.isBinarySearchTree(treeRoot));
	}
	
	private boolean isBinarySearchTree(Node root) {
		
		if (root == null) {
			return true;
		}
		
		if (root.leftNode != null && root.leftNode.value > root.value) {
			return false;
		}
		
		if (root.rightNode != null && root.rightNode.value < root.value) {
			return false;
		}
		
		if (!isBinarySearchTree(root.leftNode) || ! isBinarySearchTree(root.rightNode)) {
			return false;
		}
		return true;
	}
	
	private Node getSampleTree() {
		Node n1 = new Node(10, null, null);
		Node n2 = new Node(9, null, n1);
		Node n3 = new Node(8, null, n2);
		Node n4 = new Node(7, null, n3);
		Node n5 = new Node(6, null, n4);
		Node n6 = new Node(5, null, n5);
		Node n7 = new Node(4, null, n6);
		Node n8 = new Node(3, null, n7);
		Node n9 = new Node(2, null, n8);
		Node n10 = new Node(5, null, n9);
		
		return n10;
		
	}
}
