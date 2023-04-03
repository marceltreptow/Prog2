package gui.set10;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class MemoryGameApp extends Application {
    private MemoryGame memoryGame = new MemoryGame();
    private TextField textField;
    private BorderPane borderPane;
    private Button[] buttons;

    @Override
    public void start(Stage stage) throws Exception {
        createScene(stage);
        stage.show();

    }

    public void createScene(Stage stage){
        borderPane = new BorderPane();
        borderPane.setTop(createMenuBar(stage));
        borderPane.setCenter(createCardField());
        textField = new TextField("Rot ist dran");
        borderPane.setBottom(textField);

        Scene scene = new Scene(borderPane,1000,600);
        scene.getStylesheets().add(getClass().getResource("MemoryGameApp.css").toExternalForm());
        stage.setTitle("MemoryGameApp");
        stage.setScene(scene);
    }

    public Button[] createCards(){
        Button[] result = new Button[12];

        for (int i = 0; i < 12; i++) {
            result[i] = new Button();
            result[i].setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
            result[i].setStyle("-fx-background-image: url(" +
                    getClass().getResource("default.jpg").toExternalForm()+"); -fx-background-size: cover");
        }
        result[0].setOnAction(actionEvent -> process(0));
        result[1].setOnAction(actionEvent -> process(1));
        result[2].setOnAction(actionEvent -> process(2));
        result[3].setOnAction(actionEvent -> process(3));
        result[4].setOnAction(actionEvent -> process(4));
        result[5].setOnAction(actionEvent -> process(5));
        result[6].setOnAction(actionEvent -> process(6));
        result[7].setOnAction(actionEvent -> process(7));
        result[8].setOnAction(actionEvent -> process(8));
        result[9].setOnAction(actionEvent -> process(9));
        result[10].setOnAction(actionEvent -> process(10));
        result[11].setOnAction(actionEvent -> process(11));
        return result;

    }

    public MenuBar createMenuBar(Stage stage){
        MenuBar menuBar = new MenuBar();
        Menu menu = new Menu("Menu");
        MenuItem exitmenu = new MenuItem("Exit");
        exitmenu.setOnAction(actionEvent -> stage.close());
        MenuItem newgamemenu = new MenuItem("New Game");
        newgamemenu.setOnAction(ev -> {
            try {
                start(new Stage());
                memoryGame = new MemoryGame();
            } catch (Exception e) {
                e.printStackTrace();
            }
            stage.close();
        });
        menu.getItems().addAll(newgamemenu,exitmenu);
        menuBar.getMenus().addAll(menu);
        return menuBar;

    }

    public GridPane createCardField(){
        GridPane gridpane = new GridPane();
        buttons = createCards();
        RowConstraints rowConstraints = new RowConstraints();
        rowConstraints.setPercentHeight(33.3);
        gridpane.getRowConstraints().addAll(rowConstraints,rowConstraints,rowConstraints);
        ColumnConstraints columnConstraints = new ColumnConstraints();
        columnConstraints.setPercentWidth(25);
        gridpane.getColumnConstraints().addAll(columnConstraints,columnConstraints,columnConstraints,columnConstraints);
        gridpane.setAlignment(Pos.CENTER);
        gridpane.setHgap(15);
        gridpane.setVgap(15);
        gridpane.setPadding(new Insets(15));
        gridpane.add(buttons[0], 0,0);
        gridpane.add(buttons[1], 1,0);
        gridpane.add(buttons[2], 2,0);
        gridpane.add(buttons[3], 3,0);
        gridpane.add(buttons[4], 0,1);
        gridpane.add(buttons[5], 1,1);
        gridpane.add(buttons[6], 2,1);
        gridpane.add(buttons[7], 3,1);
        gridpane.add(buttons[8], 0,2);
        gridpane.add(buttons[9], 1,2);
        gridpane.add(buttons[10], 2,2);
        gridpane.add(buttons[11], 3,2);
        return gridpane;
    }

    public void process(int btnnr){
        if(memoryGame.twoCardsChoosen())
            convertCards();
        if(memoryGame.chooseCard(btnnr))
            turnCard(btnnr);
        borderPane.setBottom(memoryGame.getTurn() == MemoryGame.Player.Red ? new TextField("Rot ist dran") : new TextField("Blau ist dran"));

        if(memoryGame.checkcards()) {
            memoryGame.getTurn();
            textField = memoryGame.getTurn() == MemoryGame.Player.Red ? new TextField("Rot ist dran") : new TextField("Blau ist dran");

        }
    }

    public void turnCard(int btnnr){
        buttons[btnnr].setStyle("-fx-background-image: url(" +
                getClass().getResource(memoryGame.getCard(btnnr).getPic()).toExternalForm()+"); -fx-background-size: cover");

    }

    public void convertCards(){
        if (memoryGame.checkCardResult()) {
            if(memoryGame.getTurn() == MemoryGame.Player.Red) {
                buttons[memoryGame.getFirstChoosencard()].setStyle("-fx-background-color:" + "red");
                buttons[memoryGame.getSecondChoosencard()].setStyle("-fx-background-color:" + "red");
            } else {
                buttons[memoryGame.getFirstChoosencard()].setStyle("-fx-background-color:" + "blue");
                buttons[memoryGame.getSecondChoosencard()].setStyle("-fx-background-color:" + "blue");
            }


        } else {
            buttons[memoryGame.getFirstChoosencard()].setStyle("-fx-background-image: url(" +
                    getClass().getResource("default.jpg").toExternalForm() + "); -fx-background-size: cover");
            buttons[memoryGame.getSecondChoosencard()].setStyle("-fx-background-image: url(" +
                    getClass().getResource("default.jpg").toExternalForm() + "); -fx-background-size: cover");

        }
    }
}
