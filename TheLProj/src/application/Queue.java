package application;

public class Queue {

	private Node front, rear;
	private int size;

	public Queue() {
		front = rear = null;
		size = 0;
	}

	public void enqueue(Object element) {
		Node newNode = new Node(element);
		if (isEmpty()) {
			front = rear = newNode;
			size++;
		} else {
			rear.setNext(newNode);
			rear = newNode;
			size++;
		}
	}

	public Object dequeue() {
		Object element = null;

		if (isEmpty()) {
			System.out.println("Empty Queue");
			return null;
		} else {
			element = front.getElement();
			front = front.getNext();
			size--;
			if (isEmpty()) {
				rear = null;
			}
		}
		return element;

	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public boolean isEmpty() {
		if (size == 0) {
			return true;
		}
		return false;

	}

	public String toString() {
		String result = "";
		Node current = front;
		while (current != null) {
			result = result + current.getElement() + "\n";
			current = current.getNext();
		}
		return result;
	}

	private class Node {
		private Object element;
		private Node next;

		public Node(Object element) {
			this(element, null);
		}

		public Node(Object element, Node next) {
			this.element = element;
			this.next = next;
		}

		public Object getElement() {
			return element;
		}

		public void setElement(Object element) {
			this.element = element;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}
	}

}
