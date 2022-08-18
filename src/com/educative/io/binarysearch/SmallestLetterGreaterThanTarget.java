package com.educative.io.binarysearch;

public class SmallestLetterGreaterThanTarget {

	public static void main(String[] args) {
		char[] arr = { 'c', 'f', 'j' };
		System.out.println(binarySearch(arr, 'a'));
	}

	public static char binarySearch(char a[], char target) {
		int start = 0;
		int end = a.length - 1;

		while (start <= end) {
			int mid = (start + end) / 2;
			if (target < a[mid]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}

		// if (start >= a.length) {
		// return a[0];
		// }
		// return a[start];
		return a[start % a.length];

	}

}
