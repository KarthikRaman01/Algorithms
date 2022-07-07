package com.educative.io.dfs;

import java.util.ArrayList;
import java.util.List;

public class SumOfPathNumbers {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(0);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(1);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(5);

		System.out.println(getDiffPaths(root, ""));
		System.out.println("Total Sum of Path Numbers: " + SumOfPathNumbers.SumOfAllPathNumbers(root));
		System.out.println("Total Sum of Path Numbers: " + SumOfPathNumbers.SumOfAllPathNumbers1(root));

	}

	public static int SumOfAllPathNumbers(TreeNode root) {
		List<String> paths = getDiffPaths(root, "");
		if (paths == null || paths.isEmpty()) {
			return -1;
		}
		int sum = 0;
		for (String path : paths) {
			sum = sum + Integer.parseInt(path);
		}
		return sum;
	}

	public static List<String> getDiffPaths(TreeNode root, String p) {

		if (root == null) {
			return new ArrayList<String>();
		}

		if (root.left == null && root.right == null) {
			p = p + root.val;
			List<String> ans = new ArrayList<>();
			ans.add(p);
			return ans;
		}

		List<String> allPaths = new ArrayList<>();
		allPaths.addAll(getDiffPaths(root.left, p + root.val));
		allPaths.addAll(getDiffPaths(root.right, p + root.val));

		return allPaths;
	}

	public static int SumOfAllPathNumbers1(TreeNode root) {
		return helper(root, 0);

	}

	public static int helper(TreeNode root, int sum) {
		if (root == null) {
			return 0;
		}

		if (root.left == null && root.right == null) {
			return (sum * 10) + root.val;

		}

		int currentVal = root.val;
		int leftSum = helper(root.left, (sum * 10) + currentVal);
		int rightSum = helper(root.right, (sum * 10) + currentVal);
		return leftSum + rightSum;

	}
}
