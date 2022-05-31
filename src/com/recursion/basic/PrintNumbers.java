package com.recursion.basic;

public class PrintNumbers {

	public static void main(String[] args) {
		print(5);
		print1(1);

	}

	/**
	 * Prints 1 to number num
	 * 
	 * @param num
	 */
	public static void print(int num) {
		if (num > 1) {
			print(num - 1);
		}
		System.out.println(num);
	}
	
	public static void print1(int num) {
		if (num > 5) {
			return;
		}
		System.out.println(num);
		print1(num+1);
	}

}
