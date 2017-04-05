package com.dubbo.service.api.imp;

import com.alibaba.dubbo.rpc.RpcException;
import com.dubbo.api.BarServiceMock;

public class BarServiceImpl implements BarServiceMock {
	
	

	@Override
	public String sayHello(String name) {
		if(name.equals("hello baby")) {
			
			throw new RpcException();
			
		}
		return name;
	}

}
