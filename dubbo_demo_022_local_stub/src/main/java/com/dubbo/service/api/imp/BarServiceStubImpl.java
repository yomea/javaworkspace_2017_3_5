package com.dubbo.service.api.imp;

import com.dubbo.api.BarServiceStub;

public class BarServiceStubImpl implements BarServiceStub {
	
	private BarServiceStub barServiceStub;
	
	public BarServiceStubImpl(BarServiceStub barServiceStub) {
		
		this.barServiceStub = barServiceStub;
	}

	@Override
	public String sayHello(String name) {
		System.out.println(barServiceStub);
		return barServiceStub.sayHello(name);
	}

}
