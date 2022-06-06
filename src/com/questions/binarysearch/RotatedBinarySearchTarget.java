package com.questions.binarysearch;

public class RotatedBinarySearchTarget {

	public static void main(String[] args) {
		int arr[] = { 4, 5, 6, 7, 0, 1, 2 };
		int target = 4;

		System.out.println(rotatedBinarySearchTarget(arr, target));
	}

	public static int rotatedBinarySearchTarget(int arr[], int target) {

		int start = 0;
		int end = arr.length - 1;
		while (start <= end) {
			int mid = start + (end - start) / 2;

			if (arr[mid] == target) {
				return mid;
			}

			if (arr[mid] <= arr[end]) {
				// then the array to the right is sorted
				if (target >= arr[mid] && target <= arr[end]) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			} else if (target >= arr[start] && target <= arr[mid]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}

		}

		return -1;
	}

}
