package gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("ui.fxml"));
        primaryStage.setTitle("Fio export 1.3");
        primaryStage.getIcons().add(new Image(Main.class.getResourceAsStream("/xml-icon.png")));
        primaryStage.setScene(new Scene(root, 480, 350));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
