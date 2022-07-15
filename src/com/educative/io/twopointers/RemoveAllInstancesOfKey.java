package com.educative.io.twopointers;

import java.util.Arrays;

public class RemoveAllInstancesOfKey {

	public static void main(String[] args) {
		int arr[] = { 3, 2, 3, 6, 3, 10, 9, 3 };
		int key = 3;
		System.out.println(remove(arr, key));
		System.out.println(Arrays.toString(arr));

	}

	public static int removeAllInstancesOfKey(int[] arr, int key) {
		int firstInstanceOfKey = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == key) {

				int temp = arr[firstInstanceOfKey];
				arr[firstInstanceOfKey] = arr[i];
				arr[i] = temp;

				firstInstanceOfKey++;

			}
		}

		return arr.length - firstInstanceOfKey;

	}

	public static int remove(int[] arr, int key) {
		int nextElement = 0; // index of the next element which is not 'key'
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != key) {
				arr[nextElement] = arr[i];
				nextElement++;
			}
		}

		return nextElement;
	}

}
