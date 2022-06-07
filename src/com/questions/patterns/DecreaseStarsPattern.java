package com.questions.patterns;

public class DecreaseStarsPattern {

	public static void main(String[] args) {
		decreaseStarsPrint(4, 4);
	}

	public static void decreaseStarsPrint(int rows, int column) {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < column - i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
