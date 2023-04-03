package gui.Test0510;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

// vm-options (java > 8): --module-path ${PATH_TO_FX} --add-modules javafx.controls,javafx.fxml
public class MusicControlApp extends Application
{
    @Override
    public void start(Stage stage) {
        HBox box = new HBox(10);
        box.setPadding(new Insets(10));
        box.setAlignment(Pos.CENTER);
        box.getChildren().addAll(
                new MusicControlButton(MusicControlButton.Type.PLAY),
                new MusicControlButton(MusicControlButton.Type.STOP));

        stage.setScene(new Scene(box));
        stage.setTitle("Music Control App");
        stage.show();
    }
}
