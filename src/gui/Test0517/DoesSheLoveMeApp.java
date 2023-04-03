package gui.Test0517;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DoesSheLoveMeApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        DslmModel model = new DslmModel();
        SimpleDsLmController controller = new SimpleDsLmController(model);
        DslmView view = new DslmView(controller,model);
        model.addObserver(view);

        stage.setTitle("Does she love me App");
        stage.setScene(view.getScene());
        stage.show();

    }

    //View
    public static class DslmView implements Observer{
        private Scene scene;
        private SimpleDsLmController controller;
        private DslmModel model;
        private TextField answerFld;

        public DslmView(SimpleDsLmController controller, DslmModel model){
            this.controller = controller;
            this.model = model;
            Button startbtn = new Button("Start");
            startbtn.setId("startId");
            startbtn.setMaxWidth(Double.MAX_VALUE);
            startbtn.setOnAction(controller::handle);
            answerFld = new TextField();
            VBox box = new VBox(10);
            box.setPadding(new Insets(10));
            box.getChildren().addAll(startbtn,answerFld);
            scene = new Scene(box);

        }

        public Scene getScene() {return scene;}

        @Override
        public void update() {
            answerFld.setText(model.getAnswer());

        }
    }

    //Controller

    /*public static interface DslmController implements EventHandler<ActionEvent>{

    }
     */

    public static class SimpleDsLmController implements EventHandler<ActionEvent> {
        private DslmModel model;

        public SimpleDsLmController(DslmModel model){
            this.model = model;

        }

        @Override
        public void handle(ActionEvent actionEvent) {
            if("startId".equals(((Control)actionEvent.getSource()).getId())){
               model.askTheQuestion();

            }
        }
    }


    //Model
    public static class DslmModel {
        private String answer;
        private static Random random = new Random();
        private List<Observer> observers = new ArrayList<>();

        public void askTheQuestion(){
            answer = (random.nextBoolean()) ? "Yas" :  "Yasnt";
            notifyObsevers();

        }

        public String getAnswer(){
            return answer;

        }

        public void addObserver(Observer observer){
            observers.add(observer);

        }

        protected void notifyObsevers(){
            observers.forEach(Observer::update);

        }
    }

    //Utils

    public interface Observer{
        void update();

    }

}
