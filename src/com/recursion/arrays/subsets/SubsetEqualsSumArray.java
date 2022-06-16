package com.recursion.arrays.subsets;

public class SubsetEqualsSumArray {

	public static void main(String[] args) {
		int a[] = {1, 1, 1};
		int target = 2;
		System.out.println(getSumEqualsSubset(a, target));

	}

	public static int getSumEqualsSubset(int[] input, int target) {
		Integer count = 0;
		count = helper(new int[input.length], input, count, target);
		return count;
	}

	/**
	 * Google question - https://leetcode.com/problems/subarray-sum-equals-k/
	 * 
	 * @param p
	 * @param up
	 * @param count
	 * @param target
	 */
	public static Integer helper(int[] p, int[] up, Integer count, int target) {
		if (up.length == 0) {
			if (isSumEqualToTarget(p, target)) {
				count = count + 1;
			}
			return count;
		}

		int[] modifiedUP = getNewListAfterRemovingFirstElement(up);
		Integer count1 = helper(getAddedList(p, up[0]), modifiedUP, count, target);
		Integer count2 = helper(p, modifiedUP, count, target);
		return count1 + count2;
	}

	private static boolean isSumEqualToTarget(int[] input, int target) {
		int sum = 0;
		for (Integer i : input) {
			sum = sum + i;
		}

		if (sum == target) {
			return true;
		}

		return false;
	}

	private static int[] getNewListAfterRemovingFirstElement(int[] up) {
		int size = 0;
		int[] modifiedList = new int[up.length - 1];
		for (int i = 1; i < up.length; i++) {
			modifiedList[size] = up[i];
			size = size + 1;
		}
		return modifiedList;

	}

	private static int[] getAddedList(int[] p, Integer data) {
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
