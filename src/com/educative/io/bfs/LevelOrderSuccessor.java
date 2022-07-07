package com.educative.io.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Anything to do with level - try BFS first
 * 
 * @author Karthik
 *
 */
public class LevelOrderSuccessor {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		TreeNode result = LevelOrderSuccessor.findSuccessor(root, 3);
		if (result != null)
			System.out.println(result.val + " ");

		root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(9);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);

		result = LevelOrderSuccessor.findSuccessor(root, 9);
		if (result != null)
			System.out.println(result.val + " ");

		result = LevelOrderSuccessor.findSuccessor(root, 12);
		if (result != null)
			System.out.println(result.val + " ");
	}

	public static TreeNode findSuccessor(TreeNode root, int key) {
		if (root == null) {
			return root;
		}

		/*
		 * if (root.val == key) { return successorForRootNode(root); }
		 */

		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		while (queue.size() > 0) {
			int queueSize = queue.size();
			for (int start = 0; start < queueSize; start++) {
				TreeNode node = queue.poll();

				if (node.left != null) {
					queue.add(node.left);
				}

				if (node.right != null) {
					queue.add(node.right);
				}

				if (node.val == key) {
					return queue.poll();
				}
			}

		}
		return root;

	}

	public static TreeNode successorForRootNode(TreeNode root) {
		if (root.left != null) {
			return root.left;
		}

		if (root.right != null) {
			return root.right;
		}
		return null;

	}

}
