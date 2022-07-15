package com.educative.io.twopointers;

public class StringsContainingBackspaces {

	public static void main(String[] args) {
		String str1 = "j##xfix", str2 = "j###xfix";
		System.out.println(stringsContainingBackspaces1(str1, str2));
	}

	public static boolean stringsContainingBackspaces1(String str1, String str2) {

		int str1Pointer = str1.length() - 1;
		int str2Pointer = str2.length() - 1;
		while (str1Pointer >= 0 || str2Pointer >= 0) {

			int i1 = getNextCharIndex(str1, str1Pointer);
			int i2 = getNextCharIndex(str2, str2Pointer);

			if (i1 < 0 && i2 < 0) {
				break;
			}

			if (i1 < 0 || i2 < 0) {
				return false;
			}

			if (str1.charAt(i1) != str2.charAt(i2)) {
				return false;
			}

			str1Pointer = i1;
			str2Pointer = i2;
			str1Pointer--;
			str2Pointer--;
		}

		return true;

	}

	public static int getNextCharIndex(String str, int index) {
		int backSpaceCount = 0;
		while (index >= 0) {
			if (str.charAt(index) == '#') {
				backSpaceCount++;
			} else if (backSpaceCount > 0) {
				backSpaceCount--;
			} else {
				break;
			}
			index--;
		}
		
		return index;

	}

	public static boolean stringsContainingBackspaces(String str1, String str2) {

		int length = str1.length();
		int i = 0;
		while (i < length) {
			if (str1.charAt(i) == '#') {
				if (i > 0) {
					str1 = str1.substring(0, i - 1) + str1.substring(i + 1);
					i = i - 2;
				} else {
					str1 = str1.substring(1);
					i = -1;
				}

			}
			length = str1.length();
			i++;
		}

		System.out.println(str1);

		i = 0;
		length = str2.length();
		while (i < length) {
			if (str2.charAt(i) == '#') {
				if (i > 0) {
					str2 = str2.substring(0, i - 1) + str2.substring(i + 1);
					i = i - 2;
				} else {
					str2 = str2.substring(1);
					i = -1;
				}
			}
			length = str2.length();
			i++;
		}

		System.out.println(str2);
		if (str1.equalsIgnoreCase(str2)) {
			return true;
		}
		return false;
	}

}
