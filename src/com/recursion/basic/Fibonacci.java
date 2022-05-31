package com.recursion.basic;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		System.out.println(num + " th fibonacci number is: " + fibonacci(num - 1));
		System.out.println("Printing all the fibonacci numbers: ");
		printFibonacci(num);

	}

	public static int fibonacci(int number) {
		if (number <= 0 || number == 1) {
			return number;
		}
		int fibNumber = fibonacci(number - 1) + fibonacci(number - 2);
		return fibNumber;
	}

	public static void printFibonacci(int num) {
		for (int i = 0; i < num; i++) {
			if (i == 0 || i == 1) {
				System.out.print(i);
			} else {
				System.out.print(fibonacci(i));
			}
		}
	}

}
