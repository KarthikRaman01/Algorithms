package com.educative.io.binarysearch;

public class SearchElementInBitonicArray {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 3, 2, 1 };

		// 3, 4, 5, 6, 2, 1
		// mid < mid+1
		// start = mid+1

		// 1, 7, 6, 5, 4, 3, 2
		// 1, 2,3,4,3,2,1
		int target = 2;
		int peak = findPeakInBitonicArray(arr);
		int index = findElementInOrderAgnosticBinarySearch(arr, target, 0, peak, true);
		if (index == -1) {
			index = findElementInOrderAgnosticBinarySearch(arr, target, peak + 1, arr.length - 1, false);
		}
		System.out.println(index);
	}

	public static int findElementInOrderAgnosticBinarySearch(int[] arr, int target, int start, int end, boolean isAsc) {
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (arr[mid] == target) {
				return mid;
			}

			if (isAsc) {
				if (arr[mid] > target) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			} else {
				if (arr[mid] > target) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			}

		}

		return -1;

	}

	public static int findPeakInBitonicArray(int[] arr) {

		int start = 0;
		int end = arr.length - 1;

		// keep an eye here --> < or <=
		while (start < end) {
			int mid = start + (end - start) / 2;

			if (arr[mid] < arr[mid + 1]) {
				start = mid + 1;
			} else {
				end = mid;
			}

		}

		return start;

	}

}
