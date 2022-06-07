package com.recursion.basic;

public class DecreaseStarsPattern {

	public static void main(String[] args) {
		/*decreaseStarsPrint(4, 4);

		System.out.println();

		decreaseStarsPrintRecursive(4, 4);

		triangle(4, 0);*/
		
		triangle2(4, 0);
	}

	public static void decreaseStarsPrint(int rows, int column) {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < column - i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public static void decreaseStarsPrintRecursive(int rows, int column) {

		if (rows > 0 && column > 0) {
			System.out.print("*");
			column = column - 1;
			decreaseStarsPrintRecursive(rows, column);

			if (column == 0) {
				rows--;
				column = rows;
				System.out.println();
				decreaseStarsPrintRecursive(rows, column);
			}
		}

	}

	public static void triangle(int r, int c) {
		if (r == 0) {
			return;
		}

		if (c < r) {
			System.out.print("*");
			triangle(r, c + 1);
		} else {
			System.out.println();
			r = r - 1;
			triangle(r, 0);
		}
	}

	public static void triangle2(int r, int c) {
		if (r == 0) {
			return;
		}

		if (c < r) {
			triangle2(r, c + 1);
			System.out.print("*");
		} else {
			triangle2(r - 1, 0);
			System.out.println();

		}
	}

}
