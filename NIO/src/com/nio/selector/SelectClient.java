package com.nio.selector;

import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

/**
 * selector 必须工作在非阻塞模式下
 * @author Administrator
 *
 */
public class SelectClient {
	
	public static void main(String[] args) throws Exception {
		
		SocketChannel socketChannel = SocketChannel.open();
		
		socketChannel.configureBlocking(false);
		
		socketChannel.connect(new InetSocketAddress("localhost", 8888));
		
		if(socketChannel.finishConnect()) {
			
			System.out.println("已连接到服务器。。。。。。");
			
		}
		
		
		
	}
	

}
