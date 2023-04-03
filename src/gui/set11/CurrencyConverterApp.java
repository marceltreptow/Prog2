package gui.set11;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CurrencyConverterApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        GridPane gridPane = FXMLLoader.load(getClass().getResource("CurrencyConverterApp.fxml"));
        Scene scene = new Scene(gridPane);
        stage.setScene(scene);
        stage.show();

    }
}
