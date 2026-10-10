package serverPackage;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server2 {
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(1234);
        System.out.println("Je suis un serveur(2) en attente la connexion d'un client ");

            Socket socket = serverSocket.accept();
            System.out.println("un client est connecté");

            // std-in
            InputStream is = socket.getInputStream();
            DataInputStream dis = new DataInputStream(is);
            
            // std-out
            OutputStream os = socket.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);

            int x = 0;
            
            do {
                // lire x
                x = dis.readInt();
                System.out.println("entier reçu : " + x);

                // traitement
                int res = x * 5;

                // envoi
                dos.writeInt(res);
                dos.flush();
                System.out.println("resultat envoyé : " + res);

            } while (x!=0);


            socket.close();

        }
}
