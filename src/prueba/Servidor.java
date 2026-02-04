package prueba;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Servidor {

	public static void main(String[] args) throws IOException {
	DatagramSocket socket = new DatagramSocket();
	byte[] message="Hello UDP".getBytes();
	DatagramPacket packet = new DatagramPacket(message, message.length, InetAddress.getByName("localhost"), 6000); 
	socket.send(packet);
	socket.close();
	}

}
