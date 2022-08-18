package com.educative.io.binarysearch;

public class PositionOfAnElementInInfiniteArray {

	public static void main(String[] args) {

	}

	public static int binarySearch(int arr[], int target) {
		int k = 2;
		int start = 0;
		int end = k - 1;

		while (true) {
			if (arr[end] < target) {
				if (end == Integer.MAX_VALUE || end == arr.length - 1) {
					return -1;
				}
				start = end + 1;
				end = end + k;
			} else {
				return actualBinarySearch(arr, start, end, target);
			}

		}

	}

	public static int actualBinarySearch(int arr[], int low, int high, int searchElement) {
		while (low <= high) {
			int mid = (low + high) / 2;
			if (arr[mid] == searchElement) {
				return mid;
			} else if (arr[mid] > searchElement) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}

		}

		return -1;

	}

}
