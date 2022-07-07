package com.educative.io.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://www.educative.io/courses/grokking-the-coding-interview/m2YYxXDOJ03
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 * BFS logic 
 * Keep track of the previous node so you can assign next just like LL to the
 * current value;
 * 
 * @author Karthik
 *
 */
public class ConnectLevelOrderSiblings {

	static TreeNode previousNode = null;

	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(9);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		// 12 7 1 9 10 5
		levelOrderTraversal(root);
		printSiblings(root);
	}

	/**
	 * BFS logic Keep track of the previous node so you can assign next to the
	 * current value;
	 * 
	 * @param root
	 */
	public static void levelOrderTraversal(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		while (queue.size() > 0) {
			int queueSize = queue.size();
			TreeNode previousNode = null;
			for (int start = 0; start < queueSize; start++) {
				TreeNode node = queue.poll();

				System.out.println(node.val);
				if (node.left != null) {
					queue.offer(node.left);
				}

				if (node.right != null) {
					queue.offer(node.right);
				}

				if (previousNode != null) {
					previousNode.next = node;
				}

				previousNode = node;
			}
		}

		System.out.println("Ended Level order Traversing");

	}

	public static void printSiblings(TreeNode root) {
		TreeNode tempNode = root;
		while (tempNode != null) {
			System.out.print(tempNode.val + "-->");
			tempNode = tempNode.next;
		}
		System.out.print("null");
		System.out.println("");

		if (root.left != null) {
			printSiblings(root.left);
		} else if (root.right != null) {
			printSiblings(root.right);
		}

	}

}

class TreeNode {
	TreeNode left;
	TreeNode right;
	TreeNode next;
	int val;

	public TreeNode(int val) {
		this.val = val;
		this.left = null;
		this.right = null;
		this.next = null;
	}
}
