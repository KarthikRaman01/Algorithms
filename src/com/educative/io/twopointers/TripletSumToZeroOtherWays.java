package com.educative.io.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class TripletSumToZeroOtherWays {

	private static Integer count = 0;

	public static void main(String[] args) {
		int arr[] = { -3, 0, 1, 2, -1, -2, 1 };
		// System.out.println(getTripletsSumToZero(arr, 0));
		List<List<Integer>> ans = getTripletsSumToZeroUsingMap(arr, 0);
		for (List<Integer> ind : ans) {
			System.out.println(ind);
		}

	}

	public static List<List<Integer>> getTripletsSumToZeroUsingMap(int arr[], int sum) {
		List<List<Integer>> ans = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			int element = arr[i];
			List<List<Integer>> tempAns = searchUsingMap(arr, i, sum - element);
			for (List<Integer> ind : tempAns) {
				ind.add(element);
				Collections.sort(ind);
				if (!ans.contains(ind)) {
					ans.add(ind);
				}

			}
		}
		return ans;
	}

	public static List<List<Integer>> searchUsingMap(int[] arr, int index, int targetSum) {
		List<List<Integer>> ans = new ArrayList<>();
		HashMap<Integer, Integer> valueMap = new HashMap<>();

		for (int i = 0; i < arr.length; i++) {
			if (i != index) {
				int checkInElement = targetSum - arr[i];
				if (valueMap.containsKey(checkInElement)) {
					List<Integer> individualPair = new ArrayList<>();
					individualPair.add(arr[i]);
					individualPair.add(checkInElement);
					ans.add(individualPair);
				}
				valueMap.put(arr[i], i);
			}

		}

		return ans;
	}

	public static int getTripletsSumToZero(int[] arr, int sum) {
		int[] processed = new int[0];
		getTripletsSumToZeroCombinationHelper(processed, arr, sum);
		return count;
	}

	public static void getTripletsSumToZeroCombinationHelper(int[] p, int[] up, int sum) {

		if (up.length == 0) {

			return;
		}

		/*
		 * if (p.length > 3) { return; }
		 */

		if (p.length == 3) {
			if (sum(p) == sum) {
				System.out.println(Arrays.toString(p));
				count++;

			}
			return;
		}

		int firstElementOfUP = up[0];

		getTripletsSumToZeroCombinationHelper(getNewProcessed(p, firstElementOfUP), getNewUnProcessed(up), sum);
		getTripletsSumToZeroCombinationHelper(p, getNewUnProcessed(up), sum);

	}

	public static int[] getNewProcessed(int[] oldProcessed, int element) {
		int[] newP = new int[oldProcessed.length + 1];
		for (int i = 0; i < oldProcessed.length; i++) {
			newP[i] = oldProcessed[i];
		}
		newP[oldProcessed.length] = element;
		return newP;
	}

	public static int[] getNewUnProcessed(int[] oldUpProcessed) {
		int[] newUP = new int[oldUpProcessed.length - 1];

		for (int i = 0; i < oldUpProcessed.length - 1; i++) {
			newUP[i] = oldUpProcessed[i + 1];
		}
		return newUP;
	}

	public static int sum(int[] p) {
		int sum = 0;
		for (int i = 0; i < p.length; i++) {
			sum = sum + p[i];
		}
		return sum;
	}

}
