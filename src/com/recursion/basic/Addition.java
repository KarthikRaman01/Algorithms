package com.recursion.basic;

import java.util.HashMap;
import java.util.Scanner;

public class Addition {

	static HashMap<Integer, Integer> sumMap = new HashMap<>();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int upToNumber = scanner.nextInt();
		System.out.println(add(upToNumber));

	}

	public static int add(int number) {
		if (number == 1) {
			return 1;
		}

		if (sumMap.containsKey(number)) {
			return sumMap.get(number);
		}
		int sum = number + add(number - 1);
		sumMap.put(number, sum);
		return sum;
	}

}
