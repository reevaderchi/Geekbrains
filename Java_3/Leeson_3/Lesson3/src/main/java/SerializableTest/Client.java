package SerializableTest;

import java.io.*;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws IOException{

        Socket socket;
        DataOutputStream out;
        DataInputStream in;

        final String HOST = "localhost";
        final int PORT = 8080;
        try {
            System.out.println("Подключение к серверу\n\t" +
                    "(IP address " + HOST +
                    ", port " + PORT + ")");

            socket = new Socket(HOST, PORT);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            System.out.println("Соединение установлено!");

            Students students = new Students("James", 25);
            ObjectOutputStream oos = new ObjectOutputStream( new FileOutputStream("students.ser"));
            oos.writeObject(students);
            oos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
