package com.educative.io.linkedlist;

public class ReverseALinkedList {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		ListNode temp = head;

		print(temp);

		ListNode ans = reverseRecursively(head);
		System.out.println();
		print(ans);

	}

	public static void print(ListNode head) {
		while (head != null) {
			System.out.print(head.val + "-->");
			head = head.next;
		}
		System.out.print("null");
	}

	public static ListNode reverseRecursively(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode node = reverseRecursively(head.next);
		head.next.next = head;
		head.next = null;
		return node;

	}

}

class ListNode {
	int val;
	ListNode next;

	public ListNode() {

	}

	public ListNode(int val) {
		this.val = val;
		this.next = null;
	}

	public ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}
