package com.dubbo.service.api.imp;

import com.dubbo.api.BarServiceStub;

public class BarServiceImpl implements BarServiceStub {

	@Override
	public String sayHello(String name) {
		
		return name;
	}

}
