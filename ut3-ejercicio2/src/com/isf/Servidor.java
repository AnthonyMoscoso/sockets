package com.isf;


import java.io.IOException;
import java.io.InputStream;

import java.net.ServerSocket;
import java.net.Socket;



public class Servidor {
	// creo una variable estatica de mi puerto para cualquier cambio realizarlo directamente desde aqui
	public static int PUERTO=800;
	public static void main(String[] arg) throws IOException, InterruptedException {
		ServerSocket servidor = new ServerSocket(PUERTO);
		Socket clienteConectado = null;
		InputStream inputIn = null;
		System.out.println("Esperando al cliente.....");
		try {
			clienteConectado = servidor.accept();
		}
		catch (	IOException ex) {
			System.out.println("No se ha podido conectar con el cliente");
		}
		try {
			// CREO FLUJO DE ENTRADA DEL CLIENTE
			System.out.println("Leyendo del clientes....");
			inputIn = clienteConectado.getInputStream();
		}
		catch (IOException ex) {
			System.out.println("error de conexion");
		}
		
		byte[] bytes = new byte[1024];
		
		
		int contador;
		String pregunta="";
		while((contador =inputIn.read(bytes))>0) {
			
			for(int i=0;i<bytes.length;i++) {
				char letra=(char)bytes[i];
			
				pregunta=pregunta+letra;
				
				
				if(letra=='?') {
					break;
				}
				
			}
			
		}
		System.out.println(pregunta);
		System.out.println("Respondiendo...");
	
		Thread.sleep(1000);
	
		if(pregunta.equals("como te llamas?")) {
			System.out.println("Me llamo Ejercicio 2");
		}
		else if (pregunta.equals("cuantas lineas de codigo tienes?")){
			System.out.println(pregunta.length());
		}
		else {
			System.out.println("No he entendido la pregunta");
		}
		

	
		inputIn.close();

		clienteConectado.close();
		servidor.close();
	  }
}
