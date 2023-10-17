package server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import java.net.ServerSocket;
import java.net.Socket;

public class server {
    public static void  main(String[] args){
        try {
            ServerSocket ss = new ServerSocket(1234);
            System.out.println("J'attend le connexion d'un client");
            Socket s = ss.accept();
            System.out.println("Un client est connecté");

            InputStream is = s.getInputStream();
            OutputStream os = s.getOutputStream();
            int nb = is.read();
            int res = nb / 5;
            os.write(nb);
            ss.close();
            s.close();

        }catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}