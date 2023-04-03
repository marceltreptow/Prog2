package gui.Test0510;

import javafx.beans.binding.Bindings;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

public class MusicControlButton extends Button {

    public enum Type {PLAY, STOP};

    private Pane pane = new StackPane();

    public MusicControlButton(Type type) {
        setGraphic(pane);
        switch (type) {
            case PLAY:
                widthProperty().addListener((obs, o, n) -> updateSize());
                heightProperty().addListener((obs, o, n) -> updateSize());
                //updateSize();
                break;
            case STOP:
                Rectangle rect = new Rectangle();
                rect.widthProperty().bind(Bindings.min(pane.widthProperty(),
                        pane.heightProperty()).divide(3));
                rect.heightProperty().bind(Bindings.min(pane.widthProperty(),
                        pane.heightProperty()).divide(3));
                pane.getChildren().add(rect);
                break;
        }
        this.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        this.setPrefSize(60, 20);
    }

    private void updateSize() {
        double size = Math.min(getWidth(), getHeight()) / 3;
        Polygon poly = new Polygon();
        poly.getPoints().addAll(0.0, 0.0, size, size/2, 0.0, size);
        pane.getChildren().clear();
        pane.getChildren().add(poly);
    }

}
