package dubbo_demo_001;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dubbo.action.UserAction;

/**
 * 在配置了check为true时，表示启动时检查
 * 如果服务不可用时，抛出了了以下异常，阻止了spring的初始化
 * 发生以下错误，很明显服务不可用，因为register为false，服务并未注册
 * org.springframework.beans.factory.BeanCreationException: Error creating bean
 * with name 'userAction' defined in class path resource
 * [consumer_check_is_true.xml]: Cannot resolve reference to bean 'service'
 * while setting bean property 'service'; nested exception is
 * org.springframework.beans.factory.BeanCreationException: Error creating bean
 * with name 'service': FactoryBean threw exception on object creation; nested
 * exception is java.lang.IllegalStateException: Failed to check the status of
 * the service com.dubbo.service.UserService. No provider available for the
 * service com.dubbo.service.UserService from the url
 * zookeeper://127.0.0.1:2181/com.alibaba.dubbo.registry.RegistryService?application=consumer-of-helloworld-app&check=true&dubbo=2.5.3&init=false&interface=com.dubbo.service.UserService&methods=sayHello&pid=4496&side=consumer&timestamp=1490339005319
 * to the consumer 192.168.8.7 use dubbo version 2.5.3
 * 
 * @author Administrator
 *
 */
public class CosumerTest_check_is_true {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext application = new ClassPathXmlApplicationContext(
				new String[] { "classpath:consumer_check_is_true.xml" });
		UserAction action = application.getBean("userAction", UserAction.class);
		action.sayHello();
	}

}
