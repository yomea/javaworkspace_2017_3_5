package com.nio.transferFrom_transferTo;

import java.io.File;
import java.io.FileInputStream;
import java.nio.channels.FileChannel;

public class FileChannelTest {
	
	@SuppressWarnings("all")
	public static void main(String[] args) throws Exception {
		
		File file = new File("src/test_2.txt");
		FileInputStream in = new FileInputStream(file);
		
		FileChannel channel = in.getChannel();
		
		//channel.position(newPosition)//set position
		long currentPosition = channel.position();
		
		channel.size();//get file size;
		
		channel.lock();//lock the file
		
		channel.truncate(1024);//truncate 1024byte
		
		channel.force(true);//force make channel's data writer to hdd
		
		channel.close();
		
	}

}
