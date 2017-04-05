package com.nio.socketChannel;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class SocketClient {
	
	public static void main(String[] args) throws Exception {
		
		SocketChannel channel = SocketChannel.open();
		
		Socket socket = channel.socket();
		
		socket.connect(new InetSocketAddress("localhost", 8888), 1000);
		
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		
		
		
		buffer.put("Hello world".getBytes("utf-8"));
		buffer.flip();
		
		channel.write(buffer);
		
		buffer.clear();
		
		channel.close();
		socket.close();
		
	}

}
