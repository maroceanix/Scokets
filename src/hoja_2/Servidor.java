package hoja_2;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) {
		int port=6000;
		try (ServerSocket server=new ServerSocket(port)){
			Socket client= null;
			for(int i=1;i<4;i++) {
				client=server.accept();
				PrintWriter pw= new PrintWriter(client.getOutputStream(), true	);
				pw.println("Hello client "+i);
				client.close();
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
