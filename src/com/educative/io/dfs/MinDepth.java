package com.educative.io.dfs;

import org.w3c.dom.Node;

public class MinDepth {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		// root.left = new TreeNode(0);
		root.right = new TreeNode(1);
		// root.left.left = new TreeNode(1);
		// root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(5);
		root.right.right.right = new TreeNode(5);
		root.right.right.right = new TreeNode(5);
		System.out.println(minDepth1(root));

	}

	public static int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return helper(root, 1);

	}

	public static int helper(TreeNode root, int level) {
		// leaf node
		if (root.left == null && root.right == null) {
			return level;
		}

		Integer LL = null;
		if (root.left != null) {
			LL = helper(root.left, level + 1);
		}

		Integer RR = null;
		if (root.right != null) {
			RR = helper(root.right, level + 1);
		}

		if (LL != null && RR != null) {
			if (LL < RR) {
				return LL;
			} else {
				return RR;
			}
		} else if (LL == null) {
			return RR;
		} else {
			return LL;
		}

	}

	public static int minDepth1(TreeNode root) {
		if (root == null) {
			return 0;
		}

		if ((root.left == null) && (root.right == null)) {
			return 1;
		}

		int min_depth = Integer.MAX_VALUE;
		if (root.left != null) {
			min_depth = Math.min(minDepth1(root.left), min_depth);
		}
		if (root.right != null) {
			min_depth = Math.min(minDepth1(root.right), min_depth);
		}

		return min_depth + 1;
	}

}
