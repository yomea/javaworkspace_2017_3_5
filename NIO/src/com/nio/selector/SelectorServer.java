package com.nio.selector;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * selector 必须工作在非阻塞下
 * @author Administrator
 *
 */
public class SelectorServer {
	
	public static ByteBuffer dst = ByteBuffer.allocate(50);
	
	@SuppressWarnings("all")
	public static void main(String[] args) throws Exception {
		
		ServerSocketChannel ssc = ServerSocketChannel.open();
		
		ssc.bind(new InetSocketAddress("localhost", 8888));
		
		ssc.configureBlocking(false);
		
		Selector selector = Selector.open();
		
		SelectionKey selectionKey =  ssc.register(selector, SelectionKey.OP_ACCEPT);
		
		while(true) {
			
			int aviableCount = selector.select();//当没有可选择的通道时发生阻塞，不过可以通过其他的线程调用selector的wakeup可解除阻塞
			
			if(aviableCount <= 0) continue;
			
			Set<SelectionKey> keys =  selector.selectedKeys();
			
			Iterator<SelectionKey> it = keys.iterator();
			
			while(it.hasNext()) {
				SelectionKey key = it.next();
				
				System.out.println(key.isAcceptable());
				
				//it.remove();
				
			//	key.cancel();//取消这个key，那么这个key将永远失效，需要重新register
				if(key.isAcceptable()) {
					ServerSocketChannel ssc1 = (ServerSocketChannel) key.channel();
					SocketChannel sc = ssc1.accept();
					sc.configureBlocking(false);
					sc.register(selector, SelectionKey.OP_CONNECT | SelectionKey.OP_READ | SelectionKey.OP_WRITE);
					
				}
				
				if(key.isConnectable()) {
					SocketChannel sc= (SocketChannel) key.channel();
					System.out.println(sc + " connect success");
				}
				
				if(key.isReadable()) {
					
					SocketChannel sc= (SocketChannel) key.channel();
					while(sc.read(dst) != -1) {
						dst.flip();
						sc.read(dst);
						System.out.println(new String(dst.array(), 0, dst.limit()));
						
					}
					
					it.remove();
				}
				
				
			}
			
			
		}
		
	}
	

}
