package tres_tres;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) {
		int puerto=6000;
		String host="localhost";
		
		System.out.println("Iniciando cliente..");
		
		try {
			Socket cliente= new Socket(host, puerto);

			Scanner sc= new Scanner(System.in);
			DataOutputStream salida= new DataOutputStream(cliente.getOutputStream());
			
			System.out.println("Escribe un número para obtener su cuadrado: ");
			int respuesta=sc.nextInt();
			
			salida.writeInt(respuesta);
			
			DataInputStream entrada= new DataInputStream(cliente.getInputStream());
			System.out.println(entrada.readInt());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
