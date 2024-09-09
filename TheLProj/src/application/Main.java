package application;

import java.io.BufferedReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;

//import application.DoublyLinkedList.DoublyLinkedList1;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Main extends Application {
	Scene scene;
	Menu m1, m2, m3, m4;
	MenuBar mBar;
	MenuItem mI1, mI2, mI3, mI4, mI5, mI6, mI7, mI9, mI10;
	HBox h, h2, h3;
	VBox vBox = new VBox();
	Image image;
	ImageView imageView;
	BorderPane borderPane;
	Label label, label2;
	DoublyLinkedList1 location;
	Button button;

	@Override
	public void start(Stage primaryStage) throws Exception {
		Font font = new Font(40);
		location = new DoublyLinkedList1();
		ImageView imageView1 = new ImageView("file.png");
		button = new Button("read", imageView1);
		imageView1.setFitWidth(60);
		imageView1.setFitHeight(60);
		button.setStyle("-fx-border-color: Black;-fx-background-color:White");
		button.setFont(font);
		button.setPrefWidth(300);
		button.setPrefHeight(70);
		button.setOnAction(e -> {
			try {
				FileChooser fileChooser = new FileChooser();
				File selector = fileChooser.showOpenDialog(primaryStage);
				if (selector != null) {
					BufferedReader scan = new BufferedReader(new FileReader(selector));
					String line;
					scan.readLine();
					while ((line = scan.readLine()) != null) {
						String[] list = line.split(",");
						String[] DateList = list[3].split("/");
						location.insertOrUpdateLocation(list[2],
								new Martyr(
										list[0], Integer.valueOf(list[1]), new Date(Integer.valueOf(DateList[2]) - 1900,
												Integer.valueOf(DateList[0]) - 1, Integer.valueOf(DateList[1])),
										list[4].charAt(0)));
						Date a = new Date(Integer.valueOf(DateList[2]) - 1900, Integer.valueOf(DateList[0]),
								Integer.valueOf(DateList[1]));

					}

				}

			} catch (NumberFormatException | IOException ex) {

			}
		});

		h3 = new HBox();
		label2 = new Label("Read the file through the button, then choose what you want via the menu bar");
		label2.setStyle("-fx-font-size:28;-fx-font-Weight:Bold;-fx-Color-fill:BROWN;-fx-Color-setBackground:BROWN");
		h3.getChildren().add(label2);

		h2 = new HBox();
//		h2.getChildren().add(label);
		borderPane = new BorderPane();

		m1 = new Menu("Location Screen");
		m2 = new Menu("Martyrs Screeen");
		m3 = new Menu(" Statistics Screen");
		m4 = new Menu("Save Screen");
		mI1 = new MenuItem("insert location");
		String style = "-fx-font-size: 18px;";
		m1.setStyle(style);
		m2.setStyle(style);
		m3.setStyle(style);
		m4.setStyle(style);
		mI1.setOnAction(e -> {
			InsertLocation insertLocation = new InsertLocation(location);
		});
		mI2 = new MenuItem("update location");
		mI2.setOnAction(e -> {
			UpdateDelete update = new UpdateDelete(location);
		});
		mI3 = new MenuItem("Search by Location");
		mI3.setOnAction(e -> {
			SearchLocation searchLocation = new SearchLocation(location);
		});
		mI4 = new MenuItem("insert new Martyrs");
		mI4.setOnAction(e -> {
			InsertMartyrs insertMartys = new InsertMartyrs(location);
		});
		mI5 = new MenuItem("update Matryrs");
		mI5.setOnAction(e -> {
			UpdateMartyrs updateMartyrs = new UpdateMartyrs(location);

		});
		mI6 = new MenuItem("Seaech by part of Name");
		mI6.setOnAction(e -> {
			SearchMartyr searchMartyr = new SearchMartyr(location);
		});
		mI7 = new MenuItem("summary");
		mI7.setOnAction(e -> {
			StatisticsScreen summary = new StatisticsScreen(location);
		});
		mI10 = new MenuItem("Save in file");
		mI10.setOnAction(e -> {
			SaveInFile saveInFile = new SaveInFile(location);
		});
		m1.getItems().addAll(mI1, mI2, mI3);
		m2.getItems().addAll(mI4, mI5, mI6);
		m3.getItems().addAll(mI7);
		m4.getItems().addAll(mI10);

		mBar = new MenuBar(m1, m2, m3, m4);
		mBar.prefWidthProperty().bind(primaryStage.widthProperty());
		mBar.setPrefHeight(40);

		h = new HBox();
		h.getChildren().add(mBar);
		vBox = new VBox(150);
		vBox.getChildren().addAll(h, h3, button);
		vBox.setAlignment(Pos.CENTER);
		h3.setAlignment(Pos.CENTER);
		borderPane.setTop(vBox);
		RadialGradient nR = new RadialGradient(0, 0, 0, 0, 1, true, // sizing
				CycleMethod.NO_CYCLE, // cycling
				new Stop(0, Color.web("#81c483")), // colors
				new Stop(1, Color.web("#fcc200")));

		// Change to your desired color
		BackgroundFill backgroundFill = new BackgroundFill(nR, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY);
		Background background = new Background(backgroundFill);
		borderPane.setBackground(background);
		scene = new Scene(borderPane, 1530, 800);
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setFullScreen(true);

	}

	public static void main(String[] args) {
		launch(args);
	}
}
