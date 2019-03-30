package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    TextArea textArea;

    @FXML
    TextField textField;

    @FXML
    Button btn;

    Socket socket;
    DataInputStream in;
    DataOutputStream out;

    final String HOST = "localhost";
    final int PORT = 7070;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {

            System.out.println("Подключение к серверу\n\t" +
                    "(IP address " + HOST +
                    ", port " + PORT + ")");

            socket = new Socket(HOST, PORT);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            System.out.println(
                    "Соединение установлено.");
            System.out.println(
                    "\tLocalPort = " +
                            socket.getLocalPort() +
                            "\n\tInetAddress.HostAddress = " +
                            socket.getInetAddress()
                                    .getHostAddress() +
                            "\n\tReceiveBufferSize (SO_RCVBUF) = "
                            + socket.getReceiveBufferSize());

            new Thread(new Runnable() {
                @Override
                public void run() {

                    try {

                        while(true) {
                            String str = in.readUTF();

                            System.out.println(
                                        "Клиент получил сообщение от Сервера :\n\t"
                                                + str);
                            if (str.equalsIgnoreCase("/serverClose")) {
                                textArea.appendText("Вы покинули чат");
                                break;
                            }
                            textArea.appendText(str + "\n");
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        try {
                                socket.close();

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }).start();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void sendMsg() {

        try {
            out.writeUTF(textField.getText());
            out.flush();
            textField.clear();
            textField.requestFocus();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
