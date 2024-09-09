package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
//this class to implement a stage thats update or delete the martyr
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;

public class UpdateMartyrs extends InsertMartyrs {
	private GridPane gridPane;
	private VBox vBox;
	private Label label;
	private TextField textField;
	private Button button;
	private Scene scene;
	private GridPane gridPane2;
	private Button button1;
	private TextField textField1;
	private Label label1;
	private TextArea textArea1;
	private TabPane tabPane;
	private SplitPane splitPane;

	public UpdateMartyrs(DoublyLinkedList1 doublyLinkedList1) {
		super(doublyLinkedList1);
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
		splitPane = new SplitPane();
		splitPane.getItems().addAll(gridPane, getGridPane());
		scene = new Scene(splitPane, 1100, 500);
		RadialGradient nR = new RadialGradient(0, 0, 0, 0, 1, true, // sizing
				CycleMethod.NO_CYCLE, // cycling
				new Stop(0, Color.web("#81c483")), // colors
				new Stop(1, Color.web("#fcc200")));

		// Change to your desired color
		BackgroundFill backgroundFill = new BackgroundFill(nR, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY);
		Background background = new Background(backgroundFill);
		splitPane.setBackground(background);
		getStage().setScene(scene);
		getGridPane().setVisible(false);
//		label=new Label("please enter the part of name of the martyr");
//		textField=new TextField();
//		button=new Button("search");
//		gridPane=new GridPane();
//		gridPane.add(label, 0, 0);
//		gridPane.add(textField, 0, 1);
//		gridPane.add(button, 1, 1);
//		vBox=new VBox();
		getStage().setTitle("Update Stage");
		getButton().setText("Update");
		button = new Button("Delete");
		getHbutton().getChildren().add(button);
		button1.setOnAction(e -> {
			try {
				doublyLinkedList1.searchMartyrByName(textField1.getText());
				if (doublyLinkedList1.getString() == null) {
					textArea1.setText("not found");
				} else {
					if (doublyLinkedList1.getNumberOfMartyrs() == 1) {
						getGridPane().setVisible(true);
						textArea1.setText(doublyLinkedList1.getString());
						doublyLinkedList1.setString("");

					} else if (doublyLinkedList1.getNumberOfMartyrs() == 0) {
						textArea1.setText("not found");
					} else {

						textArea1
								.setText(doublyLinkedList1.getString() + "\n" + "more than one (please complete name)");
						doublyLinkedList1.setString("");
					}

				}
			} catch (NumberFormatException e2) {
				// TODO: handle exception
			}
		});
		getButton().setOnAction(e -> {
			SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

			try {
				doublyLinkedList1.getMartyr().setName(getT1().getText());
				doublyLinkedList1.getMartyr().setAge(Integer.valueOf(getT2().getText()));
				doublyLinkedList1.getMartyr().setDateOfDeath(dateFormat.parse(getT4().getText()));
				doublyLinkedList1.getMartyr().setGender(getGender());
				doublyLinkedList1.getLocationNode().setLocation(getT3().getText());

			}

			catch (NumberFormatException ex) {
				// TODO: handle exception
			} catch (ParseException e1) {

			}
		});
		button.setOnAction(e -> {
			doublyLinkedList1.deleteMartyr(textField1.getText());
		});

	}

}
