package com.questions.binarysearch;

public class RotatedBinarySearchPeak {

	public static void main(String[] args) {
		int a[] = { 4, 5, 6, 7, 8, 1, 2 };
		System.out.println(rotatedIndex(a));
	}

	/**
	 * two aspects - my method give the example - 4, 5, 6, 7, 0, 1, 2 for returning
	 * the answer take mid as 7 and compare it with 0 take 0 as mid and compare it
	 * with 7
	 * 
	 * for moving the start and end compare the mid with the end element to see if
	 * it is in sorted order if in sorted order, then the peak is not in there , so
	 * end = mid-1 if not in sorted order, search there only --> start = mid + 1
	 * 
	 * @param a
	 * @return
	 */
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

}
