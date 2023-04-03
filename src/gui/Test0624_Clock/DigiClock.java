package gui.Test0624_Clock;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.Calendar;

// vm-options (java > 8): --module-path ${PATH_TO_FX} --add-modules javafx.controls,javafx.fxml

public class DigiClock extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	
	private TextField textFld;

	public void start(Stage stage) {
		textFld = new TextField();
		textFld.setPrefColumnCount(6);
		textFld.setAlignment(Pos.CENTER);
		textFld.setFont(Font.font("sans-serif", FontWeight.BOLD, 40));
		textFld.setEditable(false);
		StackPane pane = new StackPane();
		pane.getChildren().add(textFld);
		stage.setTitle("DigiClock");
		stage.setScene(new Scene(pane));

		Thread th = new Thread(this::runClock);
		th.setDaemon(true);
		th.start();
		stage.show();
	}


	public void runClock() {
		while (true) {
			//pane.getChildren().add(new Button("x"));
			Calendar instance = Calendar.getInstance();

			String timeText = String.format("%s:%s:%s",
					instance.get(Calendar.HOUR_OF_DAY),
					instance.get(Calendar.MINUTE),
					instance.get(Calendar.SECOND));
			//textFld.setText(timeText);
			Platform.runLater(() -> textFld.setText(timeText));
			/*
			Platform.runLater(() -> textFld.setText
					(LocalTime.now().format(DateTimeFormatter.ISO_LOCAL_TIME)));
			 */
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
