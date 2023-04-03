package gui.set09;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Ex02 extends Application {
    protected TextField faceValueField;
    protected Button countBtn;
    private int count;

    @Override
    public void start(Stage stage) throws Exception {
        createScene(stage);
        stage.show();

    }

    protected void createScene(Stage stage){
        Label label = new Label("Count:");

        faceValueField = new TextField();
        faceValueField.setText(Integer.toString(count));
        faceValueField.setPrefColumnCount(4);
        faceValueField.setEditable(false);
        countBtn = new Button("Count");

        BorderPane pane = new BorderPane();
        pane.setTop(label);
        pane.setCenter(faceValueField);
        pane.setBottom(countBtn);
        countBtn.setOnAction(ev -> Count());

        stage.setTitle("Counter");
        stage.setScene(new Scene(pane,50,100));

    }

    private void Count(){
        faceValueField.setText(Integer.toString(count++));

    }
}
