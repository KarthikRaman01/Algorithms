package com.recursion.strings.subsetandsubsequence;

public class Permutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		permutation("", "abc");
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

}
