package gui.Test0513;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

// vm-options (java > 8): --module-path ${PATH_TO_FX} --add-modules javafx.controls,javafx.fxml

public class LayoutExerciseApp extends Application {
    @Override
    public void start(Stage stage) {
        Button top1Btn = new Button("< Top");
        Button top2Btn = new Button("Top >>>");
        Button centerBtn = new Button("Center");
        Button bottom1Btn = new Button("< Bottom");
        Button bottom2Btn = new Button("Bottom >>>");
        Button leftBtn = new Button("Left");
        leftBtn.setMaxHeight(Double.MAX_VALUE);

        HBox topBox = new HBox();
        topBox.getChildren().addAll(top1Btn, top2Btn);
        HBox bottomBox = new HBox();
        bottomBox.getChildren().addAll(bottom1Btn, bottom2Btn);

        BorderPane centerPane = new BorderPane();
        centerPane.setTop(topBox);
        centerPane.setCenter(centerBtn);
        centerPane.setBottom(bottomBox);

        BorderPane rootPane = new BorderPane();
        rootPane.setLeft(leftBtn);
        rootPane.setCenter(centerPane);


        stage.setScene(new Scene(rootPane));
        stage.setTitle("Layout Exercise App");
        stage.show();
    }
}
