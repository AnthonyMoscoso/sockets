package com.isf;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {
	// creamos una variable estatica final que sera nuestro puerto debido a que a la hora de necesitar cambiar el codigo
	// podemos cambiar el Puerto directamente desde aqui
	public static final int PUERTO=800;
	public static final String host ="192.168.2.61";
	public static final String RUTA=".\\src\\com\\isf\\preguntas.txt";
	public static void main (String[] args) throws IOException{
		 DataInputStream input;
	
		 int in;
		 byte[] byteArray;
		 //Fichero a transferir
		
		 // creamos nuestro socket cliente
		 Socket client = new Socket(host, PUERTO);
		 // File donde le pasaremos la ruta
		 File file = new File(RUTA);
		 // Un bufferInput para leer el archivo
		 BufferedInputStream bufferInput= new BufferedInputStream(new FileInputStream(file));
		 //un bufferOutput para escribir el archivo
		 BufferedOutputStream bufferOutput = new BufferedOutputStream(client.getOutputStream());
		 

		
		 //Enviamos el fichero
		 byteArray = new byte[(int) file.length()];
		 while ((in = bufferInput.read(byteArray)) != -1){
			 bufferOutput.write(byteArray,0,in);
			 bufferOutput.flush();
		 }
		 
	
		 bufferOutput.close();
		 bufferInput.close();
		 client.close();
		 
		
		 }
		}

