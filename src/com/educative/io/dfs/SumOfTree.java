package com.educative.io.dfs;

public class SumOfTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(25);
		root.right = new TreeNode(25);
		root.left.left = new TreeNode(50);
		root.left.right = new TreeNode(50);
		root.right.left = new TreeNode(50);
		root.right.right = new TreeNode(50);

		System.out.println(getSum(root));

	}

	public static int getSum(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int val = root.val;
		int leftSum = getSum(root.left);
		int rightSum = getSum(root.right);
		return val + leftSum + rightSum;

	}

}
