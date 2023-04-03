package gui.Klausurtests;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

public class Canvastest extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
            primaryStage.setTitle("Drawing Operations Test");
            Pane pane = new Pane();
            Group root = new Group();
            Canvas canvas = new Canvas(300, 250);
            GraphicsContext gc = canvas.getGraphicsContext2D();
            drawShapes(gc); // see next slides
            addMouseEventHandlers(canvas); // see next slides
            pane.getChildren().add(canvas);
            primaryStage.setScene(new Scene(pane));
            primaryStage.show();

    }

    public void drawShapes(GraphicsContext gc){
        /*gc.setFill(Color.GREEN);
        gc.setStroke(Color.BLUE);
        gc.setLineWidth(5);
        gc.strokeLine(40, 10, 10, 40);
        gc.fillOval(10, 60, 30, 30);
        gc.strokeOval(60, 60, 30, 30);
        gc.fillRoundRect(110, 60, 30, 30, 10, 10);
        gc.strokeRoundRect(160, 60, 30, 30, 10, 10);
        gc.fillArc(10, 110, 30, 30, 45, 240, ArcType.OPEN);
        gc.fillArc(60, 110, 30, 30, 45, 240, ArcType.CHORD);
        gc.fillArc(110, 110, 30, 30, 45, 240, ArcType.ROUND);
        gc.strokeArc(10, 160, 30, 30, 45, 240, ArcType.OPEN);
        gc.strokeArc(60, 160, 30, 30, 45, 240, ArcType.CHORD);
        gc.strokeArc(110, 160, 30, 30, 45, 240, ArcType.ROUND);
        gc.fillPolygon(new double[]{10, 40, 10, 40},
                new double[]{210, 210, 240, 240}, 4);
        gc.strokePolygon(new double[]{60, 90, 60, 90},
                new double[]{210, 210, 240, 240}, 4);
        gc.strokePolyline(new double[]{110, 140, 110, 140},
                new double[]{210, 210, 240, 240}, 4);

         */
    }

    public void addMouseEventHandlers(Canvas canvas){
        GraphicsContext gc = canvas.getGraphicsContext2D();
        canvas.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent ev) {
                    gc.fillOval(ev.getX(), ev.getY(), 30, 30);
            }} );


        canvas.setOnMouseClicked(ev -> handle(ev));

    }

    public void handle(MouseEvent ev){


    }
}
