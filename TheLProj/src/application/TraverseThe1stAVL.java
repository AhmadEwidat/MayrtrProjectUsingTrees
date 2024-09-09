package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.Scanner;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.stage.Stage;

public class TraverseThe1stAVL {
	private TextArea textArea;
	private Button next, Back;
	private HBox hBox;
	private VBox vBox;
	private ImageView imageView, imageView2;

	private Stage stage;
	int x = 1;

	public TextArea getTextArea() {
		return textArea;
	}

	public void setTextArea(TextArea textArea) {
		this.textArea = textArea;
	}

	public Button getNext() {
		return next;
	}

	public void setNext(Button next) {
		this.next = next;
	}

	public Button getBack() {
		return Back;
	}

	public void setBack(Button back) {
		Back = back;
	}

	public HBox gethBox() {
		return hBox;
	}

	public void sethBox(HBox hBox) {
		this.hBox = hBox;
	}

	public VBox getvBox() {
		return vBox;
	}

	public void setvBox(VBox vBox) {
		this.vBox = vBox;
	}

	public ImageView getImageView() {
		return imageView;
	}

	public void setImageView(ImageView imageView) {
		this.imageView = imageView;
	}

	public ImageView getImageView2() {
		return imageView2;
	}

	public void setImageView2(ImageView imageView2) {
		this.imageView2 = imageView2;
	}

	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	private Label l;

	public Label getL() {
		return l;
	}

	public void setL(Label l) {
		this.l = l;
	}

	public TraverseThe1stAVL(DoublyLinkedList1 doublyLinkedList1, String string) {

		stage = new Stage();
		doublyLinkedList1.traverseAVLLevelByLevel(string, x);

		l = new Label("show the martyrs level By level :");
		l.setStyle("-fx-font-size:24;-fx-font-Weight:Bold;-fx-Color-fill:BROWN;-fx-Color-setBackground:BROWN");
		imageView = new ImageView("next.png");
		textArea = new TextArea();
		next = new Button("", imageView);
		imageView2 = new ImageView("previous.png");
		Back = new Button("", imageView2);
		hBox = new HBox(10);
		hBox.getChildren().addAll(Back, textArea, next);
		imageView.setFitWidth(40);
		imageView.setFitHeight(40);
		imageView2.setFitWidth(40);
		imageView2.setFitHeight(40);
		Label nameLabel = new Label("Name:");
		TextField nameTextField = new TextField();
		nameTextField.setMaxWidth(150);
		Label brandLabel = new Label("Brand:");

		Label modelLabel = new Label("Model:");
		TextField modelTextField = new TextField();
		modelTextField.setMaxWidth(150);
		Label yearLabel = new Label("Year:");
		TextField yearTextField = new TextField();
		yearTextField.setMaxWidth(150);
		Button Back1 = new Button("Back");

		// Create a grid pane and add the form controls
		GridPane gridPane = new GridPane();
		gridPane.setPadding(new Insets(10));
		gridPane.setHgap(10);
		gridPane.setVgap(10);
		gridPane.add(l, 0, 1);

//		gridPane.add(hBox, 1, 5);
		VBox vb = new VBox(20);
		vb.getChildren().addAll(gridPane, hBox, Back1);
		hBox.setAlignment(Pos.CENTER);
		gridPane.setAlignment(Pos.CENTER);
		RadialGradient nR = new RadialGradient(0, 0, 0, 0, 1, true, // sizing
				CycleMethod.NO_CYCLE, // cycling
				new Stop(0, Color.web("#81c483")), // colors
				new Stop(1, Color.web("#fcc200")));

		// Change to your desired color
		BackgroundFill backgroundFill = new BackgroundFill(nR, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY);
		Background background = new Background(backgroundFill);
		vb.setBackground(background);
		vb.setAlignment(Pos.CENTER);
		// Create a scene with the grid pane
		Scene scene = new Scene(vb, 1100, 700);
		stage.setScene(scene);
		textArea.setText(doublyLinkedList1.getString());
		next.setOnAction(e -> {
			doublyLinkedList1.traverseAVLLevelByLevel(string, ++x);
			textArea.setText(doublyLinkedList1.getString());
		});
		Back.setOnAction(e -> {
			if (x > 0) {
				doublyLinkedList1.traverseAVLLevelByLevel(string, --x);
				textArea.setText(doublyLinkedList1.getString());
			}
		});
		stage.show();
		Back1.setOnAction(e -> {
			stage.close();
		});
	}
}