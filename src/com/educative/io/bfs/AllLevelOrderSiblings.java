package com.educative.io.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class AllLevelOrderSiblings {

	public static void main(String[] args) {
		TreeNodeLL root = new TreeNodeLL(12);
		root.left = new TreeNodeLL(7);
		root.right = new TreeNodeLL(1);
		root.left.left = new TreeNodeLL(9);
		root.right.left = new TreeNodeLL(10);
		root.right.right = new TreeNodeLL(5);
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
	public static void levelOrderTraversal(TreeNodeLL root) {
		Queue<TreeNodeLL> queue = new LinkedList<>();
		queue.offer(root);
		TreeNodeLL previousNode = null;
		while (queue.size() > 0) {
			int queueSize = queue.size();

			for (int start = 0; start < queueSize; start++) {
				TreeNodeLL node = queue.poll();

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

	public static void printSiblings(TreeNodeLL root) {
		TreeNodeLL tempNode = root;
		while (tempNode != null) {
			System.out.print(tempNode.val + "-->");
			tempNode = tempNode.next;
		}
		System.out.print("null");
		System.out.println("");

		/*
		 * if (root.left != null) { printSiblings(root.left); } else if (root.right !=
		 * null) { printSiblings(root.right); }
		 */

	}

}

class TreeNodeLL {
	TreeNodeLL left;
	TreeNodeLL right;
	TreeNodeLL next;
	int val;

	public TreeNodeLL(int val) {
		this.val = val;
		this.left = null;
		this.right = null;
		this.next = null;
	}

}
