package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

import java.io.*;
import java.lang.reflect.InvocationTargetException;

public class Controller {

    @FXML
    TextArea textArea;

    @FXML
    TextField textField;

    @FXML
    Button btn;

    @FXML
    HBox upperPanel;

    @FXML
    HBox bottomPanel;

    @FXML
    TextField loginField;

    @FXML
    PasswordField passwordField;

    public void showPage() {
        long t = System.currentTimeMillis();

        textArea.clear();

        int pageLength = 1800;
        int pageNum = 0;

        FileReader fr = null;
        BufferedReader br = null;


        try {
            pageNum = Integer.parseInt(textField.getText());
        }
        catch (NumberFormatException e)
        {
            System.out.println("Неверный формат страницы!");
            textArea.appendText("Неверный формат страницы!" + "\n");
        }

        try (RandomAccessFile raf = new RandomAccessFile("text1.txt", "r")){

            textArea.appendText("Page: " + pageNum + "\n" + "\n");
            byte [] arr = new byte[pageLength];
            raf.seek((pageNum - 1) * pageLength);
            int x = raf.read(arr);
            if (x == -1) {
               textArea.appendText("Страницы не существует!");
            }
            textArea.appendText(new String (arr, 0, x, "UTF-8"));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        textField.clear();
        System.out.println("Время исполнения программы: " + (System.currentTimeMillis() - t));
    }
}


