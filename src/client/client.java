package client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;
import java.net.InetAddress;
import java.net.InetSocketAddress;

public class client {
    public static void main(String[] args) {
        try {
            // Obtenir une adresse IP à partir d'une chaîne d'adresse IP
            InetAddress IA = InetAddress.getByName("192.168.147.20");

            // Créer une adresse de socket avec l'adresse IP et le port
            InetSocketAddress ISA = new InetSocketAddress(IA, 1234);

            // Créer une nouvelle socket
            Socket s = new Socket();

            // Établir une connexion avec le serveur en utilisant l'adresse de socket
            s.connect(ISA);

            // Obtenir les flux d'entrée et de sortie de la socket
            InputStream is = s.getInputStream();
            OutputStream os = s.getOutputStream();

            // Afficher un message pour indiquer que la connexion a été établie
            System.out.println("Je suis Connecté au serveur");

            // Créer un scanner pour lire l'entrée de l'utilisateur
            Scanner scanner = new Scanner(System.in);
            System.out.print("Entrer un entier: ");
            int nb = scanner.nextInt();

            // Envoyer l'entier au serveur en écrivant dans le flux de sortie
            os.write(nb);

            // Lire la réponse du serveur depuis le flux d'entrée
            int res = is.read();

            // Afficher la réponse reçue du serveur
            System.out.println("Réponse du serveur : " + res);

            // Fermer la socket
            s.close();

        } catch (Exception e) {
            // Gérer les exceptions en affichant un message d'erreur
            System.out.println("Erreur : " + e.getMessage());
        }
    }
}

