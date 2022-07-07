package com.educative.io.bfs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.educative.io.dfs.TreeNode;

public class ZigZagOrderTraversal {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(9);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		root.right.left.left = new TreeNode(20);
		root.right.left.right = new TreeNode(17);
		System.out.println(zigZagOrderTraversal(root));
	}

	public static List<List<Integer>> zigZagOrderTraversal(TreeNode root) {
		List<List<Integer>> valLevelList = new LinkedList<List<Integer>>();
		if (root == null) {
			return valLevelList;
		}

		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		int count = 1;

		while (!queue.isEmpty()) {
			int queueSize = queue.size();
			List<Integer> internalList = new LinkedList<>();
			for (int start = 0; start < queueSize; start++) {
				TreeNode node = queue.poll();
				if (count % 2 == 1) {
					internalList.add(node.val);
				} else {
					internalList.add(0, node.val);
				}

				if (node.left != null) {
					queue.offer(node.left);
				}

				if (node.right != null) {
					queue.offer(node.right);
				}

			}

			count++;

			if (!internalList.isEmpty()) {
				valLevelList.add(internalList);
			}
		}

		return valLevelList;
	}
}
