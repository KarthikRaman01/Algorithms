package com.recursion.strings.subsetandsubsequence;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

	public static void main(String[] args) {
		permutation("", "abc");
		System.out.println(permutationList("", "abc"));
		System.out.println(permutationCount("", "abc"));
	}

	public static void permutation(String processed, String unProcessed) {
		if (unProcessed.isEmpty()) {
			System.out.println(processed);
			return;
		}

		Character ch = unProcessed.charAt(0);
		for (int i = 0; i < processed.length() + 1; i++) {
			String p = processed.substring(0, i) + ch.toString() + processed.substring(i);
			permutation(p, unProcessed.substring(1));
		}

	}

	public static List<String> permutationList(String processed, String unProcessed) {
		if (unProcessed.isEmpty()) {
			List<String> output = new ArrayList<String>();
			output.add(processed);
			return output;
		}

		Character ch = unProcessed.charAt(0);
		List<String> output = new ArrayList<String>();
		for (int i = 0; i < processed.length() + 1; i++) {
			String p = processed.substring(0, i) + ch.toString() + processed.substring(i);
			List<String> returnedOutput = permutationList(p, unProcessed.substring(1));
			output.addAll(returnedOutput);
		}

		return output;
	}

	public static Integer permutationCount(String processed, String unProcessed) {
		if (unProcessed.isEmpty()) {
			return 1;
		}

		Character ch = unProcessed.charAt(0);
		Integer count = 0;
		for (int i = 0; i < processed.length() + 1; i++) {
			String p = processed.substring(0, i) + ch.toString() + processed.substring(i);
			count = count + permutationCount(p, unProcessed.substring(1));
		}

		return count;
	}

}
