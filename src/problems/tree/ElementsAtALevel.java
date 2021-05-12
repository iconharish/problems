package problems.tree;

public class ElementsAtALevel {
	
	static class Node {
		int data;
		Node left, right;
	}
	
	private void printLevelElements(Node root, int currentLevel, int level) {
		if (root == null) {
			return;
		}
		
		if (currentLevel == level) {
			System.out.println(root.data);
		}
		
		printLevelElements(root.left, currentLevel+1, level);
		printLevelElements(root.right, currentLevel+1, level);
	}

}
