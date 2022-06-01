package com.recursion.basic;

public class PrintNumbers {

	public static void main(String[] args) {
		print(5);
		print1(1);
		print1ToN(5);
		printNToN(10);
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
		print1(num + 1);
	}

	public static void print1ToN(int num) {
		if (num == 0) {
			return;
		}
		print1ToN(num - 1);
		System.out.println(num);
	}

	public static void printNToN(int num) {
		if (num == 0) {
			return;
		}
		System.out.println(num);
		printNToN(num - 1);
		System.out.println(num);

	}

}
