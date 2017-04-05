package com.dubbo.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dubbo.service.UserService;

public class Consumer {
	public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"classpath:consumer.xml"});
        context.start();
        //getBean("Service");里的参数是consumer中配置的dubbo:reference中的ID
        UserService userService = (UserService)context.getBean("Service"); // 获取远程服务代理
        String hello = userService.sayHello("hello world"); // 执行远程方法
 
        System.out.println( hello ); // 显示调用结果
    }
}
