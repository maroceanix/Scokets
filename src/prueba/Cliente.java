package prueba;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Cliente {

	public static void main(String[] args) throws Exception {
		int port=6000;
		DatagramSocket socket= new DatagramSocket(port);
		byte[] buffer= new byte[1024];
		DatagramPacket receive= new DatagramPacket(buffer, buffer.length);
		
		System.out.println("Waiting for UDP packet..");
		
		socket.receive(receive);
		
		int bytesRec=receive.getLength();
		
		String message=new String(receive.getData(), 0, bytesRec);
		
		
		System.out.println("Number of bytes received: "+bytesRec);
		System.out.println("Packet content: "+message);
		System.out.println("Origin port: "+receive.getPort());
		System.out.println("IP origin: "+receive.getAddress().getHostAddress());
		
		socket.close();
		

	}

}
