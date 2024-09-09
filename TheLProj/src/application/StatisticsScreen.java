package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
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

public class StatisticsScreen {
	private Label label1;
	private ComboBox comboBox;
	private VBox vBox;
	private Scene scene1;
	private Stage stage1;
	private HBox hBox, hBox2, hBox3;
	private Button b, getReport, TraverseThe1stAVL, TraverseThe2ndAVL,next,prev;

	public Button getB() {
		return b;
	}

	public void setB(Button b) {
		this.b = b;
	}

	public Label getLabel1() {
		return label1;
	}

	public void setLabel1(Label label1) {
		this.label1 = label1;
	}

	public ComboBox getComboBox() {
		return comboBox;
	}

	public void setComboBox(ComboBox comboBox) {
		this.comboBox = comboBox;
	}

	public VBox getvBox() {
		return vBox;
	}

	public void setvBox(VBox vBox) {
		this.vBox = vBox;
	}

	public Scene getScene1() {
		return scene1;
	}

	public void setScene1(Scene scene1) {
		this.scene1 = scene1;
	}

	public Stage getStage1() {
		return stage1;
	}

	public void setStage1(Stage stage1) {
		this.stage1 = stage1;
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

	public HBox gethBox3() {
		return hBox3;
	}

	public void sethBox3(HBox hBox3) {
		this.hBox3 = hBox3;
	}

	public StatisticsScreen(DoublyLinkedList1 doublyLinkedList1) {
		prev=new Button("prev");
		next=new Button("next");
		hBox = new HBox(20);
		hBox2 = new HBox(50);
		hBox3 = new HBox(30);
		getReport = new Button("Get Report");
		TraverseThe1stAVL = new Button("Traverse The 1st AVL");
		TraverseThe2ndAVL = new Button("Traverse The 2st AVL");
		getReport.setDisable(true);
		TraverseThe1stAVL.setDisable(true);
		TraverseThe2ndAVL.setDisable(true);
		RadialGradient nR = new RadialGradient(0, 0, 0, 0, 1, true, // sizing
				CycleMethod.NO_CYCLE, // cycling
				new Stop(0, Color.web("#81c483")), // colors
				new Stop(1, Color.web("#fcc200")));

		// Change to your desired color
		BackgroundFill backgroundFill = new BackgroundFill(nR, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY);
		Background background = new Background(backgroundFill);

//		ImageView imageView = new ImageView("left-arrow.png");
//		imageView.setFitWidth(20);
//		imageView.setFitHeight(20);
		b = new Button("back");
		doublyLinkedList1.display();
		label1 = new Label("select the location and then select\n" + "the choice  :");
		ObservableList observableList = FXCollections.observableArrayList(doublyLinkedList1.getArrayList());
		comboBox = new ComboBox();
		comboBox.setPrefWidth(200);
		comboBox.getItems().addAll(observableList);
		vBox = new VBox(40);
		hBox.getChildren().addAll(prev,comboBox,next);
		hBox2.getChildren().add(label1);
		hBox.setAlignment(Pos.CENTER);
		hBox2.setAlignment(Pos.CENTER);
		hBox3.getChildren().addAll(b, getReport, TraverseThe1stAVL, TraverseThe2ndAVL);
		hBox3.setAlignment(Pos.CENTER);
		vBox.getChildren().addAll(hBox2, hBox, hBox3);
		scene1 = new Scene(vBox, 1530, 800);
		stage1 = new Stage();
		stage1.setScene(scene1);
		stage1.show();
		stage1.setTitle("search stage");
		label1.setStyle("-fx-font-size:24;-fx-font-Weight:Bold;-fx-Color-fill:BROWN;-fx-Color-setBackground:BROWN");
		ColorPicker colorPicker3 = new ColorPicker(Color.web("#ffcce6"));
		vBox.setBackground(background);
		vBox.setAlignment(Pos.CENTER);
		vBox.setBackground(background);
		prev.setOnAction(e->{
			comboBox.getSelectionModel().selectPrevious();
		});
		next.setOnAction(e->{
			comboBox.getSelectionModel().selectNext();
		});
		b.setOnAction(e -> {
			stage1.close();
		});

		comboBox.setOnAction(e -> {
			if (comboBox.getValue() != null) {
				getReport.setDisable(false);
				TraverseThe1stAVL.setDisable(false);
				TraverseThe2ndAVL.setDisable(false);
			}
		});
		getReport.setOnAction(e -> {
			getReport report = new getReport(doublyLinkedList1);
		});
		
		TraverseThe1stAVL.setOnAction(e->{
			TraverseThe1stAVL the1stAVL=new TraverseThe1stAVL(doublyLinkedList1,(String)comboBox.getValue());
		});
		TraverseThe2ndAVL.setOnAction(e->{
			TraverseThe2stAVL traverseThe2stAVL=new  TraverseThe2stAVL(doublyLinkedList1, (String)comboBox.getValue()) ;
		});
		
	}

	private class getReport {

		TextArea textArea;
		Button Back;
		Stage stage;
		
		public getReport(DoublyLinkedList1 doublyLinkedList1) {
			doublyLinkedList1.display();

			Label l = new Label("show Report for this city :");
			l.setStyle("-fx-font-size:24;-fx-font-Weight:Bold;-fx-Color-fill:BROWN;-fx-Color-setBackground:BROWN");

			textArea = new TextArea();

			Back = new Button("Back");
			hBox = new HBox(10);
			hBox.getChildren().add(textArea);
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

			// Create a grid pane and add the form controls
			GridPane gridPane = new GridPane();
			gridPane.setPadding(new Insets(10));
			gridPane.setHgap(10);
			gridPane.setVgap(10);
			gridPane.add(l, 0, 1);

//			gridPane.add(hBox, 1, 5);
			VBox vb = new VBox(20);
			vb.getChildren().addAll(gridPane, hBox, Back);
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
			stage = new Stage();
			stage.setScene(scene);

			stage.show();
			doublyLinkedList1.Report((String) comboBox.getValue());
			
			textArea.setText(doublyLinkedList1.getString());

			Back.setOnAction(e -> {
				stage.close();

			});
		
		}
	}

}
