package com.educative.io.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class PairWithTargetSum {

	public static void main(String[] args) {
		int arr[] = { 2, 5, 9, 11 };
		int[] ans = search(arr, 11);
		System.out.println(Arrays.toString(ans));

		List<List<Integer>> ans1 = searchUsingMap(arr, 11);
		for (List<Integer> ind : ans1) {
			System.out.println(ind);
		}

	}

	public static int[] search(int[] arr, int targetSum) {

		int start = 0;
		int end = arr.length - 1;

		while (start < end) {
			if ((arr[start] + arr[end]) > targetSum) {
				end = end - 1;
			} else if ((arr[start] + arr[end]) < targetSum) {
				start = start + 1;
			} else {
				return new int[] { start, end };
			}

		}

		return new int[] { -1, -1 };
	}

	public static List<List<Integer>> searchUsingMap(int[] arr, int targetSum) {
		List<List<Integer>> ans = new ArrayList<>();
		HashMap<Integer, Integer> valueMap = new HashMap<>();

		for (int i = 0; i < arr.length; i++) {
			int checkInElement = targetSum - arr[i];
			if (valueMap.containsKey(checkInElement)) {
				List<Integer> individualPair = new ArrayList<>();
				individualPair.add(i);
				individualPair.add(valueMap.get(checkInElement));
				ans.add(individualPair);
			}
			valueMap.put(arr[i], i);
		}

		return ans;
	}

}
