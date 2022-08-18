package com.educative.io.TopKElements;

import java.util.Collections;
import java.util.PriorityQueue;

public class KSmallestNumber {

	public static void main(String[] args) {
		int[] nums = { 3, 1, 5, 12, 2, 11 };
		int k = 3;
		System.out.println(getKSmallestNumber(nums, k));
	}

	public static int getKSmallestNumber(int[] nums, int k) {
		PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>(Collections.reverseOrder());
		for (int i = 0; i < k; i++) {
			pQueue.add(nums[i]);
		}

		for (int i = k; i < nums.length; i++) {
			if (nums[i] < pQueue.peek()) {
				pQueue.poll();
				pQueue.add(nums[i]);
			}
		}

		return pQueue.peek();

	}

}
