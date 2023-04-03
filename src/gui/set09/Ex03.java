package gui.set09;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Ex03 extends Application {
    protected TextField faceValueField;
    protected Button countBtn;
    protected Button resetBtn;
    protected Button exitBtn;
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
        resetBtn = new Button("Reset");
        exitBtn = new Button("Exit");

        BorderPane pane = new BorderPane();
        pane.setTop(label);
        pane.setCenter(faceValueField);

        HBox box = new HBox(10);
        box.getChildren().addAll(countBtn,resetBtn,exitBtn);
        box.setAlignment(Pos.CENTER);

        pane.setBottom(box);
        countBtn.setOnAction(ev -> faceValueField.setText(Integer.toString(count++)));
        resetBtn.setOnAction(ev -> reset());
        exitBtn.setOnAction(ev -> stage.close());

        stage.setTitle("Counter");
        stage.setScene(new Scene(pane,150,100));

    }

    protected void reset(){
        count = 0;
        faceValueField.setText(Integer.toString(count));

    }
}