package com.leetcode.medium.recursion;

public class RotatedBinarySearch {

	public static void main(String[] args) {
		int arr[] = { 4, 5, 6, 7, 0, 1, 2 };
		int target = 5;
		int start = 0;
		int end = arr.length - 1;
		System.out.println(rotatedBinarySearchTargetRecursion(arr, target, start, end));

	}

	public static int rotatedBinarySearchTargetRecursion(int arr[], int target, int start, int end) {
		// come out of recursion
		if (start > end) {
			return -1;
		}

		int mid = start + (end - start) / 2;

		if (arr[mid] == target) {
			return mid;
		}

		if (arr[mid] <= arr[end]) {
			// then the array to the right is sorted
			if (target >= arr[mid] && target <= arr[end]) {
				start = mid + 1;
				return rotatedBinarySearchTargetRecursion(arr, target, start, end);
			} else {
				end = mid - 1;
				return rotatedBinarySearchTargetRecursion(arr, target, start, end);
			}
		} else if (target >= arr[start] && target <= arr[mid]) {
			end = mid - 1;
			return rotatedBinarySearchTargetRecursion(arr, target, start, end);
		} else {
			start = mid + 1;
			return rotatedBinarySearchTargetRecursion(arr, target, start, end);
		}

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
