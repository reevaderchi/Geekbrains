package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class Server {

    private Vector<ClientHandler> clients;

    public Server() {

        Socket socket = null;
        ServerSocket serverSocket = null;
        clients = new Vector<>();

        try {

            serverSocket = new ServerSocket(7070);
            System.out.println("Сервер запущен!");

            while (true) {
                socket = serverSocket.accept();
                System.out.println("Клиент подключился");
                clients.add(new ClientHandler(this,socket));
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public void broadcast (String msg) {

        for (ClientHandler c: clients) {
            c.sendMsg(msg);
        }

    }

    public void removeClient(ClientHandler client) {
        clients.remove(client);
    }
}
