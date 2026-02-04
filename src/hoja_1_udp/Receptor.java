package hoja_1_udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Receptor {

	public static void main(String[] args) throws Exception {
		int port=6000;
		DatagramSocket socket= new DatagramSocket(port);
		byte[] buffer= new byte[1024];
		DatagramPacket receive= new DatagramPacket(buffer, buffer.length);
		System.out.println("Waiting for package..");
		socket.setSoTimeout(5000);
		
		while(true) {
			socket.receive(receive);
			String mess= new String(receive.getData(),0, receive.getLength());
			System.out.println("Receiving: "+mess);
			String mensaje=">> ECO: "+mess;
			byte[] envio= mensaje.getBytes();
			DatagramPacket send= new DatagramPacket(envio, envio.length, receive.getAddress(), receive.getPort());
			socket.send(send);
			socket.setSoTimeout(10000);
		}
		
		
		
	}

}
