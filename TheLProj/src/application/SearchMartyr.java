package application;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.stage.Stage;

//to search of input Martyr
public class SearchMartyr {
	Stage stage;
	Scene scene;
	GridPane gridPane;
	Button button1;
	TextField textField1;
	Label label1;
	TextArea textArea1;

	public SearchMartyr(DoublyLinkedList1 doublyLinkedList1) {
		label1 = new Label("please enter the part of name of the martyr :");
		textField1 = new TextField();
		button1 = new Button("search");
		textArea1 = new TextArea();
		gridPane = new GridPane();
		gridPane.add(label1, 0, 0);
		gridPane.add(textField1, 0, 1);
		gridPane.add(button1, 1, 1);
		gridPane.add(textArea1, 0, 2);
		gridPane.setHgap(5);
		gridPane.setVgap(5);
		scene = new Scene(gridPane);
		stage = new Stage();
		stage.setScene(scene);
		stage.setTitle("Search Martyr");
		stage.setResizable(false);
		stage.show();
		RadialGradient nR = new RadialGradient(0, 0, 0, 0, 1, true, // sizing
				CycleMethod.NO_CYCLE, // cycling
				new Stop(0, Color.web("#81c483")), // colors
				new Stop(1, Color.web("#fcc200")));

		// Change to your desired color
		BackgroundFill backgroundFill = new BackgroundFill(nR, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY);
		Background background = new Background(backgroundFill);
		gridPane.setBackground(background);
		button1.setOnAction(e -> {
			try {
				doublyLinkedList1.searchMartyrByName(textField1.getText());
				if (doublyLinkedList1.getString() == null) {
					textArea1.setText("not found");
				} else {
					textArea1.setText(doublyLinkedList1.getString());
					doublyLinkedList1.setString("");
				}
			} catch (NumberFormatException e2) {
				// TODO: handle exception
			}
		});
	}

}
