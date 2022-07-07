package com.educative.io.bfs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.educative.io.dfs.TreeNode;

public class LevelAveragesInABinaryTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(0);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(1);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(5);
		System.out.println(LevelAveragesInABinaryTree(root));
	}

	public static List<Double> LevelAveragesInABinaryTree(TreeNode root) {
		List<Double> avgList = new LinkedList<Double>();
		if (root == null) {
			return avgList;
		}

		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		while (!queue.isEmpty()) {
			int queueSize = queue.size();
			Double sum = 0.0;
			int start = 0;
			while (start < queueSize) {
				TreeNode node = queue.poll();
				sum = sum + node.val;
				if (node.left != null) {
					queue.offer(node.left);
				}

				if (node.right != null) {
					queue.offer(node.right);
				}
				start = start + 1;
			}

			// get the average of the elements from the internal list
			avgList.add(sum / start);

		}

		return avgList;
	}

	public static Double getAverage(List<Integer> internalList) {
		Double sum = 0.0;
		for (Integer data : internalList) {
			sum = sum + data;
		}
		return (double) (sum / internalList.size());

	}
}
