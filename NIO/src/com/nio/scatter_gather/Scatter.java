package com.nio.scatter_gather;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 从channel分散数据到多个buffer
 * @author Administrator
 *
 */
public class Scatter {
	
	public static void main(String[] args) throws Exception {
		
		RandomAccessFile file = new RandomAccessFile("src/test.txt", "rw");
		FileChannel channel = file.getChannel();
		
		ByteBuffer buffer_1 = ByteBuffer.allocate(6);//创建一个6字节大小的缓冲区
		ByteBuffer buffer_2 = ByteBuffer.allocate(5);
		
		ByteBuffer[] buffers = {buffer_1, buffer_2};
		//当填满第一个buffer_1后才会继续填到第二个buffer_2里面
		long len = channel.read(buffers);
		
		buffer_1.flip();
		
		buffer_2.flip();
		
		while(len != -1) {
			
			while(buffer_1.hasRemaining()) {
				System.out.print((char)buffer_1.get());
			}
			
			while(buffer_2.hasRemaining()) {
				System.out.print((char)buffer_2.get());
			}
			
			buffer_1.clear();
			
			buffer_2.clear();
			
			len = channel.read(buffers);
			
			
		}
		
		file.close();
		
		
		
	}

}
