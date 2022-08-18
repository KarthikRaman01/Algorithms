package com.educative.io.TopKElements;

import java.util.PriorityQueue;

public class ConnectRopes {

	public static void main(String[] args) {
		int ropeLength[] = { 3, 4, 5, 6 };
		minRateForConnectingRopes(ropeLength);

	}

	public static void minRateForConnectingRopes(int[] rope) {
		PriorityQueue<Integer> ans = new PriorityQueue<>((n1, n2) -> n1 - n2);
		for (int i = 0; i < rope.length; i++) {
			ans.add(rope[i]);
		}
		
		int sum = 0;
		while(ans.size() > 1) {
			int temp = ans.poll() + ans.poll();
			ans.add(temp);
			sum = sum + temp;
		}
		
		System.out.println(sum);

	}

}
