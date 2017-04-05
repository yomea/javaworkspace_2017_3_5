package com.netty.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class TimeServer {
	
	
	public void bind(int port) {
		//NIO线程组，Reactor线程组，一个用于接受客户端的请求，另一个用于进行SocketChannel的操作
		EventLoopGroup bossGroup = new NioEventLoopGroup();
		
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		
		try {
			//用于NIO服务端启动的辅助类
			ServerBootstrap b = new ServerBootstrap();
			
			b.group(bossGroup, workerGroup)
			  .channel(NioServerSocketChannel.class)
			  .option(ChannelOption.SO_BACKLOG, 1024)
			  .childHandler(new ChildChannelHandler());
			
			//绑定端口，同步等待成功，一直等待到绑定端口成功，返回一个ChannelFuture,类似JDK中的java.util.concurrent.Future
			//用于异步的通知会调
			ChannelFuture f = b.bind(port).sync();
			
			//进行阻塞，等待服务器链路关闭，就退出
			f.channel().closeFuture().sync();
		
		
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			
			//优雅退出，释放线程资源
			
			bossGroup.shutdownGracefully();
			workerGroup.shutdownGracefully();
			
		}
		
	}
	
	private class ChildChannelHandler extends ChannelInitializer<SocketChannel> {

		@Override
		protected void initChannel(SocketChannel arg0) throws Exception {
			arg0.pipeline().addLast(new TimeServerHandler());
			
		}
		
		
	}
	
	
	public static void main(String[] args) {
		
		int port = 8080;
		
		if(args != null && args.length > 0) {
			try {
				
				port = Integer.valueOf(args[0]);
				
			} catch (NumberFormatException e) {
				
				
			}
			
		}
		
		new TimeServer().bind(port);
		
	}
	

}
