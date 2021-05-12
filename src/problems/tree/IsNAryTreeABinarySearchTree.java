package problems.tree;

public class IsNAryTreeABinarySearchTree {

	// check if the given n-ary tree can be possibly considered as a binary search tree or not.
	boolean isBinarySearchTree(TreeNode root) {
		if (root == null) {
			return true;
		}
		
		if (root.child == null || root.child.length == 0) {
			return true;
		}
		
		if (root.child.length == 1) {
			return isBinarySearchTree(root.child[0]);
		}
		
		if (root.child.length > 2) {
			return false;
		}
		
		if ((root.child[0].value >= root.value && root.child[1].value <= root.value) || (root.child[0].value <= root.value && root.child[1].value >= root.value)) {
			return isBinarySearchTree(root.child[0]) && isBinarySearchTree(root.child[1]);
		} else {
			return false;
		}
	}
}

class TreeNode {
	int value;
	TreeNode[] child;
}