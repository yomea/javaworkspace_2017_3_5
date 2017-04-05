package com.httpServer;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpConnector implements Runnable {
	
	private boolean stop = false;
	
	private String schema = "http";
	

	@Override
	public void run() {
		
		ServerSocket serverSocket = null;
		
		try {
			serverSocket = new ServerSocket(8080, 1, InetAddress.getByName("127.0.0.1"));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
		while(!stop) {
			
			try {
				Socket socket = serverSocket.accept();
				
			} catch (IOException e) {
				e.printStackTrace();
				continue;
			}
			
			
		}
		
		
		
	}

	public void start() {
		Thread thread = new Thread(this);
		
		thread.start();
		
	}

}
