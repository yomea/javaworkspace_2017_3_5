package com.nio.transferFrom_transferTo;

import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

public class TransferTo {
	
	public static void main(String[] args) throws Exception {
		
		RandomAccessFile file_1 = new RandomAccessFile("src/test.txt", "rw");
		
		RandomAccessFile file_2 = new RandomAccessFile("src/test_2.txt", "rw");
		
		FileChannel channel_1 = file_1.getChannel();
		
		FileChannel channel_2 = file_2.getChannel();
		
		//将file_1的内容传输到channel_2
		channel_1.transferTo(0, channel_1.size(), channel_2);
		
		file_2.close();
		file_1.close();
		
	}

}
