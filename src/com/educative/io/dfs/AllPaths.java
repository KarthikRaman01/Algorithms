/**
 * 
 */
package com.educative.io.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Karthik
 *
 */
public class AllPaths {

	static List<List<Integer>> ans = new ArrayList<>();

	static List<Integer> sumAns = new ArrayList<>();

	public static void main(String[] args) {
		TreeNodes root = new TreeNodes(1);
		root.left = new TreeNodes(2);
		root.right = new TreeNodes(3);
		root.left.left = new TreeNodes(4);
		root.left.right = new TreeNodes(5);
		root.right.left = new TreeNodes(6);
		root.right.right = new TreeNodes(7);
		treePaths(root, new ArrayList<>());
		for (List<Integer> eachDepth : ans) {
			System.out.println(eachDepth);
		}

		treePaths1(root, 0);
		System.out.println(sumAns);
	}

	public static void treePaths(TreeNodes root, List<Integer> list) {
		if (root == null) {
			return;
		}

		if (root.left == null && root.right == null) {
			list.add(root.val);
			List<Integer> newList = new ArrayList<>(list);
			ans.add(newList);
			list.remove(root.val);
			return;
		}

		list.add(root.val);
		treePaths(root.left, list);
		treePaths(root.right, list);
		list.remove(root.val);

	}

	public static void treePaths1(TreeNodes root, int sum) {

		if (root == null) {
			return;
		}

		if (root.left == null) {
			sumAns.add(sum * 10 + root.val);
			return;
		}

		if (root.right == null) {
			sumAns.add(sum * 10 + root.val);
			return;
		}

		treePaths1(root.left, sum * 10 + root.val);
		treePaths1(root.right, sum * 10 + root.val);

	}

}

class TreeNodes {
	TreeNodes left;
	TreeNodes right;
	Integer val;

	public TreeNodes(Integer val) {
		this.val = val;
		this.left = null;
		this.right = null;

	}
}
