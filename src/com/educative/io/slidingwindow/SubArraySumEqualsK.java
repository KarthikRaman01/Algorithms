package com.educative.io.slidingwindow;

public class SubArraySumEqualsK {

	public static void main(String[] args) {
		int arr[] = {-1, -1, 1};
		System.out.println(subarraySum(arr, 0));

	}

	public static int subarraySum(int[] arr, int S) {
		int windowStart = 0;
		int count = 0;

		int sum = 0;
		for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
			sum = sum + arr[windowEnd];

			while (windowStart <= windowEnd && sum >= S) {
				if (sum == S) {
					count++;
				}

				sum = sum - arr[windowStart];
				windowStart++;
			}

		}
		return count;
	}
}
