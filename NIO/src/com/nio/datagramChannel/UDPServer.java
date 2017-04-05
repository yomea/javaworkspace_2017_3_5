package com.nio.datagramChannel;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class UDPServer {
	
	public static void main(String[] args) throws Exception {
		
		DatagramChannel channel = DatagramChannel.open();
		
		channel.socket().bind(new InetSocketAddress("localhost", 5656));
		
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		
		channel.receive(buffer);
		
		buffer.flip();
		
	//	while(buffer.hasRemaining()) {
			System.out.println(new String(buffer.array(), 0, buffer.limit()));
			
	//	}
		
	}
	

}
