package tres_tres;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) throws IOException {
		int puerto=6000;
		ServerSocket servidor= new ServerSocket(puerto);
		System.out.println("Iniciando servidor ..");
		
		Socket cliente1=servidor.accept();
		DataInputStream flujoEntrada= new DataInputStream(cliente1.getInputStream());
		
		int respuesta=flujoEntrada.readInt();
		
		DataOutputStream flujoSalida= new DataOutputStream(cliente1.getOutputStream());
		
		flujoSalida.writeInt(respuesta*respuesta);
		
		cliente1.close();
		
		Socket cliente2=servidor.accept();
		
		flujoEntrada= new DataInputStream(cliente2.getInputStream());
		
		respuesta=flujoEntrada.readInt();
		flujoSalida= new DataOutputStream(cliente2.getOutputStream());
		
		flujoSalida.writeInt(respuesta*respuesta);
		
		cliente2.close();
		
		
		
	}

}
