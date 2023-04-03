package gui.set09;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Ex01 extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Button f1 = new Button("f1");
        Button f2 = new Button("f2");
        Button f3 = new Button("f3");
        Button f4 = new Button("f4");
        Button up = new Button("Up");
        Button left = new Button("Left");
        Button right = new Button("Right");
        Button down = new Button("Down");
        Button exit = new Button("Exit");
        exit.setMaxWidth(Double.MAX_VALUE);
        up.setMaxWidth(Double.MAX_VALUE);
        left.setMaxWidth(Double.MAX_VALUE);
        right.setMaxWidth(Double.MAX_VALUE);
        down.setMaxWidth(Double.MAX_VALUE);

        HBox box = new HBox(10);
        box.setAlignment(Pos.CENTER);
        box.getChildren().addAll(f1, f2, f3, f4);

        GridPane gridpane = new GridPane();
        gridpane.setAlignment(Pos.CENTER);
        gridpane.setHgap(10);
        gridpane.setVgap(10);
        gridpane.setPadding(new Insets(15,15,15,15));
        gridpane.add(up,1,0);
        gridpane.add(left,0,1);
        gridpane.add(right,2,1);
        gridpane.add(down,1,2);
        gridpane.setGridLinesVisible(true);

        RowConstraints rowConstraints = new RowConstraints();
        rowConstraints.setPrefHeight(33.3);
        gridpane.getRowConstraints().addAll(rowConstraints,rowConstraints,rowConstraints);
        ColumnConstraints columnConstraints = new ColumnConstraints();
        columnConstraints.setPercentWidth(33.3);
        gridpane.getColumnConstraints().addAll(columnConstraints,columnConstraints,columnConstraints);

        BorderPane centerPane = new BorderPane();
        centerPane.setTop(box);
        centerPane.setCenter(gridpane);

        BorderPane pane = new BorderPane();
        pane.setBottom(exit);
        pane.setCenter(centerPane);


        stage.setScene(new Scene(pane,200,200));
        stage.setTitle("Aufgabe1");
        stage.show();
    }
}
