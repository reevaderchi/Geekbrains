import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    static final String HOST = "localhost";
    static final int PORT = 6565;
    private static DataInputStream in;
    private static DataOutputStream out;

    public static void main(String[] args) {

        try {
            System.out.println("Client is trying to connect...");
            Socket socket = new Socket(HOST, PORT);
            System.out.println("Client is connected!");
            out = new DataOutputStream(socket.getOutputStream());
            in = new DataInputStream(socket.getInputStream());

            // Output поток для отправки сообщений Серверу

            new Thread(new Runnable() {

                public void run() {

                    System.out.println("Write your message in console...");

                    while (true) {

                        try {
                            Scanner scanner = new Scanner(System.in);
                            String clientText = scanner.nextLine();
                            out.writeUTF(clientText);
                            out.flush();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();

            // Input поток для чтения сообщений от Сервера

            new Thread(new Runnable() {

                public void run() {

                    while (true) {

                        try {
                            String inputText = in.readUTF();

                            if (inputText.equalsIgnoreCase("/serverClose")) {
                                System.out.println("Вы покинули чат");
                                break;
                            }

                            System.out.println("Server says: " + inputText);
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
}