package com.educative.io.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class LevelOrderTraversal {

	private static Map<Integer, List<Integer>> levelMap = new HashMap<>();

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(0);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(1);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(5);
		System.out.println(levelOrder(root));
		System.out.println(levelOrderBFS(root));
	}

	public static List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> ans = new ArrayList<>();
		helperForLevelOrder(root, 1);
		for (List<Integer> val : levelMap.values()) {
			ans.add(val);
		}
		return ans;
	}

	public static void helperForLevelOrder(TreeNode root, int sequence) {
		if (root == null) {
			return;
		}

		List<Integer> levelList = levelMap.get(sequence);
		if (levelList == null || levelList.isEmpty()) {
			levelList = new ArrayList<Integer>();

		}
		levelList.add(root.val);
		levelMap.put(sequence, levelList);

		// left recursive call
		helperForLevelOrder(root.left, sequence + 1);

		// right recursive call
		helperForLevelOrder(root.right, sequence + 1);

	}

	public static List<List<Integer>> levelOrderBFS(TreeNode root) {
		List<List<Integer>> ans = new ArrayList<>();

		if (root == null) {
			return ans;
		}

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		List<Integer> firstList = new ArrayList<>();
		firstList.add(root.val);
		ans.add(firstList);

		while (!queue.isEmpty()) {
			List<Integer> list = new ArrayList<>();
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();

				if (node.left != null) {
					queue.add(node.left);
					list.add(node.left.val);
				}

				if (node.right != null) {
					queue.add(node.right);
					list.add(node.right.val);
				}
			}
			if (!list.isEmpty()) {
				ans.add(list);
			}

		}

		return ans;
	}

	public static List<List<Integer>> levelOrderDFS(TreeNode root) {
		helperForLevelOrderDFS(root, 0);
		return ans;
	}

	private static List<List<Integer>> ans = new ArrayList<>();

	public static void helperForLevelOrderDFS(TreeNode root, int sequence) {
		if (root == null) {
			return;
		}

		if (ans.size() == sequence) {
			List<Integer> list = new ArrayList<>();
			ans.add(list);
		}

		ans.get(sequence).add(root.val);

		// left recursive call
		helperForLevelOrderDFS(root.left, sequence + 1);

		// right recursive call
		helperForLevelOrderDFS(root.right, sequence + 1);

	}
}
