package clientPackage;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client2 {
    public static void main(String[] args) throws IOException{
        System.out.println("je suis un client pas encore connecté");

        try (Socket socket = new Socket("localhost", 1234)) {
            System.out.println("je suis un client connecté");

            // std-out
            OutputStream os = socket.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);
            
            // std-in
            InputStream is = socket.getInputStream();
            DataInputStream dis = new DataInputStream(is);

            int x=0;
            int res;
            Scanner scan = new Scanner(System.in);

            do{            
            // saisir un entier
            System.out.println("taper un entier: ");
            x = scan.nextInt();

            // envoi au serveur
            dos.writeInt(x);
            dos.flush();

            // recevoir la resultat
            res = dis.readInt();
            System.out.println("resultat reçu : " + res);
            } while( x!=0 );

           scan.close();


        } catch (Exception e) {
            System.out.println("Erreur: "+e.getMessage());
        }

    }
}
