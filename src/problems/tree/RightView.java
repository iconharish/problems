package problems.tree;

import java.util.LinkedList;

public class RightView {
	
	static class Node {
		int data;
		Node left;
		Node right;
	}
	
	int levelPrinted = -1;
	
	private void printRightView1(Node root, int level) {
		if (root == null) {
			return;
		}
		
		if (levelPrinted < level) {
			System.out.println(root.data);
			levelPrinted = level;
		}
		
		printRightView1(root.right, level+1);
		printRightView1(root.left, level+1);
	}
	
	private void printRightView(Node root) {
		
		if (root == null) {
			return;
		}
		
		LinkedList<Node> queue = new LinkedList<>();
		queue.add(root);
		
		while (!queue.isEmpty()) {
			
			int s = queue.size();
			for (int i = 1; i <= s; i++) {
				Node node = queue.poll();
				if (i == s) {
					System.out.println(node.data);
				}
				
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
			}
		}
		
	}

}
