package gui.Test0506;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import javax.swing.text.Document;
import java.util.Locale;

// vm-options (java > 8): --module-path ${PATH_TO_FX} --add-modules javafx.controls,javafx.fxml

public class NmToKmConverterApp extends Application {

    private TextField nmFld;
    private TextField kmFld;

    @Override
    public void start(Stage stage) throws Exception {
        Locale.setDefault(Locale.US);
        stage.setScene(createScene());
        stage.setTitle("NM to KM converter App");
        stage.show();
    }

    private Scene createScene() {
        HBox box = new HBox(10);
        box.setAlignment(Pos.CENTER);
        box.setPadding(new Insets(10));
        Label nmLabel = new Label("Nautical Miles");
        nmFld = new TextField(); nmFld.setPrefColumnCount(8);
        Button convertBtn = new Button("Convert");
        //convertBtn.setOnAction(ev -> convert());
        convertBtn.setOnAction(new EventHandler<>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                convert();
            }
        });
        Label kmLabel = new Label("Kilometers");
        kmFld = new TextField(); kmFld.setPrefColumnCount(8);
        kmFld.setEditable(false);
        kmFld.setFocusTraversable(false);
        box.getChildren().addAll(nmLabel, nmFld, convertBtn, kmLabel, kmFld);
        Scene scene = new Scene(box);
        scene.getStylesheets().add(getClass().getResource("NmToKmConverterAPP.css").toExternalForm());

        return scene;
    }

    public void convert() {
        try {
            double nm = Double.parseDouble(nmFld.getText());
            double km = nm * 1.852;
            kmFld.setText(String.format("%1.3f", km));
        } catch (NumberFormatException ex) {
            kmFld.setText("Format error!");
        }
    }

}
