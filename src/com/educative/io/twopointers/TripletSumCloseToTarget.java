package com.educative.io.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TripletSumCloseToTarget {

	static Integer closeToTarget = Integer.MAX_VALUE;

	static Map<Integer, List<List<Integer>>> map = new TreeMap<>();

	public static void main(String args[]) {
		int arr[] = { 1, 1, -1 };

		List<List<Integer>> output = tripletSumCloseToTarget(arr, 0);
		for (List<Integer> ans : output) {
			System.out.println(ans);
		}

		System.out.println(map);

		System.out.println(tripletSumCloseToTarget1(arr, 0));

	}

	public static List<List<Integer>> tripletSumCloseToTarget(int arr[], int target) {
		List<List<Integer>> output = new ArrayList<List<Integer>>();
		Arrays.sort(arr);
		for (int start = 0; start < arr.length; start++) {
			int element = arr[start];

			// skip the duplicates
			if (start > 0 && element == arr[start - 1]) {
				continue;
			}

			helper(arr, target - element, start);
		}

		// print case
		List<List<Integer>> ans = map.entrySet().iterator().next().getValue();
		if (ans.size() == 0) {
			System.out.println(ans);
			System.out.println(0);
		} else {
			int minimum = Integer.MAX_VALUE;
			List<Integer> minList = null;
			for (List<Integer> list : ans) {
				int tempSum = sum(list);
				if (tempSum < minimum) {
					minimum = tempSum;
					minList = list;
				}
			}
			System.out.println(minimum);
			System.out.println(minList);
		}

		return output;
	}

	public static int sum(List<Integer> list) {
		int sum = 0;
		for (Integer i : list) {
			sum = sum + i;
		}
		return sum;
	}

	public static void updateMap(int[] arr, int start, int end, int index) {
		List<Integer> ans = new ArrayList<>();
		ans.add(arr[start]);
		ans.add(arr[end]);
		ans.add(arr[index]);

		if (map.containsKey(closeToTarget)) {
			map.get(closeToTarget).add(ans);
		} else {
			List<List<Integer>> first = new ArrayList<>();
			first.add(ans);
			map.put(closeToTarget, first);
		}
	}

	public static void helper(int arr[], int target, int index) {
		int start = index + 1;
		int end = arr.length - 1;
		while (start < end) {
			if (arr[start] + arr[end] > target) {

				int closeToTargetTemp = (arr[start] + arr[end]) - target;
				if (closeToTargetTemp <= closeToTarget) {
					closeToTarget = closeToTargetTemp;
					updateMap(arr, start, end, index);
				}
				end--;
			} else if (arr[start] + arr[end] < target) {
				int closeToTargetTemp = target - (arr[start] + arr[end]);
				if (closeToTargetTemp <= closeToTarget) {
					closeToTarget = closeToTargetTemp;
					updateMap(arr, start, end, index);
				}
				start++;
			} else {
				closeToTarget = target - (arr[start] + arr[end]);
				updateMap(arr, start, end, index);

				start++;
				end--;

				while (arr[start] == arr[start - 1]) {
					start++;
				}

				while (arr[end] == arr[end + 1]) {
					end--;
				}

			}
		}

	}

	public static int tripletSumCloseToTarget1(int arr[], int target) {
		List<List<Integer>> output = new ArrayList<List<Integer>>();
		Arrays.sort(arr);

		for (int start = 0; start < arr.length; start++) {
			int element = arr[start];

			// skip the duplicates
			if (start > 0 && element == arr[start - 1]) {
				continue;
			}

			helper1(arr, target - element, start);
		}
		return sum;

	}

	static Integer out = Integer.MAX_VALUE;
	static Integer sum = Integer.MAX_VALUE;

	public static void helper1(int arr[], int target, int index) {
		int start = index + 1;
		int end = arr.length - 1;

		while (start < end) {
			if (arr[start] + arr[end] > target) {
				int closeToTargetTemp = (arr[start] + arr[end]) - target;
				if (closeToTargetTemp < out) {
					out = closeToTargetTemp;
					int tempSum = arr[start] + arr[end] + arr[index];
					sum = tempSum;

				} else if (closeToTargetTemp == out) {
					int tempSum = arr[start] + arr[end] + arr[index];
					if (tempSum < sum) {
						sum = tempSum;
					}
				}

				end--;

				while (start < end && arr[end] == arr[end + 1]) {
					end--;
				}

			} else if (arr[start] + arr[end] < target) {

				int closeToTargetTemp = (arr[start] + arr[end]) - target;
				int closeToTargetTempMakingPositive = closeToTargetTemp * -1;
				if (closeToTargetTempMakingPositive < out) {
					out = closeToTargetTempMakingPositive;
					int tempSum = arr[start] + arr[end] + arr[index];
					sum = tempSum;
				} else if (closeToTargetTempMakingPositive == out) {
					int tempSum = arr[start] + arr[end] + arr[index];
					if (tempSum < sum) {
						sum = tempSum;
					}
				}

				start++;

				while (start < end && arr[start] == arr[start - 1]) {
					start++;
				}

			} else {
				out = target - (arr[start] + arr[end]);
				System.out.println(arr[start]);
				System.out.println(arr[end]);
				System.out.println(arr[index]);
				sum = arr[start] + arr[end] + arr[index];
				return;

			}
		}

	}

}
