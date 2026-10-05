package serverPackage;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    static void main() throws IOException {

        ServerSocket serverSocket = new ServerSocket(1234);
        System.out.println("Je suis un serveur en attente la connexion d'un client ");

        Socket socket = serverSocket.accept();
        System.out.println("un client est connecté");

        socket.close();
        serverSocket.close();
    }
}
