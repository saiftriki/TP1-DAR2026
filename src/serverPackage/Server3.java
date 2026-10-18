package serverPackage;

import java.io.*;
import java.net.*;

public class Server3 {
    public static void main(String[] args) throws IOException {
        // Ip adr
        InetAddress ip = InetAddress.getByName("192.168.1.40"); 
        InetSocketAddress adr = new InetSocketAddress(ip, 8080); 

        // Server
        ServerSocket server = new ServerSocket();
        server.bind(adr);
        System.out.println("\nLe serveur écoute sur "+adr+" !");


        while (true){
            // Accept connection
            Socket socket = server.accept();
            System.out.println("Un client est connecté !");

            // In
            InputStream is = socket.getInputStream();
            DataInputStream dis = new DataInputStream(is);

            // Out
            OutputStream os = socket.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);

            int c = -1;
            int x = -1;
            double res;

           while (true){
               // Lire le choix
               c = dis.readInt();
               // lire un entier
               x = dis.readInt();
               res = 0;

               // Traitement
               switch (c){
                   case 1: // Addition
                       res = x + 5; break;
                   case 2: // Soustraction
                       res = x - 5; break;
                   case 3: // Multiplication
                       res = x * 5; break;
                   case 4: // Division
                       res =(double) x / 5; break;
                   case 0: // Quitter
                       break;
                   default :
                       System.out.println("Choix Invalide ! ("+c+")");
                       break;
               }

               if (c>0 && c<5) {
                   // Message au client
                   dos.writeDouble(res);
                   dos.flush();
               }else {
                   socket.close(); // fermer la connexion
                   System.out.println("Un client est déconnecté !");
                   break; // quitter le traittement
               }
           }


        }


    }
}
