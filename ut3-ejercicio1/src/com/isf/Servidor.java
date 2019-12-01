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

public class Servidor {
	// creo una variable estatica de mi puerto para cualquier cambio realizarlo directamente desde aqui
	public static int PUERTO=800;
	public static void main(String[] arg) throws IOException {
		ServerSocket servidor = new ServerSocket(PUERTO);
		Socket clienteConectado = null;
		System.out.println("Esperando al cliente.....");
		clienteConectado = servidor.accept();

		// CREO FLUJO DE ENTRADA DEL CLIENTE
		InputStream entrada = null;
		entrada = clienteConectado.getInputStream();
		//DataInputStream flujoEntrada = new DataInputStream(entrada);

		// EL CLIENTE ME ENVIA UN MENSAJE
		BufferedReader br = new BufferedReader(new InputStreamReader(entrada));
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

		
	

		// CERRAR STREAMS Y SOCKETS
		entrada.close();
		//flujoEntrada.close();
		salida.close();
		flujoSalida.close();
		clienteConectado.close();
		servidor.close();
	  }// main
}
