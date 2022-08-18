package com.educative.io.binarysearch;

public class MinimumDifferenceElement {

	public static void main(String[] args) {
		int arr[] = { 4, 6, 10 };
		int target = 17;
		System.out.println(findMinDifferenceElement(arr, target));

	}

	public static int findMinDifferenceElement(int arr[], int target) {
		int start = 0;
		int end = arr.length - 1;

		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (arr[mid] == target) {
				return target;
			} else if (arr[mid] > target) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}

		if (start >= 0 && start <= arr.length-1 && end >= 0 && end <= arr.length-1) {
			int startDiff = target > arr[start] ? target - arr[start] : arr[start] - target;
			int endDiff = target > arr[end] ? target - arr[end] : arr[end] - target;
			if (startDiff < endDiff) {
				return arr[start];
			} else {
				return arr[end];
			}
		}

		if (start >= 0 && start <= arr.length-1) {
			return arr[start];
		}
		return arr[end];

	}

}
