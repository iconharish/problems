package problems.tree;

import java.util.ArrayList;
import java.util.List;

public class LeftView {
	
	static class Node {
		int data;
		Node left;
		Node right;
	}
	
	private void printLeftView(Node root) {
		
		List<List<Integer>> list = new ArrayList<>();
		levelOrderRecursion(root, list, 0);
		for (List<Integer> levelList : list) {
			System.out.println(levelList.get(0));
		}
	}
	
	private void levelOrderRecursion(Node root, List<List<Integer>> list, int level) {
		
		if (root == null) {
			return;
		}
		
		if (list.size() < level+1) {
			list.add(new ArrayList<>());
		}
		
		list.get(level).add(root.data);
		
		levelOrderRecursion(root.left, list, level+1);
		levelOrderRecursion(root.right, list, level+1);
		
	}
	
	int levelPrinted = -1;
	
	private void printLeftView1(Node root, int level) {
		if (root == null) {
			return;
		}
		
		if (levelPrinted < level) {
			System.out.println(root.data);
			levelPrinted = level;
		}
		
		printLeftView1(root.left, level+1);
		printLeftView1(root.right, level+1);
	}
}