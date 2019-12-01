package com.isf;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

public class Servidor {
	// creo una variable estatica de mi puerto para cualquier cambio realizarlo directamente desde aqui
	public static int PUERTO=800;
	public static void main(String[] arg) throws IOException {
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
				System.out.print(letra);
				pregunta=pregunta+letra;
				if(letra=='i') {
					break;
				}
				
			}
			//System.out.println((char)bytes[0]);
		}
		if(pregunta.equals("hola soy anthony mi")) {
			System.out.println("hello");
		}
		else {
			System.out.println("mehh");
		}
		

	
	

		/* EL CLIENTE ME ENVIA UN MENSAJE
		BufferedReader br = new BufferedReader(new InputStreamReader(inputIn));
		System.out.println("Recibiendo del CLIENTE: \n\t");		
		// leo linea a linea del buffered que reciba
		String line=br.readLine();
		while(line!=null) {
			System.out.println(line);
			line=br.readLine();
		}
		
		// CREO FLUJO DE SALIDA AL CLIENTE
		OutputStream salida = null;
		salida = clienteConectado.getOutputStream();
		OutputStream flujoSalida = salida;

		
	
*/
		// CERRAR STREAMS Y SOCKETS
		inputIn.close();
		//flujoEntrada.close();
		//salida.close();
		//flujoSalida.close();
		clienteConectado.close();
		servidor.close();
	  }// main
}
