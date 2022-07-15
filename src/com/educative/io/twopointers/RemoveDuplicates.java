package com.educative.io.twopointers;

import java.util.Arrays;

public class RemoveDuplicates {

	public static void main(String[] args) {
		int[] arr = { 2, 3, 3, 3, 6, 9, 9 };
		System.out.println(remove(arr));
		System.out.println(Arrays.toString(arr));

	}

	public static int remove(int[] arr) {
		if (arr == null) {
			return -1;
		}

		int nextNonDuplicate = 1;
		for (int start = 0; start < arr.length; start++) {
			if (arr[start] != arr[nextNonDuplicate - 1]) {
				arr[nextNonDuplicate] = arr[start];
				nextNonDuplicate++;
			}

		}

		return nextNonDuplicate;
	}

}
