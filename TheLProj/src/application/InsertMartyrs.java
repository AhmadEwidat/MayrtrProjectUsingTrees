package application;

import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.stage.Stage;

//this class to display a stage of insert Martyrs
public class InsertMartyrs {
	private Stage stage;
	private Label l0, l1, l2, l3, l4, l5, lcoment;
	private TextField t1, t2, t3, t4;
	private HBox h0, h1, h2, h3, h4, h5, h, hbutton, hBox;
	private GridPane gridPane;
	private Scene scene;
	private Button button, cancel;
	private RadioButton radioButton, radioButton2;
	private ToggleGroup group;
	private char gender;

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	public Label getL0() {
		return l0;
	}

	public void setL0(Label l0) {
		this.l0 = l0;
	}

	public Label getL1() {
		return l1;
	}

	public void setL1(Label l1) {
		this.l1 = l1;
	}

	public Label getL2() {
		return l2;
	}

	public void setL2(Label l2) {
		this.l2 = l2;
	}

	public Label getL3() {
		return l3;
	}

	public void setL3(Label l3) {
		this.l3 = l3;
	}

	public Label getL4() {
		return l4;
	}

	public void setL4(Label l4) {
		this.l4 = l4;
	}

	public TextField getT1() {
		return t1;
	}

	public void setT1(TextField t1) {
		this.t1 = t1;
	}

	public TextField getT2() {
		return t2;
	}

	public void setT2(TextField t2) {
		this.t2 = t2;
	}

	public TextField getT3() {
		return t3;
	}

	public void setT3(TextField t3) {
		this.t3 = t3;
	}

	public TextField getT4() {
		return t4;
	}

	public void setT4(TextField t4) {
		this.t4 = t4;
	}

	public HBox getH0() {
		return h0;
	}

	public void setH0(HBox h0) {
		this.h0 = h0;
	}

	public HBox getH1() {
		return h1;
	}

	public void setH1(HBox h1) {
		this.h1 = h1;
	}

	public HBox getH2() {
		return h2;
	}

	public void setH2(HBox h2) {
		this.h2 = h2;
	}

	public HBox getH3() {
		return h3;
	}

	public void setH3(HBox h3) {
		this.h3 = h3;
	}

	public HBox getH4() {
		return h4;
	}

	public void setH4(HBox h4) {
		this.h4 = h4;
	}

	public HBox getH() {
		return h;
	}

	public void setH(HBox h) {
		this.h = h;
	}

	public HBox getHbutton() {
		return hbutton;
	}

	public void setHbutton(HBox hbutton) {
		this.hbutton = hbutton;
	}

	public GridPane getGridPane() {
		return gridPane;
	}

	public void setGridPane(GridPane gridPane) {
		this.gridPane = gridPane;
	}

	public Scene getScene() {
		return scene;
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}

	public Button getButton() {
		return button;
	}

	public void setButton(Button button) {
		this.button = button;
	}

	public Button getCancel() {
		return cancel;
	}

	public void setCancel(Button cancel) {
		this.cancel = cancel;
	}

