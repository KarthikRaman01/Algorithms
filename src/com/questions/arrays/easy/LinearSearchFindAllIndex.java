package com.questions.arrays.easy;

import java.util.ArrayList;
import java.util.List;

public class LinearSearchFindAllIndex {

	public static void main(String[] args) {
		int a[] = { 1, 3, 5, 5, 7, 5 };
		System.out.println(findAllIndexes(a, 5));
		System.out.println(findAllIndexesRecursive(a, 5));
		System.out.println(findAllIndexesRecursive2(a, 5));

	}

	public static List<Integer> findAllIndexes(int arr[], int target) {
		List<Integer> ans = new ArrayList<Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == target) {
				ans.add(i);
			}
		}

		return ans;
	}

	public static List<Integer> findAllIndexesRecursive(int arr[], int target) {
		List<Integer> ans = new ArrayList<Integer>();
		return helper(arr, target, ans, 0);
	}

	public static List<Integer> helper(int arr[], int target, List<Integer> ans, int index) {
		if (index == arr.length) {
			return ans;
		}

		if (arr[index] == target) {
			ans.add(index);
		}

		return helper(arr, target, ans, index + 1);

	}

	public static List<Integer> findAllIndexesRecursive2(int arr[], int target) {
		return helper2(arr, target, 0);

	}

	public static List<Integer> helper2(int arr[], int target, int index) {
		if (index == arr.length) {
			return new ArrayList<>();
		}

		List<Integer> ans = new ArrayList<>();

		if (arr[index] == target) {
			ans.add(index);
		}

		List<Integer> ans2 = helper2(arr, target, index + 1);
		ans.addAll(ans2);
		return ans;

	}

}
