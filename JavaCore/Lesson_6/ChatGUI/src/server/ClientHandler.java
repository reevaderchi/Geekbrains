package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler {

    private Server server;
    private Socket socket;
    private DataOutputStream out;
    private DataInputStream in;

    public ClientHandler (Server server, Socket socket) {

        try {
            this.server = server;
            this.socket = socket;
            this.out = new DataOutputStream(socket.getOutputStream());
            this.in = new DataInputStream(socket.getInputStream());

            new Thread(new Runnable() {
                @Override
                public void run() {

                    try {

                        while (true) {

                            String str = in.readUTF();
                            System.out.println("Клиент передает Серверу сообщение: " + str);


                            if (str.equalsIgnoreCase("/end")) {
                                System.out.println("Клиент отключился");
                                out.writeUTF("/serverClose");
                                server.removeClient(ClientHandler.this);
                                System.out.println("Клиент удален");
                                break;
                            }

                            System.out.println("Север пересылает сообщение обратно Клиенту...");
                            server.broadcast(str);

                        }

                    }catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            in.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        try {
                            out.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
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

    public void sendMsg(String msg) {
        try {
            out.writeUTF(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
