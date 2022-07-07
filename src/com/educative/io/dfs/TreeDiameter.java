package com.educative.io.dfs;

public class TreeDiameter {

	public static void main(String args[]) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		/*
		 * root.right.left = new TreeNode(5); root.right.right = new TreeNode(6);
		 * root.right.left.left = new TreeNode(7); root.right.left.right = new
		 * TreeNode(8); root.right.left.right.right = new TreeNode(10);
		 * root.right.right.right = new TreeNode(9); root.right.right.right.right = new
		 * TreeNode(11);
		 */
		diameterTree(root);
		System.out.println(maxDiameter);

	}

	private static Integer maxDiameter = 0;

	public static void diameterTree(TreeNode root) {
		if (root == null) {
			return;
		}

		Integer leftHeight = maxDepth(root.left, 1);
		Integer rightHeight = maxDepth(root.right, 1);
		Integer diameter = leftHeight + rightHeight + 1;
		if (diameter > maxDiameter) {
			maxDiameter = diameter;
		}
		diameterTree(root.left);
		diameterTree(root.right);

	}

	public static Integer maxDepth(TreeNode root, Integer occurence) {
		if (root == null) {
			return 0;
		}

		if (root.left == null && root.right == null) {
			return occurence;
		}

		int leftDepth = maxDepth(root.left, occurence + 1);
		int rightDepth = maxDepth(root.right, occurence + 1);
		if (leftDepth > rightDepth) {
			return leftDepth;
		}
		return rightDepth;
	}
	
	private static int calculateHeight(TreeNode currentNode) {
	    if (currentNode == null)
	      return 0;

	    int leftTreeHeight = calculateHeight(currentNode.left);
	    int rightTreeHeight = calculateHeight(currentNode.right);


	    // height of the current node will be equal to the maximum of the heights of
	    // left or right subtrees plus '1' for the current node
	    return Math.max(leftTreeHeight, rightTreeHeight) + 1;
	  }
	
	
}
