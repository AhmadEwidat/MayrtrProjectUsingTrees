package application;

public class TraverseThe2stAVL extends TraverseThe1stAVL {
	int x = 0;

	public TraverseThe2stAVL(DoublyLinkedList1 doublyLinkedList1, String string) {
		super(doublyLinkedList1, string);
		getL().setText("show the Martyrs by the date descanding :");
		doublyLinkedList1.traverseBackward(string);
		String[] st = doublyLinkedList1.getString().split("@");
		getTextArea().setText(st[x]);
		getNext().setOnAction(e -> {
			if (x < st.length - 1) {
				getTextArea().setText(st[++x]);
			}

		});
		getBack().setOnAction(e -> {
			if (x > 0) {
				getTextArea().setText(st[--x]);
			}

		});

	}

}
