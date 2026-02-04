package hoja_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {
	public static void main(String[] args) {
		int port=6000;
		String address="localhost";
		try(Socket soc= new Socket(address, port)) {
			BufferedReader br= new BufferedReader(new InputStreamReader(soc.getInputStream()));
			String showInCmd= br.readLine();
			
			System.out.println(showInCmd);
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
}
