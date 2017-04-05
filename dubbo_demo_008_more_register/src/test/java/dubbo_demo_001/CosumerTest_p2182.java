package dubbo_demo_001;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dubbo.action.UserAction;

/**
 * 
 * @author Administrator
 *
 */
public class CosumerTest_p2182 {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext application = new ClassPathXmlApplicationContext(
				new String[] { "classpath:consumer_p2182.xml" });
		UserAction action = application.getBean("userAction", UserAction.class);
		action.sayHello();
	}

}
