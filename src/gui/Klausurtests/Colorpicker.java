package gui.Klausurtests;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Colorpicker extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        final ColorPicker colorPicker = new ColorPicker();
        colorPicker.setValue(Color.CORAL);
        final Label label = new Label("Try the color picker!");
        label.setFont(Font.font(20));
        System.out.println(label.getMaxHeight());
        label.setTextFill(colorPicker.getValue());
        colorPicker.setOnAction(ev -> label.setTextFill(colorPicker.getValue()));
        HBox box = new HBox();
        box.setPrefHeight(1000);
        box.getChildren().addAll(colorPicker, label);
        stage.setScene(new Scene(box,200,200));
        stage.show();


    }
}
