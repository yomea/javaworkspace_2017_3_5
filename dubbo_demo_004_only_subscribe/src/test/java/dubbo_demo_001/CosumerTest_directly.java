package dubbo_demo_001;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dubbo.action.UserAction;

/**
 * 在服务因为正在开发，没有在注册中心注册时，可以进行直连访问测试。
 * @author Administrator
 *
 */
public class CosumerTest_directly {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext application = new ClassPathXmlApplicationContext(
				new String[] { "classpath:consumer_directly.xml" });
		UserAction action = application.getBean("userAction", UserAction.class);
		action.sayHello();
	}

}
