package hoja_1_udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Emisor {

	public static void main(String[] args) throws Exception {
		Scanner sc=new Scanner(System.in);
		DatagramSocket socket= new DatagramSocket();
		DatagramPacket pack= null;
		System.out.println("Type anything: ");
		
		while(true) {
			String mensaje=sc.nextLine();
			byte[] send= mensaje.getBytes();
			pack= new DatagramPacket(send, send.length, InetAddress.getByName("localhost"), 6000);
			socket.send(pack);
			if(mensaje.equalsIgnoreCase("salir")) {
				break;
			}
			byte[] buffer= new byte[1024];
			DatagramPacket receive=new DatagramPacket(buffer, buffer.length);
			socket.receive(receive);
			String mensajeFinal= new String(receive.getData(),0 , receive.getLength());
			System.out.println(mensajeFinal);
			
			
		}
		
	}

}
