package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

//to Save the end information in file
public class SaveInFile {
	private Stage stage;
	private Text text;
	private Scene scene;
	private Label l1, l2;
	private TextField t1;
	private HBox h1;
	private VBox v1;
	private Button b1;

	public SaveInFile(DoublyLinkedList1 doublyLinkedList1) {
		b1 = new Button("Save the information in file");
		b1.setStyle("-fx-background-color: Black;");
		b1.setPrefWidth(180);
		b1.setPrefHeight(80);
		l2 = new Label();
		l2.setTextFill(Color.RED);
		b1.setTextFill(Color.LAVENDERBLUSH);
		v1 = new VBox(40);
		v1.getChildren().addAll(b1, l2);
		v1.setAlignment(Pos.CENTER);
		v1.setStyle("-fx-background-color: AZURE;");
		scene = new Scene(v1, 400, 400);
		stage = new Stage();
		stage.setResizable(false);
		stage.setScene(scene);
		stage.setTitle("Save Stage");
		stage.show();
		RadialGradient nR = new RadialGradient(0, 0, 0, 0, 1, true, // sizing
				CycleMethod.NO_CYCLE, // cycling
				new Stop(0, Color.web("#81c483")), // colors
				new Stop(1, Color.web("#fcc200")));

		// Change to your desired color
		BackgroundFill backgroundFill = new BackgroundFill(nR, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY);
		Background background = new Background(backgroundFill);
		v1.setBackground(background);
		b1.setOnAction(e -> {
			try {
				FileChooser fileChooser = new FileChooser();
				fileChooser.setTitle("Save File");

				File selector = fileChooser.showOpenDialog(stage);
				if (selector != null) {
					BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(selector));
					doublyLinkedList1.printAllMartyrsWithLocations();
					String s = doublyLinkedList1.getString();
					bufferedWriter.write(s);
					bufferedWriter.close();
					l2.setText("its done ");
				}

			} catch (Exception ex) {

			}
		});

	}
}
