package application;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

public class Stack {
	private Node top;
	private int size;

	public void push(Object data) {
		Node newNode = new Node(data);
		if (top == null) {
			top = newNode;
		} else {
			newNode.next = top;
			top = newNode;
		}
		size++; // Increment size when pushing an element
	}

	public Object pop() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		Object data = top.data;
		top = top.next;
		size--; // Decrement size when popping an element
		return data;
	}

	public Object peek() {
		if (isEmpty()) {
			return null;
		}
		return top.data;
	}

	public boolean isEmpty() {
		return top == null;
	}

	public int size() {
		return size;
	}

	public void remove(String name) {
		if (isEmpty()) {
			return;

		}

		Node current = top;
		Node previous = null;

		while (current != null) {
			if (((Martyr) (current.getData())).getName().equalsIgnoreCase(name)) {
				if (previous == null) {
					// The record to remove is at the top of the stack
					top = current.getNext();
				} else {
					// The record to remove is not at the top of the stack
					previous.setNext(current.getNext());
				}
				return;
			}
			previous = current;
			current = current.getNext();
		}

	}

	private static class Node {
		private Object data;
		private Node next;

		public Object getData() {
			return data;
		}

		public void setData(Object data) {
			this.data = data;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		public Node(Object data) {
			this.data = data;
			this.next = null;
		}

	}

}
