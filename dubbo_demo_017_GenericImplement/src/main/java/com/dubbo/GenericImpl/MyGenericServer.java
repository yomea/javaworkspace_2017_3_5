package com.dubbo.GenericImpl;

import com.alibaba.dubbo.rpc.service.GenericException;
import com.alibaba.dubbo.rpc.service.GenericService;
import com.dubbo.service.UserService;

/**
 * 在服务端进行配置
 * @author may
 *
 */
public class MyGenericServer implements GenericService, UserService {

	@Override
	public Object $invoke(String methodName, String[] parameterType, Object[] parameter) throws GenericException {
		
		if(methodName.equals("sayHello")) {
			System.out.println("sayHello");
			sayHello();
		}
		
		return "自定义通用接口";
	}
	
	@Override
	public void sayHello() {
		System.out.println("hello world!!!");
	}

}
