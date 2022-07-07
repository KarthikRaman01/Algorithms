package com.educative.io.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.educative.io.dfs.TreeNode;

public class MinimumBinaryTreeDepth {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		System.out.println("Tree Minimum Depth: " + MinimumBinaryTreeDepth.findDepth(root));
		root.left.left = new TreeNode(9);
		root.right.left.left = new TreeNode(11);
		System.out.println("Tree Minimum Depth: " + MinimumBinaryTreeDepth.findDepth(root));
	}

	public static int findDepth(TreeNode root) {
		if (root == null) {
			return -1;
		}

		int depth = 1;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			int queueSize = queue.size();
			for (int start = 0; start < queueSize; start++) {
				TreeNode node = queue.poll();
				if (node.left == null && node.right == null) {
					return depth;
				}
				if (node.left != null) {
					queue.add(node.left);
				}

				if (node.right != null) {
					queue.add(node.right);
				}

			}
			depth = depth + 1;

		}

		return depth;
	}

}
