package clientPackage;

import java.io.IOException;
import java.net.Socket;

public class Client {
    public static void main() throws IOException {
        System.out.println("je suis un client pas encore connecté");


        Socket socket= new Socket("localhost",1234);
        System.out.println("je suis un client connecté");

        socket.close();
    }
}
