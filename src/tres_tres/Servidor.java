package tres_tres;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) {
		int numPuerto=6000;
		try {
			ServerSocket servidor= new ServerSocket(numPuerto);
			Socket cliente=null;
			cliente=servidor.accept();
			
			
			DataInputStream flujoEntrada=new DataInputStream(cliente.getInputStream());

			int respuesta=flujoEntrada.readInt();
			
			DataOutputStream flujoSalida= new DataOutputStream(cliente.getOutputStream());
			
			flujoSalida.writeInt(respuesta*respuesta);
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
