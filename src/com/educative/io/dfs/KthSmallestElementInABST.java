package com.educative.io.dfs;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallestElementInABST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int kthSmallest(TreeNode root, int k) {
		if(root == null || k==0) {
			return k;
		}
		
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, Collections.reverseOrder());
		if(maxHeap.size() < k) {
			return -1;
		}
		return maxHeap.poll();

	}

	public static void helper(TreeNode root, PriorityQueue<Integer> maxHeap) {
		if(root == null) {
			return;
		}
		
		maxHeap.offer(root.val);
		helper(root.left, maxHeap);
		helper(root.right, maxHeap);

	}

}
