package com.leetcode.recursion.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Answer is right but time exceeded
 * @author Karthik
 *
 */
public class CombinationsSum {

	static List<List<Integer>> tempAns = new ArrayList<>();

	public static void main(String[] args) {
		int candidates[] = { 3, 12, 9, 11, 6, 7, 8, 5, 4 };
		// Arrays.sort(candidates);
		int target = 15;
		Long currenTimeInMillis = System.currentTimeMillis();
		System.out.println(combinationSum1(candidates, target));
		System.out.println(System.currentTimeMillis() - currenTimeInMillis);
	}

	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		List<String> ansString = helperCombinationSum(candidates, "", target);
		System.out.println(ansString);
		for (String s : ansString) {
			List<Integer> ansInt = new ArrayList<>();
			for (int j = 0; j < s.length(); j++) {
				Character ch = s.charAt(j);
				ansInt.add(Integer.parseInt(ch.toString()));
			}
			Collections.sort(ansInt);
			if (!(ans.contains(ansInt))) {
				ans.add(ansInt);
			}

		}
		return ans;
	}

	public static List<List<Integer>> combinationSum1(int[] candidates, int target) {
		List<List<Integer>> tempAns = helperCombinationSum1(candidates, new ArrayList<>(), target);
		/*
		 * List<List<Integer>> ans = new ArrayList<>();
		 * 
		 * for (List<Integer> s : tempAns) { if (!(ans.contains(s))) { ans.add(s); }
		 * 
		 * }
		 */
		return tempAns;
	}

	public static List<String> helperCombinationSum(int[] candidates, String p, Integer target) {

		if (target == 0) {
			// System.out.println(p);
			if (isValidOutput(p, candidates)) {
				List<String> miniAns = new ArrayList<>();
				miniAns.add(p);
				return miniAns;
			} else {
				return new ArrayList<>();
			}
		}

		List<String> ans = new ArrayList<>();
		for (Integer i = 1; i <= target; i++) {
			ans.addAll(helperCombinationSum(candidates, p + i.toString(), target - i));
		}
		return ans;

	}

	public static List<List<Integer>> helperCombinationSum1(int[] candidates, List<Integer> p, Integer target) {

		if (!isValidOutput1(p, candidates)) {
			return new ArrayList<List<Integer>>();
		}

		if (target == 0) {
			List<List<Integer>> miniAns = new ArrayList<List<Integer>>();
			Collections.sort(p);
			if (!(tempAns.contains(p))) {
				miniAns.add(p);
				return miniAns;
			}
			return new ArrayList<List<Integer>>();

			/*
			 * if (isValidOutput1(p, candidates)) { List<List<Integer>> miniAns = new
			 * ArrayList<List<Integer>>(); miniAns.add(p); return miniAns; } else { return
			 * new ArrayList<List<Integer>>(); }
			 */
		}

		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		for (Integer i = 1; i <= target; i++) {
			List<Integer> temp = addIToList(p, i);
			ans.addAll(helperCombinationSum1(candidates, temp, target - i));
		}
		return ans;

	}

	public static List<Integer> addIToList(List<Integer> inList, int number) {
		List<Integer> outList = new ArrayList<>(inList);
		outList.add(number);
		return outList;
	}

	public static boolean isValidOutput(String p, int[] candidates) {
		for (int i = 0; i < p.length(); i++) {
			HashMap<Integer, Boolean> isPresent = new HashMap<Integer, Boolean>();
			Character ch = p.charAt(i);
			int number = Integer.parseInt(ch.toString());
			if (isPresent.containsKey(number)) {
				continue;
			}
			boolean isPres = checkIsNumberPresentInArray(number, candidates);
			if (!isPres) {
				return isPres;
			}
			isPresent.put(number, isPres);
		}
		return true;

	}

	public static boolean isValidOutput1(List<Integer> p, int[] candidates) {
		for (int i = 0; i < p.size(); i++) {
			HashMap<Integer, Boolean> isPresent = new HashMap<Integer, Boolean>();
			int number = p.get(i);
			if (isPresent.containsKey(number)) {
				continue;
			}
			boolean isPres = checkIsNumberPresentInArray1(number, candidates);
			if (!isPres) {
				return isPres;
			}
			isPresent.put(number, isPres);
		}
		return true;

	}

	public static boolean checkIsNumberPresentInArray1(int number, int[] array) {
		int start = 0;
		int end = array.length - 1;
		while (start <= end) {
			if (array[start] == number || array[end] == number) {
				return true;
			}
			start++;
			end--;
		}
		return false;
	}

	public static boolean checkIsNumberPresentInArray(int number, int[] array) {
		int start = 0;
		int end = array.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (number > array[mid]) {
				start = mid + 1;
			} else if (number > array[mid]) {
				end = mid - 1;
			} else {
				return true;
			}

		}
		return false;
	}

}
