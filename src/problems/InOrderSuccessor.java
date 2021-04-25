package problems;

public class InOrderSuccessor {
	
	// if found in left leaf - return root
	// if found in right leaf - return branching root
	// if found in root - return right child or if right child is null return branching root
	
	static Node root;
	
	public static void main(String[] args) {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		Node node7 = new Node(7);
		Node node8 = new Node(8);
		Node node9 = new Node(9);
		Node node10 = new Node(10);
		Node node11 = new Node(11);
		Node node12 = new Node(12);
		Node node13 = new Node(13);
		Node node14 = new Node(14);
		Node node15 = new Node(15);
		
		node10.left = node6;
		node10.right = node12;
		
		node6.left = node2;
		node6.right = node8;
		
		node2.left = node1;
		node2.right = node4;
		
		node4.left = node3;
		node4.right = node5;
		
		node8.left = node7;
		node8.right = node9;
		
		node12.left = node11;
		node12.right = node14;
		
		node14.left = node13;
		node14.right = node15;
		
		InOrderSuccessor executor = new InOrderSuccessor();
		boolean[] isFound = new boolean[1];
		Node successor = executor.inOrderSuccessor(node10, 1, isFound);
		System.out.println(successor != null ? successor.value : "null");
		
	}
	
	Node inOrderSuccessor (Node root, int key, boolean[] isFound) {
		
		if (root != null) {
			
			Node successor = inOrderSuccessor(root.left, key, isFound);
			
			if (successor != null) {
				return successor;
			}
			
			if (isFound[0]) {
				return root;
			}
			
			if (root.value == key) {
				isFound[0] = true;
			}
			
			//System.out.println(root.value);
			successor = inOrderSuccessor(root.right, key, isFound);
			if (successor != null) {
				return successor;
			}
		}
		
		return null;
		
	}
	
}

class Node {
	int value;
	Node left;
	Node right;
	
	public Node (int value) {
		this.value = value;
	}
}