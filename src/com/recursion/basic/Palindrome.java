package com.recursion.basic;

public class Palindrome {

	public static void main(String[] args) {
		System.out.println(palindrome(1551));
	}

	public static boolean palindrome(int n) {
		if (n == ReverseANumber.reverseANumberRecursive(n)) {
			return true;
		}
		return false;
	}

}
