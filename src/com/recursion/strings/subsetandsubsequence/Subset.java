package com.recursion.strings.subsetandsubsequence;

import java.util.ArrayList;
import java.util.List;

public class Subset {

	public static void main(String[] args) {
		// printAllSubsets("abc");
		List<String> ans = new ArrayList<String>();
		helper("", "abc", ans);
		// System.out.println(ans);

		System.out.println(helper2("", "abc"));
	}

	public static void printAllSubsets(String word) {
		helper("", word);
	}

	public static void helper(String p, String up) {
		if (up.isEmpty()) {
			System.out.println(p);
			return;
		}

		helper(p + up.charAt(0), up.substring(1));
		helper(p, up.substring(1));
	}

	public static void helper(String p, String up, List<String> ans) {
		if (up.isEmpty()) {
			ans.add(p);
			return;
		}

		helper(p + up.charAt(0), up.substring(1), ans);
		helper(p, up.substring(1), ans);
	}

	public static List<String> helper2(String p, String up) {
		if (up.isEmpty()) {
			List<String> ans = new ArrayList<>();
			ans.add(p);
			return ans;
		}

		List<String> ans1 = helper2(p + up.charAt(0), up.substring(1));
		List<String> ans2 = helper2(p, up.substring(1));
		ans1.addAll(ans2);
		return ans1;
	}

}
