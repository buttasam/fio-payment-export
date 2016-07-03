package logic.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private TextField tfAccountFrom;

    @FXML
    private TextField tfDate;

    @FXML
    public void handleBtnFile(ActionEvent event) {
        if(validate()) {
            System.out.println(tfAccountFrom.getText());
        }
    }

    private boolean validate() {
        if(tfAccountFrom.getText().isEmpty() || tfAccountFrom.getText().isEmpty()) {
            printErrorDialog("Textová pole musí být vyplněna.");
        }

        return true;
    }

    private void printErrorDialog(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Nastala chyba");
        alert.setHeaderText(message);

        alert.showAndWait();
    }

}
