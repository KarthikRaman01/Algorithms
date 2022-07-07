package com.educative.io.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightViewOfABinaryTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(9);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		root.left.left.left = new TreeNode(3);
		List<TreeNode> result = RightViewOfABinaryTree.traverse(root);
		for (TreeNode node : result) {
			System.out.print(node.val + " ");
		}

	}

	public static List<TreeNode> traverse(TreeNode root) {
		if (root == null) {
			return new ArrayList<TreeNode>();
		}

		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		List<TreeNode> rightSideList = new ArrayList<>();
		int count = 0;
		while (queue.size() > 0) {
			int queueSize = queue.size();
			for (int start = 0; start < queueSize; start++) {
				TreeNode node = queue.poll();
				System.out.println(node.val);
				if (start == 0) {
					rightSideList.add(node);
				}

				if (node.right != null) {
					queue.offer(node.right);
				}

				if (node.left != null) {
					queue.offer(node.left);
				}

			}
			count++;
		}

		return rightSideList;

	}

}
