package com.educative.io.dfs;

public class SameTree {

	public static void main(String[] args) {
		TreeNode p = new TreeNode(10);
		p.left = new TreeNode(5);
		p.right = new TreeNode(15);
		
		TreeNode q = new TreeNode(10);
		q.left = new TreeNode(5);
		q.left.right = new TreeNode(15);
		
		System.out.println(isSameTree(p, q));
	}

	public static boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		} else if (p == null) {
			return false;
		} else if (q == null) {
			return false;
		}

		if (p.val == q.val) {
			boolean leftSame = isSameTree(p.left, q.left);
			boolean rightSame = isSameTree(p.right, q.right);
			if (leftSame && rightSame) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}

	}

	public void dfs(TreeNode p) {
		if (p == null) {
			return;
		}

		System.out.println(p.val);
		dfs(p.left);
		dfs(p.right);

	}

}
