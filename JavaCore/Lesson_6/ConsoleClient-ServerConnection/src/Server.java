import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    private static final int PORT = 6565;
    private static Socket socket = null;
    private static ServerSocket server = null;
    private static DataInputStream in;
    private static DataOutputStream out;

    public static void main(String[] args) {

        try {
            server = new ServerSocket(PORT);
            System.out.println("Server is initialized!");
            System.out.println("Waiting for connections...");
            socket = server.accept();
            System.out.println("Got the connection from the Client!");
            out = new DataOutputStream(socket.getOutputStream());
            in = new DataInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Output поток для отправки сообщений Клиенту

        new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println("Write your message in console...");

                while (true) {

                    try {
                        Scanner scanner = new Scanner(System.in);
                        String serverText = scanner.nextLine();
                        out.writeUTF(serverText);
                        out.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        // Input поток для получения сообщений от Клиента

        new Thread (new Runnable() {

            @Override
            public void run() {

                while (true) {

                    try {
                        String inputText = in.readUTF();

                        if (inputText.equalsIgnoreCase("/end")) {
                            System.out.println("Клиент отключился");
                            out.writeUTF("/serverClose");
                            break;
                        }

                        System.out.println("Client says: " + inputText);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}