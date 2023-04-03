package gui.Test0426;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class HelloWorldApp extends Application {
    @Override
    public void start(Stage stage) {
        Button btn = new Button("Hello World");
        btn.setFont(Font.font(42));
        StackPane pane = new StackPane();
        pane.getChildren().add(btn);
        Scene scene = new Scene(pane, 300, 300);
        GridPane gridPane = new GridPane();

        TextField textField = new TextField("Hey");
        textField.setPrefColumnCount(3);
        textField.setEditable(false);
        textField.setText("he");
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(textField);
        System.out.println(borderPane.widthProperty());

        SplitPane splitPane = new SplitPane();
        splitPane.setDividerPosition(0,0.8);
        Pane pane1 = new Pane();
        Pane pane2 = new Pane();
        Pane pane3 = new Pane();
        splitPane.getItems().addAll(pane1,pane2,pane3);

        TabPane tp = new TabPane();
        tp.getTabs().addAll(new Tab("Yeha",pane1),new Tab("",pane2));

        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(tp, splitPane);
        final ToggleButton b0 = new ToggleButton("TabPane");
        final ToggleButton b1 = new ToggleButton("SplitPane");
        ToggleGroup tg = new ToggleGroup();
        tg.getToggles().addAll(b0, b1);
        ChangeListener<Boolean> listener = (obs, o, n) -> {
            stackPane.getChildren().get(0).setVisible(b0.isSelected());
            stackPane.getChildren().get(1).setVisible(b1.isSelected());
            stackPane.requestLayout();
        };
        ToolBar toolbar = new ToolBar();
        b0.selectedProperty().addListener(listener);
        b1.selectedProperty().addListener(listener);
        toolbar.getItems().addAll(b0, b1);
        BorderPane rootPane = new BorderPane();
        rootPane.setTop(toolbar);
        rootPane.setCenter(stackPane);

        Canvas canvas = new Canvas();
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.CORAL);
        canvas.setOnMousePressed((ev) -> {
            ev.getX();
        });
        stage.setScene(new Scene(rootPane,200,200));
        stage.setTitle("My first App");
        stage.show();

    }
}

