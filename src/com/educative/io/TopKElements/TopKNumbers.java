package com.educative.io.TopKElements;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class TopKNumbers {

	public static void main(String[] args) {
		int[] nums = { 3, 1, 5, 12, 2, 11 };
		int k = 3;
		System.out.println(getTopKNumbers1(nums, k));

	}

	public static List<Integer> getTopKNumbers(int[] nums, int k) {
		if (nums.length < k) {
			k = nums.length;
		}
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(Collections.reverseOrder());
		for (int start = 0; start < nums.length; start++) {
			queue.add(nums[start]);
		}

		List<Integer> ans = new ArrayList<>();
		for (int top = 0; top < k; top++) {
			int maxElement = queue.peek();
			ans.add(maxElement);
			queue.poll();
		}

		return ans;

	}

	public static List<Integer> getTopKNumbers1(int[] nums, int k) {
		if (nums.length < k) {
			k = nums.length;
		}
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(k);
		for (int start = 0; start < k; start++) {
			queue.add(nums[start]);
		}

		for (int start = k; start < nums.length; start++) {
			if (nums[start] > queue.peek()) {
				queue.poll();
				queue.add(nums[start]);
			}
		}

		return new ArrayList<>(queue);

	}

}
