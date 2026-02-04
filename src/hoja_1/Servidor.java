package hoja_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) throws Exception {
        int port = 5000;
        ServerSocket server = new ServerSocket(port);
        System.out.println("Server initialized and waiting...");
        
        Socket client = server.accept();
        System.out.println("Client connected: " + client.getInetAddress());

        try (
            BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter pw = new PrintWriter(client.getOutputStream(), true)
        ) {
            String message;
            // El bucle se mantiene mientras el cliente envíe datos
            while ((message = br.readLine()) != null) {
                System.out.println("Receiving: " + message);
                
                // Opción para cerrar si el cliente escribe "byte" o "salir"
                if ("salir".equalsIgnoreCase(message)) {
                    pw.println("Goodbye!");
                    break;
                }

                pw.println(">> ECO: " + message);
            }
            client.close();
            server.close();
            System.out.println("Connection closed.");
        } catch (IOException e) {
            System.err.println("Error en la comunicación: " + e.getMessage());
        } 
    }
}