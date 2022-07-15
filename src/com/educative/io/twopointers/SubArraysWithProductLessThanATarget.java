package com.educative.io.twopointers;

import java.util.ArrayList;
import java.util.List;

public class SubArraysWithProductLessThanATarget {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4 };
		List<List<Integer>> ans = subArraysWithProductLessThanATarget(arr, 50);
		System.out.println(ans);

	}

	public static List<List<Integer>> subArraysWithProductLessThanATarget(int[] arr, int target) {

		if (arr == null || arr.length == 0) {
			return new ArrayList<>();
		}

		List<List<Integer>> ans = new ArrayList<>();

		int firstPointer = 0;
		int secondPointer = 0;

		while (firstPointer < arr.length && secondPointer < arr.length) {
			int product = arr[firstPointer];
			while (product < target) {
				List<Integer> indList = new ArrayList<>();
				for (int i = firstPointer; i <= secondPointer; i++) {
					indList.add(arr[i]);
				}
				ans.add(indList);

				secondPointer = secondPointer + 1;
				if (secondPointer < arr.length) {
					product = product * arr[secondPointer];
				} else {
					break;
				}

			}

			firstPointer++;
			secondPointer = firstPointer;
		}

		return ans;

	}

	public static List<List<Integer>> subArraysWithProductLessThanATarget1(int[] arr, int target) {

		if (arr == null || arr.length == 0) {
			return new ArrayList<>();
		}

		List<List<Integer>> ans = new ArrayList<>();

		for (int i = 0; i < arr.length; i++) {
			int product = 1;
			for (int j = i; j < arr.length; j++) {
				product = product * arr[j];
				if (product < target) {
					List<Integer> smallList = new ArrayList<>();
					for (int k = i; k <= j; k++) {
						smallList.add(arr[k]);
					}
					ans.add(smallList);
				}
			}

		}

		return ans;
	}

}
