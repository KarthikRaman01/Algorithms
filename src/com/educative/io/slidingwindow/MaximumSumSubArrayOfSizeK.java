package com.educative.io.slidingwindow;

public class MaximumSumSubArrayOfSizeK {

	public static void main(String[] args) {
		int arr[] = { 2, 1, 5, 1, 3, 2 };
		int k = 3;
		System.out.println(findMaxSumSubArray(k, arr));
	}

	public static int findMaxSumSubArray(int k, int[] arr) {
		int windowStart = 0;
		int maxSum = Integer.MIN_VALUE;
		int sum = 0;
		for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
			sum = sum + arr[windowEnd];
			if (windowEnd >= k - 1) {
				if (sum > maxSum) {
					maxSum = sum;
				}
				sum = sum - arr[windowStart];
				windowStart++;
			}

		}
		return maxSum;
	}

}
