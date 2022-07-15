package com.educative.io.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletsWithSmallerSum {

	public static void main(String[] args) {
		int arr[] = { 3, 2, -2, 6, 2, -2, 6, -2, -4, 2, 3, 0, 4, 4, 1 };
		tripletsSumToZero(arr, 3);
		System.out.println(searchTriplets(arr, 3));

	}

	public static int searchTriplets(int[] arr, int target) {
		Arrays.sort(arr);
		int count = 0;
		for (int i = 0; i < arr.length - 2; i++) {
			count += searchPair(arr, target - arr[i], i);
		}
		return count;
	}

	private static int searchPair(int[] arr, int targetSum, int first) {
		int count = 0;
		int left = first + 1, right = arr.length - 1;
		while (left < right) {
			if (arr[left] + arr[right] < targetSum) { // found the triplet
				// since arr[right] >= arr[left], therefore, we can replace arr[right] by any
				// number between
				// left and right to get a sum less than the target sum
				count += right - left;
				left++;
			} else {
				right--; // we need a pair with a smaller sum
			}
		}
		return count;
	}

	public static void tripletsSumToZero(int[] arr, int targetSum) {
		Arrays.sort(arr);
		List<List<Integer>> output = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			// i>0 check for null pointer
			// check the prev element and the current and that it's not equal
			/*
			 * if (i > 0 && arr[i] == arr[i - 1]) { continue;
			 * 
			 * }
			 */
			search1(arr, targetSum, i, output);
		}

		for (List<Integer> ind : output) {
			System.out.println(ind);
		}

		System.out.println(output.size());

	}

	public static void search(int[] arr, int targetSum, int indexElement, List<List<Integer>> output) {

		int start = indexElement + 1;
		int end = arr.length - 1;

		while (start < end) {
			if (arr[start] + arr[end] + arr[indexElement] > targetSum) {
				end = end - 1;
			} else if (arr[start] + arr[end] + arr[indexElement] < targetSum) {

				List<Integer> ans = new ArrayList<Integer>();
				ans.add(arr[start]);
				ans.add(arr[end]);
				ans.add(arr[indexElement]);
				output.add(ans);

				start = start + 1;

				while (start < end && arr[start] == arr[start - 1]) {
					start++;
				}

				while (start < end && end < arr.length - 1 && arr[end] == arr[end + 1]) {
					end--;
				}

			} else {
				start++;
				end--;
			}

		}
	}

	public static void search1(int[] arr, int targetSum, int indexElement, List<List<Integer>> output) {

		int start = indexElement + 1;
		int end = arr.length - 1;

		while (start < end) {
			if (arr[start] + arr[end] + arr[indexElement] < targetSum) {
				for (int i = end; i > start; i--) {
					List<Integer> ans = new ArrayList<Integer>();
					ans.add(arr[start]);
					ans.add(arr[i]);
					ans.add(arr[indexElement]);
					output.add(ans);
				}
				start++;

			} else {
				end--;
			}

		}
	}

}
