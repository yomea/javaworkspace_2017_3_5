package com.nio.pipe;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;
import java.nio.channels.Pipe.SinkChannel;
import java.nio.channels.Pipe.SourceChannel;

public class PipeTest {
	
	public static void main(String[] args) throws Exception {
		
		Pipe pipe = Pipe.open();
		
		SinkChannel sinkChannel = pipe.sink();
		
		ByteBuffer buffer = ByteBuffer.allocate(50).put("hello world".getBytes());
		
		buffer.flip();
		//make data in sink channel
		sinkChannel.write(buffer);
		
		SourceChannel sourceChannel = pipe.source();
		
		ByteBuffer buffer_1 = ByteBuffer.allocate(50);
		
		sourceChannel.read(buffer_1);
		
		buffer_1.flip();
		
		System.out.println(new String(buffer_1.array(), 0, buffer_1.limit()));
		
	}

}
