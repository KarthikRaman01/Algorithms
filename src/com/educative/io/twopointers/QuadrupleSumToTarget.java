package com.educative.io.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class QuadrupleSumToTarget {

	public static void main(String[] args) {
		int arr[] = { 1000000000,1000000000,1000000000,1000000000};
		int target = -294967296;

		List<List<Integer>> output = quadrapuleSumToTarget(arr, target);
		System.out.println(output);

	}

	public static List<List<Integer>> quadrapuleSumToTarget(int[] arr, int target) {
		Arrays.sort(arr);
		List<List<Integer>> output = new ArrayList<>();
		if (arr == null || arr.length == 0) {
			return output;
		}

		for (int oIndex = 0; oIndex < arr.length - 3; oIndex++) {
			for (int iIndex = oIndex + 1; iIndex < arr.length - 2; iIndex++) {

				/*if (iIndex > 2 && arr[iIndex] == arr[iIndex - 1]) {
					continue;
				}*/

				double temp = arr[oIndex] + arr[iIndex];
				double tempTarget = target - temp;
				helper(output, oIndex, iIndex, tempTarget, arr);

			}
		}

		return output;
	}

	public static void helper(List<List<Integer>> output, int outerIndex, int innerIndex, double target, int[] arr) {
		int start = innerIndex + 1;
		int end = arr.length - 1;
		while (start < end) {
			if (arr[start] + arr[end] == target) {
				List<Integer> ans = new ArrayList<>();
				ans.add(arr[outerIndex]);
				ans.add(arr[innerIndex]);
				ans.add(arr[start]);
				ans.add(arr[end]);
				Collections.sort(ans);
				if (!output.contains(ans)) {
					output.add(ans);
				}

				start++;
				end--;

				/*while (start < end && arr[start] == arr[start - 1]) {
					start++;
				}

				while (end < arr.length - 1 && start < end && arr[end] == arr[end + 1]) {
					end--;
				}*/

			} else if (arr[start] + arr[end] > target) {
				end--;
			} else {
				start++;
			}
		}

	}

}
