package com.educative.io.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversalBFS {

	public static void main(String[] args) {
		TreeNode1 root = new TreeNode1(1);
		root.left = new TreeNode1(0);
		root.right = new TreeNode1(1);
		root.left.left = new TreeNode1(1);
		root.right.left = new TreeNode1(6);
		root.right.right = new TreeNode1(5);
		System.out.println(levelOrderTraversalBFS(root));
	}

	public static List<List<Integer>> levelOrderTraversalBFS(TreeNode1 root) {
		List<List<Integer>> valLevelList = new ArrayList<List<Integer>>();
		if (root == null) {
			return valLevelList;
		}

		Queue<TreeNode1> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			List<Integer> internalList = new ArrayList<>();
			int queueSize = queue.size();
			for (int start = 0; start < queueSize; start++) {
				TreeNode1 node = queue.poll();
				internalList.add(node.val);
				if (node.left != null) {
					queue.add(node.left);
				}

				if (node.right != null) {
					queue.add(node.right);
				}

			}

			if (!internalList.isEmpty()) {
				valLevelList.add(internalList);
			}
		}

		return valLevelList;
	}

}

class TreeNode1 {
	TreeNode1 left;
	TreeNode1 right;
	int val;

	public TreeNode1(int val) {
		this.val = val;
		this.left = null;
		this.right = null;
	}

}
