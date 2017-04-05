package com.dubbo.service.api.imp;

import com.dubbo.api.BarServiceMock;

/**
 * 这个方法只有在服务提供方出错时会被调用
 * @author may
 *
 */
public class BarServiceMockImpl implements BarServiceMock {
	
	/**
	 * 这里一定要有个无参构造器
	 */
	public BarServiceMockImpl () {
		
		
	}
	

	@Override
	public String sayHello(String name) {
		System.out.println("出错时被调用");
		return "容错信息";
	}

}
