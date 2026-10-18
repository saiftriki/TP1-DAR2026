package clientPackage;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client3 {
    public static void main(String[] args) throws IOException {
        // Connect
        Socket socket = new Socket();
        socket.connect(new InetSocketAddress("192.168.1.40", 8080));
        System.out.println("je suis un client connecté !");

        // Out
        OutputStream os = socket.getOutputStream();
        DataOutputStream dos = new DataOutputStream(os);

        // In
        InputStream is = socket.getInputStream();
        DataInputStream dis = new DataInputStream(is);

        // scanner
        Scanner scan = new Scanner(System.in);

        int c = 0;
        int x = 0;
        double res = -1;
        do {
            // Menu & choix
            showMenu(); // 1. Addition, 2. Soustraction, 3. Multiplication, 4. Division
            System.out.print("Choix n°: ");
            c = scan.nextInt();

            if (c > 0 && c <5){
                // Saisir un entier
                System.out.print("Taper un entier: ");
                x = scan.nextInt();

                // Message au Serveur
                dos.writeInt(c);
                dos.writeInt(x);
                dos.flush();

                // Lire Resulat
                res=dis.readDouble();
                System.out.println("Resultat: "+res+"\n");
            }else if (c == 0)
                dos.writeDouble(0); // déconnexion

            else
                System.out.println("Choix Invalide!");


        } while (c != 0);


        scan.close();

    }




    private static void showMenu(){
        System.out.println("Les services de calcul:");
        System.out.println("1: + , 2: - , 3: * , 4: / , 0: Quit");
    }
}