package hoja_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) throws IOException {
        int port = 5000;
        String address = "localhost";

        try (
            Socket client = new Socket(address, port);
            Scanner sc = new Scanner(System.in);
            PrintWriter pw = new PrintWriter(client.getOutputStream(), true);
            BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()))
        ) {
            System.out.println("Connected to server. Type 'salir' to quit.");

            while (true) {
                System.out.print("Write message: ");
                String message = sc.nextLine();
                
                pw.println(message);

                if ("salir".equalsIgnoreCase(message)) break;

                String response = br.readLine(); 
                System.out.println("Server response: " + response);
            }
        }
        System.out.println("Disconnected.");
    }
}