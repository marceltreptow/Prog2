package gui.set11;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;



public class CurrencyConverterController implements Initializable {

    @FXML
    public TextField eingabe;
    public TextField result;
    public ChoiceBox curr1;
    public ChoiceBox curr2;
    public Object firstselectedCurr;
    public Object secondselectedCurr;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        curr1.getItems().addAll("Euro","US-Dollar","Pfund","Yen","Schweizer Franken");
        curr2.getItems().addAll("Euro","US-Dollar","Pfund","Yen","Schweizer Franken");
        curr1.setOnAction((event) -> firstselectedCurr = curr1.getSelectionModel().getSelectedItem());
        curr2.setOnAction((event) -> secondselectedCurr = curr2.getSelectionModel().getSelectedItem());

    }

    public void calc(ActionEvent actionEvent) {
        double eingabewert = 0;
        try {
            eingabewert = Double.parseDouble(eingabe.getText());

        } catch (Exception e){
            System.out.println("Bitte eine Eingabe");

        }
        result.setText(String.valueOf(calcEuroInCurr(calcInEuro(eingabewert))));

    }
    public double calcInEuro(double b){
        switch ((String)firstselectedCurr) {
            case "Euro":
                break;
            case "Yen":
                b *= 0.0072;
                break;
            case "Schweizer Franken":
                b *= 0.97;
                break;
            case "US-Dollar":
                b *= 0.93;
                break;
            case "Pfund":
                b *= 1.17;
                break;

    }
        return b;

    }

    public double calcEuroInCurr(double b){
        switch ((String)secondselectedCurr) {
            case "Euro":
                break;
            case "Yen":
                b *= 138.78;
                break;
            case "Schweizer Franken":
                b *= 1.03;
                break;
            case "US-Dollar":
                b *= 1.07;
                break;
            case "Pfund":
                b *= 0.85;
                break;

        }
        return b;

    }
}
