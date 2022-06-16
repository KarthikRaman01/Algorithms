package com.recursion.arrays.subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetEqualsSumArrayList {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(1);
		list.add(1);
		Integer a[] = { 2, 4, 6, 10 };
		List<Integer> elementList = new ArrayList<>(Arrays.asList(a));
		int target = 2;
		int num = getSumEqualsSubset(list, target);
		System.out.println(num);

	}

	public static int getSumEqualsSubset(ArrayList<Integer> input, int target) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		helper2(new ArrayList<>(), input, ans, target);
		return ans.size();
	}

	/*
	 * public static void subset(ArrayList<Integer> input) {
	 * ArrayList<ArrayList<Integer>> ans = new ArrayList<>(); helper2(new
	 * ArrayList<>(), input, ans); System.out.println(ans); }
	 */

	public static void helper2(ArrayList<Integer> p, ArrayList<Integer> up, ArrayList<ArrayList<Integer>> ans,
			int target) {
		if (up.isEmpty()) {
			if (isSumEqualToTarget(p, target)) {
				ans.add(p);
			}

			return;
		}

		ArrayList<Integer> modifiedUP = getNewListAfterRemovingFirstElement(up);
		helper2(getAddedList(p, up.get(0)), modifiedUP, ans, target);
		helper2(p, modifiedUP, ans, target);
	}

	private static ArrayList<Integer> getAddedList(ArrayList<Integer> p, Integer data) {
		ArrayList<Integer> addedList = new ArrayList<>();
		addedList.addAll(p);
		addedList.add(data);
		return addedList;
	}

	private static ArrayList<Integer> getNewListAfterRemovingFirstElement(ArrayList<Integer> up) {
		ArrayList<Integer> modifiedList = new ArrayList<>();
		modifiedList.addAll(up);
		modifiedList.remove(0);
		return modifiedList;

	}

	private static boolean isSumEqualToTarget(ArrayList<Integer> input, int target) {
		int sum = 0;
		for (Integer i : input) {
			sum = sum + i;
		}

		if (sum == target) {
			return true;
		}

		return false;
	}

	/**
	 * Google question - https://leetcode.com/problems/subarray-sum-equals-k/
	 * 
	 * @param p
	 * @param up
	 * @param count
	 * @param target
	 */
	public static void helper3(int[] p, int[] up, Integer count, int target) {
		if (up.length == 0) {
			if (isSumEqualToTarget2(p, target)) {
				count = count + 1;
			}
			return;
		}

		int[] modifiedUP = getNewListAfterRemovingFirstElement2(up);
		helper3(getAddedList2(p, up[0]), modifiedUP, count, target);
		helper3(p, modifiedUP, count, target);
	}

	public static int getSumEqualsSubset2(int[] input, int target) {
		Integer count = 0;
		helper3(new int[input.length], input, count, target);
		return count;
	}

	private static boolean isSumEqualToTarget2(int[] input, int target) {
		int sum = 0;
		for (Integer i : input) {
			sum = sum + i;
		}

		if (sum == target) {
			return true;
		}

		return false;
	}

	private static int[] getNewListAfterRemovingFirstElement2(int[] up) {
		int size = 0;
		int[] modifiedList = new int[up.length - 1];
		for (int i = 1; i < up.length; i++) {
			modifiedList[size] = up[i];
			size = size + 1;
		}
		return modifiedList;

	}

	private static int[] getAddedList2(int[] p, Integer data) {
		int i = 0;
		int[] newP = new int[p.length + 1];
		while (i < p.length) {
			newP[i] = p[i];
			i = i + 1;
		}
		newP[i] = data;
		return newP;
	}

}
