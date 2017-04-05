package com.nio.scatter_gather;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 聚集，从多个buffer中读入数据到channel中
 * @author Administrator
 *
 */
public class Gather {
	
	public static void main(String[] args) throws Exception {
		RandomAccessFile file = new RandomAccessFile("src/test.txt", "rw");
		FileChannel channel = file.getChannel();
		
		ByteBuffer buffer_1 = ByteBuffer.allocate(6);//创建一个6字节大小的缓冲区
		ByteBuffer buffer_2 = ByteBuffer.allocate(5);
		
		ByteBuffer buffer_3 = ByteBuffer.allocate("youth".getBytes().length);
		
		buffer_3.put("youth".getBytes());
		
		ByteBuffer[] buffers = {buffer_1, buffer_2, buffer_3};
		
		for (ByteBuffer byteBuffer : buffers) {
			byteBuffer.flip();
			
		}
		
		
		channel.write(buffers);
		
		file.close();
		
	}

}
