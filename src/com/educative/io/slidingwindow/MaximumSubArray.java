package com.educative.io.slidingwindow;

public class MaximumSubArray {

	public static void main(String[] args) {
		int arr[] = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(maxSubArray(arr));

	}

	public static int maxSubArray(int[] nums) {
		Integer maxSum = Integer.MIN_VALUE;
		for (int start = 0; start < nums.length; start++) {
			int sum = 0;
			for (int end = start; end < nums.length; end++) {
				sum = sum + nums[end];
				if (sum > maxSum) {
					maxSum = sum;
				}
			}
		}
		return maxSum;

	}

}
