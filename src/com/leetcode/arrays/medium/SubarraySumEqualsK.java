package com.leetcode.arrays.medium;

import java.util.HashMap;

public class SubarraySumEqualsK {

	static HashMap<String, Integer> sumMap = new HashMap<>();

	public static void main(String[] args) {
		int nums[] = { 1, 2, 3 };
		int target = 3;
		System.out.println(subarraySum1(nums, target));
	}

	public static int subarraySum(int[] nums, int k) {
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			int subsetLength = i + 1;
			for (int j = 0; j < nums.length - i; j++) {
				int sum = getSum(nums, j, subsetLength + j);
				if (sum == k) {
					count = count + 1;
				}
			}
		}
		return count;
	}

	public static int getSum(int[] nums, Integer startIndex, Integer endIndex) {
		Integer keyEndIndex = endIndex - 1;
		String key = startIndex.toString() + "-" + keyEndIndex.toString();
		if (sumMap.containsKey(key)) {
			return sumMap.get(key) + nums[endIndex - 1];
		}

		int sum = 0;
		for (int i = startIndex; i < endIndex; i++) {
			sum = sum + nums[i];
		}
		sumMap.put(startIndex.toString() + "-" + endIndex.toString(), sum);
		return sum;
	}
	
	public static int subarraySum1(int[] nums, int k) {
		int count = 0;
		for (int start = 0; start < nums.length; start++) {
			int sum = 0;
			for (int end = start; end < nums.length; end++) {
				sum = sum + nums[end];
				if (sum == k) {
					count = count + 1;
				}
			}
		}
		return count;
	}

}
