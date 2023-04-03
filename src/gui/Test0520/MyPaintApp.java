package gui.Test0520;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.Optional;


// vm-options (java > 8): --module-path ${PATH_TO_FX} --add-modules javafx.controls,javafx.fxml

public class MyPaintApp extends Application {

    private Canvas canvas = new Canvas(500,400);
    private double x;
    private double y;
    private ToggleButton paintBtn = new ToggleButton("Paint");
    private ToggleButton eraseBtn = new ToggleButton("Delete");
    private ColorPicker picker;

    public void start(Stage stage) {
        BorderPane rootPane = new BorderPane();
        rootPane.setStyle("-fx-background-color: white");
        ToolBar toolBar = new ToolBar();
        rootPane.setTop(toolBar);
        ToggleGroup toggleGrp = new ToggleGroup();
        toggleGrp.getToggles().addAll(paintBtn, eraseBtn);

        picker = new ColorPicker();
        //picker.setValue();

        //canvas.setOnMouseDragged(this::onMouseDragged);
        canvas.setOnMousePressed(this::onMousePressed);
        rootPane.setCenter(canvas);

        toolBar.getItems().addAll(paintBtn, eraseBtn, picker);
        paintBtn.setSelected(true);

        stage.setScene(new Scene(rootPane));
        stage.setTitle("My Paint App");
        stage.show();
    }

    private void onMousePressed(MouseEvent ev) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setStroke(picker.getValue());
        gc.setLineWidth(1);
        if(ev.getButton() == MouseButton.SECONDARY){
            System.out.println("Hallo");
            gc.strokeLine(x,y,ev.getX(),ev.getY());

        }
        x = ev.getX();
        y = ev.getY();

    }

    public void onMouseDragged(MouseEvent ev){
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setLineWidth(1);
        gc.setStroke(picker.getValue());
        if (paintBtn.isSelected()) {
            gc.strokeLine(x,y,ev.getX(),ev.getY());
            x = ev.getX();
            y = ev.getY();
        } else {
            gc.clearRect(ev.getX()-5, ev.getY()-5,10,10);

        }
    }

    public void onClicked(MouseEvent ev){
        if(ev.getClickCount() == 2){
            TextInputDialog dialog = new TextInputDialog();
            dialog.setTitle("Text Input");
            dialog.setContentText("Provide a Text");
            Optional<String> text = dialog.showAndWait();

            if(text.isPresent()) {
                GraphicsContext gc = canvas.getGraphicsContext2D();
                gc.setFill(picker.getValue());
                gc.setFont(Font.font(15));
                //gc.fillText(text,get(),);

            }
        }
    }
}
