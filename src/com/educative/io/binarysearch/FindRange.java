package com.educative.io.binarysearch;

import java.util.Arrays;

public class FindRange {

	public static void main(String[] args) {
		int arr[] = { 1, 3, 8, 10, 15 };
		System.out.println(Arrays.toString(binarySearch(arr, 8)));

		int startIndex = binarySearch1(arr, 8, true);
		int endIndex = binarySearch1(arr, 8, false);
		System.out.println(startIndex);
		System.out.println(endIndex);
	}

	public static int[] binarySearch(int arr[], int target) {
		int start = 0;
		int end = arr.length - 1;

		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (arr[mid] == target) {
				// check for the index
				int startIndex = mid;
				int endIndex = mid;

				for (int i = endIndex + 1; i < arr.length; i++) {
					if (arr[i] == arr[i - 1]) {
						endIndex = endIndex + 1;
					} else {
						break;
					}
				}

				for (int i = startIndex - 1; i >= 0; i--) {
					if (arr[i] == arr[i + 1]) {
						startIndex = startIndex - 1;
					} else {
						break;
					}
				}

				return new int[] { startIndex, endIndex };
			} else if (arr[mid] > target) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}

		return new int[] { -1, -1 };
	}

	public static int binarySearch1(int arr[], int target, boolean first) {
		int start = 0;
		int end = arr.length - 1;
		int ans = -1;

		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (arr[mid] == target) {
				// check for the index
				ans = mid;
				if (first) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}

			} else if (arr[mid] > target) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}

		return ans;
	}

}
