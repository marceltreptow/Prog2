package gui.set09;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Test extends Application {
    @Override
    public void start(Stage stage) {
        Button button = new Button("F1");
        GridPane gridpane = new GridPane();

        Button[] buttons = {new Button("1"),new Button("2"),new Button("3")};
        gridpane.setAlignment(Pos.CENTER);
        gridpane.setVgap(10);
        gridpane.setHgap(10);
        gridpane.setPadding(new Insets(15,15,15,15));
        buttons[0].setPrefSize(50,50);
        gridpane.add(buttons[0],0,0);
        gridpane.add(buttons[1],0,1);
        gridpane.add(buttons[2],0,2);
        gridpane.setGridLinesVisible(true);

        RowConstraints rowConstraints = new RowConstraints();
        rowConstraints.setPrefHeight(33.3);
        gridpane.getRowConstraints().addAll(rowConstraints,rowConstraints,rowConstraints);
        ColumnConstraints columnConstraints = new ColumnConstraints();
        columnConstraints.setPercentWidth(33.3);
        gridpane.getColumnConstraints().addAll(columnConstraints,columnConstraints,columnConstraints);

        

        Scene scene = new Scene(gridpane, 200,200);
        stage.setTitle("Aufgabe 1");
        //stage.setScene(scene);
        //stage.show();

        /*BorderPane pane = new BorderPane();
        pane.setPadding(new Insets(10));
        Button[] buttons1 = createButtons("hallo","hallo1");
        pane.setTop(buttons1[1]);
        pane.setCenter(buttons1[0]);
        Scene scene2 = new Scene(pane,200,200);
        stage.setScene(scene2);
        stage.show();*/

        FlowPane pane = new FlowPane();
        Button[] buttons1 = createButtons("hallo","hallo1");

        Scene scene2 = new Scene(pane,200,200);
        stage.setScene(scene2);
        stage.show();

    }

    public static Button[] createButtons(String... names){
        Button[] result = new Button[names.length];
        String[] colors = new String[]{"red","orange"};
        for (int i = 0; i < names.length; i++){
            result[i] = new Button(names[i]);
            result[i].setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
            result[i].setStyle("-fx-text-fill: " + colors[i% colors.length]);
        }
        return result;

    }
}
