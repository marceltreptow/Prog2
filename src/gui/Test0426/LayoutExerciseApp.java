package gui.Test0426;

import javafx.application.Application;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.awt.*;

public class LayoutExerciseApp extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Button top1Btn = new Button("< Top");
        Button top2Btn = new Button(">>> Top");
        Button centerBtn = new Button("Center");
        Button bottom1Btn = new Button("< Bottom");
        Button bottom2Btn = new Button("Bottom >>>");
        Button leftBtn = new Button("Left");

        /*HBox topBox = new HBox();
        topBox.getChildren().addAll(top1Btn, top2Btn);
        HBox bottomBox = new HBox();
        bottomBox.getChildren().addAll(bottom1Btn,bottom2Btn);

        BorderPane centerPane = new BorderPane();
        centerPane.setTop(topBox);
        centerPane.setCenter(centerBtn);
        centerPane.setCenter(centerBtn);

        primaryStage.setTitle("Layout Exercise App");
        */primaryStage.show();

    }
}
