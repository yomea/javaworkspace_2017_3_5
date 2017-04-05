package com.nio.datagramChannel;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class UDPClient {
	
	public static void main(String[] args) throws Exception {
		
		DatagramChannel channel = DatagramChannel.open();
		
		channel.socket().bind(new InetSocketAddress("localhost", 5657));
		
		//channel.connect(new InetSocketAddress("localhost", 5656));
		
	//	if(channel.isConnected()) {
			
			ByteBuffer buffer = ByteBuffer.allocate(1024);
			
			buffer.put("Hello world".getBytes());
			
			buffer.flip();
			
		
			
			//channel.write(buffer);
			channel.send(buffer, new InetSocketAddress("localhost", 5656));
	//	}
		
		
		
	}

}
