	package tres_cinco;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Servidor {

	public static void main(String[] args) throws Exception {
		int port=6000;
		DatagramSocket socket= new DatagramSocket(port);
		byte[] buffer= new byte[1024];
		
		DatagramPacket receive=new DatagramPacket(buffer, buffer.length);
		
		System.out.println("Waiting for a package..");
		socket.setSoTimeout(10000);
		socket.receive(receive);
		
//		int bytesRec=receive.getLength();
		String message= new String(receive.getData(), 0, receive.getLength());
		while(!message.equalsIgnoreCase("*")) {
			message=message.toUpperCase();
			byte[] sendBuffer= message.getBytes();
			
			DatagramPacket send= new DatagramPacket(sendBuffer, sendBuffer.length, receive.getAddress(), receive.getPort());
			
			socket.send(send);
			socket.receive(receive);
			message= new String(receive.getData(), 0, receive.getLength());
		}
			System.out.println("Connection finished :PP");
			socket.close();
		

	}

}
