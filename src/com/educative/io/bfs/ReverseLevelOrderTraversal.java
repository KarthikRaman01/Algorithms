package com.educative.io.bfs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.educative.io.dfs.TreeNode;

public class ReverseLevelOrderTraversal {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(0);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(1);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(5);
		System.out.println(levelOrderTraversalBFS(root));
	}

	public static List<List<Integer>> levelOrderTraversalBFS(TreeNode root) {
		List<List<Integer>> valLevelList = new LinkedList<List<Integer>>();
		if (root == null) {
			return valLevelList;
		}

		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		while (!queue.isEmpty()) {

			int queueSize = queue.size();
			List<Integer> internalList = new LinkedList<>();
			for (int start = 0; start < queueSize; start++) {
				TreeNode node = queue.poll();
				internalList.add(node.val);
				if (node.left != null) {
					queue.offer(node.left);
				}

				if (node.right != null) {
					queue.offer(node.right);
				}

			}

			if (!internalList.isEmpty()) {
				valLevelList.add(0, internalList);
			}
		}

		return valLevelList;
	}

}
