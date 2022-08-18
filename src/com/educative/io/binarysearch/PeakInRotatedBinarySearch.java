package com.educative.io.binarysearch;

public class PeakInRotatedBinarySearch {

	public static void main(String[] args) {
		/*
		 * int arr[] = { 4, 5, 6, 7, 1, 2 }; System.out.println(findPeakInRBS(arr));
		 */
		int arr1[] = { 3, 6, 3, 3, 3, 3, 3 };
		System.out.println(findPeakInRBSWithDuplicates(arr1));

	}

	// check for --> any null pointers
	// gop thru the code with various use cases
	public static int findPeakInRBS(int[] arr) {
		int start = 0;
		int end = arr.length - 1;
		// <= or <
		while (start <= end) {
			int mid = start + (end - start) / 2;

			// good chance of a np --> so
			if (mid < end && arr[mid] > arr[mid + 1]) {
				return mid;
			}

			if (mid > start && arr[mid - 1] > arr[mid]) {
				return mid - 1;
			}

			if (arr[start] <= arr[mid]) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}

		}

		return -1;
	}

	public static int findPeakInRBSWithDuplicates(int[] arr) {
		int start = 0;
		int end = arr.length - 1;
		// <= or <
		while (start <= end) {
			int mid = start + (end - start) / 2;

			// good chance of a np --> so
			if (mid < arr.length && arr[mid] > arr[mid + 1]) {
				return mid;
			}

			if (mid >= 0 && arr[mid - 1] > arr[mid]) {
				return mid - 1;
			}

			if (arr[mid] == arr[start] && arr[mid] == arr[end]) {
				start++;
				end--;
				continue;
			}

			if (arr[start] <= arr[mid]) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}

		}

		return -1;
	}

}
