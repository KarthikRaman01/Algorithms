package com.educative.io.dfs;

public class MaxDepth {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(0);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(1);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(5);
		System.out.println(maxDepth(root));

	}

	public static int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int count = 1;
		int leftCount = maxDepth(root.left);
		int rightCount = maxDepth(root.right);
		count = leftCount > rightCount ? count + leftCount : count + rightCount;
		return count;
	}

}
