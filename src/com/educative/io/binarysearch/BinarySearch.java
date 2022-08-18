package com.educative.io.binarysearch;

public class BinarySearch {

	public static void main(String[] args) {
		int arr[] = { 2, 4, 5, 7, 9, 11 };
		System.out.println(binarySearch(arr, 11));
		int arr1[] = { 11, 10, 8, 6, 5, 3, 1 };
		System.out.println(orderAgnosticBinarySearch(arr1, 1));
	}

	public static boolean binarySearch(int arr[], int searchElement) {
		int low = 0;
		int high = arr.length - 1;

		while (low <= high) {
			int mid = (low + high) / 2;
			if (arr[mid] == searchElement) {
				return true;
			} else if (arr[mid] > searchElement) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}

		}

		return false;

	}

	public static boolean orderAgnosticBinarySearch(int arr[], int searchElement) {

		int low = 0;
		int high = arr.length - 1;

		boolean isAsc = false;
		if (arr[low] < arr[high]) {
			isAsc = true;
		}

		while (low <= high) {
			int mid = (low + high) / 2;
			if (arr[mid] == searchElement) {
				return true;
			}

			if (isAsc) {
				if (arr[mid] > searchElement) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			} else {
				if (arr[mid] > searchElement) {
					low = mid + 1;

				} else {
					high = mid - 1;
				}
			}

		}

		return false;
	}

}
