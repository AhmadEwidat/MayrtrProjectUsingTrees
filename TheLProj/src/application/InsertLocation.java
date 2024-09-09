package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.stage.Stage;

//this class to display a stage of insert Location
public class InsertLocation {
	private Stage stage;
	private Scene scene;
	private TextField textField;
	private Button button1, button2;
	private Label l1, l2;
	private BorderPane borderPane;
	private HBox hBox, hBox2, hBox3;
	VBox vBox;
	private Insets insets;

	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	public Scene getScene() {
		return scene;
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}

	public TextField getTextField() {
		return textField;
	}

	public void setTextField(TextField textField) {
		this.textField = textField;
	}

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

	public Label getL1() {
		return l1;
	}

	public void setL1(Label l1) {
		this.l1 = l1;
	}

	public BorderPane getBorderPane() {
		return borderPane;
	}

	public void setBorderPane(BorderPane borderPane) {
		this.borderPane = borderPane;
	}

	public HBox gethBox() {
		return hBox;
	}

	public void sethBox(HBox hBox) {
		this.hBox = hBox;
	}

	public HBox gethBox2() {
		return hBox2;
	}

	public void sethBox2(HBox hBox2) {
		this.hBox2 = hBox2;
	}

	public Insets getInsets() {
		return insets;
	}

	public void setInsets(Insets insets) {
		this.insets = insets;
	}

	public Label getL2() {
		return l2;
	}

	public void setL2(Label l2) {
		this.l2 = l2;
	}

	public HBox gethBox3() {
		return hBox3;
	}

	public void sethBox3(HBox hBox3) {
		this.hBox3 = hBox3;
	}

	public VBox getvBox() {
		return vBox;
	}

	public void setvBox(VBox vBox) {
		this.vBox = vBox;
	}

//insert location and Sorted it
	public InsertLocation(DoublyLinkedList1 doublyLinkedList1) {

		stage = new Stage();
		textField = new TextField();
		l1 = new Label("please enter the location in the box");
		l1.setStyle("-fx-font-size:17;-fx-font-Weight:Bold");
		button1 = new Button("insert");
		l2 = new Label();
		button1.setOnAction(e -> {
			boolean check = true;
			if (textField.getText().length() == 0) {
				l2.setText("the text feild is empty");
				check = false;
			} else {
				for (int i = 0; i < textField.getText().length(); i++) {
					char c = textField.getText().charAt(i);
					if (!Character.isLetter(c)) {
						l2.setText("use charctars just");
						check = false;
						break;
					}

				}
			}
			if (check == true) {
				try {
					doublyLinkedList1.insertOrderedLocation(textField.getText());
					l2.setText("Its Done");
				} catch (NumberFormatException ex) {

				}
			}
		});
		button2 = new Button("cancel");
		button2.setOnAction(e -> {
			stage.close();

		});
		borderPane = new BorderPane();
		borderPane.setTop(l1);
		hBox2 = new HBox(10);
		hBox2.getChildren().add(textField);
		textField.setPrefWidth(200);
		borderPane.setCenter(hBox2);
		hBox2.setAlignment(Pos.CENTER);

		vBox = new VBox(10);
		hBox3 = new HBox();
		hBox3.getChildren().add(l2);
		hBox = new HBox(10);
		hBox.getChildren().addAll(button1, button2);
		vBox.getChildren().addAll(hBox3, hBox);
		hBox3.setAlignment(Pos.CENTER);
		borderPane.setBottom(vBox);
		hBox.setAlignment(Pos.CENTER);
		scene = new Scene(borderPane, 500, 300);
		stage.setScene(scene);
		stage.setTitle("insert");
		stage.setResizable(false);
		stage.show();
		RadialGradient nR = new RadialGradient(0, 0, 0, 0, 1, true, // sizing
				CycleMethod.NO_CYCLE, // cycling
				new Stop(0, Color.web("#81c483")), // colors
				new Stop(1, Color.web("#fcc200")));

		// Change to your desired color
		BackgroundFill backgroundFill = new BackgroundFill(nR, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY);
		Background background = new Background(backgroundFill);
		borderPane.setBackground(background);
	}

}
