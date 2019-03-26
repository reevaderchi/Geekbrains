package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

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

    private boolean isAuthorized;

    Socket socket;
    DataInputStream in;
    DataOutputStream out;

    final String HOST = "localhost";
    final int PORT = 7070;

    public void setAuthorized(boolean isAuthorized) {
        this.isAuthorized = isAuthorized;
        if (!isAuthorized) {
            upperPanel.setManaged(true);
            upperPanel.setVisible(true);
            bottomPanel.setManaged(false);
            bottomPanel.setVisible(false);
        } else {
            upperPanel.setManaged(false);
            upperPanel.setVisible(false);
            bottomPanel.setManaged(true);
            bottomPanel.setVisible(true);
        }
    }

    public void tryToAuth(ActionEvent actionEvent) {

        if(socket == null || socket.isClosed()) {
            connect();
        }

        try {
            out.writeUTF("/auth " + loginField.getText() + " " + passwordField.getText());
            loginField.clear();
            passwordField.clear();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void connect() {

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
                            if (str.startsWith("/authOk")) {
                                setAuthorized(true);
                                break;
                            } else {
                                textArea.appendText(str + "\n");
                            }

                        }

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
                        setAuthorized(false);
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
