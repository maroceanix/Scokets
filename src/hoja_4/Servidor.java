package hoja_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) throws Exception {
		int port=6000;
		ServerSocket server= new ServerSocket(port);
		System.out.println("Initializing server..");
		Socket client= server.accept();
		BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
		PrintWriter pw= new PrintWriter(client.getOutputStream(), true);
		String receive=br.readLine();
		int receive1=Integer.parseInt(receive);	
		for(int i=receive1;i>-1;i--) {
			pw.println(i);
		}
	}

}
