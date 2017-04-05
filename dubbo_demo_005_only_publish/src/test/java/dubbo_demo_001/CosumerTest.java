package dubbo_demo_001;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dubbo.action.UserAction;

/**
 * 
 * 测试一：启动顺序ProviderDao.java-》ProviderService_subscribe_false.java直接报错，因为服务这注册到注册中心时，不允禁止了订阅
 * 测试二：启动循序ProviderDao.java-》ProviderService_subscribe_true.java-》CosumerTest.java顺利通过
 * @author Administrator
 *
 */
public class CosumerTest {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext application = new ClassPathXmlApplicationContext(
				new String[] { "classpath:consumer.xml" });
		UserAction action = application.getBean("userAction", UserAction.class);
		action.sayHello();
	}

}
