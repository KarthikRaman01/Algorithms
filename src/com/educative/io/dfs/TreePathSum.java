package com.educative.io.dfs;

class TreePathSum {
	public static boolean hasPath(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}
		// check if it's a leaf node
		if (root.left == null && root.right == null) {
			if (sum - root.val == 0) {
				return true;
			} else {
				return false;
			}
		}

		boolean hasPathLeft = hasPath(root.left, sum - root.val);
		boolean hasPathRight = hasPath(root.right, sum - root.val);

		return hasPathLeft || hasPathRight;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(9);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		System.out.println("Tree has path: " + TreePathSum.hasPath(root, 23));
		System.out.println("Tree has path: " + TreePathSum.hasPath(root, 16));
	}
}
