package com.educative.io.twopointers;

public class MinimumWindowSort {

	public static void main(String[] args) {
		int[] arr = {  2, 1 };
		int output = mimWindowSort(arr);
		System.out.println("Min Window Sort: " + output);

	}

	public static int mimWindowSort(int[] arr) {
		
		if(arr == null || arr.length == 0 || arr.length == 1) {
			return 0;
		}

		Integer startIndex = -1;
		for (int i = 1; i <= arr.length - 1; i++) {
			if (arr[i - 1] > arr[i]) {
				startIndex = i - 1;
				break;
			}
		}

		Integer endIndex = -1;
		for (int i = arr.length - 2; i >= 0; i--) {
			if (arr[i + 1] < arr[i]) {
				endIndex = i + 1;
				break;
			}
		}

		// array is sorted
		if (startIndex == -1 || endIndex == -1) {
			return 0;
		}

		int ans = endIndex - startIndex + 1;
		int minimum = findMin(arr, startIndex, endIndex);
		int maximum = findMax(arr, startIndex, endIndex);

		int rightSortedCount = 0;
		for (int i = endIndex + 1; i < arr.length; i++) {
			if (arr[i] < maximum) {
				rightSortedCount = i - endIndex;
			}
		}

		int leftSortedCount = 0;
		for (int i = startIndex - 1; i >= 0; i--) {
			if (arr[i] > minimum) {
				leftSortedCount = startIndex - i;
			}
		}

		return ans + leftSortedCount + rightSortedCount;
	}

	public static int findMin(int arr[], int start, int end) {
		int minimum = Integer.MAX_VALUE;
		for (int i = start; i <= end; i++) {
			if (arr[i] < minimum) {
				minimum = arr[i];
			}
		}
		return minimum;

	}

	public static int findMax(int arr[], int start, int end) {
		int max = Integer.MIN_VALUE;
		for (int i = start; i <= end; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		return max;

	}

}
