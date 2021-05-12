package problems.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BFS {
	
	static class Node {
		int data;
		Node left, right;
	}
	
	private void BFS(Node root) {
		if (root == null) {
			return;
		}
		LinkedList<Node> queue = new LinkedList<>();
		queue.add(root);
		
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			System.out.println(node.data);
			
			if (root.left != null) {
				queue.add(root.left);
			}
			
			if (root.right != null) {
				queue.add(root.right);
			}
		}
	}
	
	private void BFS1(Node root) {
		
		List<List<Integer>> list = new ArrayList<>();
		BFSRecursion(root, list, 0);
		for (List<Integer> levelList : list) {
			System.out.println(levelList);
		}
	}
	
	private void BFSRecursion(Node root, List<List<Integer>> list, int level) {
	    if(root==null) {
	    	return;
	    }

	    if(list.size() < (level+1)) {
	    	list.add(new ArrayList<>());
	    }
	        
	    list.get(level).add(root.data);

	    BFSRecursion(root.left, list, level+1);

	    BFSRecursion(root.right, list, level+1);
	}
}
