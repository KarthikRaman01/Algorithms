package com.questions.arrays.easy;

/**
 * Leetcode - https://leetcode.com/problems/fibonacci-number/
 * @author Karthik
 *
 */
public class ReverseAString {

	public static void main(String[] args) {
		char[] s = { 'h', 'e', 'l', 'l', 'o' };
		reverseString(s);
		System.out.println(reverseStringRecursive(s, 0, s.length-1));
	}

	public static void reverseString(char[] s) {
		int start = 0;
		int end = s.length - 1;

		while (start < end) {
			char temp = s[start];
			s[start] = s[end];
			s[end] = temp;
			start++;
			end--;
		}
		System.out.println(s);
	}

	public static char[] reverseStringRecursive(char[] s, int start, int end) {
		if (start > end) {
			return s;
		}
		char temp = s[start];
		s[start] = s[end];
		s[end] = temp;
		return reverseStringRecursive(s, start+1, end-1);
	}

}
