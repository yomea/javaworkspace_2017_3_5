package com.nio.socketChannel;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.channels.ServerSocketChannel;

public class SocketChannelserver {
	
	public static void main(String[] args) throws Exception {
		
		ServerSocketChannel channel = ServerSocketChannel.open();
		
		ServerSocket socket = channel.socket();
		
		socket.bind(new InetSocketAddress("localhost", 8888));
		
		channel.accept();
		
		channel.close();
		
		socket.close();
		
		
		System.out.println("connet success");
		
		
	}
	

}
