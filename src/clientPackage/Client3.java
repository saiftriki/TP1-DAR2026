package clientPackage;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client3 {
    static void main(String[] args) throws IOException {
        Socket socket = new Socket();
        socket.connect(new InetSocketAddress("localhost", 8080), 5000); // 5000 = timeout en ms
        System.out.println("je suis un client connecté");

    }
}
