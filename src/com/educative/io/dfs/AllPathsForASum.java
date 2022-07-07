package com.educative.io.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllPathsForASum {

	public static void main(String args[]) {
		/*
		 * TreeNode rootNode = new TreeNode(1); rootNode.left = new TreeNode(7);
		 * rootNode.right = new TreeNode(9); rootNode.left.left = new TreeNode(4);
		 * rootNode.left.right = new TreeNode(5);
		 * 
		 * rootNode.right.left = new TreeNode(2); rootNode.right.right = new
		 * TreeNode(7);
		 * 
		 * findPaths(rootNode, 12, ""); System.out.println(findPathsList(rootNode, 12,
		 * new ArrayList<>()));
		 */

		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(4);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		int sum = 23;
		System.out.println(findPathsList(root, sum, new ArrayList<>()));
		findPaths2(root, sum, new ArrayList<>());
		findPaths3(root, sum, new ArrayList<>());
	}

	public static void findPaths(TreeNode root, int sum, String p) {

		if (root.left == null && root.right == null) {
			if (sum - root.val == 0) {
				p = p + " " + root.val;
				System.out.println(p);
				return;
			}
			return;
		}

		Integer val = root.val;
		findPaths(root.left, sum - root.val, p + " " + val.toString());
		findPaths(root.right, sum - root.val, p + " " + val.toString());

	}

	public static List<List<Integer>> findPathsList(TreeNode root, int sum, List<Integer> prevValues) {

		List<List<Integer>> nullAns = new ArrayList<>();
		if (root == null) {
			return nullAns;
		}

		if (root.left == null && root.right == null) {
			if (sum - root.val == 0) {
				List<List<Integer>> ans = new ArrayList<>();
				prevValues.add(root.val);
				ans.add(prevValues);
				return ans;
			}
			return nullAns;
		}

		List<Integer> newList = new ArrayList<>();
		newList.addAll(prevValues);
		newList.add(root.val);
		List<List<Integer>> left = findPathsList(root.left, sum - root.val, newList);
		List<List<Integer>> right = findPathsList(root.right, sum - root.val, newList);
		left.addAll(right);
		return left;

	}

	public static void findPaths2(TreeNode root, int sum, List<Integer> oldValues) {
		if (root == null) {
			return;
		}
		if (root.left == null && root.right == null) {
			oldValues.add(root.val);
			int indPathSum = getSum(oldValues);
			if (indPathSum == sum) {
				System.out.println(oldValues);
				return;
			}
			return;
		}

		List<Integer> path = new ArrayList<>(oldValues);
		path.add(root.val);
		findPaths2(root.left, sum, path);
		findPaths2(root.right, sum, path);

	}

	public static int getSum(List<Integer> singlePath) {
		int sum = 0;
		for (Integer val : singlePath) {
			sum = sum + val;
		}
		return sum;
	}

	public static void findPaths3(TreeNode root, int sum, List<Integer> values) {
		if (root == null) {
			return;
		}
		values.add(root.val);
		if (root.left == null && root.right == null) {
			int indPathSum = getSum(values) + root.val;
			if (indPathSum == sum) {
				System.out.println(values);
			}
			values.remove(values.size() - 1);
			return;
		}

		findPaths3(root.left, sum, values);
		findPaths3(root.right, sum, values);
		values.remove(values.size() - 1);

	}

}
