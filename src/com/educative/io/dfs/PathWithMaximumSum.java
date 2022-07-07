package com.educative.io.dfs;

public class PathWithMaximumSum {

	private static int maxSum = 0;

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(6);
		pathWithMaximumSum(root);
		System.out.println(maxSum);
	}

	public static int pathWithMaximumSum(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int leftSum = pathWithMaximumSum(root.left);
		int rightSum = pathWithMaximumSum(root.right);
		if (leftSum != 0 && rightSum != 0) {
			if (root.val + leftSum + rightSum > maxSum) {
				maxSum = root.val + leftSum + rightSum;
			}
		}

		return Math.max(leftSum, rightSum) + root.val;

	}

}
