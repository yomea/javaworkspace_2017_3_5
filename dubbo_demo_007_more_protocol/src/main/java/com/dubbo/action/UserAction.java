package com.dubbo.action;

import com.alibaba.dubbo.rpc.protocol.dubbo.DubboExporter;
import com.alibaba.dubbo.rpc.protocol.dubbo.DubboInvoker;
import com.alibaba.dubbo.rpc.protocol.dubbo.DubboProtocol;
import com.dubbo.service.UserService;

public class UserAction {
	
	private UserService service;
	
	
	public void setService(UserService service) {
		
		//DubboExporter<T>
		//DubboInvoker<T>
		//DubboProtocol
		this.service = service;
		
	}
	
	
	public void sayHello() {
		
		service.sayHello();
	}
	
}
