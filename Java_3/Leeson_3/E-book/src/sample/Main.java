package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    long t = System.currentTimeMillis();

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("E-book");
        primaryStage.setScene(new Scene(root, 500, 400));
        primaryStage.show();
        System.out.println("Время загрузки программы: " + (System.currentTimeMillis() - t));
    }


    public static void main(String[] args) {
        launch(args);
    }
}
