package com.educative.io.dfs;

public class TwoSumBST {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(4);
		root.right.right = new TreeNode(7);
		
		
		/*TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		root.right = new TreeNode(3);*/
		
		System.out.println(findTarget(root, 9));
	}

	private static TreeNode rootElement;

	public static boolean findTarget(TreeNode root, int k) {
		rootElement = root;
		return findTarget1(root, k);
	}

	public static boolean findTarget1(TreeNode root, int k) {
		if (root == null) {
			return false;
		}

		int target = k - root.val;
		
		boolean isPresent = search(rootElement, target, root);
		if (isPresent) {
			return isPresent;
		}

		if (findTarget1(root.left, k)) {
			return true;
		}

		if (findTarget1(root.right, k)) {
			return true;
		}

		return false;
	}

	public static boolean search(TreeNode root, int target, TreeNode currentElement) {
		if (root == null || root == currentElement) {
			return false;
		}

		if (root.val == target) {
			return true;
		} else if (root.val > target) {
			return search(root.left, target, currentElement);
		} else {
			return search(root.right, target, currentElement);
		}
	}

}
