package application;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//to update or delete location thats already exist
public class UpdateDelete extends InsertLocation {
	private TextField textField;
	private Button Delete, search;
	private Label l1;
	private HBox hBox;

	public UpdateDelete(DoublyLinkedList1 doublyLinkedList1) {
		super(doublyLinkedList1);
		getL1().setText("please enter the location:");
		getL1().setStyle("-fx-font-size:15;");
		getL1().setAlignment(Pos.CENTER_LEFT);
		l1 = new Label("please enter the new location:");
		l1.setStyle("-fx-font-size:15;");
		hBox = new HBox(50);
		hBox.getChildren().addAll(getL1(), l1);
		getBorderPane().setTop(hBox);
		l1.setVisible(false);
		getStage().setHeight(200);
		getStage().setWidth(450);
		getStage().setTitle("Update");
		textField = new TextField();
		textField.setPrefWidth(200);
		search = new Button("Search");

		gethBox2().getChildren().add(search);

		getButton1().setText("Update");

		Delete = new Button("Delete");
		gethBox().getChildren().add(Delete);
		Delete.setVisible(false);
		getButton1().setVisible(false);
		Delete.setOnAction(e -> {
			try {
				WrongStage wrongStage = new WrongStage();

				wrongStage.getButton1().setOnAction(ex -> {
					doublyLinkedList1.deleteLocation(getTextField().getText());
					wrongStage.getStage().close();
				});
				wrongStage.getButton2().setOnAction(ex -> {
					wrongStage.getStage().close();
				});

			} catch (NumberFormatException ex) {

			}
		});
		search.setOnAction(e -> {
			boolean check = true;
			if (getTextField().getText().length() == 0) {
				getL2().setText("the text feild is empty");
				check = false;
			} else {
				for (int i = 0; i < getTextField().getText().length(); i++) {
					char c = getTextField().getText().charAt(i);
					if (!Character.isLetter(c)) {
						getL2().setText("use charctars just");

						check = false;
						break;
					}

				}
			}
			if (check == true) {
				try {
					if (doublyLinkedList1.searchLocation(getTextField().getText())) {
						gethBox2().getChildren().set(1, textField);
						l1.setVisible(true);
						Delete.setVisible(true);
						getButton1().setVisible(true);
						getL2().setText("ist exist");
						getTextField().setEditable(false);

					} else {
						getL2().setText("not found this location");
					}

				} catch (NumberFormatException e2) {

				}
			}

		});
		getButton1().setOnAction(e -> {
			boolean check = true;
			if (textField.getText().length() == 0) {
				getL2().setText("the text feild is empty");
				check = false;
			} else {
				for (int i = 0; i < textField.getText().length(); i++) {
					char c = textField.getText().charAt(i);
					if (!Character.isLetter(c)) {
						getL2().setText("use charctars just");
						check = false;
						break;
					}

				}
			}
			if (check == true) {
				doublyLinkedList1.updateLocation(getTextField().getText(), textField.getText());
				doublyLinkedList1.deleteLocation(getTextField().getText());
			}

		});

	}

}

class WrongStage {
	private Stage stage;
	private Scene scene;
	private Label label;
	private HBox box;
	private Button button1, button2;
	private VBox box2;

	public Button getButton1() {
		return button1;
	}

	public void setButton1(Button button1) {
		this.button1 = button1;
	}

	public Button getButton2() {
		return button2;
	}

	public void setButton2(Button button2) {
		this.button2 = button2;
	}

	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	public WrongStage() {

		stage = new Stage();
		label = new Label("are you sure you need to delete this Location??");
		button1 = new Button("yes");
		button2 = new Button("No");
		box = new HBox(20);
		box.getChildren().addAll(button1, button2);
		box.setAlignment(Pos.CENTER);
		box2 = new VBox(40);
		box2.getChildren().addAll(label, box);
		box2.setAlignment(Pos.TOP_CENTER);
		scene = new Scene(box2, 300, 150);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();

	}
}
