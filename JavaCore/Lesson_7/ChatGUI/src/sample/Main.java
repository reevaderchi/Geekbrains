package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.InputStream;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        InputStream stream = getClass().getResourceAsStream("sample.fxml");
        Parent root = new FXMLLoader().load(stream);
//        Parent root = FXMLLoader.load(getClass().getResource("/sample/sample.fxml"));
        primaryStage.setTitle("Online Chat");
        primaryStage.setScene(new Scene(root, 400, 400));
        primaryStage.getIcons().add(new Image("img/chat_icon.png"));

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
