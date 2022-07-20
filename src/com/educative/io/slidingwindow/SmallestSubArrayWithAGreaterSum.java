package com.educative.io.slidingwindow;

public class SmallestSubArrayWithAGreaterSum {

	public static void main(String[] args) {
		int arr[] = { 2, 1, 5, 2, 3, 2 };
		int S = 7;
		smallestSubArrayWithAGreaterSum(arr, S);

	}

	public static void smallestSubArrayWithAGreaterSum(int arr[], int S) {
		int windowStart = 0;
		int smallestSize = Integer.MAX_VALUE;

		int sum = 0;
		for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
			sum = sum + arr[windowEnd];

			while (windowStart <= windowEnd && sum >= S) {

				int lengthOfSA = windowEnd - windowStart + 1;
				if (lengthOfSA < smallestSize) {
					smallestSize = lengthOfSA;
				}

				sum = sum - arr[windowStart];
				windowStart++;
			}

		}

		System.out.println(smallestSize);

	}

}
