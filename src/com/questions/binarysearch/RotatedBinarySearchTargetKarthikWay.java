package com.questions.binarysearch;

public class RotatedBinarySearchTargetKarthikWay {

	public static void main(String[] args) {
		int arr[] = { 4, 5, 6, 7, 0, 1, 2 };
		int target = 4;

		System.out.println(search(arr, target));

	}

	public static int search(int[] a, int target) {
		int rotatedIndex = rotatedIndex(a);
		int index = -1;
		if (rotatedIndex == -1) {
			index = binarySearch(a, target, 0, a.length - 1);
			return index;
		}

		if (a[rotatedIndex] == target) {
			return rotatedIndex;
		}

		if (target > a[a.length - 1]) {
			index = binarySearch(a, target, 0, rotatedIndex);
		} else {
			index = binarySearch(a, target, rotatedIndex + 1, a.length - 1);
		}
		return index;
	}

	public static int rotatedIndex(int a[]) {
		int start = 0;
		int end = a.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (mid < a.length - 1 && a[mid] > a[mid + 1]) {
				return mid;
			}

			if (mid > 0 && a[mid] < a[mid - 1]) {
				return mid - 1;
			}

			if (a[mid] <= a[end]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}

		return -1;
	}

	public static int binarySearch(int a[], int target, int start, int end) {
		while (start <= end) {
			int middle = (start + end) / 2;
			if (target < a[middle]) {
				end = middle - 1;
			} else if (target > a[middle]) {
				start = middle + 1;
			} else {
				return middle;
			}
		}
		return -1;

	}

}
