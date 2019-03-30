package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.Vector;

public class Server {

    private Vector<ClientHandler> clients;

    public Server() throws SQLException {

        Socket socket = null;
        ServerSocket serverSocket = null;
        clients = new Vector<>();

        try {

            AuthService.connect();
            serverSocket = new ServerSocket(7070);
            System.out.println("Сервер запущен!");

            while (true) {
                socket = serverSocket.accept();
                System.out.println("Клиент подключился");
                new ClientHandler(this,socket);
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
            AuthService.disconnect();

        }
    }

    public void broadcast (String msg) {

        for (ClientHandler c: clients) {
            c.sendMsg(msg);
        }

    }

    public void whisper (ClientHandler from, String to, String msg)
    {

        for (ClientHandler client: clients) {
            if(client.getNick().equals(to)) {
                client.sendMsg("[Whisper from: " + from.getNick() + "] " + msg);
                break;
            }
        }
        from.sendMsg("[Whisper to: " + to + "] " + msg);
    }

    public void addClient(ClientHandler client) {
        clients.add(client);
    }

    public void removeClient(ClientHandler client) {
        clients.remove(client);
    }

    public boolean isActive (String nick) {
        for (ClientHandler c: clients) {
            if(c.getNick().equals(nick))
                return true;
        }
        return false;
    }

}
