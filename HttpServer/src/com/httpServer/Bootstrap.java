package com.httpServer;

public class Bootstrap {
	
	
	public static void main(String[] args) {
		
		HttpConnector httpConnector = new HttpConnector();
		
		httpConnector.start();
	}

}
