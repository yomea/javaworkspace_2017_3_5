package dubbo_demo_001;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dubbo.action.UserAction;

/**
 * 
 * @author Administrator
 *
 */
public class CosumerTest {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext application = new ClassPathXmlApplicationContext(
				new String[] { "classpath:consumer.xml" });
		UserAction action = application.getBean("userAction", UserAction.class);
		action.sayHello();//只会输出第一个找到的接口实现hello world!!!，如果都要输出，就要merge
	}

}