	public InsertMartyrs(DoublyLinkedList1 doublyLinkedList) {
		radioButton = new RadioButton("M");
		radioButton2 = new RadioButton("F");
		group = new ToggleGroup();
		hBox = new HBox(15);
		hBox.getChildren().addAll(radioButton, radioButton2);
		group.getToggles().addAll(radioButton, radioButton2);
		button = new Button("Insert");
		cancel = new Button("cancel");
		hbutton = new HBox(10);
		hbutton.getChildren().addAll(button, cancel);
		cancel.setOnAction(e -> {
			stage.close();
		});
		lcoment = new Label();
		l0 = new Label("please fill the next information :");
		l1 = new Label("Name");
		l2 = new Label("Age");
		l3 = new Label("location");
		l4 = new Label("Date Of Deth");
		l5 = new Label("Gender");
		t1 = new TextField();
		t2 = new TextField();
		t3 = new TextField();
		t4 = new TextField();
		h0 = new HBox();
		h0.getChildren().add(l0);
		h1 = new HBox(43);
		h1.getChildren().addAll(l1, t1);
		h2 = new HBox(56);
		h2.getChildren().addAll(l2, t2);
		h3 = new HBox(32);
		h3.getChildren().addAll(l3, t3);
		h4 = new HBox(5);
		h4.getChildren().addAll(l4, t4);
		h5 = new HBox(45);
		h5.getChildren().addAll(l5, hBox);
		gridPane = new GridPane();
		gridPane.setVgap(10);
		gridPane.add(h0, 0, 0);
		gridPane.add(h1, 0, 1);
		gridPane.add(h2, 0, 2);
		gridPane.add(h3, 0, 3);
		gridPane.add(h4, 0, 4);
		gridPane.add(h5, 0, 5);
		gridPane.add(lcoment, 0, 6);
		gridPane.add(hbutton, 0, 7);
		hbutton.setAlignment(Pos.CENTER_RIGHT);
		gridPane.setAlignment(Pos.CENTER);
		l0.setStyle("-fx-Text-Fill:Black;-fx-font-size:12;-fx-font-weight:BOLD;");
		l1.setStyle("-fx-Text-Fill:Black;-fx-font-size:12;-fx-font-weight:BOLD;");
		l2.setStyle("-fx-Text-Fill:Black;-fx-font-size:12;-fx-font-weight:BOLD;");
		l3.setStyle("-fx-Text-Fill:Black;-fx-font-size:12;-fx-font-weight:BOLD;");
		l4.setStyle("-fx-Text-Fill:Black;-fx-font-size:12;-fx-font-weight:BOLD;");
		l5.setStyle("-fx-Text-Fill:Black;-fx-font-size:12;-fx-font-weight:BOLD;");
		scene = new Scene(gridPane, 600, 400);
		stage = new Stage();
		stage.setScene(scene);
		stage.setTitle("InsertMartyer");
		stage.setResizable(false);
		RadialGradient nR = new RadialGradient(0, 0, 0, 0, 1, true, // sizing
				CycleMethod.NO_CYCLE, // cycling
				new Stop(0, Color.web("#81c483")), // colors
				new Stop(1, Color.web("#fcc200")));

		// Change to your desired color
		BackgroundFill backgroundFill = new BackgroundFill(nR, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY);
		Background background = new Background(backgroundFill);
		gridPane.setBackground(background);
		radioButton.setOnAction(e -> {
			gender = 'M';

		});
		radioButton2.setOnAction(e -> {
			gender = 'F';
		});
		button.setOnAction(e -> {
			boolean check = true;
			if (t1.getText().length() == 0) {
				lcoment.setText("the text feild is empty");
				check = false;
			}
//			else 
//			{
//				for (int i = 0; i < t1.getText().length(); i++) {
//		            char c = t1.getText().charAt(i);
//		            if (!Character.isLetter(c)) {
//		                lcoment.setText("use charctars just");
//		                check=false;
//		                break;
//		            }
//		            
//		        }
//			}
			if (t2.getText().length() == 0) {
				lcoment.setText("the text feild is empty");
				check = false;
			} else {

				for (int i = 0; i < t2.getText().length(); i++) {
					char c = t2.getText().charAt(i);
					if (!Character.isDigit(c)) {
						lcoment.setText("use numbers between 1-200 just in text feild 2");
						check = false;
						break;
					}
				}
				if (check == true) {
					if (!(Integer.valueOf(t2.getText()) > 0) || !(Integer.valueOf(t2.getText()) < 200)) {
						lcoment.setText("use numbers between 1-200 just");
						check = false;
					}
				}

			}
			if (t3.getText().length() == 0) {
				lcoment.setText("the text feild is empty");
				check = false;
			} else {
				for (int i = 0; i < t3.getText().length(); i++) {
					char c = t3.getText().charAt(i);
					if (!Character.isLetter(c)) {
						check = false;
						break;
					}

				}
			}
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
//	        dateFormat.setLenient(false);
//
			try {
				dateFormat.parse(t4.getText());

			} catch (ParseException ex) {
				check = false;
				lcoment.setText("please enter the corect date");
			}

			if (check == true) {
				try {

					if (doublyLinkedList.searchLocation(t3.getText())) {
						doublyLinkedList.addMartyrInLocation(t3.getText(), new Martyr(t1.getText(),
								Integer.valueOf(t2.getText()), dateFormat.parse(t4.getText()), gender));

					} else {
						doublyLinkedList.insertOrderedLocation(t3.getText());
						doublyLinkedList.addMartyrInLocation(t3.getText(), new Martyr(t1.getText(),
								Integer.valueOf(t2.getText()), dateFormat.parse(t4.getText()), gender));
					}
					lcoment.setText("its Done");

				} catch (ParseException e1) {

				}

				catch (NumberFormatException e2) {

				}
			}
		});

		stage.show();

	}
}
