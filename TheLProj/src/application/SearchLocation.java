package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//to search of input location
public class SearchLocation extends InsertLocation {
	private Pane pane;
	private HBox hBox;
	private VBox vBox;
	private TextArea textArea;
	private TabPane tabPane;
	private ComboBox comboBox;
	private ObservableList observableList;

	public SearchLocation(DoublyLinkedList1 doublyLinkedList1) {
		super(doublyLinkedList1);
		comboBox = new ComboBox();
		doublyLinkedList1.display();
		observableList = FXCollections.observableArrayList(doublyLinkedList1.getArrayList());
		comboBox.getItems().addAll(observableList);
		comboBox.setPrefWidth(150);
		hBox = new HBox();
		hBox.getChildren().add(getL2());
		getStage().setWidth(500);
		getStage().setHeight(500);
		getStage().setTitle("search by location");
		getButton1().setText("search");
		textArea = new TextArea();
		pane = new Pane();
		pane.getChildren().add(textArea);
		vBox = new VBox(15);
		getBorderPane().setBottom(null);
		vBox.getChildren().addAll(hBox, gethBox(), pane);
		hBox.setAlignment(Pos.CENTER);
		pane.setPrefHeight(200);
		pane.setPrefWidth(100);
		textArea.setVisible(false);
		getBorderPane().setBottom(vBox);
		gethBox2().getChildren().remove(0);
		gethBox2().getChildren().add(comboBox);
		getButton1().setOnAction(e -> {
			boolean check = true;
			if (((String) (comboBox.getValue())) == null) {
				getL2().setText("the text feild is empty");
				check = false;
			} else {
				for (int i = 0; i < ((String) (comboBox.getValue())).length(); i++) {
					char c = ((String) (comboBox.getValue())).charAt(i);
					if (!Character.isLetter(c)) {
						getL2().setText("use charctars just");

						check = false;
						break;
					}

				}
			}
			if (check == true) {
				try {
					textArea.setVisible(true);
					doublyLinkedList1.displayAllMartyrsByLocation(((String) (comboBox.getValue())));
					textArea.setText(doublyLinkedList1.getString());
					doublyLinkedList1.setString("");

				} catch (NumberFormatException ex) {

				}
			}
		});
	}
}
