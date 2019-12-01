package Ejemplos;

import java.io.IOException;
import java.net.*;

public class TCPServidorBasico {

	public static void main(String[] args) throws IOException {
		
		int Puerto = 600;// Puerto 
		ServerSocket Servidor = new ServerSocket(Puerto);
		
		System.out.println("Escuchando en " + Servidor.getLocalPort());	
		Socket cliente1= Servidor.accept();//esperando a un cliente 
		//realizar acciones con cliente1
		
		
		Servidor.close();	//cierro socket servidor
	}

}