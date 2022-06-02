package com.questions.arrays.easy;

public class LinearSearch {

	public static void main(String[] args) {
		int a[] = { 1, 3, 5, 7 };
		System.out.println(search(a, 4));
		System.out.println(linearSearchRecursive(a, 8));

		System.out.println(searchIndex(a, 5));
		System.out.println(linearSearchIndexRecursive(a, 5));
	}

	public static boolean search(int arr[], int target) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == target) {
				return true;
			}
		}

		return false;
	}

	public static int searchIndex(int arr[], int target) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == target) {
				return i;
			}
		}

		return -1;
	}

	public static boolean linearSearchRecursive(int arr[], int target) {
		return helper2(arr, target, 0);
	}

	public static int linearSearchIndexRecursive(int arr[], int target) {
		return helperIndex(arr, target, 0);
	}

	public static boolean helper(int arr[], int target, int index) {
		if (index == arr.length) {
			return false;
		}

		if (arr[index] == target) {
			return true;
		}

		return helper(arr, target, ++index);

	}

	public static int helperIndex(int arr[], int target, int index) {
		if (index == arr.length) {
			return -1;
		}

		if (arr[index] == target) {
			return index;
		}

		return helperIndex(arr, target, ++index);

	}

	public static boolean helper2(int arr[], int target, int index) {
		if (index == arr.length) {
			return false;
		}

		return (arr[index] == target) || helper2(arr, target, ++index);

	}

}
