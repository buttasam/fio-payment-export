package logic.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;

public class Controller {

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private TextField tfAccountFrom;

    @FXML
    private TextField tfDate;

    @FXML
    private Label labelFileStatus;

    private FileChooser fileChooser;

    private String filePath;
    private String dirPath;

    private String date;
    private String accountFrom;

    public Controller() {
        fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Soubory XLS", "*.xlsx"));
    }

    @FXML
    public void handleBtnFile(ActionEvent event) {
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        File file = fileChooser.showOpenDialog(stage);
        if(file != null) {
            filePath = file.getAbsolutePath();
            dirPath = file.getAbsolutePath().replaceAll(file.getName(), "");

            String fileName = file.getName();
            labelFileStatus.setText(fileName);
        }
    }

    @FXML
    public void handleBtnGenerate(ActionEvent event) {
        if(validate()) {
            try {
                ArrayList<Transaction> transactions = new ArrayList<>();
                XlsReader reader = new XlsReader(filePath);

                date = tfDate.getText();
                accountFrom = tfAccountFrom.getText();

                reader.fillTransactions(transactions, date, accountFrom);

                XmlWriter xmlWriter = new XmlWriter();
                xmlWriter.writeTransactions(transactions, dirPath);

                printDialog("Soubor vygenerován", "XML soubor byl vygenerován", Alert.AlertType.INFORMATION);
            } catch(Exception e) {
                printDialog("Nastala chyba", "Soubor nebyl vybrán nebo není validní", Alert.AlertType.ERROR);
            }
        }
    }

    private boolean validate() {
        if(tfAccountFrom.getText().isEmpty() || tfDate.getText().isEmpty()) {
            printDialog("Nastala chyba", "Textová pole musí být vyplněna.", Alert.AlertType.ERROR);

            return false;
        }

        return true;
    }

    private void printDialog(String title, String message, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(message);

        alert.showAndWait();
    }

}
