package com.educative.io.binarysearch;

public class CeilingOfANumber {

	public static void main(String[] args) {
		int arr[] = { 2, 4, 5, 7, 9, 11 };
		System.out.println(binarySearch(arr, 3));
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

		if (low <= arr.length - 1) {
			return low;
		}
		return -1;

	}

}
