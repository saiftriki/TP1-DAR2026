package serverPackage;

import java.io.IOException;
import java.net.*;

public class Server3 {
    public static void main(String[] args) throws IOException {
        InetAddress ip = InetAddress.getByName("192.168.1.40"); 
        InetSocketAddress adr = new InetSocketAddress(ip, 8080); 

        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(adr);

        System.out.println("\nLe serveur écoute sur "+adr+" !");
        while (true){
            Socket socket = serverSocket.accept();
            System.out.println("Un client est connecté !");
            socket.close();
        }


    }
}
