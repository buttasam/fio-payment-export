package gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("ui.fxml"));
        primaryStage.setTitle("Fio export 1.0");
        primaryStage.setScene(new Scene(root, 320, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
