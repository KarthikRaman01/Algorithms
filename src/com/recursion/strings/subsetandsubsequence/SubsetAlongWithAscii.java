package com.recursion.strings.subsetandsubsequence;

public class SubsetAlongWithAscii {

	public static void main(String[] args) {
		String input = "abc";
		subsetAscii("", input);

	}

	public static void subsetAscii(String processed, String unProcessed) {
		if (unProcessed.isEmpty()) {
			System.out.println(processed);
			return;
		}

		char fl = unProcessed.charAt(0);
		Integer ascii = fl + 0;
		subsetAscii(processed + fl, unProcessed.substring(1));
		subsetAscii(processed + ascii, unProcessed.substring(1));
		subsetAscii(processed, unProcessed.substring(1));

	}

}
