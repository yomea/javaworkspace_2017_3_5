package dubbo_demo_001;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dubbo.action.UserAction;

/**
 * 在配置了check为false时，表示启动时不检查，在调用以下代码时
 * UserAction action = application.getBean("userAction", UserAction.class);
 * action.sayHello();
 * 发生以下错误，很明显服务不可用，因为register为false，服务并未注册
 *  com.alibaba.dubbo.rpc.RpcException: 
 *  Forbid consumer 192.168.8.7 access service com.dubbo.service.UserService from registry 127.0.0.1:2181 use 
 *  dubbo version 2.5.3, Please check registry access list (whitelist/blacklist).
 * @author Administrator
 *
 */
public class CosumerTest_check_is_false {
	
	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext application = new ClassPathXmlApplicationContext(new String[] {"classpath:consumer_check_is_false.xml"});
		UserAction action = application.getBean("userAction", UserAction.class);
		action.sayHello();
	}

}
