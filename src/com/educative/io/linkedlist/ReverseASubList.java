package com.educative.io.linkedlist;

public class ReverseASubList {

	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);

		head = reverse(head, 2, 4);
		print(head);

	}

	public static Node reverse(Node head, int p, int q) {
		if (p == q)
			return head;

		// after skipping 'p-1' nodes, current will point to 'p'th node
		Node current = head, previous = null;
		for (int i = 0; current != null && i < p - 1; ++i) {
			previous = current;
			current = current.next;
		}

		// we are interested in three parts of the LinkedList, part before index 'p',
		// part between 'p' and
		// 'q', and the part after index 'q'
		Node lastNodeOfFirstPart = previous; // points to the node at index 'p-1'
		// after reversing the LinkedList 'current' will become the last node of the
		// sub-list
		Node lastNodeOfSubList = current;
		Node next = null; // will be used to temporarily store the next node
		// reverse nodes between 'p' and 'q'
		for (int i = 0; current != null && i < q - p + 1; i++) {
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}

		// connect with the first part
		if (lastNodeOfFirstPart != null)
			lastNodeOfFirstPart.next = previous; // 'previous' is now the first node of the sub-list
		else // this means p == 1 i.e., we are changing the first node (head) of the
				// LinkedList
			head = previous;

		// connect with the last part
		lastNodeOfSubList.next = current;

		return head;
	}

	public static Node reverseSubList(Node head, int p, int q) {

		Node current = head;
		Node prev = null;
		int index = 0;
		while (current != null && index < p - 1) {
			prev = current;
			current = current.next;
			index = index + 1;
		}

		return head;
	}

	public static void print(Node head) {
		while (head != null) {
			System.out.print(head.data + "-->");
			head = head.next;
		}
		System.out.print("null");
	}

}

class Node {
	int data;
	Node next;

	public Node() {

	}

	public Node(int data) {
		this.data = data;
	}

	public Node(int data, Node next) {
		this.data = data;
		this.next = next;
	}

}
