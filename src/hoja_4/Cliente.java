package hoja_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) throws Exception {
		Scanner sc= new Scanner(System.in);
		int port=6000;
		String address="localhost";
		Socket socket= new Socket(address, port);
		System.out.println("From where do you wanna start your countdown? (number): ");
		String num=sc.nextLine();
		BufferedReader br= new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter pw= new PrintWriter(socket.getOutputStream(), true);
		pw.println(num);
		String received=br.readLine();
		while(Integer.parseInt(received)>-1) {
			System.out.println(received);
			received=br.readLine();
		}
		socket.close();
	}

}
