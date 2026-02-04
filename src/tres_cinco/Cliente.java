package tres_cinco;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) throws Exception {
		Scanner sc= new Scanner(System.in);
		DatagramSocket socket=new DatagramSocket();
		DatagramPacket packet=null;
		System.out.println("Write anything to get it to uppercase: ");
		while(true) {
			String utf=sc.nextLine();
			byte[] message=utf.getBytes();
			packet=new DatagramPacket(message, message.length, InetAddress.getByName("localhost"), 6000);
			socket.send(packet);
			
			if (utf.equals("*")) {
                break; // Salimos del bucle si es asterisco
            }
			
			byte[] buffer= new byte[1024];
			DatagramPacket receive=new DatagramPacket(buffer, buffer.length);
			socket.receive(receive);
			String finalMessage= new String(receive.getData(), 0, receive.getLength());
			System.out.println(finalMessage);
		}
		
		
	}

}
