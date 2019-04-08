package SerializableTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Socket socket;
        ServerSocket serverSocket;

        try {

            serverSocket = new ServerSocket(8080);
            System.out.println("Сервер запущен!");

            while (true) {

                socket = serverSocket.accept();
                System.out.println("Клиент подключился!");
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream("students.ser"));
                Students students2 = (Students)ois.readObject();
                ois.close();
                students2.info();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
