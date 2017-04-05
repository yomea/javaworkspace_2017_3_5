package com.nio.test_001;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Test {
	
	public static void main(String[] args) throws Exception {
		
		RandomAccessFile file = new RandomAccessFile("src/test.txt", "rw");
		FileChannel channel = file.getChannel();
		//ByteBuffer buffer = ByteBuffer.allocate((int)file.length());
		ByteBuffer buffer = ByteBuffer.allocate(10);
		int len = channel.read(buffer);
		while(len != -1) {
			buffer.flip();//将current position设置成零并且将limit设置成原先的current position
			buffer.rewind();//将current position设置成零，并且把mark标记去除
			while(buffer.hasRemaining()) {
				System.out.print((char)buffer.get());//获取一个element并且将current position加1
				
				
			}
			
			buffer.clear();//position将被设回0，limit被设置成 capacity的值，并不是清空数据，可以覆盖插入值
			//buffer.compact();//清空已经被度过的数据
			len = channel.read(buffer);
			
			
		}
		
		//System.out.println(file.length());
		
		file.close();
		
	}

}
