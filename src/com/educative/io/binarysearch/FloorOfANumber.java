package com.educative.io.binarysearch;

public class FloorOfANumber {

	public static void main(String[] args) {
		int arr[] = { 2, 4, 5, 7, 9, 11 };
		System.out.println(binarySearch(arr, 15));
	}

	public static int binarySearch(int arr[], int searchElement) {
		int low = 0;
		int high = arr.length - 1;

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

		if (high >= 0) {
			return high;
		}
		return -1;

	}

}
