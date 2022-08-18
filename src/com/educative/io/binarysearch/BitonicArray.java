package com.educative.io.binarysearch;

public class BitonicArray {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 3, 2, 1 };

		// 3, 4, 5, 6, 2, 1
		// mid < mid+1
		// start = mid+1

		// 1, 7, 6, 5, 4, 3, 2
		// 1, 2,3,4,3,2,1

		System.out.println(findPeakInBitonicArray(arr));

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
